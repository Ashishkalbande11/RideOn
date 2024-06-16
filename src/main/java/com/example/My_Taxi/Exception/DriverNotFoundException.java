package com.example.My_Taxi.Exception;

public class DriverNotFoundException extends RuntimeException{

    public DriverNotFoundException(String message){
        super(message);
    }
}
