package com.example.reporting.model;

import jakarta.persistence.*;

@Entity
@Table(name = "allocation")
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "hours_allocated")
    private int hoursAllocated;

    public Allocation() {
    }

    public Allocation(String resourceName, String projectName, int hoursAllocated) {
        this.resourceName = resourceName;
        this.projectName = projectName;
        this.hoursAllocated = hoursAllocated;
    }

}
