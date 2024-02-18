package com.example.tjv_project.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "customers")
public class Customer implements EntityWithId<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerid;
    @Column(name = "customertype")
    private String customertype;
    @OneToOne
    @JoinColumn(name = "personholder")
    private Person personholder;

    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype;
    }

    public Person getPersonholder() {
        return personholder;
    }

    public void setPersonholder(Person personholder) {
        this.personholder = personholder;
    }

    @Override
    public Long getId() {
        return customerid;
    }

    @Override
    public void setId(Long aLong) {
        customerid = aLong;
    }
}
