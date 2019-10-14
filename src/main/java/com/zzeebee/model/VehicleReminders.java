package com.zzeebee.model;


public class VehicleReminders {
    
      private Integer vehicle_id;
      private String renewal_title;
      private String renewal_description;
      private String issue_date;

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
     * @return the renewal_title
     */
    public String getRenewal_title() {
        return renewal_title;
    }

    /**
     * @param renewal_title the renewal_title to set
     */
    public void setRenewal_title(String renewal_title) {
        this.renewal_title = renewal_title;
    }

    /**
     * @return the renewal_description
     */
    public String getRenewal_description() {
        return renewal_description;
    }

    /**
     * @param renewal_description the renewal_description to set
     */
    public void setRenewal_description(String renewal_description) {
        this.renewal_description = renewal_description;
    }

    /**
     * @return the issue_date
     */
    public String getIssue_date() {
        return issue_date;
    }

    /**
     * @param issue_date the issue_date to set
     */
    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }
    
}
