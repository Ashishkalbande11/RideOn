package com.example.My_Taxi.Controller;

import com.example.My_Taxi.DAO.CustomerRepo;
import com.example.My_Taxi.DTO.Request.CustomerRequest;
import com.example.My_Taxi.DTO.Request.TripBookingRequest;
import com.example.My_Taxi.DTO.Response.CustomerResponse;
import com.example.My_Taxi.DTO.Response.TripBookingResponse;
import com.example.My_Taxi.Exception.DuplicateResourceException;
import com.example.My_Taxi.Model.TripBooking;
import com.example.My_Taxi.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/my-taxi")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepo customerRepo;

    @PostMapping("/add-customer")
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerRequest customerRequest){
        if(customerRepo.existsByEmail(customerRequest.getEmail())){
            throw new DuplicateResourceException("email already exists");
        }
        if(customerRepo.existsByNumber(customerRequest.getNumber())){
            throw  new DuplicateResourceException("Phone number already exists");
        }
        return new ResponseEntity<>(customerService.addCustomer(customerRequest), HttpStatus.CREATED);
    }

    @PostMapping("/book-cab")
    public ResponseEntity<TripBookingResponse> bookCab(@RequestBody TripBookingRequest tripBookingRequest){
        return new ResponseEntity<>(customerService.bookCab(tripBookingRequest),HttpStatus.CREATED);
    }
    @PutMapping("/cab")
    public String updateCab(){
        customerService.updateAllCabsToAvailable();
        return "All Cabs Are Available now";
    }
    @GetMapping("/customer/{email}/trip-bookings")
    public ResponseEntity<List<TripBookingResponse>> getAllBookings(@PathVariable String email){
        return new ResponseEntity<>(customerService.getAllBookings(email),HttpStatus.FOUND);
    }

//    @GetMapping("/book-cab")
//    public ResponseEntity<>
}
