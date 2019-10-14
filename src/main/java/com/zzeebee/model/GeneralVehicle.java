package com.zzeebee.model;

import com.zzeebee.databasemodel.Vehicle;
import org.springframework.web.multipart.MultipartFile;

public class GeneralVehicle {

    private Integer vehicleId;
    private Integer admin_id;
    private String name;
    private String vin;
    private String licensePlate;
    private String type;
    private Integer year;
    private String model;
    private String company;
    private String registrationProvince;
    private MultipartFile image;
    private String fuelType;
    private Double fuelTank1Capacity;
    private Double fuelTank2Capacity;
    private String archived;
    private String status;
    private String operator;
    private String image_url;
    private Integer driver_id;
    private Integer assigned_inspection;
    private Integer assigned_workorders;
    private Integer assigned_serviceentry;

    /**
     * @return the vehicleId
     */
    public Integer getVehicleId() {
        return vehicleId;
    }

    /**
     * @param vehicleId the vehicleId to set
     */
    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the vin
     */
    public String getVin() {
        return vin;
    }

    /**
     * @param vin the vin to set
     */
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     * @return the licensePlate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * @param licensePlate the licensePlate to set
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the registrationProvince
     */
    public String getRegistrationProvince() {
        return registrationProvince;
    }

    /**
     * @param registrationProvince the registrationProvince to set
     */
    public void setRegistrationProvince(String registrationProvince) {
        this.registrationProvince = registrationProvince;
    }

    /**
     * @return the image
     */
    public MultipartFile getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(MultipartFile image) {
        this.image = image;
    }

    /**
     * @return the fuelType
     */
    public String getFuelType() {
        return fuelType;
    }

    /**
     * @param fuelType the fuelType to set
     */
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    /**
     * @return the fuelTank1Capacity
     */
    public Double getFuelTank1Capacity() {
        return fuelTank1Capacity;
    }

    /**
     * @param fuelTank1Capacity the fuelTank1Capacity to set
     */
    public void setFuelTank1Capacity(Double fuelTank1Capacity) {
        this.fuelTank1Capacity = fuelTank1Capacity;
    }

    /**
     * @return the fuelTank2Capacity
     */
    public Double getFuelTank2Capacity() {
        return fuelTank2Capacity;
    }

    /**
     * @param fuelTank2Capacity the fuelTank2Capacity to set
     */
    public void setFuelTank2Capacity(Double fuelTank2Capacity) {
        this.fuelTank2Capacity = fuelTank2Capacity;
    }

    /**
     * @return the archived
     */
    public String getArchived() {
        return archived;
    }

    /**
     * @param archived the archived to set
     */
    public void setArchived(String archived) {
        this.archived = archived;
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
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    public static Vehicle getVehicle(GeneralVehicle vehicle) {
        Vehicle v = new Vehicle();
        v.setName(vehicle.getName());
        v.setArchived("no");
        v.setCompany(vehicle.getCompany());
        v.setFuelTank1Capacity(vehicle.getFuelTank1Capacity());
        v.setFuelTank2Capacity(vehicle.getFuelTank2Capacity());
        v.setFuelType(vehicle.getFuelType());
        v.setLicensePlate(vehicle.getLicensePlate());
        v.setRegistrationProvince(vehicle.getRegistrationProvince());
        v.setType(vehicle.getType());
        v.setModel(vehicle.getModel());
        v.setVin(vehicle.getVin());
        v.setYear(vehicle.getYear());
        v.setImage(vehicle.getImage_url());
        

        return v;
    }

    public static GeneralVehicle getGeneralVehicle(Vehicle vehicle) {
        GeneralVehicle v = new GeneralVehicle();
        v.setVehicleId(vehicle.getVehicleId());
        v.setName(vehicle.getName());
        v.setArchived(vehicle.getArchived());
        v.setCompany(vehicle.getCompany());
        v.setFuelTank1Capacity(vehicle.getFuelTank1Capacity());
        v.setFuelTank2Capacity(vehicle.getFuelTank2Capacity());
        v.setFuelType(vehicle.getFuelType());
        v.setLicensePlate(vehicle.getLicensePlate());
        v.setRegistrationProvince(vehicle.getRegistrationProvince());
        v.setType(vehicle.getType());
        v.setModel(vehicle.getModel());
        v.setVin(vehicle.getVin());
        v.setYear(vehicle.getYear());
        v.setImage_url(vehicle.getImage());

        return v;
    }

    /**
     * @return the image_url
     */
    public String getImage_url() {
        return image_url;
    }

    /**
     * @param image_url the image_url to set
     */
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

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
     * @return the assigned_inspection
     */
    public Integer getAssigned_inspection() {
        return assigned_inspection;
    }

    /**
     * @param assigned_inspection the assigned_inspection to set
     */
    public void setAssigned_inspection(Integer assigned_inspection) {
        this.assigned_inspection = assigned_inspection;
    }

    /**
     * @return the assigned_workorders
     */
    public Integer getAssigned_workorders() {
        return assigned_workorders;
    }

    /**
     * @param assigned_workorders the assigned_workorders to set
     */
    public void setAssigned_workorders(Integer assigned_workorders) {
        this.assigned_workorders = assigned_workorders;
    }

    /**
     * @return the assigned_serviceentry
     */
    public Integer getAssigned_serviceentry() {
        return assigned_serviceentry;
    }

    /**
     * @param assigned_serviceentry the assigned_serviceentry to set
     */
    public void setAssigned_serviceentry(Integer assigned_serviceentry) {
        this.assigned_serviceentry = assigned_serviceentry;
    }

}
