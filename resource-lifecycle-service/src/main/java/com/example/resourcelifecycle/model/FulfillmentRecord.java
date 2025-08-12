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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(Long allocationId) {
        this.allocationId = allocationId;
    }

    public String getExternalRequirementId() {
        return externalRequirementId;
    }

    public void setExternalRequirementId(String externalRequirementId) {
        this.externalRequirementId = externalRequirementId;
    }

    public boolean isMet() {
        return isMet;
    }

    public void setMet(boolean met) {
        isMet = met;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDate getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(LocalDate verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public String getVerificationNotes() {
        return verificationNotes;
    }

    public void setVerificationNotes(String verificationNotes) {
        this.verificationNotes = verificationNotes;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getComplianceStandard() {
        return complianceStandard;
    }

    public void setComplianceStandard(String complianceStandard) {
        this.complianceStandard = complianceStandard;
    }

    // Additional fields as needed
    private String requirementType;
    private String complianceStandard;
}