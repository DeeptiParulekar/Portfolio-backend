package com.example.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portfolio.entity.ContactForm;

@Repository
public interface ContactFormRepository extends JpaRepository<ContactForm, Long> {

}
