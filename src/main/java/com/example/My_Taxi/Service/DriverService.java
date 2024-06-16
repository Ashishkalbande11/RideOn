package com.example.My_Taxi.Service;

import com.example.My_Taxi.DAO.CabRepo;
import com.example.My_Taxi.DAO.DriverRepo;
import com.example.My_Taxi.DAO.TripBookingRepo;
import com.example.My_Taxi.DTO.Request.DriverRequest;
import com.example.My_Taxi.DTO.Response.DriverResponse;
import com.example.My_Taxi.DTO.Response.TripBookingResponse;
import com.example.My_Taxi.Exception.DriverNotFoundException;
import com.example.My_Taxi.Model.Cab;
import com.example.My_Taxi.Model.Driver;
import com.example.My_Taxi.Model.TripBooking;
import com.example.My_Taxi.Transformer.CabTransformer;
import com.example.My_Taxi.Transformer.DriverTransformer;
import com.example.My_Taxi.Transformer.TripBookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepo driverRepo;
    private final TripBookingRepo tripBookingRepo;

    private final CabRepo cabRepo;

    public DriverResponse addDriver(DriverRequest driverRequest){

        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);

        if(driverRequest.getCabRequest() == null){
            throw new IllegalArgumentException("cab request cannot be null");
        }

        Cab cab = CabTransformer.cabRequestToCab(driverRequest.getCabRequest());

        driver.setCab(cab);
        cab.setDriver(driver);

        driverRepo.save(driver);
//        cabRepo.save(cab);

        return DriverTransformer.driverToDriverResponse(driver);
    }

    public List<TripBookingResponse> getAllBookings(Long driverId) {

        Optional<Driver> driver = driverRepo.findById(driverId);

        if(driver.isEmpty()){
            throw new DriverNotFoundException("driver does not exist with this emailId "+driverId);
        }
        List<TripBooking> bookings = tripBookingRepo.findByDriver(driver.orElse(null));
        List<TripBookingResponse> tripBookingResponseList = new ArrayList<>();

        for(TripBooking tripBooking : bookings){
            tripBookingResponseList.add(TripBookingTransformer.tripBookingToTripBookingResponse(tripBooking));
        }
        return tripBookingResponseList;
    }
}
