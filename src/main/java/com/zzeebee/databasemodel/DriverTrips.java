package com.zzeebee.databasemodel;



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
@Table(name="driver_trips"
    ,catalog="iefleetx"
)
public class DriverTrips  implements java.io.Serializable {


     private Integer tripId;
     private Driver driver;
     private Long startingTime;
     private Long endingTime;
     private Double startingLat;
     private Double startingLon;
     private Double endingLat;
     private Double endingLon;
     private Integer speedingScore;
     private Double fuelStartReading;
     private Integer averageScore;
     private Double fuelEndReading;
     private Integer fuelIncreaseCounter;
     private Double fuelIncreaseQuantity;

    public DriverTrips() {
    }

    public DriverTrips(Driver driver, Long startingTime, Long endingTime, Double startingLat, Double startingLon, Double endingLat, Double endingLon, Integer speedingScore, Double fuelStartReading, Integer averageScore, Double fuelEndReading, Integer fuelIncreaseCounter, Double fuelIncreaseQuantity) {
       this.driver = driver;
       this.startingTime = startingTime;
       this.endingTime = endingTime;
       this.startingLat = startingLat;
       this.startingLon = startingLon;
       this.endingLat = endingLat;
       this.endingLon = endingLon;
       this.speedingScore = speedingScore;
       this.fuelStartReading = fuelStartReading;
       this.averageScore = averageScore;
       this.fuelEndReading = fuelEndReading;
       this.fuelIncreaseCounter = fuelIncreaseCounter;
       this.fuelIncreaseQuantity = fuelIncreaseQuantity;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="trip_id", unique=true, nullable=false)
    public Integer getTripId() {
        return this.tripId;
    }
    
    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="driver_id")
    public Driver getDriver() {
        return this.driver;
    }
    
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    
    @Column(name="starting_time")
    public Long getStartingTime() {
        return this.startingTime;
    }
    
    public void setStartingTime(Long startingTime) {
        this.startingTime = startingTime;
    }

    
    @Column(name="ending_time")
    public Long getEndingTime() {
        return this.endingTime;
    }
    
    public void setEndingTime(Long endingTime) {
        this.endingTime = endingTime;
    }

    
    @Column(name="starting_lat", precision=22, scale=0)
    public Double getStartingLat() {
        return this.startingLat;
    }
    
    public void setStartingLat(Double startingLat) {
        this.startingLat = startingLat;
    }

    
    @Column(name="starting_lon", precision=22, scale=0)
    public Double getStartingLon() {
        return this.startingLon;
    }
    
    public void setStartingLon(Double startingLon) {
        this.startingLon = startingLon;
    }

    
    @Column(name="ending_lat", precision=22, scale=0)
    public Double getEndingLat() {
        return this.endingLat;
    }
    
    public void setEndingLat(Double endingLat) {
        this.endingLat = endingLat;
    }

    
    @Column(name="ending_lon", precision=22, scale=0)
    public Double getEndingLon() {
        return this.endingLon;
    }
    
    public void setEndingLon(Double endingLon) {
        this.endingLon = endingLon;
    }

    @Column(name="speeding_score")
    public Integer getSpeedingScore() {
        return this.speedingScore;
    }
    
    public void setSpeedingScore(Integer speedingScore) {
        this.speedingScore = speedingScore;
    }

    
    @Column(name="fuel_start_reading", precision=22, scale=0)
    public Double getFuelStartReading() {
        return this.fuelStartReading;
    }
    
    public void setFuelStartReading(Double fuelStartReading) {
        this.fuelStartReading = fuelStartReading;
    }

    
    @Column(name="average_score")
    public Integer getAverageScore() {
        return this.averageScore;
    }
    
    public void setAverageScore(Integer averageScore) {
        this.averageScore = averageScore;
    }

    
    @Column(name="fuel_end_reading", precision=22, scale=0)
    public Double getFuelEndReading() {
        return this.fuelEndReading;
    }
    
    public void setFuelEndReading(Double fuelEndReading) {
        this.fuelEndReading = fuelEndReading;
    }

    
    @Column(name="fuel_increase_counter")
    public Integer getFuelIncreaseCounter() {
        return this.fuelIncreaseCounter;
    }
    
    public void setFuelIncreaseCounter(Integer fuelIncreaseCounter) {
        this.fuelIncreaseCounter = fuelIncreaseCounter;
    }

    
    @Column(name="fuel_increase_quantity", precision=22, scale=0)
    public Double getFuelIncreaseQuantity() {
        return this.fuelIncreaseQuantity;
    }
    
    public void setFuelIncreaseQuantity(Double fuelIncreaseQuantity) {
        this.fuelIncreaseQuantity = fuelIncreaseQuantity;
    }




}

