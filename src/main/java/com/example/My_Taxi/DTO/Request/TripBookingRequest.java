package com.example.My_Taxi.DTO.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TripBookingRequest {

    String source;
    String destination;
    Double distanceInKm;
    String customerEmailId;
    LocalDateTime bookingDate;
}
