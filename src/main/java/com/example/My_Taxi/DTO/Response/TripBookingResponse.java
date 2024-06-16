package com.example.My_Taxi.DTO.Response;


import com.example.My_Taxi.Enum.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TripBookingResponse {

    String bookingId;
    String source;
    String destination;
    Double totalFare;
    Double distanceInKm;
    Status status;
    LocalDateTime bookedAt;
    DriverResponse driverResponse;
    CustomerResponse customerResponse;
    LocalDateTime journeyDate;
    String message;
}
