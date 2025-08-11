package com.example.reporting.controller;

import com.example.reporting.model.Approval;
import com.example.reporting.service.ApprovalWorkflowService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/approvals")
public class ApprovalController {

    private final ApprovalWorkflowService approvalService;

    public ApprovalController(ApprovalWorkflowService approvalService) {
        this.approvalService = approvalService;
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<Approval> approveRequest(
            @PathVariable Long id,
            @RequestParam(required = false) String comments) {
        return ResponseEntity.ok(
                approvalService.approveRequest(id, comments != null ? comments : "")
        );
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<Approval> rejectRequest(
            @PathVariable Long id,
            @RequestParam String reason) {
        return ResponseEntity.ok(
                approvalService.rejectRequest(id, reason)
        );
    }



}