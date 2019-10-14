package com.zzeebee.repository;

import com.zzeebee.databasemodel.Admin;
import com.zzeebee.databasemodel.Vendor;
import org.springframework.data.repository.CrudRepository;

public interface VendorRepository extends CrudRepository<Vendor, Integer> {

      public Iterable<Vendor> findByAdmin(Admin admin);
}
