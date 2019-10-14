package com.zzeebee.databasemodel;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="inspection"
    ,catalog="iefleetx"
)
public class Inspection  implements java.io.Serializable {


     private Integer inspectionId;
     private Driver driver;
     private Vehicle vehicle;
     private Integer odometerReading;
     private Long endingTime;
     private Long startingTime;
     private String istatus;
     private String ititle;
     private String idescription;
     private Long ilastPerformed;
     private String iparts;

    public Inspection() {
    }

    public Inspection(Driver driver, Vehicle vehicle, Integer odometerReading, Long endingTime, Long startingTime, String istatus, String ititle, String idescription, Long ilastPerformed, String iparts) {
       this.driver = driver;
       this.vehicle = vehicle;
       this.odometerReading = odometerReading;
       this.endingTime = endingTime;
       this.startingTime = startingTime;
       this.istatus = istatus;
       this.ititle = ititle;
       this.idescription = idescription;
       this.ilastPerformed = ilastPerformed;
       this.iparts = iparts;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="inspection_id", unique=true, nullable=false)
    public Integer getInspectionId() {
        return this.inspectionId;
    }
    
    public void setInspectionId(Integer inspectionId) {
        this.inspectionId = inspectionId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="driver_id")
    public Driver getDriver() {
        return this.driver;
    }
    
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vehicle_id")
    public Vehicle getVehicle() {
        return this.vehicle;
    }
    
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    
    @Column(name="odometer_reading")
    public Integer getOdometerReading() {
        return this.odometerReading;
    }
    
    public void setOdometerReading(Integer odometerReading) {
        this.odometerReading = odometerReading;
    }

    
    @Column(name="ending_time")
    public Long getEndingTime() {
        return this.endingTime;
    }
    
    public void setEndingTime(Long endingTime) {
        this.endingTime = endingTime;
    }

    
    @Column(name="starting_time")
    public Long getStartingTime() {
        return this.startingTime;
    }
    
    public void setStartingTime(Long startingTime) {
        this.startingTime = startingTime;
    }

    
    @Column(name="istatus", length=500)
    public String getIstatus() {
        return this.istatus;
    }
    
    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    
    @Column(name="ititle", length=500)
    public String getItitle() {
        return this.ititle;
    }
    
    public void setItitle(String ititle) {
        this.ititle = ititle;
    }

    
    @Column(name="idescription", length=1000)
    public String getIdescription() {
        return this.idescription;
    }
    
    public void setIdescription(String idescription) {
        this.idescription = idescription;
    }

    
    @Column(name="ilast_performed")
    public Long getIlastPerformed() {
        return this.ilastPerformed;
    }
    
    public void setIlastPerformed(Long ilastPerformed) {
        this.ilastPerformed = ilastPerformed;
    }

    
    @Column(name="iparts", length=3000)
    public String getIparts() {
        return this.iparts;
    }
    
    public void setIparts(String iparts) {
        this.iparts = iparts;
    }




}

