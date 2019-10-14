package com.zzeebee.controllers;

import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.Inspection;
import com.zzeebee.databasemodel.Vehicle;
import com.zzeebee.model.GeneralInspection;
import com.zzeebee.model.InspectionStatus;
import com.zzeebee.model.Part;
import com.zzeebee.repository.DriverRepository;
import com.zzeebee.repository.InspectionRepository;
import com.zzeebee.repository.VehicleRepository;
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
public class InspectionListController {

    @Autowired(required = true)
    InspectionRepository inspectionRepository;

    @Autowired(required = true)
    DriverRepository driverRepository;

    @Autowired(required = true)
    VehicleRepository vehicleRepository;

    @RequestMapping(value = "/inspection_list", method = RequestMethod.GET)
    public ModelAndView showStartInspection(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("inspection_list");

        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        List<Inspection> inspections = inspectionRepository.findAllWithInspectionAdmin(admin_id);
        List<GeneralInspection> generalInspections = new ArrayList<>();
        inspections.forEach(item -> {
            GeneralInspection g = GeneralInspection.getGeneralInspection(item);

            if (item.getIlastPerformed() != null) {
                String date = new SimpleDateFormat("EEE, d MMM yyyy").format(new Date(item.getIlastPerformed()));
                g.setLastPerformedText(date);
            }

            if (item.getIstatus().equals(InspectionStatus.START_STATUS)) {
                g.setStatusColor("gold");
            } else if (item.getIstatus().equals(InspectionStatus.PROGRESS_STATUS)) {
                g.setStatusColor("lightgreen");
            } else if (item.getIstatus().equals(InspectionStatus.END_STATUS)) {
                g.setStatusColor("red");
            }

            g.setTotal();
            generalInspections.add(g);

        });

        mav.addObject("inspections", generalInspections);
        return mav;
    }

    @RequestMapping(value = "/view_inspection_detail", method = RequestMethod.GET)
    public ModelAndView showInspectionDetails(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
        ModelAndView mav = new ModelAndView("inspectioncard_detail");
        GeneralInspection gen = GeneralInspection.getGeneralInspection(inspectionRepository.findById(id).get());
        gen.setPercentage();

        Driver d = driverRepository.findById(gen.getDriverId()).get();
        Vehicle v = vehicleRepository.findById(gen.getVehicleId()).get();
        gen.setDriver_name(d.getFirstName() + " " + d.getLastName());
        gen.setVehicle_name(v.getName());

        ArrayList<Part> parts = gen.getParts();
        parts.forEach(item -> {

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

        mav.addObject("inspection", gen);
        mav.addObject("parts", parts);

        return mav;
    }

}
