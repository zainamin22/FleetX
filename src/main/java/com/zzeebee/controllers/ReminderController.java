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
import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.DriverVehicle;
import com.zzeebee.databasemodel.Reminders;
import com.zzeebee.databasemodel.Vehicle;
import com.zzeebee.databasemodel.Vendor;
import com.zzeebee.model.DriverRenewalReminders;
import com.zzeebee.model.ServiceReminders;
import com.zzeebee.model.VehicleReminders;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.DriverRepository;
import com.zzeebee.repository.DriverVehicleRepository;
import com.zzeebee.repository.ReminderRepository;
import com.zzeebee.repository.VehicleRepository;
import com.zzeebee.repository.VendorRepository;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public class ReminderController {

    @Autowired(required = true)
    DriverVehicleRepository driverVehicleRepository;

    @Autowired(required = true)
    DriverRepository driverRepository;

    @Autowired(required = true)
    VehicleRepository vehicleRepository;

    @Autowired(required = true)
    VendorRepository vendorRepository;

    @Autowired(required = true)
    ReminderRepository reminderRepository;

    @Autowired(required = true)
    AdminRepository adminRepository;

    @RequestMapping(value = "/showReminder", method = RequestMethod.GET)
    public ModelAndView showReminders(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("issue_notification");
        mav.addObject("service", new ServiceReminders());
        mav.addObject("driverrem", new DriverRenewalReminders());
        mav.addObject("vehiclerem", new VehicleReminders());
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Admin a = adminRepository.findById(admin_id).get();

        Iterable<Driver> dr = driverRepository.findByAdmin(a);
        Iterable<Vehicle> ve = vehicleRepository.findAllWithVehicleAssigned(admin_id);
        Iterable<Vendor> ven = vendorRepository.findByAdmin(a);

        Map<Integer, String> drivers = new HashMap<>();
        Map<Integer, String> vehicles = new HashMap<>();
        Map<Integer, String> vendors = new HashMap<>();

        for (Driver d : dr) {
            drivers.put(d.getDriverId(), d.getFirstName() + " " + d.getLastName());

        }

        for (Vendor d : ven) {
            vendors.put(d.getVendorId(), d.getFirstName() + " " + d.getLastName());

        }

        for (Vehicle v : ve) {
            vehicles.put(v.getVehicleId(), v.getName());
        }

        mav.addObject("vehicles", vehicles);
        mav.addObject("drivers", drivers);
        mav.addObject("vendors", vendors);

        return mav;
    }

    @RequestMapping(value = "/issue_service_reminder", method = RequestMethod.POST)
    public ModelAndView issueServiceReminder(@ModelAttribute("service") ServiceReminders reminder,
            HttpServletRequest request, HttpServletResponse response) throws IOException {

        Reminders r = new Reminders();
        r.setReminderTitle(reminder.getService_title());
        r.setReminderDescription(reminder.getService_description());
        r.setIssuedTo("vendor");
        r.setIssuedToId(reminder.getVendor_id());
        r.setReminderType("service");

        try {
            Date date = new SimpleDateFormat("MM/dd/yyyy").parse(reminder.getIssue_date());
            r.setIssuedTime(date.getTime());

            Calendar c = Calendar.getInstance();
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);

            Date today = c.getTime();

            if (date.after(today)) {
                r.setIssuedType("overdue");
            } else {
                r.setIssuedType("issued");
            }

        } catch (ParseException ex) {
            Logger.getLogger(WordOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

        reminderRepository.save(r);

        ModelAndView mav = new ModelAndView("issue_notification");
        mav.addObject("service", new ServiceReminders());
        mav.addObject("driverrem", new DriverRenewalReminders());
        mav.addObject("vehiclerem", new VehicleReminders());
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Admin a = adminRepository.findById(admin_id).get();
        

        Iterable<Driver> dr = driverRepository.findByAdmin(a);
        Iterable<Vehicle> ve = vehicleRepository.findAllWithVehicleAssigned(admin_id);
        Iterable<Vendor> ven = vendorRepository.findByAdmin(a);

        Map<Integer, String> drivers = new HashMap<>();
        Map<Integer, String> vehicles = new HashMap<>();
        Map<Integer, String> vendors = new HashMap<>();

        for (Driver d : dr) {
            drivers.put(d.getDriverId(), d.getFirstName() + " " + d.getLastName());

        }

        for (Vendor d : ven) {
            vendors.put(d.getVendorId(), d.getFirstName() + " " + d.getLastName());

        }

        for (Vehicle v : ve) {
            vehicles.put(v.getVehicleId(), v.getName());
        }
        
        issueServiceNotification(admin_id, reminder);

        mav.addObject("vehicles", vehicles);
        mav.addObject("drivers", drivers);
        mav.addObject("vendors", vendors);
        mav.addObject("status", "add");

        return mav;
    }

    @RequestMapping(value = "/issue_driver_reminder", method = RequestMethod.POST)
    public ModelAndView issueDriverReminder(@ModelAttribute("driver") DriverRenewalReminders reminder,
            HttpServletRequest request, HttpServletResponse response) throws IOException {

        Reminders r = new Reminders();
        r.setReminderTitle(reminder.getRenewal_title());
        r.setReminderDescription(reminder.getRenewal_description());
        r.setIssuedTo("driver");
        r.setIssuedToId(reminder.getDriver_id());
        r.setReminderType("driver_renewal");

        try {
            Date date = new SimpleDateFormat("MM/dd/yyyy").parse(reminder.getIssue_date());
            r.setIssuedTime(date.getTime());

            Calendar c = Calendar.getInstance();
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);

            Date today = c.getTime();

            if (date.after(today)) {
                r.setIssuedType("overdue");
            } else {
                r.setIssuedType("issued");
            }

        } catch (ParseException ex) {
            Logger.getLogger(WordOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

        reminderRepository.save(r);

        ModelAndView mav = new ModelAndView("issue_notification");
        mav.addObject("service", new ServiceReminders());
        mav.addObject("driverrem", new DriverRenewalReminders());
        mav.addObject("vehiclerem", new VehicleReminders());
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Admin a = adminRepository.findById(admin_id).get();

        issueDriverNotification(admin_id, reminder);

        Iterable<Driver> dr = driverRepository.findByAdmin(a);
        Iterable<Vehicle> ve = vehicleRepository.findAllWithVehicleAssigned(admin_id);
        Iterable<Vendor> ven = vendorRepository.findByAdmin(a);

        Map<Integer, String> drivers = new HashMap<>();
        Map<Integer, String> vehicles = new HashMap<>();
        Map<Integer, String> vendors = new HashMap<>();

        for (Driver d : dr) {
            drivers.put(d.getDriverId(), d.getFirstName() + " " + d.getLastName());

        }

        for (Vendor d : ven) {
            vendors.put(d.getVendorId(), d.getFirstName() + " " + d.getLastName());

        }

        for (Vehicle v : ve) {
            vehicles.put(v.getVehicleId(), v.getName());
        }

        mav.addObject("vehicles", vehicles);
        mav.addObject("drivers", drivers);
        mav.addObject("vendors", vendors);
        mav.addObject("status", "add");

        return mav;
    }

    @RequestMapping(value = "/issue_vehicle_reminder", method = RequestMethod.POST)
    public ModelAndView issueVehicleReminder(@ModelAttribute("vehicle") VehicleReminders reminder,
            HttpServletRequest request, HttpServletResponse response) throws IOException {

        Vehicle vvv = new Vehicle();
        vvv.setVehicleId(reminder.getVehicle_id());
        DriverVehicle dv = driverVehicleRepository.findByVehicle(vvv);

        Reminders r = new Reminders();
        r.setReminderTitle(reminder.getRenewal_title());
        r.setReminderDescription(reminder.getRenewal_description());
        r.setIssuedTo("driver");
        r.setIssuedToId(dv.getDriver().getDriverId());
        r.setReminderType("vehicle_renewal");

        try {
            Date date = new SimpleDateFormat("MM/dd/yyyy").parse(reminder.getIssue_date());
            r.setIssuedTime(date.getTime());

            Calendar c = Calendar.getInstance();
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);

            Date today = c.getTime();

            if (date.after(today)) {
                r.setIssuedType("overdue");
            } else {
                r.setIssuedType("issued");
            }

        } catch (ParseException ex) {
            Logger.getLogger(WordOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

        reminderRepository.save(r);

        ModelAndView mav = new ModelAndView("issue_notification");
        mav.addObject("service", new ServiceReminders());
        mav.addObject("driverrem", new DriverRenewalReminders());
        mav.addObject("vehiclerem", new VehicleReminders());
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Admin a = adminRepository.findById(admin_id).get();

        issueVehicleNotification(admin_id, reminder, dv.getDriver().getDriverId());

        Iterable<Driver> dr = driverRepository.findByAdmin(a);
        Iterable<Vehicle> ve = vehicleRepository.findAllWithVehicleAssigned(admin_id);
        Iterable<Vendor> ven = vendorRepository.findByAdmin(a);

        Map<Integer, String> drivers = new HashMap<>();
        Map<Integer, String> vehicles = new HashMap<>();
        Map<Integer, String> vendors = new HashMap<>();

        for (Driver d : dr) {
            drivers.put(d.getDriverId(), d.getFirstName() + " " + d.getLastName());

        }

        for (Vendor d : ven) {
            vendors.put(d.getVendorId(), d.getFirstName() + " " + d.getLastName());

        }

        for (Vehicle v : ve) {
            vehicles.put(v.getVehicleId(), v.getName());
        }

        mav.addObject("vehicles", vehicles);
        mav.addObject("drivers", drivers);
        mav.addObject("vendors", vendors);
        mav.addObject("status", "add");

        return mav;
    }

    public void issueServiceNotification(int admin_id, ServiceReminders reminder) throws IOException {
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
                .getReference(admin_id + "/" + reminder.getVendor_id());

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                String reg = ds.getValue().toString();

                Message message = Message.builder()
                        .setNotification(new Notification(
                                "Service Reminder Issued ," + reminder.getService_title(),
                                reminder.getService_description()))
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

    public void issueDriverNotification(int admin_id, DriverRenewalReminders reminder) throws IOException {
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
                .getReference(admin_id + "/" + reminder.getDriver_id() + "/token");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                String reg = ds.getValue().toString();

                Message message = Message.builder()
                        .setNotification(new Notification(
                                "Driver Renewal Reminder Issued ," + reminder.getRenewal_title(),
                                reminder.getRenewal_description()))
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

    public void issueVehicleNotification(int admin_id, VehicleReminders reminder, int driver_id) throws IOException {
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
                String reg = ds.getValue().toString();

                Message message = Message.builder()
                        .setNotification(new Notification(
                                "Vehicle Renewal Reminder Issued ," + reminder.getRenewal_title(),
                                reminder.getRenewal_description()))
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
