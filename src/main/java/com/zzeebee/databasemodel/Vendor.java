package com.zzeebee.databasemodel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="vendor"
    ,catalog="iefleetx"
    , uniqueConstraints = @UniqueConstraint(columnNames="email") 
)
public class Vendor  implements java.io.Serializable {


     private int vendorId;
     private Admin admin;
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

    public Vendor() {
    }

	
    public Vendor(int vendorId, String email) {
        this.vendorId = vendorId;
        this.email = email;
      
    }
    public Vendor(int vendorId, Admin admin, String email, String firstName, String lastName, String image, String city, String country, String address, String phone, String approved, String firebaseId) {
       this.vendorId = vendorId;
       this.admin = admin;
       this.email = email;
       this.firstName = firstName;
       this.lastName = lastName;
       this.image = image;
       this.city = city;
       this.country = country;
       this.address = address;
       this.phone = phone;
       this.approved = approved;
       this.firebaseId = firebaseId;
    }
   
     @Id 

    
    @Column(name="vendor_id", unique=true, nullable=false)
    public int getVendorId() {
        return this.vendorId;
    }
    
    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
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

    
    @Column(name="image", length=100)
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
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

    
    @Column(name="phone", length=100)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="approved", length=45)
    public String getApproved() {
        return this.approved;
    }
    
    public void setApproved(String approved) {
        this.approved = approved;
    }

    
    @Column(name="firebase_id", length=500)
    public String getFirebaseId() {
        return this.firebaseId;
    }
    
    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }




}


