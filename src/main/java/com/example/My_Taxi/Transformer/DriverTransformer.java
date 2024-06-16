package com.example.My_Taxi.Transformer;

import com.example.My_Taxi.DTO.Request.DriverRequest;
import com.example.My_Taxi.DTO.Response.DriverResponse;
import com.example.My_Taxi.Model.Driver;

public class DriverTransformer {

    public static Driver driverRequestToDriver(DriverRequest driverRequest){
        return Driver.builder()
                .firstName(driverRequest.getFirstName())
                .lastName(driverRequest.getLastName())
                .address(driverRequest.getAddress())
                .rating(driverRequest.getRating())
                .number(driverRequest.getNumber())
                .email(driverRequest.getEmail())
                .cab(CabTransformer.cabRequestToCab(driverRequest.getCabRequest()))
                .build();
    }
    public static DriverResponse driverToDriverResponse(Driver driver){
        return DriverResponse.builder()
                .firstName(driver.getFirstName())
                .lastName(driver.getLastName())
                .number(driver.getNumber())
                .rating(driver.getRating())
                .cabResponse(CabTransformer.cabToCabResponse(driver.getCab()))
                .build();
    }
}
