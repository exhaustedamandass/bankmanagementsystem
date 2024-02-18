package com.example.tjv_project.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction implements EntityWithId<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionid;
    private String transactiontype;
    private double amount;
    private LocalDateTime transactiondate;
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Account clientaccount;

    public Long getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Long transctionId) {
        this.transactionid = transctionId;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactionType) {
        this.transactiontype = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(LocalDateTime transactionDate) {
        this.transactiondate = transactionDate;
    }

    public Account getClientaccount() {
        return clientaccount;
    }

    public void setClientaccount(Account clientAccount) {
        this.clientaccount = clientAccount;
    }


    @Override
    public Long getId() {
        return transactionid;
    }

    @Override
    public void setId(Long aLong) {
        transactionid = aLong;
    }
}
