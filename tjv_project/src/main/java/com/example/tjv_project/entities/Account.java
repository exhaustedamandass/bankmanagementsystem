package com.example.tjv_project.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "accounts")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "accountid")
public class Account implements EntityWithId<Long>{
    @Id
    @GeneratedValue(generator = "accounts_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "accounts_seq", sequenceName = "accounts_seq", allocationSize = 1)
    private Long accountid;
    private String accountnumber;
    private String accounttype;
    private double currentbalance;
    private LocalDateTime dateopened;
    private LocalDateTime dateclosed;
    private String accountstatus;
    @ManyToMany
    @JoinTable(
            name = "accounts_holded",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Collection<Customer> accountholders;
    @OneToMany(mappedBy = "clientaccount")
    @JsonManagedReference
    private Collection<Transaction> mytransactions;

    public Account() {
        this.accountholders = new ArrayList<>();
        this.mytransactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        if (mytransactions == null) {
            mytransactions = new ArrayList<>();
        }
        mytransactions.add(transaction);
    }
    public void addHolder(Customer customer){
        if(accountholders == null){
            accountholders = new ArrayList<>();
        }
        accountholders.add(customer);
    }

    @Override
    public Long getId() {
        return accountid;
    }

    @Override
    public void setId(Long aLong) {
        accountid = aLong;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountId) {
        this.accountid = accountId;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountNumber) {
        this.accountnumber = accountNumber;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accountType) {
        this.accounttype = accountType;
    }

    public double getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(double currentBalance) {
        this.currentbalance = currentBalance;
    }

    public LocalDateTime getDateopened() {
        return dateopened;
    }

    public void setDateopened(LocalDateTime dateOpened) {
        this.dateopened = dateOpened;
    }

    public LocalDateTime getDateclosed() {
        return dateclosed;
    }

    public void setDateclosed(LocalDateTime dateClosed) {
        this.dateclosed = dateClosed;
    }

    public String getAccountstatus() {
        return accountstatus;
    }

    public void setAccountstatus(String accountStatus) {
        this.accountstatus = accountStatus;
    }

    public Collection<Customer> getAccountholders() {
        return accountholders;
    }

    public void setAccountholders(Collection<Customer> accountHolders) {
        this.accountholders = accountHolders;
    }

    public Collection<Transaction> getMytransactions() {
        return mytransactions;
    }

    public void setMytransactions(Collection<Transaction> myTransactions) {
        this.mytransactions = myTransactions;
    }
}
