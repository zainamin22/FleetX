package com.zzeebee.restapi;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Vendor;
import com.zzeebee.model.FireUser;
import com.zzeebee.model.GeneralVendor;
import com.zzeebee.model.Status;
import com.zzeebee.model.UserAuth;
import com.zzeebee.model.VendorDashboard;
import com.zzeebee.model.WorkOrderStatus;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.ServiceEntryRepository;
import com.zzeebee.repository.VendorRepository;
import com.zzeebee.repository.WordOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorRegistration {
    
     @Autowired(required = true)
    VendorRepository vendorRepository;

    @Autowired(required = true)
    AdminRepository adminRepository;
    
    
      @Autowired(required = true)
    WordOrderRepository workorderRepository;

    @Autowired(required = true)
    ServiceEntryRepository serviceEntryRepository;

    
    
    
      @RequestMapping(value = "/vendorregister", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> adddriver(@RequestBody UserAuth user) {
        Vendor d = new Vendor();
        d.setEmail(user.getEmail());
        d.setFirebaseId(user.getFirebase_id());
        d.setVendorId(user.getId());
        vendorRepository.save(d);
        Vendor ds = vendorRepository.findById(user.getId()).get();
        Status s = new Status();
        s.setId(d.getVendorId());
        s.setMessage("success");

        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @RequestMapping(value = "/firevendorregister", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> addFiredriver(@RequestBody FireUser user) {
   Vendor d = new Vendor();
        d.setEmail(user.getEmail());
        d.setFirebaseId(user.getFirebase_id());
        d.setVendorId(user.getId());
        d.setImage(user.getProfile_pic());

        String[] elements = user.getName().split(" ");
        if (elements.length > 1) {
            d.setFirstName(elements[0]);
            d.setLastName(elements[1]);
        } else if (elements.length == 1) {
            d.setFirstName(elements[0]);
        }
        vendorRepository.save(d);

        Vendor ds = vendorRepository.findById(user.getId()).get();
        Status s = new Status();
        if (ds.getAdmin() != null) {
            s.setId(d.getVendorId());
            s.setMessage("success");
        } else {
            s = new Status();
            s.setId(d.getVendorId());
            s.setMessage("addAdmin");
        }
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @RequestMapping(value = "/addvendorAdmin", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> addAdmin(@RequestBody UserAuth user) {

        Vendor ds = vendorRepository.findById(user.getId()).get();
        Admin a = adminRepository.findByEmail(user.getEmail());
        Status s = new Status();
        s.setId(user.getId());
        if (a != null) {
            s.setMessage("success");
            ds.setAdmin(a);
            vendorRepository.save(ds);
        } else {

            s.setMessage("i nvalid");

        }
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
    
    
    
        @RequestMapping(value = "/getVendorAdminId", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<VendorDashboard> getAdminID(@RequestBody GeneralVendor driver) {

        VendorDashboard v=new VendorDashboard();
        
        Vendor d = vendorRepository.findById(driver.getVendorId()).get();
        GeneralVendor de = GeneralVendor.getGeneralVendor(d);
        v.setGeneralVendor(de);
        
        
        v.setAssignedServiceEntry(serviceEntryRepository.countByVendorAndWstatusNot(d, WorkOrderStatus.END_STATUS).intValue());
        v.setAssignedServiceEntryVehicle(serviceEntryRepository.findDistinctVehiclesCount(d.getAdmin().getAdminId(),d.getVendorId() ).intValue());
        v.setAssignedWorkOrders(workorderRepository.countByVendorAndWstatusNot(d, WorkOrderStatus.END_STATUS).intValue());
        v.setAssignedWorkOrdersVehicle(workorderRepository.findDistinctVehiclesCount(d.getAdmin().getAdminId(),d.getVendorId() ).intValue());
        v.setCompletedServiceEntry(serviceEntryRepository.countByVendorAndWstatus(d, WorkOrderStatus.END_STATUS).intValue());
        v.setCompletedWorkOrders(workorderRepository.countByVendorAndWstatus(d, WorkOrderStatus.END_STATUS).intValue());
        

        return new ResponseEntity<>(v, HttpStatus.OK);
    }
    
    
    
}
