package com.zzeebee.controllers;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.model.GeneralAdmin;
import com.zzeebee.repository.AdminRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

   

    @Autowired(required = true)
    AdminRepository adminRepository;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView showProfile(HttpServletRequest request, HttpServletResponse response) {
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        ModelAndView mav = new ModelAndView("profile");
        GeneralAdmin admin = GeneralAdmin.getGeneralAdmin(adminRepository.findById(admin_id).get());
        mav.addObject("admin", admin);
        return mav;
    }

    @RequestMapping(value = "/profile_process", method = RequestMethod.POST)
    public ModelAndView SaveProfile(@ModelAttribute("admin") GeneralAdmin admin, HttpServletRequest request, HttpServletResponse response) {

        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
       
        Admin m = GeneralAdmin.getAdmin(admin);
        m.setAdminId(admin_id);
        
        adminRepository.save(m);

        GeneralAdmin adminis = GeneralAdmin.getGeneralAdmin(adminRepository.findById(admin_id).get());
        ModelAndView mav = new ModelAndView("profile");
        mav.addObject("admin", adminis);
        return mav;
    }

   

}
