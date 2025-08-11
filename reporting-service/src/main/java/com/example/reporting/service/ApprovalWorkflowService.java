package com.example.reporting.service;

import com.example.reporting.model.Approval;
import com.example.reporting.model.ApprovalStatus;
import com.example.reporting.repository.ApprovalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApprovalWorkflowService {

    private final ApprovalRepository approvalRepository;

    public ApprovalWorkflowService(ApprovalRepository approvalRepository) {
        this.approvalRepository = approvalRepository;
    }

    @Transactional
    public Approval approveRequest(Long approvalId, String approverComments) {
        Approval approval = approvalRepository.findById(approvalId)
                .orElseThrow(() -> new IllegalArgumentException("Approval not found"));

        approval.setStatus(ApprovalStatus.APPROVED);
        approval.setApprovalDate(LocalDateTime.now());
        approval.setApproverComments(approverComments);

        return approvalRepository.save(approval);
    }

    @Transactional
    public Approval rejectRequest(Long approvalId, String rejectionReason) {
        Approval approval = approvalRepository.findById(approvalId)
                .orElseThrow(() -> new IllegalArgumentException("Approval not found"));

        approval.setStatus(ApprovalStatus.REJECTED);
        approval.setRejectionDate(LocalDateTime.now());
        approval.setRejectionReason(rejectionReason);

        return approvalRepository.save(approval);
    }

    public List<Approval> getPendingApprovals() {
        return approvalRepository.findByStatus(ApprovalStatus.PENDING);
    }
}