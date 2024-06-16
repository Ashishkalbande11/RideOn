package com.example.My_Taxi.DTO.Request;

import com.example.My_Taxi.Enum.Gender;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerRequest {

    String firstName;

    String lastName;

    String email;

    Long number;

    Gender gender;

    String address;
}
