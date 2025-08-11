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
    // getters/setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getRequestType(){return requestType;} public void setRequestType(String r){this.requestType=r;}
    public Long getRequestId(){return requestId;} public void setRequestId(Long i){this.requestId=i;}
    public String getApprover(){return approver;} public void setApprover(String a){this.approver=a;}
    public String getStatus(){return status;} public void setStatus(String s){this.status=s;}
    public LocalDateTime getActedAt(){return actedAt;} public void setActedAt(LocalDateTime t){this.actedAt=t;}
}
