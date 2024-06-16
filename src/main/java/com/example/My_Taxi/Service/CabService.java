package com.example.My_Taxi.Service;

import com.example.My_Taxi.DAO.CabRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CabService {

    private final CabRepo cabRepo;


}
