package com.example.job_service.controller;


import com.example.job_service.dto.AddJobDto;
import com.example.job_service.dto.JobResponseDto;
import com.example.job_service.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping
    public ResponseEntity<Page<JobResponseDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy) {

        Page<JobResponseDto> jobs = jobService.getAllJobs(page, size, sortBy);
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponseDto> getById(@PathVariable Long id) {
        JobResponseDto job = jobService.getById(id);
        return ResponseEntity.ok(job);
    }

    @GetMapping("/search/{skill}")
    public ResponseEntity<Page<JobResponseDto>> searchBySkill(
            @RequestParam String skill,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy) {
        Page<JobResponseDto> jobs = jobService.searchBySkills(skill, page, size, sortBy);
        return ResponseEntity.ok(jobs);
    }

    @PostMapping
    public ResponseEntity<JobResponseDto> createJob(@RequestBody AddJobDto addJobDto) {
        JobResponseDto jobResponseDto = jobService.createJob(addJobDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(jobResponseDto);
    }


}
