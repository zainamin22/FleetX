package com.zzeebee.repository;


import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.DriverTrips;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface DriverTripsRepository extends CrudRepository<DriverTrips, Integer> {

    List<DriverTrips> findByDriver(Driver driver);
     
     DriverTrips findTopByDriverOrderByTripIdDesc(Driver driver);
     
     Long countByDriver(Driver driver);
    
    
    

}
