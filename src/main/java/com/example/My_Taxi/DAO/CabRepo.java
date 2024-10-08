package com.example.My_Taxi.DAO;

import com.example.My_Taxi.Model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepo extends JpaRepository<Cab,Long> {

    boolean existsByCabNo(String cabNo);

    @Query(value = "select * from cab where available = true order by rand() limit 1", nativeQuery = true)
//    @Query(value = "select * from cab where available = true order by rand() limit 1", nativeQuery = true)
    Cab getRandomAvailableCab();
}
