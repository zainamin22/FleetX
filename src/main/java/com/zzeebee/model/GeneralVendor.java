package com.zzeebee.model;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Vendor;

public class GeneralVendor {
    
     private int vendorId;
     private Integer admin_id;
     private String email;
     private String firstName;
     private String lastName;
     private String image;
     private String city;
     private String country;
     private String address;
     private String phone;
     private String approved;
     private String firebaseId;
     private Integer countOfVehicles;
     private String status;
     private Integer countOfWorkOrders;
     private Integer countOfServiceEntries;

    /**
     * @return the vendorId
     */
    public int getVendorId() {
        return vendorId;
    }

    /**
     * @param vendorId the vendorId to set
     */
    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the approved
     */
    public String getApproved() {
        return approved;
    }

    /**
     * @param approved the approved to set
     */
    public void setApproved(String approved) {
        this.approved = approved;
    }

    /**
     * @return the firebaseId
     */
    public String getFirebaseId() {
        return firebaseId;
    }

    /**
     * @param firebaseId the firebaseId to set
     */
    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }
    
    
    public static Vendor getVendor(GeneralVendor driver) {
        Vendor d = new Vendor();
        d.setAddress(driver.getAddress());
        Admin a = new Admin();
        a.setAdminId(driver.getAdmin_id());
        d.setAdmin(a);
        d.setApproved(driver.getApproved());
        d.setCity(driver.getCity());
        d.setCountry(driver.getCountry());
        d.setVendorId(driver.getVendorId());
        d.setEmail(driver.getEmail());
        d.setFirebaseId(driver.getFirebaseId());
        d.setFirstName(driver.getFirstName());
        d.setImage(driver.getImage());
        d.setLastName(driver.getLastName());
        d.setPhone(driver.getPhone());

        return d;
    }

    public static GeneralVendor getGeneralVendor(Vendor driver) {
        GeneralVendor d = new GeneralVendor();

        d.setAddress(driver.getAddress());
        d.setAdmin_id(driver.getAdmin().getAdminId());
        d.setApproved(driver.getApproved());
        d.setCity(driver.getCity());
        d.setCountry(driver.getCountry());
        d.setVendorId(driver.getVendorId());
        d.setEmail(driver.getEmail());
        d.setFirebaseId(driver.getFirebaseId());
        d.setFirstName(driver.getFirstName());
        d.setImage(driver.getImage());
        d.setLastName(driver.getLastName());
        d.setPhone(driver.getPhone());
        return d;
    }

    /**
     * @return the countOfVehicles
     */
    public Integer getCountOfVehicles() {
        return countOfVehicles;
    }

    /**
     * @param countOfVehicles the countOfVehicles to set
     */
    public void setCountOfVehicles(Integer countOfVehicles) {
        this.countOfVehicles = countOfVehicles;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the countOfWorkOrders
     */
    public Integer getCountOfWorkOrders() {
        return countOfWorkOrders;
    }

    /**
     * @param countOfWorkOrders the countOfWorkOrders to set
     */
    public void setCountOfWorkOrders(Integer countOfWorkOrders) {
        this.countOfWorkOrders = countOfWorkOrders;
    }

    /**
     * @return the countOfServiceEntries
     */
    public Integer getCountOfServiceEntries() {
        return countOfServiceEntries;
    }

    /**
     * @param countOfServiceEntries the countOfServiceEntries to set
     */
    public void setCountOfServiceEntries(Integer countOfServiceEntries) {
        this.countOfServiceEntries = countOfServiceEntries;
    }
    
    
    
    
    
}
