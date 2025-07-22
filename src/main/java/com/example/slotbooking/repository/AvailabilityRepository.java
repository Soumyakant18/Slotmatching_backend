package com.example.slotbooking.repository;

import com.example.slotbooking.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByRole(String role);
    List<Availability> findByUserId(Long userId);

    boolean existsByUserIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
            Long userId, LocalDateTime startTime, LocalDateTime endTime
    );
}
