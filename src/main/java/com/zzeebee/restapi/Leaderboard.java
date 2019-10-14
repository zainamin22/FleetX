package com.zzeebee.restapi;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Driver;
import com.zzeebee.model.GeneralDriver;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.DriverRepository;
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
public class Leaderboard {

    @Autowired(required = true)
    DriverRepository driverRepository;

    @Autowired(required = true)
    AdminRepository adminRepository;

    @RequestMapping(value = "/getDriverLeaderboard", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<List<GeneralDriver>> loadingInspections(@RequestBody GeneralDriver user) {

        Admin a = adminRepository.findById(user.getAdmin_id()).get();
        Iterable<Driver> drivers = driverRepository.findByAdminOrderByAverageScoreDesc(a);
        ArrayList<GeneralDriver> gen_driver = new ArrayList<>();
        
        for (Driver d : drivers) {
            GeneralDriver gen = GeneralDriver.getGeneralDriver(d);
            gen_driver.add(gen);
        }

        return new ResponseEntity<>(gen_driver, HttpStatus.OK);

    }

}
