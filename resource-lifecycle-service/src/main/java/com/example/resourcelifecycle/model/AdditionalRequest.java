package com.example.resourcelifecycle.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "additional_request")
public class AdditionalRequest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long allocationId;
    private Integer additionalHours;
    private String reason;
    private String status = "PENDING";
    private LocalDateTime requestedAt = LocalDateTime.now();
    }
