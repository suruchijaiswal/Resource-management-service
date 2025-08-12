package com.example.resourcelifecycle.controller;


import com.example.resourcelifecycle.model.Allocation;
import com.example.resourcelifecycle.model.AllocationDTO;
import com.example.resourcelifecycle.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/allAllocations")
public class AllocationController {

    @Autowired
    private AllocationService allocationService;


    @GetMapping
    public List<AllocationDTO> getAllAllocations() {
        return allocationService.getAllAllocations();
    }
}