package com.zzeebee.controllers;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.model.UserAuth;
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
public class RegisterController {

    @Autowired(required = true)
    AdminRepository adminRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new UserAuth());
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView registerProcess(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("user") UserAuth user) {
        Admin a = new Admin();
        a.setEmail(user.getEmail());
        a.setPassword(user.getPassword());
        adminRepository.save(a);

        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new UserAuth());

        return mav;
    }

}
