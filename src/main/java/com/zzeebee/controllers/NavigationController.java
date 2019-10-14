package com.zzeebee.controllers;

import com.zzeebee.repository.DriverRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {

    @Autowired(required = true)
    DriverRepository driverRepository;

    @RequestMapping(value = {"/navigation"}, method = RequestMethod.GET)
    public ModelAndView showNavigation(HttpServletRequest request, HttpServletResponse response) {
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        ModelAndView mav = new ModelAndView("navigation");
        mav.addObject("id", admin_id);
        return mav;
    }

}
