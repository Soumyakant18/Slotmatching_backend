package com.example.slotbooking.controller;

import com.example.slotbooking.model.Interview;
import com.example.slotbooking.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/interview")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping("/book")
    public Interview bookInterview(@RequestBody Interview interview) {
        return interviewService.bookInterview(interview);
    }

    @GetMapping("/all")
    public List<Interview> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    @GetMapping("/student/{studentId}")
    public List<Interview> getByStudent(@PathVariable Long studentId) {
        return interviewService.getInterviewsByStudent(studentId);
    }

    @GetMapping("/interviewer/{interviewerId}")
    public List<Interview> getByInterviewer(@PathVariable Long interviewerId) {
        return interviewService.getInterviewsByInterviewer(interviewerId);
    }
}
