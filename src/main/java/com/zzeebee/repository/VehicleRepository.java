package com.zzeebee.repository;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Vehicle;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

    Iterable<Vehicle> findByArchivedAndAdmin(String archived, Admin admin);
    
     Iterable<Vehicle> findByAdmin(Admin admin);

    @Query("Select v from  Vehicle v LEFT JOIN DriverVehicle dv on v.vehicleId=dv.vehicle.vehicleId WHERE dv.vehicle.vehicleId IS NULL and v.admin.adminId=:adminId")
    public Iterable<Vehicle> findAllWithVehicle(@Param("adminId") Integer adminId);
    
    
    
    @Query("Select COUNT(v) from  Vehicle v LEFT JOIN DriverVehicle dv on v.vehicleId=dv.vehicle.vehicleId WHERE dv.vehicle.vehicleId IS NULL and v.admin.adminId=:adminId")
    public Long findAllWithVehicleCountUnAssigned(@Param("adminId") Integer adminId);
    
    
    
    @Query("Select COUNT(v) from  Vehicle v  JOIN DriverVehicle dv on v.vehicleId=dv.vehicle.vehicleId WHERE v.admin.adminId=:adminId")
    public Long findAllWithVehicleCountAssigned(@Param("adminId") Integer adminId);  
    
    
    @Query("Select v from  Vehicle v  JOIN DriverVehicle dv on v.vehicleId=dv.vehicle.vehicleId WHERE v.admin.adminId=:adminId")
    public Iterable<Vehicle> findAllWithVehicleAssigned(@Param("adminId") Integer adminId);  
    

    @Query("Select v from  Vehicle v  JOIN DriverVehicle dv on v.vehicleId=dv.vehicle.vehicleId WHERE dv.driver.driverId =:driverId and v.admin.adminId=:adminId")
    public List<Vehicle> findAllWithVehicleDriver(@Param("adminId") Integer adminId, @Param("driverId") Integer driverId);
    
       @Query("Select COUNT(v) from  Vehicle v  JOIN DriverVehicle dv on v.vehicleId=dv.vehicle.vehicleId WHERE dv.driver.driverId =:driverId and v.admin.adminId=:adminId")
    public Long findAllWithVehicleDriverCount(@Param("adminId") Integer adminId, @Param("driverId") Integer driverId);
    
    

}
