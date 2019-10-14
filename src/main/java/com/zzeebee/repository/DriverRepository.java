package com.zzeebee.repository;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Driver;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DriverRepository extends CrudRepository<Driver, Integer> {

    @Query("Select d from  Driver d LEFT JOIN DriverVehicle dv on d.driverId=dv.driver.driverId WHERE dv.driver.driverId IS NULL and d.admin.adminId=:adminId")
    public Iterable<Driver> findAllWithDriver(@Param("adminId") Integer adminId);

    @Query("Select d from  Driver d LEFT JOIN DriverVehicle dv on d.driverId=dv.driver.driverId WHERE dv.driver.driverId IS not NULL and d.admin.adminId=:adminId")
    public Iterable<Driver> findAllWithDriverAssigned(@Param("adminId") Integer adminId);
    
      @Query("Select COUNT(d) from  Driver d LEFT JOIN DriverVehicle dv on d.driverId=dv.driver.driverId WHERE dv.driver.driverId IS NULL and d.admin.adminId=:adminId")
    public Long findAllWithDriverUnAssignedCount(@Param("adminId") Integer adminId);

    @Query("Select COUNT(d) from  Driver d LEFT JOIN DriverVehicle dv on d.driverId=dv.driver.driverId WHERE dv.driver.driverId IS not NULL and d.admin.adminId=:adminId")
    public Long findAllWithDriverAssignedCount(@Param("adminId") Integer adminId);
    
    

    public Iterable<Driver> findByAdmin(Admin admin);
     public Iterable<Driver> findByAdminOrderByAverageScoreDesc(Admin admin);

}
