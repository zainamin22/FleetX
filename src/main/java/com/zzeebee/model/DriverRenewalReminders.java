package com.zzeebee.model;


public class DriverRenewalReminders {
    private Integer driver_id;
    private String renewal_title;
    private String renewal_description;
    private String issue_date;

    /**
     * @return the driver_id
     */
    public Integer getDriver_id() {
        return driver_id;
    }

    /**
     * @param driver_id the driver_id to set
     */
    public void setDriver_id(Integer driver_id) {
        this.driver_id = driver_id;
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
