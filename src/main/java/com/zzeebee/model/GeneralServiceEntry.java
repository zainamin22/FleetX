package com.zzeebee.model;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.ServiceEntry;
import com.zzeebee.databasemodel.Vehicle;
import com.zzeebee.databasemodel.Vendor;


public class GeneralServiceEntry {
    
    
      private Integer serviceEntryId;
     private Integer admin_id;
      private Integer vehicle_id;
      private Integer vendor_id;
      private Integer odometerReading;
      private String wstatus;
      private Long startTime;
      private Long endTime;
      private Long lastPerformed;
      private String wlabels;
      private String description;
      private String wtitle;
      private String serviceTaskName;
      private String serviceTaskDescription;
      private String dateintext;
      private String lastPerformedText;
      private String statusColor;
      private String serviceTaskStatus;

    /**
     * @return the serviceEntryId
     */
    public Integer getServiceEntryId() {
        return serviceEntryId;
    }

    /**
     * @param serviceEntryId the serviceEntryId to set
     */
    public void setServiceEntryId(Integer serviceEntryId) {
        this.serviceEntryId = serviceEntryId;
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
     * @return the serviceTaskName
     */
    public String getServiceTaskName() {
        return serviceTaskName;
    }

    /**
     * @param serviceTaskName the serviceTaskName to set
     */
    public void setServiceTaskName(String serviceTaskName) {
        this.serviceTaskName = serviceTaskName;
    }

    /**
     * @return the serviceTaskDescription
     */
    public String getServiceTaskDescription() {
        return serviceTaskDescription;
    }

    /**
     * @param serviceTaskDescription the serviceTaskDescription to set
     */
    public void setServiceTaskDescription(String serviceTaskDescription) {
        this.serviceTaskDescription = serviceTaskDescription;
    }
    
    
    
    
    public static ServiceEntry getServiceEntry (GeneralServiceEntry order){
        
        ServiceEntry o = new ServiceEntry();
         Admin a = new Admin();
        a.setAdminId(order.getAdmin_id());
        o.setAdmin(a);
      
        o.setDescription(order.getDescription());
        o.setEndTime(order.getEndTime());
        o.setLastPerformed(order.getLastPerformed());
        o.setOdometerReading(order.getOdometerReading());
     
        o.setStartTime(order.getStartTime());
        Vehicle v = new Vehicle();
        v.setVehicleId(order.getVehicle_id());
        o.setVehicle(v);
        Vendor vv = new Vendor();
        vv.setVendorId(order.getVendor_id());
        o.setVendor(vv);
        o.setWlabels(order.getWlabels());
        o.setServiceEntryId(order.getServiceEntryId());
        o.setWstatus(order.getWstatus());
         o.setWtitle(order.getWtitle());
         o.setServiceTaskDescription(order.getServiceTaskDescription());
         o.setServiceTaskName(order.getServiceTaskName());
         o.setServiceTaskStatus(order.getServiceTaskStatus());
        
        
        return o;
    }
    
    
     public static GeneralServiceEntry getGeneralServiceEntry (ServiceEntry order){
        
        GeneralServiceEntry o = new GeneralServiceEntry();
        o.setAdmin_id(order.getAdmin().getAdminId());
        o.setDescription(order.getDescription());
        o.setEndTime(order.getEndTime());
        o.setLastPerformed(order.getLastPerformed());
        o.setOdometerReading(order.getOdometerReading());
        o.setStartTime(order.getStartTime());
        o.setVehicle_id(order.getVehicle().getVehicleId());
        o.setVendor_id(order.getVendor().getVendorId());
        o.setWlabels(order.getWlabels());
        o.setServiceEntryId(order.getServiceEntryId());
        o.setWstatus(order.getWstatus());
         o.setWtitle(order.getWtitle());
         o.setServiceTaskDescription(order.getServiceTaskDescription());
         o.setServiceTaskName(order.getServiceTaskName());
         o.setServiceTaskStatus(order.getServiceTaskStatus());
        
        
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
     * @return the serviceTaskStatus
     */
    public String getServiceTaskStatus() {
        return serviceTaskStatus;
    }

    /**
     * @param serviceTaskStatus the serviceTaskStatus to set
     */
    public void setServiceTaskStatus(String serviceTaskStatus) {
        this.serviceTaskStatus = serviceTaskStatus;
    }
    
    
    
    
    
}
