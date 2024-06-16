package com.example.My_Taxi.Transformer;

import com.example.My_Taxi.DTO.Request.TripBookingRequest;
import com.example.My_Taxi.DTO.Response.TripBookingResponse;
import com.example.My_Taxi.Enum.Status;
import com.example.My_Taxi.Model.TripBooking;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class TripBookingTransformer {

    public static TripBooking tripBookingRequestToTripBooking(TripBookingRequest tripBookingRequest){
        return TripBooking.builder()
                .bookingId(String.valueOf(UUID.randomUUID()))
                .source(tripBookingRequest.getSource())
                .destination(tripBookingRequest.getDestination())
                .localDateTime(LocalDateTime.now())
                .distanceInKm(tripBookingRequest.getDistanceInKm())
                .journeyDate(tripBookingRequest.getBookingDate())
                .status(Status.IN_TRANSIT)
                .build();
    }
    public static TripBookingResponse tripBookingToTripBookingResponse(TripBooking tripBooking){
       return TripBookingResponse.builder()
                .bookingId(tripBooking.getBookingId())
                .bookedAt(tripBooking.getLocalDateTime())
                .totalFare(tripBooking.getTotalFare())
                .distanceInKm(tripBooking.getDistanceInKm())
                .source(tripBooking.getSource())
                .destination(tripBooking.getDestination())
                .journeyDate(tripBooking.getJourneyDate())
                .status(tripBooking.getStatus())
                .driverResponse(DriverTransformer.driverToDriverResponse(tripBooking.getDriver()))
                .customerResponse((CustomerTransformer.customerToCustomerResponse(tripBooking.getCustomer())))
                .message("Wish you Happy Journey")
                .build();
    }
}
