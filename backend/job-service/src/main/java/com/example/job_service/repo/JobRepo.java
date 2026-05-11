package com.example.job_service.repo;

import com.example.job_service.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Job, Long> {
    Page<Job> findByRequiredSkillsContainingIgnoreCase(String skill, Pageable pageable);
    Page<Job> findByTitleContainingIgnoreCase(String title, Pageable pageable);

}
