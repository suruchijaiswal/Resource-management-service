package com.example.resourcelifecycle.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
    @Entity
    @Table(name = "fulfillment_status")
    public class FulfillmentStatus {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    private Long allocationId;

        @Enumerated(EnumType.STRING)
        private Status status;

        private String remarks;

        private LocalDateTime updatedAt = LocalDateTime.now();

        public enum Status {
            PENDING, JOINED, ACTIVE, EXITED
        }


    }

