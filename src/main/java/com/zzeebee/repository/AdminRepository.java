package com.zzeebee.repository;

import com.zzeebee.databasemodel.Admin;

import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

    Admin findByEmailAndPassword(String email, String password);

    Admin findByEmail(String email);

}
