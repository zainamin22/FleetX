package com.zzeebee.restapi;

import com.zzeebee.databasemodel.Vendor;
import com.zzeebee.model.FireUser;
import com.zzeebee.model.GeneralVendor;
import com.zzeebee.model.Status;
import com.zzeebee.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorProfileUpdate {
      @Autowired(required = true)
    VendorRepository vendorRepository;

    @RequestMapping(value = "/updateVendorProfile", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> addVendor(@RequestBody FireUser user) {

        Vendor d = vendorRepository.findById(user.getId()).get();
        d.setEmail(user.getEmail());     
          String[] elements = user.getName().split(" ");
        if (elements.length > 1) {
            d.setFirstName(elements[0]);
            d.setLastName(elements[1]);
        } else if (elements.length == 1) {
            d.setFirstName(elements[0]);
        }
               
        d.setImage(user.getProfile_pic());
        
       
        vendorRepository.save(d);

        Status s = new Status();
        s.setId(d.getVendorId());
        s.setMessage("success");

        return new ResponseEntity<>(s, HttpStatus.OK);
    }
    
    
     @RequestMapping(value = "/loadVendorInfo", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<GeneralVendor> getVendorInfo(@RequestBody GeneralVendor vendor) {

        Vendor d = vendorRepository.findById(vendor.getVendorId()).get();
        GeneralVendor de = GeneralVendor.getGeneralVendor(d);
        
        return new ResponseEntity<>(de, HttpStatus.OK);
    }
    
    
    
    
    
    @RequestMapping(value = "/updateVendorInfo", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> UpdateVendorInfo(@RequestBody GeneralVendor user) {

        Vendor d = vendorRepository.findById(user.getVendorId()).get();
        d.setAddress(user.getAddress());
        d.setCity(user.getCity());
        d.setCountry(user.getCountry());
        
       
        vendorRepository.save(d);

        Status s = new Status();
        s.setId(d.getVendorId());
        s.setMessage("success");

        return new ResponseEntity<>(s, HttpStatus.OK);
    }
    
    
    
    
    
}
