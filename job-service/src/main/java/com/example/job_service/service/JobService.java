package com.example.job_service.service;

import com.example.job_service.dto.AddJobDto;
import com.example.job_service.dto.JobResponseDto;
import org.springframework.data.domain.Page;

public interface JobService {

    Page<JobResponseDto> getAllJobs(int page, int size, String sortBy);
    JobResponseDto createJob(AddJobDto addJobDto);
}
