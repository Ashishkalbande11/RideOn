package com.example.My_Taxi.Exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message){
         super(message);
    }
}
