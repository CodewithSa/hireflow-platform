package com.example.job_service.dto;

import com.example.job_service.enums.EmploymentType;
import com.example.job_service.enums.JobStatus;
import com.example.job_service.enums.WorkMode;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddJobDto {

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100)
    private String title;

    @NotBlank(message = "Company is required")
    @Size(min = 2, max = 100)
    private String company;

    @NotBlank(message = "Location is required")
    @Size(min = 2, max = 100)
    private String location;

    @NotBlank(message = "Description is required")
    @Size(min = 20, max = 2000)
    private String description;

    @NotNull(message = "Employment type is required")
    private EmploymentType employmentType;

    @NotNull(message = "Work mode is required")
    private WorkMode workMode;

    private JobStatus jobStatus;

    @NotBlank(message = "Required skills are required")
    @Size(min = 2, max = 1000)
    private String requiredSkills;

    private String salaryRange;


}

