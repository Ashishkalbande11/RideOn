package com.example.My_Taxi.Model;

import com.example.My_Taxi.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false, unique = true)
    Long number;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(nullable = false)
    String address;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    List<TripBooking> tripBookingList;

}
