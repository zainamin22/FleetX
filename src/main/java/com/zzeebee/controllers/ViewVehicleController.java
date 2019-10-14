package com.zzeebee.controllers;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.DriverVehicle;
import com.zzeebee.databasemodel.Vehicle;
import com.zzeebee.model.GeneralVehicle;
import com.zzeebee.model.InspectionStatus;
import com.zzeebee.model.WorkOrderStatus;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.DriverRepository;
import com.zzeebee.repository.DriverVehicleRepository;
import com.zzeebee.repository.InspectionRepository;
import com.zzeebee.repository.ServiceEntryRepository;
import com.zzeebee.repository.VehicleRepository;
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
public class ViewVehicleController {

    @Autowired(required = true)
    VehicleRepository vehicleRepository;

    @Autowired(required = true)
    DriverVehicleRepository driverVehicleRepository;

    @Autowired(required = true)
    DriverRepository driverRepository;

    @Autowired(required = true)
    InspectionRepository inspectionRepository;

    @Autowired(required = true)
    WordOrderRepository workorderRepository;

    @Autowired(required = true)
    ServiceEntryRepository serviceEntryRepository;

    @Autowired(required = true)
    AdminRepository adminRepository;

    @RequestMapping(value = "/view_vehicle", method = RequestMethod.GET)
    public ModelAndView showViewVehicle(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("view_vehicle");
        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Admin a = adminRepository.findById(admin_id).get();
        Iterable<Vehicle> vehicles = vehicleRepository.findByArchivedAndAdmin("no", a);
        ArrayList<GeneralVehicle> gen_vehicles = new ArrayList<>();

        for (Vehicle v : vehicles) {
            GeneralVehicle ve = GeneralVehicle.getGeneralVehicle(v);

            if (driverVehicleRepository.existsByVehicle(v)) {
                DriverVehicle dv = driverVehicleRepository.findByVehicle(v);

                Driver d = driverRepository.findById(dv.getDriver().getDriverId()).get();
                ve.setStatus("Assigned");
                ve.setOperator(d.getFirstName() + " " + d.getLastName());
            } else {
                ve.setStatus("Not Assigned");
                ve.setOperator("");
            }

            gen_vehicles.add(ve);
        }

        mav.addObject("vehicles", gen_vehicles);
        return mav;
    }

    @RequestMapping(value = "/arch_vehicleProcess", method = RequestMethod.GET)
    public ModelAndView ArchiveVehicle(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
        ModelAndView mav = new ModelAndView("view_vehicle");

        Vehicle vv = vehicleRepository.findById(id).get();
        vv.setArchived("yes");
        vehicleRepository.save(vv);

        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Admin a = adminRepository.findById(admin_id).get();
        Iterable<Vehicle> vehicles = vehicleRepository.findByArchivedAndAdmin("no", a);
        ArrayList<GeneralVehicle> gen_vehicles = new ArrayList<>();

        for (Vehicle v : vehicles) {
            GeneralVehicle ve = GeneralVehicle.getGeneralVehicle(v);

            if (driverVehicleRepository.existsByVehicle(v)) {
                DriverVehicle dv = driverVehicleRepository.findByVehicle(v);

                Driver d = driverRepository.findById(dv.getDriver().getDriverId()).get();
                ve.setStatus("Assigned");
                ve.setOperator(d.getFirstName() + " " + d.getLastName());
            } else {
                ve.setStatus("Not Assigned");
                ve.setOperator("");
            }

            gen_vehicles.add(ve);
        }

        mav.addObject("vehicles", gen_vehicles);
        mav.addObject("status", "archive");

        return mav;

    }

    @RequestMapping(value = "/delete_vehicleProcess", method = RequestMethod.GET)
    public ModelAndView DeleteVehicle(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
        ModelAndView mav = new ModelAndView("view_vehicle");
        Vehicle vv = new Vehicle();
        vv.setVehicleId(id);
        if (driverVehicleRepository.existsByVehicle(vv)) {
            mav.addObject("status", "assigned");
        } else {
            vehicleRepository.delete(vv);
            mav.addObject("status", "successDelete");

        }

        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Admin a = adminRepository.findById(admin_id).get();
        Iterable<Vehicle> vehicles = vehicleRepository.findByArchivedAndAdmin("no", a);
        ArrayList<GeneralVehicle> gen_vehicles = new ArrayList<>();

        for (Vehicle v : vehicles) {
            GeneralVehicle ve = GeneralVehicle.getGeneralVehicle(v);

            if (driverVehicleRepository.existsByVehicle(v)) {
                DriverVehicle dv = driverVehicleRepository.findByVehicle(v);

                Driver d = driverRepository.findById(dv.getDriver().getDriverId()).get();
                ve.setStatus("Assigned");
                ve.setOperator(d.getFirstName() + " " + d.getLastName());
            } else {
                ve.setStatus("Not Assigned");
                ve.setOperator("");
            }

            gen_vehicles.add(ve);
        }

        mav.addObject("vehicles", gen_vehicles);
        return mav;
    }

    @RequestMapping(value = "/view_vehicle_details", method = RequestMethod.GET)
    public ModelAndView showViewVehicleDetails(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
        ModelAndView mav = new ModelAndView("vehicle_detail");

        Vehicle v = vehicleRepository.findById(id).get();
        GeneralVehicle gv = GeneralVehicle.getGeneralVehicle(v);

        if (driverVehicleRepository.existsByVehicle(v)) {
            DriverVehicle dv = driverVehicleRepository.findByVehicle(v);
            Driver d = driverRepository.findById(dv.getDriver().getDriverId()).get();
            gv.setStatus("Assigned");
            gv.setOperator(d.getFirstName() + " " + d.getLastName());
            gv.setDriver_id(d.getDriverId());
        } else {
            gv.setStatus("Not Assigned");
            gv.setOperator("");
            gv.setDriver_id(0);
        }

        gv.setAssigned_inspection(inspectionRepository.countByVehicleAndIstatusNot(v, InspectionStatus.END_STATUS).intValue());
        gv.setAssigned_workorders(workorderRepository.countByVehicleAndWstatusNot(v, WorkOrderStatus.END_STATUS).intValue());
        gv.setAssigned_serviceentry(serviceEntryRepository.countByVehicleAndWstatusNot(v, WorkOrderStatus.END_STATUS).intValue());

        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        mav.addObject("id", admin_id);

        mav.addObject("vehicle", gv);

        return mav;
    }

    @RequestMapping(value = "/edit_vehicle_details", method = RequestMethod.GET)
    public ModelAndView showEditVehicle(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") int id) {
        ModelAndView mav = new ModelAndView("edit_vehicle");

        Vehicle v = vehicleRepository.findById(id).get();
        GeneralVehicle gv = GeneralVehicle.getGeneralVehicle(v);

        mav.addObject("vehicle", gv);

        return mav;
    }

}
