package com.zzeebee.repository;


import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Vehicle;
import com.zzeebee.databasemodel.Vendor;
import com.zzeebee.databasemodel.WorkOrders;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface WordOrderRepository extends CrudRepository<WorkOrders, Integer> {
 
    List<WorkOrders> findByVendor(Vendor vendor);
    
    
     List<WorkOrders> findByVendorAndWstatusNot(Vendor vendor,String wstatus);
     
     
     List<WorkOrders> findByVendorAndWstatus(Vendor vendor,String wstatus);
    
      public List<WorkOrders> findByAdmin(Admin admin);

      
       Long countByAdminAndWstatus(Admin admin,String wstatus);
       
       
        Long countByVehicleAndWstatusNot(Vehicle vehicle,String wstatus);
       
       
       
       Long countByVendorAndWstatus(Vendor vendor,String wstatus);
       
       Long countByVendorAndWstatusNot(Vendor vendor,String wstatus);
       
       
   @Query("Select COUNT (DISTINCT v.vehicle) from  WorkOrders v  WHERE v.vendor.vendorId =:vendorId and v.admin.adminId=:adminId")
    public Long findDistinctVehiclesCount(@Param("adminId") Integer adminId, @Param("vendorId") Integer vendorId);
       
       
       
      
    
    
}
