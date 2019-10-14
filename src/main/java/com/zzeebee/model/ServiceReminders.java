package com.zzeebee.model;

public class ServiceReminders {
     private Integer vendor_id;
     private String service_title;
     private String service_description;
     private String issue_date;

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
     * @return the service_title
     */
    public String getService_title() {
        return service_title;
    }

    /**
     * @param service_title the service_title to set
     */
    public void setService_title(String service_title) {
        this.service_title = service_title;
    }

    /**
     * @return the service_description
     */
    public String getService_description() {
        return service_description;
    }

    /**
     * @param service_description the service_description to set
     */
    public void setService_description(String service_description) {
        this.service_description = service_description;
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
