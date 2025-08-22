package com.example.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portfolio.entity.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
