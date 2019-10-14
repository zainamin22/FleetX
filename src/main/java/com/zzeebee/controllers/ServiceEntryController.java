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
import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.ServiceEntry;
import com.zzeebee.databasemodel.Vehicle;
import com.zzeebee.databasemodel.Vendor;
import com.zzeebee.model.GeneralServiceEntry;
import com.zzeebee.model.WorkOrderStatus;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.ServiceEntryRepository;
import com.zzeebee.repository.VehicleRepository;
import com.zzeebee.repository.VendorRepository;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceEntryController {

    @Autowired(required = true)
    VehicleRepository vehicleRepository;

    @Autowired(required = true)
    VendorRepository vendorRepository;

    @Autowired(required = true)
    ServiceEntryRepository serviceEntryRepository;

    @Autowired(required = true)
    AdminRepository adminRepository;

    @RequestMapping(value = "/serviceentry_start", method = RequestMethod.GET)
    public ModelAndView showStartServiceEntry(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mav = new ModelAndView("serviceentry_start");
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Admin a = adminRepository.findById(admin_id).get();

        Map<Integer, String> vehicles = new HashMap<>();
        Map<Integer, String> vendors = new HashMap<>();

        Iterable<Vehicle> veh = vehicleRepository.findByAdmin(a);

        for (Vehicle ve : veh) {
            vehicles.put(ve.getVehicleId(), ve.getName());
        }

        Iterable<Vendor> ven = vendorRepository.findByAdmin(a);

        for (Vendor dr : ven) {
            vendors.put(dr.getVendorId(), dr.getFirstName() + " " + dr.getLastName());

        }

        mav.addObject("entry", new GeneralServiceEntry());
        mav.addObject("vehicles", vehicles);
        mav.addObject("vendors", vendors);

        return mav;
    }

    @RequestMapping(value = "/serviceentry_process", method = RequestMethod.POST)
    public ModelAndView ServiceEntryProcess(@ModelAttribute("entry") GeneralServiceEntry entry, HttpServletRequest request, HttpServletResponse response) throws IOException {

        ModelAndView mav = new ModelAndView("serviceentry_start");
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");

        issueNotification(admin_id, entry);

        Admin a = adminRepository.findById(admin_id).get();
        ServiceEntry sen = GeneralServiceEntry.getServiceEntry(entry);

        try {
            Date date = new SimpleDateFormat("MM/dd/yyyy").parse(entry.getDateintext());
            sen.setStartTime(date.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(WordOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

        sen.setWstatus(WorkOrderStatus.START_STATUS);
        sen.setServiceTaskStatus(WorkOrderStatus.UNCHECKED_STATUS);

        sen.setAdmin(a);

        serviceEntryRepository.save(sen);

        Map<Integer, String> vehicles = new HashMap<>();
        Map<Integer, String> vendors = new HashMap<>();

        Iterable<Vehicle> veh = vehicleRepository.findByAdmin(a);

        for (Vehicle ve : veh) {
            vehicles.put(ve.getVehicleId(), ve.getName());
        }

        Iterable<Vendor> ven = vendorRepository.findByAdmin(a);

        for (Vendor dr : ven) {
            vendors.put(dr.getVendorId(), dr.getFirstName() + " " + dr.getLastName());

        }

        mav.addObject("entry", new GeneralServiceEntry());
        mav.addObject("vehicles", vehicles);
        mav.addObject("vendors", vendors);
        mav.addObject("status", "add");

        return mav;
    }

    public void issueNotification(int admin_id, GeneralServiceEntry order) throws IOException {
        boolean hasBeenInitialized = false;

        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/vendorfleetxserviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(inputStream))
                .setDatabaseUrl("https://vendorfleetx.firebaseio.com")
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
                .getReference(admin_id + "/" + order.getVendor_id());

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                String reg = ds.getValue().toString();

                Message message = Message.builder()
                        .setNotification(new Notification(
                                "Service Entry Issued ," + order.getWtitle(),
                                order.getDescription()))
                        .setToken(reg)
                        .build();

                try {
                    String response = FirebaseMessaging.getInstance().send(message);
                } catch (FirebaseMessagingException ex) {
                    throw new RuntimeException(ex.getLocalizedMessage());
                }

            }

            @Override
            public void onCancelled(DatabaseError de) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

    }

}
