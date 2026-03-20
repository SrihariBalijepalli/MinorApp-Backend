package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Progress;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
}