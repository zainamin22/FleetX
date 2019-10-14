package com.zzeebee.restapi;

import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.Admin;
import com.zzeebee.model.FireUser;
import com.zzeebee.model.Status;
import com.zzeebee.model.UserAuth;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverRegistration {

    @Autowired(required = true)
    DriverRepository driverRepository;

    @Autowired(required = true)
    AdminRepository adminRepository;

    @RequestMapping(value = "/driverregister", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> adddriver(@RequestBody UserAuth user) {
        Driver d = new Driver();
        d.setEmail(user.getEmail());
        d.setFirebaseId(user.getFirebase_id());
        d.setDriverId(user.getId());
        driverRepository.save(d);
        Driver ds = driverRepository.findById(user.getId()).get();
        Status s = new Status();
        s.setId(d.getDriverId());
        s.setMessage("success");

        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @RequestMapping(value = "/firedriverregister", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> addFiredriver(@RequestBody FireUser user) {
        Driver d = new Driver();
        d.setEmail(user.getEmail());
        d.setFirebaseId(user.getFirebase_id());
        d.setDriverId(user.getId());
        d.setImage(user.getProfile_pic());

        String[] elements = user.getName().split(" ");
        if (elements.length > 1) {
            d.setFirstName(elements[0]);
            d.setLastName(elements[1]);
        } else if (elements.length == 1) {
            d.setFirstName(elements[0]);
        }
        driverRepository.save(d);

        Driver ds = driverRepository.findById(user.getId()).get();
        Status s = new Status();
        if (ds.getAdmin() != null) {
            s.setId(d.getDriverId());
            s.setMessage("success");
        } else {
            s = new Status();
            s.setId(d.getDriverId());
            s.setMessage("addAdmin");
        }
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> addAdmin(@RequestBody UserAuth user) {

        Driver ds = driverRepository.findById(user.getId()).get();
        Admin a = adminRepository.findByEmail(user.getEmail());
        Status s = new Status();
        s.setId(user.getId());
        if (a != null) {
            s.setMessage("success");
            ds.setAdmin(a);
            driverRepository.save(ds);
        } else {

            s.setMessage("invalid");

        }
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

}
