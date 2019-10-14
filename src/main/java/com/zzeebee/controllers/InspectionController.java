package com.zzeebee.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.Inspection;
import com.zzeebee.model.Part;
import com.zzeebee.databasemodel.Vehicle;
import com.zzeebee.model.GeneralInspection;
import com.zzeebee.model.GeneralVehicle;
import com.zzeebee.model.InspectionStatus;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.DriverRepository;
import com.zzeebee.repository.InspectionRepository;
import com.zzeebee.repository.VehicleRepository;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InspectionController {

    @Autowired(required = true)
    DriverRepository driverRepository;

    @Autowired(required = true)
    VehicleRepository vehicleRepository;

    @Autowired(required = true)
    InspectionRepository inspectionRepository;

    @Autowired(required = true)
    AdminRepository adminRepository;

    @RequestMapping(value = "/inspection_start", method = RequestMethod.GET)
    public ModelAndView showStartInspection(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("inspection_start");
        mav.addObject("inspection", new GeneralInspection());
        return mav;
    }

    @RequestMapping(value = "/add_inspection", method = RequestMethod.POST)
    public ModelAndView showAddInspection(@ModelAttribute("inspection") GeneralInspection inspection, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("add_inspection");
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");

        Admin admin = adminRepository.findById(admin_id).get();
        Iterable<Driver> driver = driverRepository.findByAdmin(admin);

        Map<Integer, String> drivers = new HashMap<>();

        for (Driver dr : driver) {
            drivers.put(dr.getDriverId(), dr.getFirstName() + " " + dr.getLastName());

        }
        mav.addObject("drivers", drivers);
        mav.addObject("inspectionlist", GeneralInspection.getInspectionItems());
        mav.addObject("inspection", inspection);
        return mav;
    }

    @RequestMapping(value = "/inspection_form_process", method = RequestMethod.POST)
    public ModelAndView InspectionFormProcess(@ModelAttribute("inspection") GeneralInspection inspection, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Inspection i = GeneralInspection.getInspection(inspection);

         Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        ArrayList<Part> parts = new ArrayList<>();

        for (int a = 0; a < inspection.getIds().size(); a++) {
            Part part = new Part();
            part.setId(inspection.getIds().get(a));
            part.setName(inspection.getNames().get(a));
            part.setStatus(InspectionStatus.UNCHECKED_STATUS);
            parts.add(part);
        }

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        String js = gson.toJson(parts);

        i.setIparts(js);
        i.setIstatus(InspectionStatus.START_STATUS);

        if (inspection.getDateCheck() == 0) {

            i.setStartingTime(System.currentTimeMillis());
        } else {
            i.setStartingTime(inspection.getDummyTime());
        }
        
        issueInspectionNotification(admin_id,inspection,inspection.getDriverId());
        
        
        inspectionRepository.save(i);

        ModelAndView mav = new ModelAndView("inspection_start");
        mav.addObject("inspection", new GeneralInspection());
        return mav;
    }

    public void issueInspectionNotification(int admin_id, GeneralInspection inspection, int driver_id) throws IOException {
        boolean hasBeenInitialized = false;

        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/driverfleetxserviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(inputStream))
                .setDatabaseUrl("https://fleetx-1530369852255.firebaseio.com")
                .build();

        for (FirebaseApp app : FirebaseApp.getApps()) {
            if (app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                hasBeenInitialized = true;
            }
        }

        if (!hasBeenInitialized) {
            FirebaseApp.initializeApp(options);
        }

        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference(admin_id + "/" + driver_id + "/token");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                if (ds.exists()){
                String reg = ds.getValue().toString();

                Message message = Message.builder()
                        .setNotification(new Notification(
                                "Inspection Issued ," + inspection.getItitle(),
                                inspection.getIdescription()))
                        .setToken(reg)
                        .build();

                try {
                    String response = FirebaseMessaging.getInstance().send(message);
                } catch (FirebaseMessagingException ex) {
                    throw new RuntimeException(ex.getLocalizedMessage());
                }

            }
                else {
                    throw new RuntimeException("well");
                }
            }

            @Override
            public void onCancelled(DatabaseError de) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

    }

    @RequestMapping(value = "/getDriverVehicles/{driverId}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<GeneralVehicle> getVehicles(@PathVariable Integer driverId, HttpServletRequest request) {

        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        List<Vehicle> vehicles = vehicleRepository.findAllWithVehicleDriver(admin_id, driverId);

        if (vehicles != null) {
            if (!vehicles.isEmpty()) {
                return new ResponseEntity<>(GeneralVehicle.getGeneralVehicle(vehicles.get(0)), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new GeneralVehicle(), HttpStatus.OK);
    }

    @RequestMapping(value = "/scheduled_inspection", method = RequestMethod.GET)
    public ModelAndView showScheduledInspection(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("scheduled_inspection");
        mav.addObject("inspection", new GeneralInspection());
        return mav;
    }

}
