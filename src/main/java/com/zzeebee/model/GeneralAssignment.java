package com.zzeebee.model;

import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.DriverVehicle;
import com.zzeebee.databasemodel.Vehicle;

public class GeneralAssignment {

    private Integer driverVehicleId;
    private int driverId;
    private int vehicleId;

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
     * @return the vehicleId
     */
    public int getVehicleId() {
        return vehicleId;
    }

    /**
     * @param vehicleId the vehicleId to set
     */
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public static DriverVehicle getDriverVehicle(GeneralAssignment assignment) {
        DriverVehicle dr = new DriverVehicle();
        Driver d = new Driver();
        d.setDriverId(assignment.getDriverId());
        Vehicle v = new Vehicle();
        v.setVehicleId(assignment.getVehicleId());
        dr.setDriver(d);
        dr.setVehicle(v);
        dr.setDriverVehicleId(assignment.getDriverVehicleId());
        return dr;
    }

    public static GeneralAssignment getGeneralAssignment(DriverVehicle assignment) {
        GeneralAssignment dr = new GeneralAssignment();
        dr.setDriverVehicleId(assignment.getDriverVehicleId());
        dr.setDriverId(assignment.getDriver().getDriverId());
        dr.setVehicleId(assignment.getVehicle().getVehicleId());

        return dr;
    }

    /**
     * @return the driverVehicleId
     */
    public Integer getDriverVehicleId() {
        return driverVehicleId;
    }

    /**
     * @param driverVehicleId the driverVehicleId to set
     */
    public void setDriverVehicleId(Integer driverVehicleId) {
        this.driverVehicleId = driverVehicleId;
    }

}
