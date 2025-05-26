package com.example.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portfolio.entity.HireMeRequest;

@Repository
public interface HireMeRepository extends JpaRepository<HireMeRequest, Long> {

}
