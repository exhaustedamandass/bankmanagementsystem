package com.example.tjv_project.api.model;

import com.example.tjv_project.entities.Customer;
import com.example.tjv_project.entities.Transaction;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
public class AccountDTO {
    private Long accountid;
    private String accountNumber;
    private String accountType;
    private double currentBalance;
    private LocalDateTime dateOpened;
    private LocalDateTime dateClosed;
    private String accountStatus;
    private Collection<Long> accountholders;
    private Collection<Long> mytransactions;

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public LocalDateTime getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(LocalDateTime dateOpened) {
        this.dateOpened = dateOpened;
    }

    public LocalDateTime getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(LocalDateTime dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Collection<Long> getAccountholders() {
        return accountholders;
    }

    public void setAccountholders(Collection<Long> accountholders) {
        this.accountholders = accountholders;
    }

    public Collection<Long> getMytransactions() {
        return mytransactions;
    }

    public void setMytransactions(Collection<Long> mytransactions) {
        this.mytransactions = mytransactions;
    }
}
