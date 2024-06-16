package com.example.My_Taxi.Controller;

import com.example.My_Taxi.DAO.CabRepo;
import com.example.My_Taxi.DAO.DriverRepo;
import com.example.My_Taxi.DTO.Request.DriverRequest;
import com.example.My_Taxi.DTO.Response.DriverResponse;
import com.example.My_Taxi.DTO.Response.TripBookingResponse;
import com.example.My_Taxi.Exception.DuplicateResourceException;
import com.example.My_Taxi.Model.Driver;
import com.example.My_Taxi.Service.DriverService;
import com.example.My_Taxi.Transformer.DriverTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.List;
import java.util.PrimitiveIterator;

@RestController
@RequestMapping("my-taxi")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;
    private  final DriverRepo driverRepo;
    private final CabRepo cabRepo;

    @PostMapping("add-driver")
    public ResponseEntity<DriverResponse> addDriver(@RequestBody DriverRequest driverRequest){
        if(driverRepo.existsByNumber(driverRequest.getNumber())){
            throw new DuplicateResourceException("number already exists");
        }
        if(driverRequest.getCabRequest() == null){
            throw new IllegalArgumentException("cab request cannot be null");
        }
        if(cabRepo.existsByCabNo(driverRequest.getCabRequest().getCabNo())){
            throw new DuplicateResourceException("cab already registered");
        }
        return new ResponseEntity<>(driverService.addDriver(driverRequest), HttpStatus.CREATED);
    }
    @GetMapping("/driver/{driverId}/trip-bookings")
    public ResponseEntity<List<TripBookingResponse>> getAllBookings(@PathVariable Long driverId){
        return new ResponseEntity<>(driverService.getAllBookings(driverId),HttpStatus.FOUND);
    }
}
