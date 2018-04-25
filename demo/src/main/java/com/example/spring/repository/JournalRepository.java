package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {

}
