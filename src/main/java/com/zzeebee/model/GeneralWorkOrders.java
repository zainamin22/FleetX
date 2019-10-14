package com.zzeebee.model;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Vehicle;
import com.zzeebee.databasemodel.Vendor;
import com.zzeebee.databasemodel.WorkOrders;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


public class GeneralWorkOrders {

    private String wtitle;
    private Integer workOrdersId;
    private Integer admin_id;
    private Integer vehicle_id;
    private Integer vendor_id;
    private Integer odometerReading;
    private String wstatus;
    private Long startTime;
    private Long endTime;
    private Long lastPerformed;
    private String wlabels;
    private String wissues;
    private String serviceTasks;
    private String description;
    private String comments;
    private String dateintext;
    private String statusColor;
    private String lastPerformedText;
    private Integer total_servicetask;
    private Integer total_issues;
    private Integer checked_servicetask;
    private Integer checked_issues;
    private String vendor_name;
    private String vehicle_name;
    private Double percentage;


    /**
     * @return the workOrdersId
     */
    public Integer getWorkOrdersId() {
        return workOrdersId;
    }

    /**
     * @param workOrdersId the workOrdersId to set
     */
    public void setWorkOrdersId(Integer workOrdersId) {
        this.workOrdersId = workOrdersId;
    }

    /**
     * @return the admin_id
     */
    public Integer getAdmin_id() {
        return admin_id;
    }

    /**
     * @param admin_id the admin_id to set
     */
    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    /**
     * @return the vehicle_id
     */
    public Integer getVehicle_id() {
        return vehicle_id;
    }

    /**
     * @param vehicle_id the vehicle_id to set
     */
    public void setVehicle_id(Integer vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    /**
     * @return the vendor_id
     */
    public Integer getVendor_id() {
        return vendor_id;
    }

    /**
     * @param vendor_id the vendor_id to set
     */
    public void setVendor_id(Integer vendor_id) {
        this.vendor_id = vendor_id;
    }

    /**
     * @return the odometerReading
     */
    public Integer getOdometerReading() {
        return odometerReading;
    }

    /**
     * @param odometerReading the odometerReading to set
     */
    public void setOdometerReading(Integer odometerReading) {
        this.odometerReading = odometerReading;
    }

    /**
     * @return the wstatus
     */
    public String getWstatus() {
        return wstatus;
    }

    /**
     * @param wstatus the wstatus to set
     */
    public void setWstatus(String wstatus) {
        this.wstatus = wstatus;
    }

    /**
     * @return the startTime
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public Long getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the lastPerformed
     */
    public Long getLastPerformed() {
        return lastPerformed;
    }

    /**
     * @param lastPerformed the lastPerformed to set
     */
    public void setLastPerformed(Long lastPerformed) {
        this.lastPerformed = lastPerformed;
    }

    /**
     * @return the wlabels
     */
    public String getWlabels() {
        return wlabels;
    }

    /**
     * @param wlabels the wlabels to set
     */
    public void setWlabels(String wlabels) {
        this.wlabels = wlabels;
    }

    /**
     * @return the wissues
     */
    public String getWissues() {
        return wissues;
    }

    /**
     * @param wissues the wissues to set
     */
    public void setWissues(String wissues) {
        this.wissues = wissues;
    }

    /**
     * @return the serviceTasks
     */
    public String getServiceTasks() {
        return serviceTasks;
    }

    /**
     * @param serviceTasks the serviceTasks to set
     */
    public void setServiceTasks(String serviceTasks) {
        this.serviceTasks = serviceTasks;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    public static WorkOrders getWorkOrder(GeneralWorkOrders order) {
        WorkOrders o = new WorkOrders();

        Admin a = new Admin();
        a.setAdminId(order.getAdmin_id());
        o.setAdmin(a);
        o.setComments(order.getComments());
        o.setDescription(order.getDescription());
        o.setEndTime(order.getEndTime());
        o.setLastPerformed(order.getLastPerformed());
        o.setOdometerReading(order.getOdometerReading());
        o.setServiceTasks(order.getServiceTasks());
        o.setStartTime(order.getStartTime());
        Vehicle v = new Vehicle();
        v.setVehicleId(order.getVehicle_id());
        o.setVehicle(v);
        Vendor vv = new Vendor();
        vv.setVendorId(order.getVendor_id());
        o.setVendor(vv);
        o.setWissues(order.getWissues());
        o.setWlabels(order.getWlabels());
        o.setWorkOrdersId(order.getWorkOrdersId());
        o.setWstatus(order.getWstatus());
        o.setWtitle(order.getWtitle());

        return o;
    }

    public static GeneralWorkOrders getGeneralWorkOrder(WorkOrders order) {
        GeneralWorkOrders o = new GeneralWorkOrders();

        o.setAdmin_id(order.getAdmin().getAdminId());
        o.setComments(order.getComments());
        o.setDescription(order.getDescription());
        o.setEndTime(order.getEndTime());
        o.setLastPerformed(order.getLastPerformed());
        o.setOdometerReading(order.getOdometerReading());
        o.setServiceTasks(order.getServiceTasks());
        o.setStartTime(order.getStartTime());
        o.setVehicle_id(order.getVehicle().getVehicleId());
        o.setVendor_id(order.getVendor().getVendorId());
        o.setWissues(order.getWissues());
        o.setWlabels(order.getWlabels());
        o.setWorkOrdersId(order.getWorkOrdersId());
        o.setWstatus(order.getWstatus());
        o.setWtitle(order.getWtitle());
        return o;
    }

    /**
     * @return the dateintext
     */
    public String getDateintext() {
        return dateintext;
    }

    /**
     * @param dateintext the dateintext to set
     */
    public void setDateintext(String dateintext) {
        this.dateintext = dateintext;
    }

    /**
     * @return the wtitle
     */
    public String getWtitle() {
        return wtitle;
    }

    /**
     * @param wtitle the wtitle to set
     */
    public void setWtitle(String wtitle) {
        this.wtitle = wtitle;
    }

    /**
     * @return the statusColor
     */
    public String getStatusColor() {
        return statusColor;
    }

    /**
     * @param statusColor the statusColor to set
     */
    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    /**
     * @return the lastPerformedText
     */
    public String getLastPerformedText() {
        return lastPerformedText;
    }

    /**
     * @param lastPerformedText the lastPerformedText to set
     */
    public void setLastPerformedText(String lastPerformedText) {
        this.lastPerformedText = lastPerformedText;
    }

    /**
     * @return the total_servicetask
     */
    public Integer getTotal_servicetask() {
        return total_servicetask;
    }

    
    public void setTotal_servicetask(Integer total_servicetask) {
        this.total_servicetask = total_servicetask;
    }

    public static List<ServiceTask> getServiceTaskList(String json) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        Type type = new TypeToken<List<ServiceTask>>() {
        }.getType();
        List<ServiceTask> serviceTasks = gson.fromJson(json, type);

        return serviceTasks;
    }

    public static List<Issue> getIssueList(String json) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        Type type = new TypeToken<List<Issue>>() {
        }.getType();
        List<Issue> issues = gson.fromJson(json, type);

        return issues;
    }

