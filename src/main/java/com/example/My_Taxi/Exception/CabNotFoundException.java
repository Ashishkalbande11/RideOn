package com.example.My_Taxi.Exception;

public class CabNotFoundException extends RuntimeException{

    public CabNotFoundException(String message){
        super(message);
    }
}
