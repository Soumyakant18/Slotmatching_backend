package com.example.slotbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SlotBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlotBookingApplication.class, args);
    }

}
