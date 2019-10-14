package com.zzeebee.model;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Driver;

public class GeneralDriver {

    private int driverId;
    private Integer admin_id;
    private String email;
    private String firstName;
    private String lastName;
    private String image;
    private Long dateOfBirth;
    private String dateOfBirthText;
    private String cnic;
    private String city;
    private String country;
    private String address;
    private String licenceNo;
    private Long licenceExpiryDate;
    private String licenceExpiryDateText;
    private Integer averageScore;
    private Double totalDistanceCovered;
    private Integer totalTrips;
   
    private String firebaseId;
    private Integer countOfVehicles;
    private String phone;
    private String colour;
    private String status;
    private Integer countOfInspections;
    
    

    /**
     * @return the driverId
     */
    public int getDriverId() {
        return driverId;
    }

    /**
     * @param driverId the driverId to set
     */
    public void setDriverId(int driverId) {
        this.driverId = driverId;
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
     * @return the dateOfBirth
     */
    public Long getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the cnic
     */
    public String getCnic() {
        return cnic;
    }

    /**
     * @param cnic the cnic to set
     */
    public void setCnic(String cnic) {
        this.cnic = cnic;
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
     * @return the licenceNo
     */
    public String getLicenceNo() {
        return licenceNo;
    }

    /**
     * @param licenceNo the licenceNo to set
     */
    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    /**
     * @return the licenceExpiryDate
     */
    public Long getLicenceExpiryDate() {
        return licenceExpiryDate;
    }

    /**
     * @param licenceExpiryDate the licenceExpiryDate to set
     */
    public void setLicenceExpiryDate(Long licenceExpiryDate) {
        this.licenceExpiryDate = licenceExpiryDate;
    }

    /**
     * @return the averageScore
     */
    public Integer getAverageScore() {
        return averageScore;
    }

    /**
     * @param averageScore the averageScore to set
     */
    public void setAverageScore(Integer averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * @return the totalDistanceCovered
     */
    public Double getTotalDistanceCovered() {
        return totalDistanceCovered;
    }

    /**
     * @param totalDistanceCovered the totalDistanceCovered to set
     */
    public void setTotalDistanceCovered(Double totalDistanceCovered) {
        this.totalDistanceCovered = totalDistanceCovered;
    }

    /**
     * @return the totalTrips
     */
    public Integer getTotalTrips() {
        return totalTrips;
    }

    /**
     * @param totalTrips the totalTrips to set
     */
    public void setTotalTrips(Integer totalTrips) {
        this.totalTrips = totalTrips;
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

    public static Driver getDriver(GeneralDriver driver) {
        Driver d = new Driver();
        d.setAddress(driver.getAddress());
        Admin a = new Admin();
        a.setAdminId(driver.getAdmin_id());
        d.setAdmin(a);
    
        d.setAverageScore(driver.getAverageScore());
        d.setCity(driver.getCity());
        d.setCnic(driver.getCnic());
        d.setCountry(driver.getCountry());

        d.setDateOfBirth(driver.getDateOfBirth());
        d.setDriverId(driver.getDriverId());
        d.setEmail(driver.getEmail());
        d.setFirebaseId(driver.getFirebaseId());
        d.setFirstName(driver.getFirstName());
        d.setImage(driver.getImage());
        d.setLastName(driver.getLastName());
        d.setLicenceExpiryDate(driver.getLicenceExpiryDate());
        d.setLicenceNo(driver.getLicenceNo());
        d.setTotalDistanceCovered(driver.getTotalDistanceCovered());
        d.setTotalTrips(driver.getTotalTrips());
        d.setPhone(driver.getPhone());

        return d;
    }

    public static GeneralDriver getGeneralDriver(Driver driver) {
        GeneralDriver d = new GeneralDriver();

        d.setAddress(driver.getAddress());
        d.setAdmin_id(driver.getAdmin().getAdminId());
      
        d.setAverageScore(driver.getAverageScore());
        d.setCity(driver.getCity());
        d.setCnic(driver.getCnic());
        d.setCountry(driver.getCountry());

        d.setDateOfBirth(driver.getDateOfBirth());
        d.setDriverId(driver.getDriverId());
        d.setEmail(driver.getEmail());
        d.setFirebaseId(driver.getFirebaseId());
        d.setFirstName(driver.getFirstName());
        d.setImage(driver.getImage());
        d.setLastName(driver.getLastName());
        d.setLicenceExpiryDate(driver.getLicenceExpiryDate());
        d.setLicenceNo(driver.getLicenceNo());
        d.setTotalDistanceCovered(driver.getTotalDistanceCovered());
        d.setTotalTrips(driver.getTotalTrips());
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
     * @return the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(String colour) {
        this.colour = colour;
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
     * @return the dateOfBirthText
     */
    public String getDateOfBirthText() {
        return dateOfBirthText;
    }

    /**
     * @param dateOfBirthText the dateOfBirthText to set
     */
    public void setDateOfBirthText(String dateOfBirthText) {
        this.dateOfBirthText = dateOfBirthText;
    }

    /**
     * @return the licenceExpiryDateText
     */
    public String getLicenceExpiryDateText() {
        return licenceExpiryDateText;
    }

    /**
     * @param licenceExpiryDateText the licenceExpiryDateText to set
     */
    public void setLicenceExpiryDateText(String licenceExpiryDateText) {
        this.licenceExpiryDateText = licenceExpiryDateText;
    }

    /**
     * @return the countOfInspections
     */
    public Integer getCountOfInspections() {
        return countOfInspections;
    }

    /**
     * @param countOfInspections the countOfInspections to set
     */
    public void setCountOfInspections(Integer countOfInspections) {
        this.countOfInspections = countOfInspections;
    }

    /**
     * @return the vehiclesCount
     */
  
}