    public static int getServiceTotal(String json) {
        List<ServiceTask> serviceTasks = getServiceTaskList(json);
        return serviceTasks.size();
    }

    public static int getIssueTotal(String json) {
        List<Issue> issues = getIssueList(json);
        return issues.size();
    }

    /**
     * @return the total_issues
     */
    public Integer getTotal_issues() {
        return total_issues;
    }

    /**
     * @param total_issues the total_issues to set
     */
    public void setTotal_issues(Integer total_issues) {
        this.total_issues = total_issues;
    }

    public static int getServiceChecked(String json) {
        int checked = 0;

        List<ServiceTask> serviceTasks = getServiceTaskList(json);
        for (int i = 0; i < serviceTasks.size(); i++) {
            ServiceTask s = serviceTasks.get(i);
            if (WorkOrderStatus.YES_STATUS.equals(s.getStatus()) || WorkOrderStatus.NO_STATUS.equals(s.getStatus())) {
                checked++;
            }
        }

        return checked;
    }

    
     public static int getIssueChecked(String json) {
        int checked = 0;

        List<Issue> issues = getIssueList(json);
        for (int i = 0; i < issues.size(); i++) {
            Issue s = issues.get(i);
            if (WorkOrderStatus.ISSUE_YES_STATUS.equals(s.getStatus())) {
                checked++;
            }
        }

        return checked;
    }

    


    public Integer getChecked_servicetask() {
        return checked_servicetask;
    }

    
    public void setChecked_servicetask(Integer checked_servicetask) {
        this.checked_servicetask = checked_servicetask;
    }

    /**
     * @return the checked_issues
     */
    public Integer getChecked_issues() {
        return checked_issues;
    }

    /**
     * @param checked_issues the checked_issues to set
     */
    public void setChecked_issues(Integer checked_issues) {
        this.checked_issues = checked_issues;
    }

    /**
     * @return the driver_name
     */


    /**
     * @return the vehicle_name
     */
    public String getVehicle_name() {
        return vehicle_name;
    }

    /**
     * @param vehicle_name the vehicle_name to set
     */
    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    /**
     * @return the percentage
     */
    public Double getPercentage() {
        return percentage;
    }

    /**
     * @param percentage the percentage to set
     */
    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    /**
     * @return the vendor_name
     */
    public String getVendor_name() {
        return vendor_name;
    }

    /**
     * @param vendor_name the vendor_name to set
     */
    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }
    

    
    public static float getPercentage(int n, int total) {
    float proportion = ((float) n) / ((float) total);
    return proportion * 100;
}
    
    

}
