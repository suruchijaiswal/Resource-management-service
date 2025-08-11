package com.example.resourcelifecycle.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter

@Entity
@Table(name = "allocation")
public class Allocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resourceName;
    private String projectName;
    private Integer hoursAllocated;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    public enum Status {ACTIVE, RELEASE_REQUESTED, RELEASED, COMPLETED}
}
