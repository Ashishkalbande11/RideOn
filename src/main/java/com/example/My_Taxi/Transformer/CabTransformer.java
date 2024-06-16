package com.example.My_Taxi.Transformer;

import com.example.My_Taxi.DTO.Request.CabRequest;
import com.example.My_Taxi.DTO.Response.CabResponse;
import com.example.My_Taxi.Model.Cab;

public class CabTransformer {

    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder()
                .cabNo(cabRequest.getCabNo())
                .carType(cabRequest.getCarType())
                .numberOfSeats(cabRequest.getNumberOfSeats())
                .farePerKm(cabRequest.getFarePerKm())
                .available(true)
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab){
        return CabResponse.builder()
                .cabNo(cab.getCabNo())
                .farePerKm(cab.getFarePerKm())
                .build();
    }
}
