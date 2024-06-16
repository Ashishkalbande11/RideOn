package com.example.My_Taxi.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coupon")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long couponId;

    String couponCode;
    Double discount;
}
