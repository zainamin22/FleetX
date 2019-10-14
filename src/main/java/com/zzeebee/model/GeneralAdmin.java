package com.zzeebee.model;

import com.zzeebee.databasemodel.Admin;
import org.springframework.web.multipart.MultipartFile;

public class GeneralAdmin {

    /**
     * @return the imageData
     */
    public MultipartFile getImageData() {
        return imageData;
    }

    /**
     * @param imageData the imageData to set
     */
    public void setImageData(MultipartFile imageData) {
        this.imageData = imageData;
    }

    private Integer adminId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String image;
    private String companyName;
    private Integer fleetSize;
    private String city;
    private String country;
    private String phone;
    private MultipartFile imageData;

    /**
     * @return the adminId
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * @param adminId the adminId to set
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the fleetSize
     */
    public Integer getFleetSize() {
        return fleetSize;
    }

    /**
     * @param fleetSize the fleetSize to set
     */
    public void setFleetSize(Integer fleetSize) {
        this.fleetSize = fleetSize;
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

    public static Admin getAdmin(GeneralAdmin admin) {

        Admin a = new Admin();
        a.setAdminId(admin.getAdminId());
        a.setCity(admin.getCity());
        a.setCompanyName(admin.getCompanyName());
        a.setCountry(admin.getCountry());
        a.setEmail(admin.getEmail());
        a.setFirstName(admin.getFirstName());
        a.setFleetSize(admin.getFleetSize());
        a.setImage(admin.getImage());
        a.setLastName(admin.getLastName());
        a.setPassword(admin.getPassword());
        a.setPhone(admin.getPhone());

        a.setImage(admin.getImage());

        return a;
    }

    public static GeneralAdmin getGeneralAdmin(Admin admin) {

        GeneralAdmin a = new GeneralAdmin();
        a.setAdminId(admin.getAdminId());
        a.setCity(admin.getCity());
        a.setCompanyName(admin.getCompanyName());
        a.setCountry(admin.getCountry());
        a.setEmail(admin.getEmail());
        a.setFirstName(admin.getFirstName());
        a.setFleetSize(admin.getFleetSize());
        a.setImage(admin.getImage());
        a.setLastName(admin.getLastName());
        a.setPassword(admin.getPassword());
        a.setPhone(admin.getPhone());

        return a;
    }

}
