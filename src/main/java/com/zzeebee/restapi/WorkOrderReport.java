package com.zzeebee.restapi;

import com.zzeebee.databasemodel.Vendor;
import com.zzeebee.databasemodel.WorkOrders;
import com.zzeebee.model.GeneralVendor;
import com.zzeebee.model.GeneralWorkOrders;
import com.zzeebee.model.Status;
import com.zzeebee.model.WorkOrderStatus;
import com.zzeebee.repository.WordOrderRepository;
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
public class WorkOrderReport {

    @Autowired(required = true)
    WordOrderRepository wordOrderRepository;

    @RequestMapping(value = "/loadWordOrder", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity< List<GeneralWorkOrders>> loadingWordOrder(@RequestBody GeneralVendor user) {
        Vendor d = new Vendor();
        d.setVendorId(user.getVendorId());
        List<WorkOrders> insp = wordOrderRepository.findByVendorAndWstatusNot(d,WorkOrderStatus.END_STATUS);
        List<GeneralWorkOrders> gen_insp = new ArrayList<>();

        insp.forEach((workorder) -> {
            GeneralWorkOrders g = GeneralWorkOrders.getGeneralWorkOrder(workorder);
            gen_insp.add(g);

        });

        return new ResponseEntity<>(gen_insp, HttpStatus.OK);

    }
    
     @RequestMapping(value = "/loadSubmittedWordOrder", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity< List<GeneralWorkOrders>> loadingSubmittedWordOrder(@RequestBody GeneralVendor user) {
        Vendor d = new Vendor();
        d.setVendorId(user.getVendorId());
        List<WorkOrders> insp = wordOrderRepository.findByVendorAndWstatus(d,WorkOrderStatus.END_STATUS);
        List<GeneralWorkOrders> gen_insp = new ArrayList<>();

        insp.forEach((workorder) -> {
            GeneralWorkOrders g = GeneralWorkOrders.getGeneralWorkOrder(workorder);
            gen_insp.add(g);

        });

        return new ResponseEntity<>(gen_insp, HttpStatus.OK);

    }

    @RequestMapping(value = "/saveWorkOrder", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> SaveWorkOrder(@RequestBody GeneralWorkOrders workOrders) {
        WorkOrders i = GeneralWorkOrders.getWorkOrder(workOrders);
        wordOrderRepository.save(i);

        Status s = new Status();
        s.setId(workOrders.getVendor_id());
        s.setMessage("success");

        return new ResponseEntity<>(s, HttpStatus.OK);

    }

}
