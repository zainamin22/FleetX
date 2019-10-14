package com.zzeebee.controllers;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Vendor;
import com.zzeebee.model.DashboardModel;
import com.zzeebee.model.InspectionStatus;
import com.zzeebee.model.WorkOrderStatus;
import com.zzeebee.repository.AdminRepository;
import com.zzeebee.repository.DriverRepository;
import com.zzeebee.repository.InspectionRepository;
import com.zzeebee.repository.ReminderRepository;
import com.zzeebee.repository.ServiceEntryRepository;
import com.zzeebee.repository.VehicleRepository;
import com.zzeebee.repository.VendorRepository;
import com.zzeebee.repository.WordOrderRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    @Autowired(required = true)
    DriverRepository driverRepository;

    @Autowired(required = true)
    VehicleRepository vehicleRepository;

    @Autowired(required = true)
    InspectionRepository inspectionRepository;

    @Autowired(required = true)
    VendorRepository vendorRepository;

    @Autowired(required = true)
    WordOrderRepository workorderRepository;

    @Autowired(required = true)
    ServiceEntryRepository serviceEntryRepository;

    @Autowired(required = true)
    ReminderRepository reminderRepository;
    
       @Autowired(required = true)
    AdminRepository adminRepository;
    

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView showDashboard(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("dashboard");
        DashboardModel dm = new DashboardModel();

        Integer admin_id = (Integer) request.getSession().getAttribute("admin_id");
        Admin admin = adminRepository.findById(admin_id).get();

        dm.setAssignedDrivers(driverRepository.findAllWithDriverAssignedCount(admin_id).intValue());
        dm.setAssignedVehicles(vehicleRepository.findAllWithVehicleCountAssigned(admin_id).intValue());
        dm.setUnassignedDrivers(driverRepository.findAllWithDriverUnAssignedCount(admin_id).intValue());
        dm.setUnassignedVehicles(vehicleRepository.findAllWithVehicleCountUnAssigned(admin_id).intValue());

        dm.setStartedInspection(inspectionRepository.findAllWithInspectionStatusCount(admin_id, InspectionStatus.START_STATUS).intValue());
        dm.setInProgressInspection(inspectionRepository.findAllWithInspectionStatusCount(admin_id, InspectionStatus.PROGRESS_STATUS).intValue());
        dm.setCompletedInspection(inspectionRepository.findAllWithInspectionStatusCount(admin_id, InspectionStatus.END_STATUS).intValue());

        dm.setStartedWorkOrders(workorderRepository.countByAdminAndWstatus(admin, WorkOrderStatus.START_STATUS).intValue());
        dm.setInProgressWorkOrders(workorderRepository.countByAdminAndWstatus(admin, WorkOrderStatus.PROGRESS_STATUS).intValue());
        dm.setCompletedWorkOrders(workorderRepository.countByAdminAndWstatus(admin, WorkOrderStatus.END_STATUS).intValue());

        int assignedVendor = 0;
        int unAssignedVendor = 0;

        Iterable<Vendor> vendors = vendorRepository.findByAdmin(admin);

        for (Vendor v : vendors) {

            int count = workorderRepository.countByVendorAndWstatus(v, WorkOrderStatus.START_STATUS).intValue();

            if (count > 0) {
                assignedVendor++;

            } else {
                int count1 = workorderRepository.countByVendorAndWstatus(v, WorkOrderStatus.PROGRESS_STATUS).intValue();

                if (count1 > 0) {
                    assignedVendor++;

                } else {

                    int count2 = serviceEntryRepository.countByVendorAndWstatus(v, WorkOrderStatus.START_STATUS).intValue();

                    if (count2 > 0) {
                        assignedVendor++;
                    } else {
                        int count3 = serviceEntryRepository.countByVendorAndWstatus(v, WorkOrderStatus.PROGRESS_STATUS).intValue();

                        if (count3 > 0) {
                            assignedVendor++;
                        } else {
                            unAssignedVendor++;
                        }

                    }

                }

            }

        }

        dm.setAssignedVendor(assignedVendor);
        dm.setUnassignedVendor(unAssignedVendor);

        Integer assignedServiceReminders = 0;

        assignedServiceReminders = reminderRepository.findCountReminders("service", "issued").intValue();

        Integer overdueServiceReminders = 0;

        overdueServiceReminders = reminderRepository.findCountReminders("service", "overdue").intValue();

        Integer assignedDriverReminders = 0;

        assignedDriverReminders = reminderRepository.findCountReminders("driver_renewal", "issued").intValue();

        Integer overdueDriverReminders = 0;

        overdueDriverReminders = reminderRepository.findCountReminders("driver_renewal", "overdue").intValue();

        Integer assignedVehicleReminders = 0;
        assignedVehicleReminders = reminderRepository.findCountReminders("vehicle_renewal", "issued").intValue();

        Integer overdueVehicleReminders = 0;

        overdueVehicleReminders = reminderRepository.findCountReminders("vehicle_renewal", "overdue").intValue();

        dm.setAssignedServiceReminders(assignedServiceReminders);
        dm.setAssignedVehicleReminders(assignedVehicleReminders);
        dm.setAssignedDriverReminders(assignedDriverReminders);

        dm.setOverdueDriverReminders(overdueDriverReminders);
        dm.setOverdueServiceReminders(overdueServiceReminders);
        dm.setOverdueVehicleReminders(overdueVehicleReminders);

        mav.addObject("info", dm);

        return mav;
    }

}
