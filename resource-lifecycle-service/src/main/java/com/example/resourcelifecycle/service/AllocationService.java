package com.example.resourcelifecycle.service;
import com.example.resourcelifecycle.model.Allocation;

import com.example.resourcelifecycle.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AllocationService {

    @Autowired
    private AllocationRepository allocationRepository;

    @Transactional(readOnly = true)
    public List<Allocation> getAllAllocations() {
        return allocationRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private Allocation convertToDTO(Allocation allocation) {
        Allocation dto = new Allocation();
        dto.setId(allocation.getId());
        dto.setProjectName(allocation.getProjectName());
        dto.setStartDate(allocation.getStartDate());
        dto.setEndDate(allocation.getEndDate());
        dto.setStatus(allocation.getStatus());
        return dto;
    }
}
