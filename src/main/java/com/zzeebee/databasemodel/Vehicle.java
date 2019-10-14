package com.zzeebee.databasemodel;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="vehicle"
    ,catalog="iefleetx"
)
public class Vehicle  implements java.io.Serializable {


     private Integer vehicleId;
     private Admin admin;
     private String name;
     private String vin;
     private String licensePlate;
     private String type;
     private Integer year;
     private String model;
     private String company;
     private String registrationProvince;
     private String image;
     private String fuelType;
     private Double fuelTank1Capacity;
     private Double fuelTank2Capacity;
     private String archived;
     private Set<Inspection> inspections = new HashSet<Inspection>(0);
     private Set<DriverVehicle> driverVehicles = new HashSet<DriverVehicle>(0);

    public Vehicle() {
    }

    public Vehicle(Admin admin, String name, String vin, String licensePlate, String type, Integer year, String model, String company, String registrationProvince, String image, String fuelType, Double fuelTank1Capacity, Double fuelTank2Capacity, String archived, Set<Inspection> inspections, Set<DriverVehicle> driverVehicles) {
       this.admin = admin;
       this.name = name;
       this.vin = vin;
       this.licensePlate = licensePlate;
       this.type = type;
       this.year = year;
       this.model = model;
       this.company = company;
       this.registrationProvince = registrationProvince;
       this.image = image;
       this.fuelType = fuelType;
       this.fuelTank1Capacity = fuelTank1Capacity;
       this.fuelTank2Capacity = fuelTank2Capacity;
       this.archived = archived;
       this.inspections = inspections;
       this.driverVehicles = driverVehicles;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="vehicle_id", unique=true, nullable=false)
    public Integer getVehicleId() {
        return this.vehicleId;
    }
    
    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="admin_id")
    public Admin getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    
    @Column(name="name", length=500)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="vin", length=500)
    public String getVin() {
        return this.vin;
    }
    
    public void setVin(String vin) {
        this.vin = vin;
    }

    
    @Column(name="license_plate", length=500)
    public String getLicensePlate() {
        return this.licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    
    @Column(name="type", length=500)
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    
    @Column(name="year")
    public Integer getYear() {
        return this.year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }

    
    @Column(name="model", length=500)
    public String getModel() {
        return this.model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }

    
    @Column(name="company", length=500)
    public String getCompany() {
        return this.company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }

    
    @Column(name="registration_province", length=45)
    public String getRegistrationProvince() {
        return this.registrationProvince;
    }
    
    public void setRegistrationProvince(String registrationProvince) {
        this.registrationProvince = registrationProvince;
    }

    
    @Column(name="image", length=500)
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    
    @Column(name="fuel_type", length=500)
    public String getFuelType() {
        return this.fuelType;
    }
    
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    
    @Column(name="fuel_tank1_capacity", precision=22, scale=0)
    public Double getFuelTank1Capacity() {
        return this.fuelTank1Capacity;
    }
    
    public void setFuelTank1Capacity(Double fuelTank1Capacity) {
        this.fuelTank1Capacity = fuelTank1Capacity;
    }

    
    @Column(name="fuel_tank2_capacity", precision=22, scale=0)
    public Double getFuelTank2Capacity() {
        return this.fuelTank2Capacity;
    }
    
    public void setFuelTank2Capacity(Double fuelTank2Capacity) {
        this.fuelTank2Capacity = fuelTank2Capacity;
    }

    
    @Column(name="archived", length=500)
    public String getArchived() {
        return this.archived;
    }
    
    public void setArchived(String archived) {
        this.archived = archived;
    }

@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="vehicle")
    public Set<Inspection> getInspections() {
        return this.inspections;
    }
    
    public void setInspections(Set<Inspection> inspections) {
        this.inspections = inspections;
    }

@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="vehicle")
    public Set<DriverVehicle> getDriverVehicles() {
        return this.driverVehicles;
    }
    
    public void setDriverVehicles(Set<DriverVehicle> driverVehicles) {
        this.driverVehicles = driverVehicles;
    }




}


