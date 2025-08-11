package com.example.reporting.repository;

import com.example.reporting.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {

     List<Allocation> findByProjectName(String projectName);
}