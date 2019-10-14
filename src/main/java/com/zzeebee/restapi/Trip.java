package com.zzeebee.restapi;

import com.zzeebee.databasemodel.DriverTrips;
import com.zzeebee.model.GeneralTrip;
import com.zzeebee.model.Status;
import com.zzeebee.repository.DriverTripsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Trip {

    @Autowired(required = true)
    DriverTripsRepository drivertripsRepository;

    @RequestMapping(value = "/setDriverTripStart", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> TripStart(@RequestBody GeneralTrip trip) {

        DriverTrips tr = GeneralTrip.getDriverTrips(trip);
        DriverTrips tri = drivertripsRepository.save(tr);

        if (tri != null) {

            Status s = new Status();
            s.setMessage("success");
            s.setId(tri.getTripId());
            return new ResponseEntity<>(s, HttpStatus.OK);
        }

        Status s = new Status();
        s.setMessage("fail");

        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @RequestMapping(value = "/setDriverTripEnd", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> TripEnd(@RequestBody GeneralTrip trip) {

        DriverTrips tr = drivertripsRepository.findById(trip.getTripId()).get();

        tr.setEndingLat(trip.getEndingLat());
        tr.setEndingLon(trip.getEndingLon());
        tr.setEndingTime(System.currentTimeMillis());
        tr.setAverageScore(trip.getAverageScore());
        tr.setSpeedingScore(trip.getSpeedingScore());
        DriverTrips tri = drivertripsRepository.save(tr);

        if (tri != null) {

            Status s = new Status();
            s.setMessage("success");
            s.setId(tri.getTripId());
            return new ResponseEntity<>(s, HttpStatus.OK);
        }

        Status s = new Status();
        s.setMessage("fail");

        return new ResponseEntity<>(s, HttpStatus.OK);
    }

}
