package com.zzeebee.repository;

import com.zzeebee.databasemodel.Driver;
import com.zzeebee.databasemodel.DriverVehicle;
import com.zzeebee.databasemodel.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface DriverVehicleRepository extends CrudRepository<DriverVehicle, Integer> {

    boolean existsByDriver(Driver driver);

    boolean existsByVehicle(Vehicle vehicle);

    DriverVehicle findByDriver(Driver driver);

    DriverVehicle findByVehicle(Vehicle vehicle);

    DriverVehicle findByDriverAndVehicle(Driver driver, Vehicle vehicles);

}
