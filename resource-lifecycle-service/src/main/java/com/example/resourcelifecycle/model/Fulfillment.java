package com.example.resourcelifecycle.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fulfillment")
public class Fulfillment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long requestId;
    private String requestType;
    private String status;
    private LocalDateTime updatedAt = LocalDateTime.now();
    // getters/setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Long getRequestId(){return requestId;} public void setRequestId(Long requestId){this.requestId=requestId;}
    public String getRequestType(){return requestType;} public void setRequestType(String requestType){this.requestType=requestType;}
    public String getStatus(){return status;} public void setStatus(String status){this.status=status;}
    public LocalDateTime getUpdatedAt(){return updatedAt;} public void setUpdatedAt(LocalDateTime t){this.updatedAt=t;}
}
