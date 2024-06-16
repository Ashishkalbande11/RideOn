package com.example.My_Taxi.Model;

import com.example.My_Taxi.Enum.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "trip_booking")
@Builder
public class TripBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String source;

    @Column(nullable = false)
    String destination;

    String bookingId;//uuid

    @Column(nullable = false)
    Double totalFare;

    @Column(nullable = false)
    Double distanceInKm;

    Status status;

    @CreationTimestamp
    LocalDateTime localDateTime;

    @Column(nullable = false)
    LocalDateTime journeyDate;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Driver driver;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    Customer customer;
}
