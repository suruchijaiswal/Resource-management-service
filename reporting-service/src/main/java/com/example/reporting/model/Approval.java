package com.example.reporting.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "approval")
public class Approval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus status;

    private LocalDateTime requestDate;
    private LocalDateTime approvalDate;
    private LocalDateTime rejectionDate;
    private String approverComments;
    private String rejectionReason;
}
