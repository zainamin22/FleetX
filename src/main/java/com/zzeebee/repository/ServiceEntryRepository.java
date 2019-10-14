package com.zzeebee.repository;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.ServiceEntry;
import com.zzeebee.databasemodel.Vehicle;
import com.zzeebee.databasemodel.Vendor;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ServiceEntryRepository extends CrudRepository<ServiceEntry, Integer> {
    
    List<ServiceEntry> findByVendor(Vendor vendor);
    
    
    public  List<ServiceEntry> findByAdmin(Admin admin);
    
    
    
     Long countByVendorAndWstatus(Vendor vendor,String wstatus);
     
     Long countByVehicleAndWstatusNot(Vehicle vehicle,String wstatus);
       
     
       Long countByVendorAndWstatusNot(Vendor vendor,String wstatus);
    
       
        List<ServiceEntry> findByVendorAndWstatusNot(Vendor vendor,String wstatus);
        
           List<ServiceEntry> findByVendorAndWstatus(Vendor vendor,String wstatus);
           
           
           @Query("Select COUNT (DISTINCT v.vehicle) from  ServiceEntry v  WHERE v.vendor.vendorId =:vendorId and v.admin.adminId=:adminId")
    public Long findDistinctVehiclesCount(@Param("adminId") Integer adminId, @Param("vendorId") Integer vendorId);
           
       
}



