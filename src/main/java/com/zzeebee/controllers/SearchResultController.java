package com.zzeebee.controllers;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.DriverVehicle;
import com.zzeebee.databasemodel.Vehicle;
import com.zzeebee.databasemodel.Vendor;
import com.zzeebee.model.GeneralDriver;
import com.zzeebee.model.GeneralVehicle;
import com.zzeebee.model.GeneralVendor;
import com.zzeebee.model.InspectionStatus;
import com.zzeebee.model.Search;
import com.zzeebee.model.WorkOrderStatus;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.DriverRepository;
import com.zzeebee.repository.DriverVehicleRepository;
import com.zzeebee.repository.InspectionRepository;
import com.zzeebee.repository.ServiceEntryRepository;
import com.zzeebee.repository.VehicleRepository;
import com.zzeebee.repository.VendorRepository;
import com.zzeebee.repository.WordOrderRepository;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchResultController {

    @Autowired(required = true)
    VehicleRepository vehicleRepository;

    @Autowired(required = true)
    DriverRepository driverRepository;

    @Autowired(required = true)
    VendorRepository vendorRepository;

    @Autowired(required = true)
    DriverVehicleRepository driverVehicleRepository;

    @Autowired(required = true)
    InspectionRepository inspectionRepository;

    @Autowired(required = true)
    WordOrderRepository workorderRepository;

    @Autowired(required = true)
    ServiceEntryRepository serviceEntryRepository;
    
    @Autowired(required = true)
    AdminRepository adminRepository;

    @RequestMapping(value = "/getSearchResults", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Search>> getSearch(HttpServletRequest request, HttpServletResponse response) {

        List<Search> searches = new ArrayList<>();

        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
      Admin a = adminRepository.findById(admin_id).get();

        Iterable<Vehicle> vc = vehicleRepository.findByAdmin(a);
        Iterable<Driver> dr = driverRepository.findByAdmin(a);
        Iterable<Vendor> vr = vendorRepository.findByAdmin(a);

        for (Vehicle v : vc) {
            Search s = new Search();
            s.setId(v.getVehicleId());
            s.setName(v.getName());
            s.setImg(v.getImage());
            s.setCategory("Vehicle");
            searches.add(s);
        }

        for (Driver v : dr) {
            Search s = new Search();
            s.setId(v.getDriverId());
            s.setName(v.getFirstName() + " " + v.getLastName());
            s.setImg(v.getImage());
            s.setCategory("Driver");
            searches.add(s);
        }

        for (Vendor v : vr) {
            Search s = new Search();
            s.setId(v.getVendorId());
            s.setName(v.getFirstName() + " " + v.getLastName());
            s.setImg(v.getImage());
            s.setCategory("Vendor");
            searches.add(s);
        }

        return new ResponseEntity<>(searches, HttpStatus.OK);
    }

    @RequestMapping(value = "/view_search_result", method = RequestMethod.GET)
    public ModelAndView showSearchResultDetails(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id, @RequestParam("category") String category) {
        ModelAndView mav = null;
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        if (category.equals("Vehicle")) {
            mav = new ModelAndView("vehicle_detail");

            Vehicle v = vehicleRepository.findById(id).get();
            GeneralVehicle gv = GeneralVehicle.getGeneralVehicle(v);

            if (driverVehicleRepository.existsByVehicle(v)) {
                DriverVehicle dv = driverVehicleRepository.findByVehicle(v);
                Driver d = driverRepository.findById(dv.getDriver().getDriverId()).get();
                gv.setStatus("Assigned");
                gv.setOperator(d.getFirstName() + " " + d.getLastName());
                gv.setDriver_id(d.getDriverId());
            } else {
                gv.setStatus("Not Assigned");
                gv.setOperator("");
                gv.setDriver_id(0);
            }

            gv.setAssigned_inspection(inspectionRepository.countByVehicleAndIstatusNot(v, InspectionStatus.END_STATUS).intValue());
            gv.setAssigned_workorders(workorderRepository.countByVehicleAndWstatusNot(v, WorkOrderStatus.END_STATUS).intValue());
            gv.setAssigned_serviceentry(serviceEntryRepository.countByVehicleAndWstatusNot(v, WorkOrderStatus.END_STATUS).intValue());

            mav.addObject("id", admin_id);

            mav.addObject("vehicle", gv);

        } else if (category.equals("Driver")) {
            mav = new ModelAndView("driver_detail");

            Driver d = driverRepository.findById(id).get();
            GeneralDriver gen = GeneralDriver.getGeneralDriver(d);

            if (d.getAverageScore() > 80) {
                gen.setColour("green");
            } else if (d.getAverageScore() > 80 || d.getAverageScore() > 50) {
                gen.setColour("gold");
            } else {
                gen.setColour("red");
            }

            Integer count = vehicleRepository.findAllWithVehicleDriverCount(admin_id, d.getDriverId()).intValue();
            gen.setCountOfVehicles(count);

            if (count > 0) {
                gen.setStatus("Active");
            } else {
                gen.setStatus("Not Active");
            }
            Integer inscount = inspectionRepository.countByDriverAndIstatusNot(d, InspectionStatus.END_STATUS).intValue();
            gen.setCountOfInspections(inscount);

            mav.addObject("driver", gen);
            mav.addObject("id", admin_id);

        } else if (category.equals("Vendor")) {
            mav = new ModelAndView("vendor_detail");
    
        Vendor v = vendorRepository.findById(id).get();
        GeneralVendor gv = GeneralVendor.getGeneralVendor(v);

        int vehcount = workorderRepository.findDistinctVehiclesCount(admin_id, v.getVendorId()).intValue();
        gv.setCountOfVehicles(vehcount);

        int worcount = workorderRepository.countByVendorAndWstatusNot(v, WorkOrderStatus.END_STATUS).intValue();
        gv.setCountOfWorkOrders(worcount);

        int sercount = serviceEntryRepository.countByVendorAndWstatusNot(v, WorkOrderStatus.END_STATUS).intValue();
        gv.setCountOfServiceEntries(sercount);

        if (vehcount > 0) {
            gv.setStatus("Active");
        } else {
            gv.setStatus("Not Active");
        }

        mav.addObject("vendor", gv);
        }

        return mav;
    }

}
