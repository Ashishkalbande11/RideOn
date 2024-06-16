package com.example.My_Taxi.Transformer;

import com.example.My_Taxi.DTO.Request.CustomerRequest;
import com.example.My_Taxi.DTO.Response.CustomerResponse;
import com.example.My_Taxi.Model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .number(customerRequest.getNumber())
                .gender(customerRequest.getGender())
                .address(customerRequest.getAddress())
                .build();
    }
    public static CustomerResponse customerToCustomerResponse(Customer customer){
        return CustomerResponse.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .number(customer.getNumber())
                .email(customer.getEmail())
                .build();
    }
}
