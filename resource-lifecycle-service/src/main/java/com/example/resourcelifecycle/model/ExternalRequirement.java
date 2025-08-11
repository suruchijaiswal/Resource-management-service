package com.example.resourcelifecycle.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

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
    // getters/setters
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getVendorName(){return vendorName;} public void setVendorName(String v){this.vendorName=v;}
    public String getRole(){return role;} public void setRole(String r){this.role=r;}
    public Integer getHoursRequested(){return hoursRequested;} public void setHoursRequested(Integer h){this.hoursRequested=h;}
    public String getStatus(){return status;} public void setStatus(String s){this.status=s;}
    public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime t){this.createdAt=t;}
}
