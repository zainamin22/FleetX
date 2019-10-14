package com.zzeebee.controllers;

import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.DriverTrips;
import com.zzeebee.model.GeneralDriver;
import com.zzeebee.model.GeneralTrip;
import com.zzeebee.repository.DriverRepository;
import com.zzeebee.repository.DriverTripsRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TripController {

    @Autowired(required = true)
    DriverRepository driverRepository;

    @Autowired(required = true)
    DriverTripsRepository driverTripsRepository;

    @RequestMapping(value = "/view_driver_trips", method = RequestMethod.GET)
    public ModelAndView showViewDriverTrips(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
        ModelAndView mav = new ModelAndView("trip_list");

        Driver d = driverRepository.findById(id).get();
        GeneralDriver gen = GeneralDriver.getGeneralDriver(d);

        List<DriverTrips> trips = driverTripsRepository.findByDriver(d);

        List<GeneralTrip> gentrips = new ArrayList<>();

        trips.forEach(item -> {
            GeneralTrip tr = GeneralTrip.getGeneralTrip(item);

            if (item.getAverageScore() > 80) {
                tr.setColour("green");
            } else if (item.getAverageScore() < 80 && item.getAverageScore() > 50) {
                tr.setColour("gold");
            } else {
                tr.setColour("red");
            }
            String timetext = "";
            String datetext = "";
            DateFormat df = new SimpleDateFormat("hh.mm aa");
            DateFormat df1 = new SimpleDateFormat("EEE, d MMM yyyy");
            Date start = new Date(tr.getStartingTime());
            if (tr.getEndingTime() != null) {
                Date end = new Date(tr.getEndingTime());
                timetext = df.format(start) + " - " + df.format(end);
                datetext = df1.format(start) + " - " + df1.format(end);
            } else {
                timetext = df.format(start) + " - ";
                datetext = df1.format(start) + " - ";
            }
            tr.setTimeText(timetext);
            tr.setDateText(datetext);

            gentrips.add(tr);
        });

        mav.addObject("driver", gen);
        mav.addObject("trips", gentrips);

        return mav;
    }

}
