package com.zzeebee.controllers;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.DriverVehicle;
import com.zzeebee.databasemodel.Vehicle;
import com.zzeebee.model.GeneralVehicle;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.DriverRepository;
import com.zzeebee.repository.DriverVehicleRepository;
import com.zzeebee.repository.VehicleRepository;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArchivedVehicleController {

    @Autowired(required = true)
    DriverVehicleRepository driverVehicleRepository;

    @Autowired(required = true)
    DriverRepository driverRepository;

    @Autowired(required = true)
    VehicleRepository vehicleRepository;
    
     @Autowired(required = true)
    AdminRepository adminRepository;

    @RequestMapping(value = "/archived_vehicle", method = RequestMethod.GET)
    public ModelAndView showArchiveVehicle(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("archived_vehicle");

        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Admin a = adminRepository.findById(admin_id).get();
        Iterable<Vehicle> vehicles = vehicleRepository.findByArchivedAndAdmin("yes", a);
        ArrayList<GeneralVehicle> gen_vehicles = new ArrayList<>();

        for (Vehicle v : vehicles) {
            GeneralVehicle ve = GeneralVehicle.getGeneralVehicle(v);

            if (driverVehicleRepository.existsByVehicle(v)) {
                DriverVehicle dv = driverVehicleRepository.findByVehicle(v);

                Driver d = driverRepository.findById(dv.getDriver().getDriverId()).get();
                ve.setStatus("Assigned");
                ve.setOperator(d.getFirstName() + " " + d.getLastName());
            } else {
                ve.setStatus("Not Assigned");
                ve.setOperator("");
            }

            gen_vehicles.add(ve);
        }
        mav.addObject("vehicles", gen_vehicles);
        return mav;
    }

    @RequestMapping(value = "/unarch_vehicleProcess", method = RequestMethod.GET)
    public ModelAndView UnArchiveVehicle(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
        ModelAndView mav = new ModelAndView("archived_vehicle");

        Vehicle vv = vehicleRepository.findById(id).get();
        vv.setArchived("no");
        vehicleRepository.save(vv);

        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Admin a = adminRepository.findById(admin_id).get();
        Iterable<Vehicle> vehicles = vehicleRepository.findByArchivedAndAdmin("yes", a);
        ArrayList<GeneralVehicle> gen_vehicles = new ArrayList<>();

        for (Vehicle v : vehicles) {
            GeneralVehicle ve = GeneralVehicle.getGeneralVehicle(v);

            if (driverVehicleRepository.existsByVehicle(v)) {
                DriverVehicle dv = driverVehicleRepository.findByVehicle(v);

                Driver d = driverRepository.findById(dv.getDriver().getDriverId()).get();
                ve.setStatus("Assigned");
                ve.setOperator(d.getFirstName() + " " + d.getLastName());
            } else {
                ve.setStatus("Not Assigned");
                ve.setOperator("");
            }

            gen_vehicles.add(ve);
        }
        mav.addObject("vehicles", gen_vehicles);
        mav.addObject("status", "unarchive");
        return mav;

    }

    @RequestMapping(value = "/delete_unvehicleProcess", method = RequestMethod.GET)
    public ModelAndView DeleteArchiveVehicle(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
        ModelAndView mav = new ModelAndView("archived_vehicle");
        Vehicle vv = new Vehicle();
        vv.setVehicleId(id);
        if (driverVehicleRepository.existsByVehicle(vv)) {
            mav.addObject("status", "assigned");
        } else {
            vehicleRepository.delete(vv);
            mav.addObject("status", "successDelete");

        }

        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Admin a = adminRepository.findById(admin_id).get();
        Iterable<Vehicle> vehicles = vehicleRepository.findByArchivedAndAdmin("yes", a);
        ArrayList<GeneralVehicle> gen_vehicles = new ArrayList<>();

        for (Vehicle v : vehicles) {
            GeneralVehicle ve = GeneralVehicle.getGeneralVehicle(v);

            if (driverVehicleRepository.existsByVehicle(v)) {
                DriverVehicle dv = driverVehicleRepository.findByVehicle(v);

                Driver d = driverRepository.findById(dv.getDriver().getDriverId()).get();
                ve.setStatus("Assigned");
                ve.setOperator(d.getFirstName() + " " + d.getLastName());
            } else {
                ve.setStatus("Not Assigned");
                ve.setOperator("");
            }

            gen_vehicles.add(ve);
        }

        mav.addObject("vehicles", gen_vehicles);
        return mav;
    }

}
