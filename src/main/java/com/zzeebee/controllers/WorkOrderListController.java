package com.zzeebee.controllers;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Vehicle;
import com.zzeebee.databasemodel.Vendor;
import com.zzeebee.databasemodel.WorkOrders;
import com.zzeebee.model.GeneralWorkOrders;
import com.zzeebee.model.InspectionStatus;
import com.zzeebee.model.Issue;
import com.zzeebee.model.ServiceTask;
import com.zzeebee.model.WorkOrderStatus;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.VehicleRepository;
import com.zzeebee.repository.VendorRepository;
import com.zzeebee.repository.WordOrderRepository;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkOrderListController {

    @Autowired(required = true)
    WordOrderRepository workorderRepository;

    @Autowired(required = true)
    AdminRepository adminRepository;

    @Autowired(required = true)
    VehicleRepository vehicleRepository;

    @Autowired(required = true)
    VendorRepository vendorRepository;

    @RequestMapping(value = "/workorder_list", method = RequestMethod.GET)
    public ModelAndView showListWorkOrder(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("workorder_list");

        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Admin a = adminRepository.findById(admin_id).get();
        List<WorkOrders> workorders = workorderRepository.findByAdmin(a);
        List<GeneralWorkOrders> generalWorkOrders = new ArrayList<>();
        workorders.forEach(item -> {
            GeneralWorkOrders g = GeneralWorkOrders.getGeneralWorkOrder(item);

            if (item.getLastPerformed() != null) {
                String date = new SimpleDateFormat("EEE, d MMM yyyy").format(new Date(item.getLastPerformed()));
                g.setLastPerformedText(date);
            }

            if (item.getWstatus().equals(WorkOrderStatus.START_STATUS)) {
                g.setStatusColor("gold");
            } else if (item.getWstatus().equals(WorkOrderStatus.PROGRESS_STATUS)) {
                g.setStatusColor("lightgreen");
            } else if (item.getWstatus().equals(WorkOrderStatus.END_STATUS)) {
                g.setStatusColor("red");
            }
            int tot_service = GeneralWorkOrders.getServiceTotal(item.getServiceTasks());
            int tot_issue = GeneralWorkOrders.getIssueTotal(item.getServiceTasks());

            g.setTotal_servicetask(tot_service);
            g.setTotal_issues(tot_issue);

            generalWorkOrders.add(g);

        });

        mav.addObject("workorders", generalWorkOrders);
        return mav;
    }

    @RequestMapping(value = "/view_servicetask_detail", method = RequestMethod.GET)
    public ModelAndView showServiceTaskDetails(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
        ModelAndView mav = new ModelAndView("servicetask_detail");
        GeneralWorkOrders gen = GeneralWorkOrders.getGeneralWorkOrder(workorderRepository.findById(id).get());
        Vendor v=vendorRepository.findById(gen.getVendor_id()).get();
        Vehicle veh=vehicleRepository.findById(gen.getVehicle_id()).get();
        
        gen.setVendor_name(v.getFirstName() + " " + v.getLastName());
        gen.setVehicle_name(veh.getName());
      int checked=GeneralWorkOrders.getServiceChecked(gen.getServiceTasks());
      gen.setChecked_servicetask(checked);
        int total=GeneralWorkOrders.getServiceTotal(gen.getServiceTasks());
        gen.setTotal_servicetask(total);
        gen.setPercentage((double)GeneralWorkOrders.getPercentage(checked, total));
        

        List<ServiceTask> servicetasks = GeneralWorkOrders.getServiceTaskList(gen.getServiceTasks());
        servicetasks.forEach(item ->{
              if (item.getStatus().equals(InspectionStatus.UNCHECKED_STATUS)) {
                item.setStatus("Uncheck");
                item.setImage("resources/images/notdonetick.png");
                item.setColor("badge-warning");
            } else if (item.getStatus().equals(InspectionStatus.YES_STATUS)) {
                item.setStatus("Pass");
                item.setImage("resources/images/donetick.png");
                item.setColor("badge-success");
            } else if (item.getStatus().equals(InspectionStatus.NO_STATUS)) {
                item.setStatus("Fail");
                item.setImage("resources/images/cross.png");
                item.setColor("badge-danger");
            }
        });
        

        mav.addObject("workorder", gen);
         mav.addObject("parts", servicetasks);
        return mav;
    }

    @RequestMapping(value = "/view_issue_detail", method = RequestMethod.GET)
    public ModelAndView showIssueDetails(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
        ModelAndView mav = new ModelAndView("issues_detail");
        GeneralWorkOrders gen = GeneralWorkOrders.getGeneralWorkOrder(workorderRepository.findById(id).get());
        Vendor v=vendorRepository.findById(gen.getVendor_id()).get();
        Vehicle veh=vehicleRepository.findById(gen.getVehicle_id()).get();
        
        gen.setVendor_name(v.getFirstName() + " " + v.getLastName());
        gen.setVehicle_name(veh.getName());
        
        
        int checked=GeneralWorkOrders.getIssueChecked(gen.getWissues());
      gen.setChecked_issues(checked);
        int total=GeneralWorkOrders.getIssueTotal(gen.getWissues());
        gen.setTotal_issues(total);
        gen.setPercentage((double)GeneralWorkOrders.getPercentage(checked, total));
       

        List<Issue> issues = GeneralWorkOrders.getIssueList(gen.getWissues());
        issues.forEach(item ->{
            
             if (item.getStatus().equals(WorkOrderStatus.ISSUE_NO_STATUS)) {
                item.setColor("badge-warning");
            } else if (item.getStatus().equals(WorkOrderStatus.ISSUE_YES_STATUS)) {
                item.setColor("badge-success");
            }
            
        });

        mav.addObject("workorder", gen);
        mav.addObject("issues", issues);
        
        return mav;
    }

}
