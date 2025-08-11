package com.example.resourcelifecycle.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "approval_workflow")
public class ApprovalWorkflow {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String requestType; // ADDITIONAL, EXTENSION, RELEASE, EXTERNAL
    private Long requestId;
    private String approver; // role or user
    private String status = "PENDING"; // PENDING, APPROVED, REJECTED
    private LocalDateTime actedAt;
    }
