package com.example.job_service.impl;

import com.example.job_service.dto.AddJobDto;
import com.example.job_service.dto.JobResponseDto;
import com.example.job_service.entity.Job;
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
        Job newJob = mapper.map(addJobDto, Job.class);
        Job saveJob = jobRepo.save(newJob);
        return mapper.map(saveJob, JobResponseDto.class);
    }




}
