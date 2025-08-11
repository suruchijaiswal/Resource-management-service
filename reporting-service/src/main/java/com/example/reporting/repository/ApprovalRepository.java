package com.example.reporting.repository;

import com.example.reporting.model.Approval;
import com.example.reporting.model.ApprovalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApprovalRepository extends JpaRepository<Approval, Long> {
    List<Approval> findByStatus(ApprovalStatus status);
}