package com.example.slotbooking.controller;

import com.example.slotbooking.model.Availability;
import com.example.slotbooking.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    @PostMapping("/add")
    public Availability addSlot(@RequestBody Availability availability) {
        return availabilityService.addAvailability(availability);
    }

    @GetMapping("/all")
    public List<Availability> getAllSlots() {
        return availabilityService.getAllAvailability();
    }

    @GetMapping("/role/{role}")
    public List<Availability> getSlotsByRole(@PathVariable String role) {
        return availabilityService.getByRole(role);
    }

    @GetMapping("/user/{userId}")
    public List<Availability> getByUserId(@PathVariable Long userId) {
        return availabilityService.getByUserId(userId);
    }
}
