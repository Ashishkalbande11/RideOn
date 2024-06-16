package com.example.My_Taxi.DAO;

import com.example.My_Taxi.Model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends JpaRepository<Coupon,Long> {
}
