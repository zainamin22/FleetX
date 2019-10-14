package com.zzeebee.restapi;

import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.Inspection;
import com.zzeebee.model.GeneralDriver;
import com.zzeebee.model.GeneralInspection;
import com.zzeebee.model.InspectionStatus;
import com.zzeebee.model.Status;
import com.zzeebee.repository.InspectionRepository;
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
public class InspectionReports {

    @Autowired(required = true)
    InspectionRepository inspectionRepository;

    @RequestMapping(value = "/loadInspections", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<List<GeneralInspection>> loadingInspections(@RequestBody GeneralDriver user) {
        Driver d = new Driver();
        d.setDriverId(user.getDriverId());
        List<Inspection> insp = inspectionRepository.findByDriverAndIstatusNot(d,InspectionStatus.END_STATUS);
        List<GeneralInspection> gen_insp = new ArrayList<>();

        insp.forEach((inspection) -> {
            GeneralInspection g = GeneralInspection.getGeneralInspection(inspection);
            g.setChecked();
            g.setTotal();
            gen_insp.add(g);

        });

        return new ResponseEntity<>(gen_insp, HttpStatus.OK);

    }
    
      @RequestMapping(value = "/loadCompletedInspections", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<List<GeneralInspection>> loadingSubmittedInspections(@RequestBody GeneralDriver user) {
        Driver d = new Driver();
        d.setDriverId(user.getDriverId());
        List<Inspection> insp = inspectionRepository.findByDriverAndIstatus(d,InspectionStatus.END_STATUS);
        List<GeneralInspection> gen_insp = new ArrayList<>();
        insp.forEach((inspection) -> {
            GeneralInspection g = GeneralInspection.getGeneralInspection(inspection);
            g.setResolved();
            g.setUnResolved();
            gen_insp.add(g);

        });
        return new ResponseEntity<>(gen_insp, HttpStatus.OK);

    }
    
    @RequestMapping(value = "/saveInspections", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Status> SaveInspections(@RequestBody GeneralInspection inspection) {
        Inspection i = GeneralInspection.getInspection(inspection);
        inspectionRepository.save(i);

        Status s = new Status();
        s.setId(inspection.getDriverId());
        s.setMessage("success");

        return new ResponseEntity<>(s, HttpStatus.OK);

    }

}
