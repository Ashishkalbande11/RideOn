package com.example.My_Taxi.Service;

import com.example.My_Taxi.DAO.CabRepo;
import com.example.My_Taxi.DAO.CustomerRepo;
import com.example.My_Taxi.DAO.DriverRepo;
import com.example.My_Taxi.DAO.TripBookingRepo;
import com.example.My_Taxi.DTO.Request.CustomerRequest;
import com.example.My_Taxi.DTO.Request.TripBookingRequest;
import com.example.My_Taxi.DTO.Response.CustomerResponse;
import com.example.My_Taxi.DTO.Response.TripBookingResponse;
import com.example.My_Taxi.Exception.CabNotFoundException;
import com.example.My_Taxi.Exception.CustomerNotFoundException;
import com.example.My_Taxi.Model.Cab;
import com.example.My_Taxi.Model.Customer;
import com.example.My_Taxi.Model.TripBooking;
import com.example.My_Taxi.Transformer.CustomerTransformer;
import com.example.My_Taxi.Transformer.TripBookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final DriverRepo driverRepo;
    private final CabRepo cabRepo;
    private final TripBookingRepo tripBookingRepo;
    private final EmailService emailService;



    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);

        customerRepo.save(customer);

        return CustomerTransformer.customerToCustomerResponse(customer);

    }

    public TripBookingResponse bookCab(TripBookingRequest tripBookingRequest) {

        Customer customer = customerRepo.findByEmailId(tripBookingRequest.getCustomerEmailId());
        if(customer == null){
            throw new CustomerNotFoundException("emailId does not exist!");
        }

        Cab cab = cabRepo.getRandomAvailableCab();
        if(cab == null){
            throw new CabNotFoundException("Sorry !! all derives all busy right now..");
        }
        //setting details
        TripBooking tripBooking = TripBookingTransformer.tripBookingRequestToTripBooking(tripBookingRequest);
        tripBooking.setTotalFare(tripBookingRequest.getDistanceInKm()*cab.getFarePerKm());
        tripBooking.setCustomer(customer);
        tripBooking.setDriver(cab.getDriver());
        //save information
        TripBooking savedTrip = tripBookingRepo.save(tripBooking);
        customer.getTripBookingList().add(savedTrip);
        cab.getDriver().getTripBookingList().add(savedTrip);
        cab.setAvailable(false);
        //saving in customer and driver repo
        customerRepo.save(customer);
        driverRepo.save(cab.getDriver());

        //email sending
        emailService.sendMail(savedTrip);

        return TripBookingTransformer.tripBookingToTripBookingResponse(savedTrip);
    }

    public void updateAllCabsToAvailable() {
        List<Cab> cabs = cabRepo.findAll();

        for (Cab cab : cabs) {
            cab.setAvailable(true);
        }
        cabRepo.saveAll(cabs);
    }

    public List<TripBookingResponse> getAllBookings(String email) {

        Customer customer = customerRepo.findByEmailId(email);

        if(customer == null){
            throw new CustomerNotFoundException("customer does not exist with this emailId "+email);
        }
        List<TripBooking> bookings = tripBookingRepo.findByCustomer(customer);
        List<TripBookingResponse> tripBookingResponseList = new ArrayList<>();
        for(TripBooking tripBooking : bookings){
            tripBookingResponseList.add(TripBookingTransformer.tripBookingToTripBookingResponse(tripBooking));
        }
        return tripBookingResponseList;
    }
}
