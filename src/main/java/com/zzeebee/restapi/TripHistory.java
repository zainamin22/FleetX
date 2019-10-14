package com.zzeebee.restapi;

import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.DriverTrips;
import com.zzeebee.model.GeneralDriver;
import com.zzeebee.model.GeneralTrip;
import com.zzeebee.repository.DriverTripsRepository;
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
public class TripHistory {

    @Autowired(required = true)
    DriverTripsRepository drivertripsRepository;

    @RequestMapping(value = "/getTripHistory", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<List<GeneralTrip>> getTripHistory(@RequestBody GeneralDriver driver) {
        Driver d = new Driver();
        d.setDriverId(driver.getDriverId());
        List<DriverTrips> trips = drivertripsRepository.findByDriver(d);
        List<GeneralTrip> tris = new ArrayList<>();

        trips.forEach(tr -> {
            GeneralTrip tra = GeneralTrip.getGeneralTrip(tr);
            tris.add(tra);
        });

        return new ResponseEntity<>(tris, HttpStatus.OK);
    }

}
