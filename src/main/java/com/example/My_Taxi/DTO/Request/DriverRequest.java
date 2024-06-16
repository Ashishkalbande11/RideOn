package com.example.My_Taxi.DTO.Request;

import com.example.My_Taxi.Model.Cab;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DriverRequest {

    String firstName;

    String lastName;

    String address;

    String email;

    Long number;

    Double rating;

    CabRequest cabRequest;
}
