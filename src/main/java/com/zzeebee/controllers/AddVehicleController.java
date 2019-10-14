package com.zzeebee.controllers;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Vehicle;
import com.zzeebee.model.GeneralVehicle;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.VehicleRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddVehicleController {

    @Autowired(required = true)
    VehicleRepository vehicleRepository;
    
     @Autowired(required = true)
    AdminRepository adminRepository;
    

    @RequestMapping(value = "/add_vehicle", method = RequestMethod.GET)
    public ModelAndView showAddVehicle(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("add_vehicle");
        mav.addObject("vehicle", new GeneralVehicle());
        return mav;
    }

    @RequestMapping(value = "/add_vehicle_process", method = RequestMethod.POST)
    public ModelAndView addVehicleProcess(@ModelAttribute("vehicle") GeneralVehicle vehicle,
            HttpServletRequest request, HttpServletResponse response) {

        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");

        Vehicle v = GeneralVehicle.getVehicle(vehicle);
        v.setImage(vehicle.getImage_url());
        Admin a = adminRepository.findById(admin_id).get();
        v.setAdmin(a);
        vehicleRepository.save(v);
        ModelAndView mav = new ModelAndView("add_vehicle");
        mav.addObject("vehicle", new GeneralVehicle());
        mav.addObject("status", "add");

        return mav;
    }

    @RequestMapping(value = "/edit_vehicle_process", method = RequestMethod.POST)
    public ModelAndView editVehicleProcess(@ModelAttribute("vehicle") GeneralVehicle vehicle,
            HttpServletRequest request, HttpServletResponse response) {

        Vehicle vv = vehicleRepository.findById(vehicle.getVehicleId()).get();
        GeneralVehicle gvv = GeneralVehicle.getGeneralVehicle(vv);

        ModelAndView mav = new ModelAndView("edit_vehicle");
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");

        Vehicle v = GeneralVehicle.getVehicle(vehicle);
        v.setVehicleId(vehicle.getVehicleId());
        if (vehicle.getImage_url() != null) {
            v.setImage(vehicle.getImage_url());
        } else {
            v.setImage(vv.getImage());
        }
        
        Admin a = adminRepository.findById(admin_id).get();
        v.setAdmin(a);

        vehicleRepository.save(v);
        mav.addObject("status", "add");
        mav.addObject("vehicle", gvv);

        return mav;
    }

}
