package com.zzeebee.databasemodel;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "admin",
         catalog = "iefleetx",
         uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class Admin implements java.io.Serializable {

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
    private Set<Driver> drivers = new HashSet<Driver>(0); 
    private Set<Vendor> vendors = new HashSet<Vendor>(0);
    private Set<Vehicle> vehicles = new HashSet<Vehicle>(0);

    public Admin() {
    }

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Admin(String email, String password, String firstName, String lastName, String image, String companyName, Integer fleetSize, String city, String country, String phone, Set<Driver> drivers, Set<Vendor> vendors, Set<Vehicle> vehicles) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.companyName = companyName;
        this.fleetSize = fleetSize;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.drivers = drivers;
        this.vendors = vendors;
        this.vehicles = vehicles;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "admin_id", unique = true, nullable = false)
    public Integer getAdminId() {
        return this.adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Column(name = "email", unique = true, nullable = false, length = 100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false, length = 100)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "first_name", length = 100)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", length = 100)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "image", length = 500)
    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "company_name", length = 100)
    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "fleet_size")
    public Integer getFleetSize() {
        return this.fleetSize;
    }

    public void setFleetSize(Integer fleetSize) {
        this.fleetSize = fleetSize;
    }

    @Column(name = "city", length = 100)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "country", length = 100)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "phone", length = 100)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "admin")
    public Set<Driver> getDrivers() {
        return this.drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

  

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "admin")
    public Set<Vendor> getVendors() {
        return this.vendors;
    }

    public void setVendors(Set<Vendor> vendors) {
        this.vendors = vendors;
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "admin")
    public Set<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
