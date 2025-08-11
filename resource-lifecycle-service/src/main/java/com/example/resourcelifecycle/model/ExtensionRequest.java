package com.example.resourcelifecycle.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "extension_request")
public class ExtensionRequest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long allocationId;
    private LocalDate newEndDate;
    private String reason;
    private String status = "PENDING";
    private LocalDateTime requestedAt = LocalDateTime.now();
    // getters/setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Long getAllocationId(){return allocationId;} public void setAllocationId(Long allocationId){this.allocationId=allocationId;}
    public LocalDate getNewEndDate(){return newEndDate;} public void setNewEndDate(LocalDate newEndDate){this.newEndDate=newEndDate;}
    public String getReason(){return reason;} public void setReason(String reason){this.reason=reason;}
    public String getStatus(){return status;} public void setStatus(String status){this.status=status;}
    public LocalDateTime getRequestedAt(){return requestedAt;} public void setRequestedAt(LocalDateTime t){this.requestedAt=t;}
}
