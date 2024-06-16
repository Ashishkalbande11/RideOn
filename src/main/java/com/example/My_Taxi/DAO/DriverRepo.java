package com.example.My_Taxi.DAO;

import com.example.My_Taxi.Model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepo extends JpaRepository<Driver,Long> {

    boolean existsByNumber(Long number);


}
