package com.example.My_Taxi.Model;

import com.example.My_Taxi.Enum.CarType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "cab")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String cabNo;

    boolean available;

    @Enumerated(EnumType.STRING)
    CarType carType;

    int numberOfSeats;

    @Column(nullable = false)
    Double farePerKm;

    @OneToOne
    @JoinColumn(name = "driver_id")
    Driver driver;

}
