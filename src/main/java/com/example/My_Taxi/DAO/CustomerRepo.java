package com.example.My_Taxi.DAO;

import com.example.My_Taxi.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);

    boolean existsByNumber(Long number);

    @Query("select c from Customer c where c.email = :email")
    Customer findByEmailId(String email);

}
