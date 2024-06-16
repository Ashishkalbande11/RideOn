package com.example.My_Taxi.DAO;

import com.example.My_Taxi.Model.Customer;
import com.example.My_Taxi.Model.Driver;
import com.example.My_Taxi.Model.TripBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripBookingRepo extends JpaRepository<TripBooking,Long> {

    List<TripBooking> findByCustomer(Customer customer);

    List<TripBooking> findByDriver(Driver driver);
}
