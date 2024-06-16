package com.example.My_Taxi.DTO.Response;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DriverResponse {

    String firstName;

    String lastName;

    Long number;

    Double rating;

    CabResponse cabResponse;
}
