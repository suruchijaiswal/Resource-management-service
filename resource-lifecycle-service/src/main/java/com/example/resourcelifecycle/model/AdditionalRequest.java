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
    // getters/setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Long getAllocationId(){return allocationId;} public void setAllocationId(Long allocationId){this.allocationId=allocationId;}
    public Integer getAdditionalHours(){return additionalHours;} public void setAdditionalHours(Integer additionalHours){this.additionalHours=additionalHours;}
    public String getReason(){return reason;} public void setReason(String reason){this.reason=reason;}
    public String getStatus(){return status;} public void setStatus(String status){this.status=status;}
    public LocalDateTime getRequestedAt(){return requestedAt;} public void setRequestedAt(LocalDateTime t){this.requestedAt=t;}
}
