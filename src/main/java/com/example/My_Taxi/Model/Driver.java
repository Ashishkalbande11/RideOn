package com.example.My_Taxi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "driver")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String address;

    @Column(unique = true, nullable = false)
    Long number;

    Double rating;

    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
    @JsonIgnore
    Cab cab;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    List<TripBooking> tripBookingList;
}
