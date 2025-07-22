package com.example.slotbooking.service;

import com.example.slotbooking.model.Interview;
import com.example.slotbooking.repository.InterviewRepository;
import com.example.slotbooking.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private AvailabilityRepository availabilityRepository;

    public Interview bookInterview(Interview interview) {
        boolean studentOverlap = interviewRepository
                .existsByStudentIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
                        interview.getStudentId(), interview.getEndTime(), interview.getStartTime());

        boolean interviewerOverlap = interviewRepository
                .existsByInterviewerIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
                        interview.getInterviewerId(), interview.getEndTime(), interview.getStartTime());

        if (studentOverlap || interviewerOverlap) {
            throw new IllegalStateException("Time slot overlaps with existing interview.");
        }

        boolean isStudentAvailable = availabilityRepository
                .existsByUserIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
                        interview.getStudentId(), interview.getStartTime(), interview.getEndTime());

        boolean isInterviewerAvailable = availabilityRepository
                .existsByUserIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
                        interview.getInterviewerId(), interview.getStartTime(), interview.getEndTime());

        if (!isStudentAvailable || !isInterviewerAvailable) {
            throw new IllegalStateException("Either student or interviewer is not available at this time.");
        }

        return interviewRepository.save(interview);
    }

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    public List<Interview> getInterviewsByStudent(Long studentId) {
        return interviewRepository.findByStudentId(studentId);
    }

    public List<Interview> getInterviewsByInterviewer(Long interviewerId) {
        return interviewRepository.findByInterviewerId(interviewerId);
    }
}
