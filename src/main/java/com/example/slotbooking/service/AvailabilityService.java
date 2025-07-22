package com.example.slotbooking.service;

import com.example.slotbooking.model.Availability;
import com.example.slotbooking.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    public Availability addAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    public List<Availability> getAllAvailability() {
        return availabilityRepository.findAll();
    }

    public List<Availability> getByRole(String role) {
        return availabilityRepository.findByRole(role);
    }

    public List<Availability> getByUserId(Long userId) {
        return availabilityRepository.findByUserId(userId);
    }

    public boolean isUserAvailable(Long userId, LocalDateTime start, LocalDateTime end) {
        return availabilityRepository.existsByUserIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(userId, start, end);
    }
}
