package com.example.resourcelifecycle.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "external_requirement")
public class ExternalRequirement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vendorName;
    private String role;
    private Integer hoursRequested;
    private String status = "OPEN";
    private LocalDateTime createdAt = LocalDateTime.now();
    }
