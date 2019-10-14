package com.zzeebee.controllers;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Driver;
import com.zzeebee.model.GeneralDriver;
import com.zzeebee.model.InspectionStatus;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.DriverRepository;
import com.zzeebee.repository.InspectionRepository;
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
public class ViewDriversController {

    @Autowired(required = true)
    DriverRepository driverRepository;
    
     @Autowired(required = true)
    VehicleRepository vehicleRepository;
     
        @Autowired(required = true)
    InspectionRepository inspectionRepository;
        
             @Autowired(required = true)
    AdminRepository adminRepository;
        
        

    @RequestMapping(value = "/drivers", method = RequestMethod.GET)
    public ModelAndView showDrivers(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("driver_list");
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Admin admin = adminRepository.findById(admin_id).get();
        Iterable<Driver> drivers = driverRepository.findByAdmin(admin);
        ArrayList<GeneralDriver> gen_driver = new ArrayList<>();

        for (Driver d : drivers) {
            GeneralDriver gen = GeneralDriver.getGeneralDriver(d);
            
            Integer count=vehicleRepository.findAllWithVehicleDriverCount(admin_id, d.getDriverId()).intValue();
            gen.setCountOfVehicles(count);

            gen_driver.add(gen);

        }
        mav.addObject("drivers", gen_driver);
        return mav;
    }
    
    
    
    
    
       @RequestMapping(value = "/view_driver_details", method = RequestMethod.GET)
    public ModelAndView showViewDriverDetails(HttpServletRequest request, HttpServletResponse response,@RequestParam("id") int id) {
        ModelAndView mav = new ModelAndView("driver_detail");
           Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
      Driver d=driverRepository.findById(id).get();
      GeneralDriver gen=GeneralDriver.getGeneralDriver(d);
      
         if (d.getAverageScore()>80){
                gen.setColour("green");
            }
            else if (d.getAverageScore()>80||d.getAverageScore()>50){
                gen.setColour("gold");
            }
            else {
                gen.setColour("red");
            }
         
            Integer count=vehicleRepository.findAllWithVehicleDriverCount(admin_id, d.getDriverId()).intValue();
            gen.setCountOfVehicles(count);
            
            if (count>0){
                gen.setStatus("Active");
            }
            else {
                   gen.setStatus("Not Active");
            }
             Integer inscount=inspectionRepository.countByDriverAndIstatusNot(d,InspectionStatus.END_STATUS).intValue();
             gen.setCountOfInspections(inscount);
             
            
      
      mav.addObject("driver",gen);
      mav.addObject("id", admin_id);
        
        return mav;
    }
    
    
    

}
