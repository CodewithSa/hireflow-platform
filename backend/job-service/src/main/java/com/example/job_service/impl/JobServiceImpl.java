package com.example.job_service.impl;

import com.example.job_service.dto.AddJobDto;
import com.example.job_service.dto.JobResponseDto;
import com.example.job_service.entity.Job;
import com.example.job_service.enums.JobStatus;
import com.example.job_service.repo.JobRepo;
import com.example.job_service.service.JobService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepo jobRepo;
    private final ModelMapper mapper;


    @Override
    public Page<JobResponseDto> getAllJobs(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        return jobRepo.findAll(pageable)
                .map(job -> mapper.map(job, JobResponseDto.class));
    }

    @Override
    public JobResponseDto createJob(AddJobDto addJobDto) {
        Job job = mapper.map(addJobDto, Job.class);

        job.setCreatedAt(LocalDateTime.now());

        if (job.getJobStatus() == null) {
            job.setJobStatus(JobStatus.OPEN);
        }

        Job savedJob = jobRepo.save(job);
        return mapper.map(savedJob, JobResponseDto.class);
    }


    @Override
    public JobResponseDto getById(Long id) {
        Job job = jobRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No job found with id: " + id));
        return mapper.map(job, JobResponseDto.class);
    }

    @Override
    public Page<JobResponseDto> searchBySkills(String skill, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        return jobRepo.findByRequiredSkillsContainingIgnoreCase(skill, pageable)
                .map(job -> mapper.map(job, JobResponseDto.class));
    }



}
