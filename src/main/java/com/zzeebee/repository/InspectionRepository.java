package com.zzeebee.repository;

import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.Inspection;
import com.zzeebee.databasemodel.Vehicle;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface InspectionRepository extends CrudRepository<Inspection, Integer> {

    List<Inspection> findByDriver(Driver driver);
    
    List<Inspection> findByDriverAndIstatusNot(Driver driver,String istatus);
    
     List<Inspection> findByDriverAndIstatus(Driver driver,String istatus);
    
     @Query("Select COUNT(i) from Inspection i WHERE i.driver.admin.adminId=:adminId and i.istatus=:status")
    public  Long findAllWithInspectionStatusCount(@Param("adminId") Integer adminId,@Param("status") String status);
    
     @Query("Select i from Inspection i WHERE i.driver.admin.adminId=:adminId")
    public  List<Inspection> findAllWithInspectionAdmin(@Param("adminId") Integer adminId);
    
    
     Long countByVehicleAndIstatusNot(Vehicle vehicle,String istatus);
     Long countByDriverAndIstatusNot(Driver driver,String istatus);
    
    
    
    
    
    

}
