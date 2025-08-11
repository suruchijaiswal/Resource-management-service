package com.example.reporting.service;

import com.example.reporting.repository.AllocationRepository;
import com.example.reporting.repository.ApprovalRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {

    private final AllocationRepository allocationRepo;
    private final ApprovalRepository approvalRepo;

    public ReportService(AllocationRepository allocationRepo, ApprovalRepository approvalRepo) {
        this.allocationRepo = allocationRepo;
        this.approvalRepo = approvalRepo;
    }

    public Map<String, Long> getReportSummary() {
        Map<String, Long> summary = new HashMap<>();
        summary.put("totalAllocations", allocationRepo.count());
        summary.put("totalApprovals", approvalRepo.count());
        return summary;
    }
}
