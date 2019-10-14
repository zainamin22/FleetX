package com.zzeebee.restapi;

import com.zzeebee.databasemodel.Driver;
import com.zzeebee.model.DriverDashboard;
import com.zzeebee.model.GeneralDriver;
import com.zzeebee.model.GeneralTrip;
import com.zzeebee.repository.DriverRepository;
import com.zzeebee.repository.DriverTripsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverLocation {

    @Autowired(required = true)
    DriverRepository driverRepository;
    
    @Autowired(required = true)
    DriverTripsRepository drivertripsRepository;

    @RequestMapping(value = "/getAdminId", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<DriverDashboard> getAdminID(@RequestBody GeneralDriver driver) {

        Driver d = driverRepository.findById(driver.getDriverId()).get();
        GeneralDriver de = GeneralDriver.getGeneralDriver(d);
        de.setTotalTrips(drivertripsRepository.countByDriver(d).intValue());
        
        
        GeneralTrip last=GeneralTrip.getGeneralTrip(drivertripsRepository.findTopByDriverOrderByTripIdDesc(d));
                
        DriverDashboard dashboard=new DriverDashboard();
        dashboard.setDriver(de);
        dashboard.setTrip(last);
        
        return new ResponseEntity<>(dashboard, HttpStatus.OK);
    }

}
