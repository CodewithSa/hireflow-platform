package com.example.job_service.dto;

import com.example.job_service.enums.EmploymentType;
import com.example.job_service.enums.JobStatus;
import com.example.job_service.enums.WorkMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private JobStatus jobStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
