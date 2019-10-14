package com.zzeebee.controllers;

import com.zzeebee.model.UserAuth;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public ModelAndView LogoutProcess(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new UserAuth());
        request.getSession().invalidate();
        return mav;
    }

}
