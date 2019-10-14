package com.zzeebee.controllers;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.ServiceEntry;
import com.zzeebee.model.GeneralServiceEntry;
import com.zzeebee.model.WorkOrderStatus;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.ServiceEntryRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceEntryListController {
    
      @Autowired(required = true)
    ServiceEntryRepository serviceEntryRepository;
      
      
      @Autowired(required = true)
    AdminRepository adminRepository;
     
     
      @RequestMapping(value = "/serviceentry_list", method = RequestMethod.GET)
    public ModelAndView showListWorkOrder(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("serviceentry_list");
        
         Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
         Admin a = adminRepository.findById(admin_id).get();
       List<ServiceEntry> serviceentry=serviceEntryRepository.findByAdmin(a);
       List<GeneralServiceEntry> generalserviceentry=new ArrayList<>();
       serviceentry.forEach(item -> {
      GeneralServiceEntry g=GeneralServiceEntry.getGeneralServiceEntry(item);
       
       if (item.getLastPerformed()!=null) {
     String date = new SimpleDateFormat("EEE, d MMM yyyy").format(new Date(item.getLastPerformed()));
     g.setLastPerformedText(date);
}
       
       if (item.getWstatus().equals(WorkOrderStatus.START_STATUS)){
           g.setStatusColor("gold");
       }
       else if (item.getWstatus().equals(WorkOrderStatus.PROGRESS_STATUS)){
             g.setStatusColor("lightgreen");
       }
       else if (item.getWstatus().equals(WorkOrderStatus.END_STATUS)){
             g.setStatusColor("red");
       }
       
       
      generalserviceentry.add(g);
       
       });
       
        mav.addObject("serviceentry",  generalserviceentry);
        return mav;
    }
    
    
    
    
}
