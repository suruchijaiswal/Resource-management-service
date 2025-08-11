package com.example.resourcelifecycle.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Data
@Entity
@Table(name = "fulfillment_records")
public class FulfillmentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long allocationId;

    @Column(nullable = false)
    private String externalRequirementId;

    @Column(nullable = false)
    private boolean isMet = false;  // Default false

    @Column(nullable = false)
    private LocalDate deadline;

    private LocalDate verificationDate;
    private String verifiedBy;
    private String verificationNotes;

    // Additional fields as needed
    private String requirementType;
    private String complianceStandard;
}