package com.example.My_Taxi.DTO.Response;

import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerResponse {

    String firstName;
    String lastName;
    String email;
    Long number;
}
