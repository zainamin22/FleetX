package com.zzeebee.databasemodel;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="driver"
    ,catalog="iefleetx"
    , uniqueConstraints = @UniqueConstraint(columnNames="email") 
)
public class Driver  implements java.io.Serializable {


     private int driverId;
     private Admin admin;
     private String email;
     private String firstName;
     private String lastName;
     private String image;
     private Long dateOfBirth;
     private String cnic;
     private String city;
     private String country;
     private String address;
     private String licenceNo;
     private Long licenceExpiryDate;
     private Integer averageScore;
     private Double totalDistanceCovered;
     private Integer totalTrips;
     private String firebaseId;
     private String phone;
     private Set<DriverVehicle> driverVehicles = new HashSet<>(0);
     private Set<Inspection> inspections = new HashSet<>(0);
     private Set<DriverTrips> driverTripses = new HashSet<>(0);

    public Driver() {
    }

	
    public Driver(int driverId, String email) {
        this.driverId = driverId;
        this.email = email;
    }
    public Driver(int driverId, Admin admin, String email, String firstName, String lastName, String image, Long dateOfBirth, String cnic, String city, String country, String address, String licenceNo, Long licenceExpiryDate, Integer averageScore, Double totalDistanceCovered, Integer totalTrips,String firebaseId, String phone, Set<DriverVehicle> driverVehicles, Set<Inspection> inspections, Set<DriverTrips> driverTripses) {
       this.driverId = driverId;
       this.admin = admin;
       this.email = email;
       this.firstName = firstName;
       this.lastName = lastName;
       this.image = image;
       this.dateOfBirth = dateOfBirth;
       this.cnic = cnic;
       this.city = city;
       this.country = country;
       this.address = address;
       this.licenceNo = licenceNo;
       this.licenceExpiryDate = licenceExpiryDate;
       this.averageScore = averageScore;
       this.totalDistanceCovered = totalDistanceCovered;
       this.totalTrips = totalTrips;
       this.firebaseId = firebaseId;
       this.phone = phone;
       this.driverVehicles = driverVehicles;
       this.inspections = inspections;
       this.driverTripses = driverTripses;
    }
   
     @Id 

    
    @Column(name="driver_id", unique=true, nullable=false)
    public int getDriverId() {
        return this.driverId;
    }
    
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="admin_id")
    public Admin getAdmin() {
        return this.admin;
    }
    
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    
    @Column(name="email", unique=true, nullable=false, length=100)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="first_name", length=100)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name", length=100)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="image", length=1000)
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    
    @Column(name="date_of_birth")
    public Long getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    
    @Column(name="cnic", length=100)
    public String getCnic() {
        return this.cnic;
    }
    
    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    
    @Column(name="city", length=100)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="country", length=100)
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    
    @Column(name="address", length=100)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="licence_no", length=100)
    public String getLicenceNo() {
        return this.licenceNo;
    }
    
    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    
    @Column(name="licence_expiry_date")
    public Long getLicenceExpiryDate() {
        return this.licenceExpiryDate;
    }
    
    public void setLicenceExpiryDate(Long licenceExpiryDate) {
        this.licenceExpiryDate = licenceExpiryDate;
    }

    
    @Column(name="average_score")
    public Integer getAverageScore() {
        return this.averageScore;
    }
    
    public void setAverageScore(Integer averageScore) {
        this.averageScore = averageScore;
    }

    
    @Column(name="total_distance_covered", precision=22, scale=0)
    public Double getTotalDistanceCovered() {
        return this.totalDistanceCovered;
    }
    
    public void setTotalDistanceCovered(Double totalDistanceCovered) {
        this.totalDistanceCovered = totalDistanceCovered;
    }

    
    @Column(name="total_trips")
    public Integer getTotalTrips() {
        return this.totalTrips;
    }
    
    public void setTotalTrips(Integer totalTrips) {
        this.totalTrips = totalTrips;
    }

    
   
    
    @Column(name="firebase_id", length=500)
    public String getFirebaseId() {
        return this.firebaseId;
    }
    
    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }

    
    @Column(name="phone", length=100)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="driver")
    public Set<DriverVehicle> getDriverVehicles() {
        return this.driverVehicles;
    }
    
    public void setDriverVehicles(Set<DriverVehicle> driverVehicles) {
        this.driverVehicles = driverVehicles;
    }

@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="driver")
    public Set<Inspection> getInspections() {
        return this.inspections;
    }
    
    public void setInspections(Set<Inspection> inspections) {
        this.inspections = inspections;
    }

@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="driver")
    public Set<DriverTrips> getDriverTripses() {
        return this.driverTripses;
    }
    
    public void setDriverTripses(Set<DriverTrips> driverTripses) {
        this.driverTripses = driverTripses;
    }




}


