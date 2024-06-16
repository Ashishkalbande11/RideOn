package com.example.My_Taxi.DTO.Request;

import com.example.My_Taxi.Enum.CarType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CabRequest {

    String cabNo;

    CarType carType;

    int numberOfSeats;

    Double farePerKm;
}
