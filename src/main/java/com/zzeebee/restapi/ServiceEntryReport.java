package com.zzeebee.restapi;

import com.zzeebee.databasemodel.ServiceEntry;
import com.zzeebee.databasemodel.Vendor;
import com.zzeebee.model.GeneralServiceEntry;
import com.zzeebee.model.GeneralVendor;
import com.zzeebee.model.Status;
import com.zzeebee.model.WorkOrderStatus;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.ServiceEntryRepository;
import com.zzeebee.repository.VendorRepository;
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
public class ServiceEntryReport {
    
    @Autowired(required = true)
    VendorRepository vendorRepository;

    @Autowired(required = true)
    ServiceEntryRepository serviceEntryRepository;

    @Autowired(required = true)
    AdminRepository adminRepository;

    
    
    @RequestMapping(value = "/loadServiceEntry", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<List<GeneralServiceEntry>> loadServieEntry(@RequestBody GeneralVendor user) {
        Vendor d=vendorRepository.findById(user.getVendorId()).get();
        List<ServiceEntry> insp = serviceEntryRepository.findByVendorAndWstatusNot(d,WorkOrderStatus.END_STATUS);
        List<GeneralServiceEntry> gen_insp = new ArrayList<>();

        insp.forEach((inspection) -> {
           GeneralServiceEntry g = GeneralServiceEntry.getGeneralServiceEntry(inspection);
            gen_insp.add(g);

        });

        return new ResponseEntity<>(gen_insp, HttpStatus.OK);

    }
    
    
    
    @RequestMapping(value = "/saveServiceEntry", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> SaveServiceEntry(@RequestBody GeneralServiceEntry serviceEntry) {
        ServiceEntry i = GeneralServiceEntry.getServiceEntry(serviceEntry);
      
        serviceEntryRepository.save(i);
        
        Status s = new Status();
        s.setId(serviceEntry.getVendor_id());
        s.setMessage("success");

        return new ResponseEntity<>(s, HttpStatus.OK);

    }
    
    
    
    
      @RequestMapping(value = "/loadSubmittedServiceEntry", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<List<GeneralServiceEntry>> loadSubmittedServieEntry(@RequestBody GeneralVendor user) {
        Vendor d=vendorRepository.findById(user.getVendorId()).get();
        List<ServiceEntry> insp = serviceEntryRepository.findByVendorAndWstatus(d,WorkOrderStatus.END_STATUS);
        List<GeneralServiceEntry> gen_insp = new ArrayList<>();

        insp.forEach((inspection) -> {
           GeneralServiceEntry g = GeneralServiceEntry.getGeneralServiceEntry(inspection);
            gen_insp.add(g);

        });

        return new ResponseEntity<>(gen_insp, HttpStatus.OK);

    }
    
    
    
}
