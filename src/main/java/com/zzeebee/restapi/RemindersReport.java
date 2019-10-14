package com.zzeebee.restapi;

import com.zzeebee.databasemodel.Reminders;
import com.zzeebee.model.GeneralDriver;
import com.zzeebee.model.GeneralReminder;
import com.zzeebee.model.GeneralVendor;
import com.zzeebee.repository.ReminderRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RemindersReport {

    @Autowired(required = true)
    ReminderRepository reminderRepository;

    @RequestMapping(value = "/getDriverReminders", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<List<GeneralReminder>> loadingDriverReminders(@RequestBody GeneralDriver user) {

        List<Reminders> reminders = reminderRepository.findByIssuedToIdAndIssuedTo(user.getDriverId(),"driver");
        ArrayList<GeneralReminder> gen_reminder = new ArrayList<>();

        for (Reminders d : reminders) {
            GeneralReminder gen = GeneralReminder.getGeneralReminder(d);
            gen_reminder.add(gen);
        }

        return new ResponseEntity<>(gen_reminder, HttpStatus.OK);

    }

      @RequestMapping(value = "/getVendorReminders", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<List<GeneralReminder>> loadingVendorReminders(@RequestBody GeneralVendor user) {

        List<Reminders> reminders = reminderRepository.findByIssuedToIdAndIssuedTo(user.getVendorId(),"vendor");
        ArrayList<GeneralReminder> gen_reminder = new ArrayList<>();

        for (Reminders d : reminders) {
            GeneralReminder gen = GeneralReminder.getGeneralReminder(d);
            gen_reminder.add(gen);
        }

        return new ResponseEntity<>(gen_reminder, HttpStatus.OK);

    }

    
    
    
}
