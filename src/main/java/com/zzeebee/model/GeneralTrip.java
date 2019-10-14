package com.zzeebee.model;

import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.DriverTrips;

public class GeneralTrip {

    private Integer tripId;
    private Integer driverId;
    private Long startingTime;
    private  Long endingTime;
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
    private String colour;
    private String timeText;
    private String dateText;

    /**
     * @return the tripId
     */
    public Integer getTripId() {
        return tripId;
    }

    /**
     * @param tripId the tripId to set
     */
    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    /**
     * @return the driverId
     */
    public Integer getDriverId() {
        return driverId;
    }

    /**
     * @param driverId the driverId to set
     */
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    /**
     * @return the startingTime
     */
    public  Long getStartingTime() {
        return startingTime;
    }

    /**
     * @param startingTime the startingTime to set
     */
    public void setStartingTime(Long startingTime) {
        this.startingTime = startingTime;
    }

    /**
     * @return the endingTime
     */
    public Long getEndingTime() {
        return endingTime;
    }

    /**
     * @param endingTime the endingTime to set
     */
    public void setEndingTime(Long endingTime) {
        this.endingTime = endingTime;
    }

    /**
     * @return the startingLat
     */
    public Double getStartingLat() {
        return startingLat;
    }

    /**
     * @param startingLat the startingLat to set
     */
    public void setStartingLat(Double startingLat) {
        this.startingLat = startingLat;
    }

    /**
     * @return the startingLon
     */
    public Double getStartingLon() {
        return startingLon;
    }

    /**
     * @param startingLon the startingLon to set
     */
    public void setStartingLon(Double startingLon) {
        this.startingLon = startingLon;
    }

    /**
     * @return the endingLat
     */
    public Double getEndingLat() {
        return endingLat;
    }

    /**
     * @param endingLat the endingLat to set
     */
    public void setEndingLat(Double endingLat) {
        this.endingLat = endingLat;
    }

    /**
     * @return the endingLon
     */
    public Double getEndingLon() {
        return endingLon;
    }

    /**
     * @param endingLon the endingLon to set
     */
    public void setEndingLon(Double endingLon) {
        this.endingLon = endingLon;
    }

    /**
     * @return the accerelationScore
     */
  

    /**
     * @return the speedingScore
     */
    public Integer getSpeedingScore() {
        return speedingScore;
    }

    /**
     * @param speedingScore the speedingScore to set
     */
    public void setSpeedingScore(Integer speedingScore) {
        this.speedingScore = speedingScore;
    }

    /**
     * @return the fuelStartReading
     */
    public Double getFuelStartReading() {
        return fuelStartReading;
    }

    /**
     * @param fuelStartReading the fuelStartReading to set
     */
    public void setFuelStartReading(Double fuelStartReading) {
        this.fuelStartReading = fuelStartReading;
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
     * @return the fuelEndReading
     */
    public Double getFuelEndReading() {
        return fuelEndReading;
    }

    /**
     * @param fuelEndReading the fuelEndReading to set
     */
    public void setFuelEndReading(Double fuelEndReading) {
        this.fuelEndReading = fuelEndReading;
    }

    /**
     * @return the fuelIncreaseCounter
     */
    public Integer getFuelIncreaseCounter() {
        return fuelIncreaseCounter;
    }

    /**
     * @param fuelIncreaseCounter the fuelIncreaseCounter to set
     */
    public void setFuelIncreaseCounter(Integer fuelIncreaseCounter) {
        this.fuelIncreaseCounter = fuelIncreaseCounter;
    }

    /**
     * @return the fuelIncreaseQuantity
     */
    public Double getFuelIncreaseQuantity() {
        return fuelIncreaseQuantity;
    }

    /**
     * @param fuelIncreaseQuantity the fuelIncreaseQuantity to set
     */
    public void setFuelIncreaseQuantity(Double fuelIncreaseQuantity) {
        this.fuelIncreaseQuantity = fuelIncreaseQuantity;
    }

    public static DriverTrips getDriverTrips(GeneralTrip trip) {
        DriverTrips t = new DriverTrips();
        t.setAverageScore(trip.getAverageScore());
        Driver d = new Driver();
        d.setDriverId(trip.getDriverId());
        t.setDriver(d);
        t.setEndingLat(trip.getEndingLat());
        t.setEndingLon(trip.getEndingLon());
        t.setEndingTime(trip.getEndingTime());
        t.setFuelEndReading(trip.getFuelEndReading());
        t.setFuelIncreaseCounter(trip.getFuelIncreaseCounter());
        t.setFuelIncreaseQuantity(trip.getFuelIncreaseQuantity());
        t.setFuelStartReading(trip.getFuelStartReading());
        t.setSpeedingScore(trip.getSpeedingScore());
        t.setStartingLat(trip.getStartingLat());
        t.setStartingLon(trip.getStartingLon());
        t.setStartingTime(trip.getStartingTime());
        t.setTripId(trip.getTripId());
        return t;
    }

    public static GeneralTrip getGeneralTrip(DriverTrips trip) {
        GeneralTrip t = new GeneralTrip();
    
        t.setAverageScore(trip.getAverageScore());
        t.setDriverId(trip.getDriver().getDriverId());
        t.setEndingLat(trip.getEndingLat());
        t.setEndingLon(trip.getEndingLon());
        t.setEndingTime(trip.getEndingTime());
        t.setFuelEndReading(trip.getFuelEndReading());
        t.setFuelIncreaseCounter(trip.getFuelIncreaseCounter());
        t.setFuelIncreaseQuantity(trip.getFuelIncreaseQuantity());
        t.setFuelStartReading(trip.getFuelStartReading());
        t.setSpeedingScore(trip.getSpeedingScore());
        t.setStartingLat(trip.getStartingLat());
        t.setStartingLon(trip.getStartingLon());
        t.setStartingTime(trip.getStartingTime());
        t.setTripId(trip.getTripId());
        return t;
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
     * @return the timeText
     */
    public String getTimeText() {
        return timeText;
    }

    /**
     * @param timeText the timeText to set
     */
    public void setTimeText(String timeText) {
        this.timeText = timeText;
    }

    /**
     * @return the dateText
     */
    public String getDateText() {
        return dateText;
    }

    /**
     * @param dateText the dateText to set
     */
    public void setDateText(String dateText) {
        this.dateText = dateText;
    }

}
