package com.example.job_service.dto;

import com.example.job_service.enums.EmploymentType;
import com.example.job_service.enums.JobStatus;
import com.example.job_service.enums.WorkMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class JobResponseDto {

    private Long id;
    private String title;
    private String company;
    private String location;
    private EmploymentType employmentType;
    private WorkMode workMode;
    private String description;
    private String requiredSkills;
    private String salaryRange;
    private JobStatus status;
    private LocalDateTime createdAt;
}
