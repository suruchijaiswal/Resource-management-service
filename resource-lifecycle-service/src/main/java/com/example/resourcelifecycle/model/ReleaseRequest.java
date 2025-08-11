package com.example.resourcelifecycle.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "release_request")
public class ReleaseRequest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long allocationId;
    private String reason;
    private String status = "PENDING";
    private LocalDateTime requestedAt = LocalDateTime.now();
    }
