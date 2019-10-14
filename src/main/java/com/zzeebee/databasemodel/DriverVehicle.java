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
@Table(name = "driver_vehicle",
         catalog = "iefleetx"
)
public class DriverVehicle implements java.io.Serializable {

    private Integer driverVehicleId;
    private Driver driver;
    private Vehicle vehicle;
    private Integer assignmentTime;

    public DriverVehicle() {
    }

    public DriverVehicle(Driver driver, Vehicle vehicle, Integer assignmentTime) {
        this.driver = driver;
        this.vehicle = vehicle;
        this.assignmentTime = assignmentTime;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "driver_vehicle_id", unique = true, nullable = false)
    public Integer getDriverVehicleId() {
        return this.driverVehicleId;
    }

    public void setDriverVehicleId(Integer driverVehicleId) {
        this.driverVehicleId = driverVehicleId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    public Driver getDriver() {
        return this.driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Column(name = "assignment_time")
    public Integer getAssignmentTime() {
        return this.assignmentTime;
    }

    public void setAssignmentTime(Integer assignmentTime) {
        this.assignmentTime = assignmentTime;
    }

}
