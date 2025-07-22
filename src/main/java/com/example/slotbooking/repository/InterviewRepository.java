package com.example.slotbooking.repository;

import com.example.slotbooking.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
    List<Interview> findByStudentId(Long studentId);
    List<Interview> findByInterviewerId(Long interviewerId);

    boolean existsByStudentIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(Long studentId, LocalDateTime end, LocalDateTime start);
    boolean existsByInterviewerIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(Long interviewerId, LocalDateTime end, LocalDateTime start);
}
