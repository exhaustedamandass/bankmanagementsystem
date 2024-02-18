package com.example.tjv_project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Loan {
    @Id
    private Long loanId;
    private String loanType;
    private float loanAmount;
    private float interestRate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String loanStatus;

}
