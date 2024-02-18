package com.example.tjv_project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Branch {
    @Id
    private Long branchId;
    private String branchName;
    private String branchCode;
    private String address;
    private String phoneNumber;
}
