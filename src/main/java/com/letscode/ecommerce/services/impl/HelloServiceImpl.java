package com.letscode.ecommerce.services.impl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.letscode.ecommerce.services.HelloService;

@Service
public class HelloServiceImpl implements HelloService{

    @Override
    public String horarioAgora() {
        LocalTime now = LocalTime.now(); 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(formatter);
    }
    
}
