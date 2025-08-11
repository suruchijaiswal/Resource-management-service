package com.example.reporting.model;

import jakarta.persistence.*;

@Entity
@Table(name = "approval")
public class Approval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "approver_name")
    private String approverName;

    @Column(name = "status")
    private String status;

    public Approval() {
    }

    public Approval(String approverName, String status) {
        this.approverName = approverName;
        this.status = status;
    }


}
