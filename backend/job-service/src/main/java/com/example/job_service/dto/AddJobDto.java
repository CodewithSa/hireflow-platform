package com.example.job_service.dto;

import com.example.job_service.enums.EmploymentType;
import com.example.job_service.enums.JobStatus;
import com.example.job_service.enums.WorkMode;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class AddJobDto {

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100)
    private String title;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100)
    private String company;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100)
    private String location;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100)
    private String description;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100)
    private EmploymentType employmentType;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100)
    private WorkMode workMode;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100)
    private JobStatus jobStatus;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100)
    private String requiredSkills;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100)
    private String salaryRange;

}
