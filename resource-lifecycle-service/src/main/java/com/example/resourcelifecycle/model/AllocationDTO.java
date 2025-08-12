package com.example.resourcelifecycle.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AllocationDTO {
    private Long id;
    private String resourceName;
    private String projectName;
    private Integer hoursAllocated;
    private java.time.LocalDate startDate;
    private java.time.LocalDate endDate;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getResourceName() { return resourceName; }
    public void setResourceName(String resourceName) { this.resourceName = resourceName; }
    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    public Integer getHoursAllocated() { return hoursAllocated; }
    public void setHoursAllocated(Integer hoursAllocated) { this.hoursAllocated = hoursAllocated; }
    public java.time.LocalDate getStartDate() { return startDate; }
    public void setStartDate(java.time.LocalDate startDate) { this.startDate = startDate; }
    public java.time.LocalDate getEndDate() { return endDate; }
    public void setEndDate(java.time.LocalDate endDate) { this.endDate = endDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}



