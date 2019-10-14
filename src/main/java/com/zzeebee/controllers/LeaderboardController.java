package com.zzeebee.controllers;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Driver;
import com.zzeebee.model.GeneralDriver;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.DriverRepository;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LeaderboardController {
    
    @Autowired(required = true)
    DriverRepository driverRepository;
    
      @Autowired(required = true)
    AdminRepository adminRepository;
    

    @RequestMapping(value = "/leaderboard", method = RequestMethod.GET)
    public ModelAndView showLeaderboard(HttpServletRequest request, HttpServletResponse response) {
        
        ModelAndView mav = new ModelAndView("leaderboard");
        
         Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Admin admin = adminRepository.findById(admin_id).get();
        Iterable<Driver> drivers = driverRepository.findByAdminOrderByAverageScoreDesc(admin);
        ArrayList<GeneralDriver> gen_driver = new ArrayList<>();

        for (Driver d : drivers) {
            GeneralDriver gen = GeneralDriver.getGeneralDriver(d);
            if (d.getAverageScore()>80){
                gen.setColour("green");
            }
            else if (d.getAverageScore()>80||d.getAverageScore()>50){
                gen.setColour("gold");
            }
            else {
                gen.setColour("red");
            }
            
            
            gen_driver.add(gen);

        }
        
        mav.addObject("drivers", gen_driver);
        
        
       
        return mav;
    }

}
