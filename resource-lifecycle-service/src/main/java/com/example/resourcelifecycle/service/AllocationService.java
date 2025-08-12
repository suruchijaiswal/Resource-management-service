package com.example.resourcelifecycle.service;
import com.example.resourcelifecycle.model.Allocation;

import com.example.resourcelifecycle.model.AllocationDTO;
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
    public List<AllocationDTO> getAllAllocations() {
        return allocationRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private AllocationDTO convertToDTO(Allocation allocation) {
        AllocationDTO dto = new AllocationDTO();
        dto.setId(allocation.getId());
        dto.setResourceName(allocation.getResourceName());
        dto.setProjectName(allocation.getProjectName());
        dto.setHoursAllocated(allocation.getHoursAllocated());
        dto.setStartDate(allocation.getStartDate());
        dto.setEndDate(allocation.getEndDate());
        dto.setStatus(allocation.getStatus().name()); // Converts enum to string
        return dto;
    }

}
