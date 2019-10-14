package com.zzeebee.restapi;

import com.zzeebee.databasemodel.Driver;
import com.zzeebee.model.FireUser;
import com.zzeebee.model.GeneralDriver;
import com.zzeebee.model.Status;
import com.zzeebee.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverProfileUpdate {

    @Autowired(required = true)
    DriverRepository driverRepository;

    @RequestMapping(value = "/updateDriverProfile", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> adddriver(@RequestBody FireUser user) {

        Driver d = driverRepository.findById(user.getId()).get();
          d.setEmail(user.getEmail());     
          String[] elements = user.getName().split(" ");
        if (elements.length > 1) {
            d.setFirstName(elements[0]);
            d.setLastName(elements[1]);
        } else if (elements.length == 1) {
            d.setFirstName(elements[0]);
        }
               
        d.setImage(user.getProfile_pic());

        driverRepository.save(d);

        Status s = new Status();
        s.setId(d.getDriverId());
        s.setMessage("success");

        return new ResponseEntity<>(s, HttpStatus.OK);
    }
    
    
        @RequestMapping(value = "/loadDriverInfo", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<GeneralDriver> getDriverInfo(@RequestBody GeneralDriver driver) {

        Driver d = driverRepository.findById(driver.getDriverId()).get();
        GeneralDriver de = GeneralDriver.getGeneralDriver(d);
        
        return new ResponseEntity<>(de, HttpStatus.OK);
    }
    
    
      @RequestMapping(value = "/updateDriverUserInfo", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> updateDriverUserInfo(@RequestBody GeneralDriver driver) {

        Driver d = driverRepository.findById(driver.getDriverId()).get();
        d.setAddress(driver.getAddress());
        d.setCity(driver.getCity());
        d.setCountry(driver.getCountry());
        d.setDateOfBirth(driver.getDateOfBirth());
        
        driverRepository.save(d);
        
           Status s = new Status();
        s.setId(d.getDriverId());
        s.setMessage("success");
        
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
    
    
    
    
       @RequestMapping(value = "/updateDriverDriverInfo", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> updateDriverDriverInfo(@RequestBody GeneralDriver driver) {

        Driver d = driverRepository.findById(driver.getDriverId()).get();
        d.setLicenceExpiryDate(driver.getLicenceExpiryDate());
        d.setLicenceNo(driver.getLicenceNo());
        d.setCnic(driver.getCnic());
        
        driverRepository.save(d);
        
           Status s = new Status();
        s.setId(d.getDriverId());
        s.setMessage("success");
        
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
    
    
    
    
    
    

}
