package com.example.slotbooking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // Use this to link to student/interviewer
    private String email; // optional field, not ideal

    private String role; // "STUDENT" or "INTERVIEWER"

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
