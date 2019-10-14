package com.zzeebee.controllers;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Vendor;
import com.zzeebee.model.GeneralVendor;
import com.zzeebee.model.WorkOrderStatus;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.ServiceEntryRepository;
import com.zzeebee.repository.VendorRepository;
import com.zzeebee.repository.WordOrderRepository;
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
public class ViewVendorController {

    @Autowired(required = true)
    VendorRepository vendorRepository;

    @Autowired(required = true)
    WordOrderRepository wordOrderRepository;

    @Autowired(required = true)
    ServiceEntryRepository serviceEntryRepository;
    
    
    
    @Autowired(required = true)
    AdminRepository adminRepository;

    @RequestMapping(value = "/vendors", method = RequestMethod.GET)
    public ModelAndView showVendors(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("vendor_list");

        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
         Admin admin = adminRepository.findById(admin_id).get();
        Iterable<Vendor> vendors = vendorRepository.findByAdmin(admin);
        ArrayList<GeneralVendor> gen_vendor = new ArrayList<>();

        for (Vendor d : vendors) {
            GeneralVendor gen = GeneralVendor.getGeneralVendor(d);
            int count = 0;
            count = wordOrderRepository.findDistinctVehiclesCount(admin_id, d.getVendorId()).intValue();
            gen.setCountOfVehicles(count);
            gen_vendor.add(gen);

        }

        mav.addObject("vendors", gen_vendor);
        return mav;
    }

    @RequestMapping(value = "/view_vendor_details", method = RequestMethod.GET)
    public ModelAndView showViewVendorDetails(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
        ModelAndView mav = new ModelAndView("vendor_detail");
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");

        Vendor v = vendorRepository.findById(id).get();
        GeneralVendor gv = GeneralVendor.getGeneralVendor(v);

        int vehcount = wordOrderRepository.findDistinctVehiclesCount(admin_id, v.getVendorId()).intValue();
        gv.setCountOfVehicles(vehcount);

        int worcount = wordOrderRepository.countByVendorAndWstatusNot(v, WorkOrderStatus.END_STATUS).intValue();
        gv.setCountOfWorkOrders(worcount);

        int sercount = serviceEntryRepository.countByVendorAndWstatusNot(v, WorkOrderStatus.END_STATUS).intValue();
        gv.setCountOfServiceEntries(sercount);

        if (vehcount > 0) {
            gv.setStatus("Active");
        } else {
            gv.setStatus("Not Active");
        }

        mav.addObject("vendor", gv);

        return mav;
    }

}
