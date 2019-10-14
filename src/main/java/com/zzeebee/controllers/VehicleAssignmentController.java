package com.zzeebee.controllers;

import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.DriverVehicle;
import com.zzeebee.databasemodel.Vehicle;
import com.zzeebee.model.GeneralAssignment;
import com.zzeebee.repository.DriverRepository;
import com.zzeebee.repository.DriverVehicleRepository;
import com.zzeebee.repository.VehicleRepository;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VehicleAssignmentController {

    @Autowired(required = true)
    DriverVehicleRepository driverVehicleRepository;

    @Autowired(required = true)
    DriverRepository driverRepository;

    @Autowired(required = true)
    VehicleRepository vehicleRepository;
    
   
    
    

    @RequestMapping(value = "/assign_vehicle", method = RequestMethod.GET)
    public ModelAndView showAssignVehicle(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("vehicle_assignment");
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");

        Iterable<Vehicle> v = vehicleRepository.findAllWithVehicle(admin_id);
        Iterable<Driver> d = driverRepository.findAllWithDriver(admin_id);

        Iterable<Driver> assigned = driverRepository.findAllWithDriverAssigned(admin_id);

        Map<Integer, String> drivers = new HashMap<>();

        for (Driver dr : d) {
            drivers.put(dr.getDriverId(), dr.getFirstName() + " " + dr.getLastName());

        }

        Map<Integer, String> vehicles = new HashMap<>();
        for (Vehicle ve : v) {
            vehicles.put(ve.getVehicleId(), ve.getName());
        }

        Map<Integer, String> assigneda = new HashMap<>();
        for (Driver dr : assigned) {

            assigneda.put(dr.getDriverId(), dr.getFirstName() + " " + dr.getLastName());
        }

        mav.addObject("vehicles", vehicles);
        mav.addObject("drivers", drivers);
        mav.addObject("assigned", assigneda);
        mav.addObject("assignment", new GeneralAssignment());
        mav.addObject("unassignment", new GeneralAssignment());

        return mav;
    }

    @RequestMapping(value = "/assign_vehicle_process", method = RequestMethod.POST)
    public ModelAndView AssignVehicle(@ModelAttribute("assignment") GeneralAssignment assignment, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("vehicle_assignment");
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        driverVehicleRepository.save(GeneralAssignment.getDriverVehicle(assignment));
        Iterable<Vehicle> v = vehicleRepository.findAllWithVehicle(admin_id);
        Iterable<Driver> d = driverRepository.findAllWithDriver(admin_id);
        Iterable<Driver> assigned = driverRepository.findAllWithDriverAssigned(admin_id);

        Map<Integer, String> drivers = new HashMap<>();

        for (Driver dr : d) {
            drivers.put(dr.getDriverId(), dr.getFirstName() + " " + dr.getLastName());

        }

        Map<Integer, String> vehicles = new HashMap<>();
        for (Vehicle ve : v) {
            vehicles.put(ve.getVehicleId(), ve.getName());
        }

        Map<Integer, String> assigneda = new HashMap<>();
        for (Driver dr : assigned) {

            assigneda.put(dr.getDriverId(), dr.getFirstName() + " " + dr.getLastName());
        }

        mav.addObject("vehicles", vehicles);
        mav.addObject("drivers", drivers);
        mav.addObject("assignment", new GeneralAssignment());
        mav.addObject("assigned", assigneda);
        mav.addObject("unassignment", new GeneralAssignment());
        mav.addObject("status", "assign");
        return mav;
    }

    @RequestMapping(value = "/unassign_vehicle_process", method = RequestMethod.POST)
    public ModelAndView UnAssignVehicle(@ModelAttribute("unassignment") GeneralAssignment assignment, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("vehicle_assignment");

        if (assignment.getDriverId() != 0 || assignment.getVehicleId() != 0) {

            Driver d = new Driver();
            d.setDriverId(assignment.getDriverId());
            Vehicle v = new Vehicle();
            v.setVehicleId(assignment.getVehicleId());
            DriverVehicle dv = driverVehicleRepository.findByDriverAndVehicle(d, v);
            driverVehicleRepository.delete(dv);
            mav.addObject("status", "unassign");

        } else {

            mav.addObject("status", "fail");

        }

        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Iterable<Vehicle> v = vehicleRepository.findAllWithVehicle(admin_id);
        Iterable<Driver> d = driverRepository.findAllWithDriver(admin_id);
        Iterable<Driver> assigned = driverRepository.findAllWithDriverAssigned(admin_id);

        Map<Integer, String> drivers = new HashMap<>();

        for (Driver dr : d) {
            drivers.put(dr.getDriverId(), dr.getFirstName() + " " + dr.getLastName());

        }

        Map<Integer, String> vehicles = new HashMap<>();
        for (Vehicle ve : v) {
            vehicles.put(ve.getVehicleId(), ve.getName());
        }

        Map<Integer, String> assigneda = new HashMap<>();
        for (Driver dr : assigned) {

            assigneda.put(dr.getDriverId(), dr.getFirstName() + " " + dr.getLastName());
        }

        mav.addObject("vehicles", vehicles);
        mav.addObject("drivers", drivers);
        mav.addObject("assignment", new GeneralAssignment());
        mav.addObject("unassignment", new GeneralAssignment());
        mav.addObject("assigned", assigneda);

        return mav;
    }

}
