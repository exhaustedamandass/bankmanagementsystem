package com.example.tjv_project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private Long employeeId;
    private String position;
}
