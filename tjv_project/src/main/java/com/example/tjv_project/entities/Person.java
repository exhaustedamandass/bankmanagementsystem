package com.example.tjv_project.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "persons")
public class Person implements EntityWithId<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personid;
    private String lastname;
    private String firstname;
    private LocalDateTime dateofbirth;
    private String email;
    private String phonenumber;
    private String address;
    private String taxidentifier;

    @Override
    public Long getId() {
        return personid;
    }

    @Override
    public void setId(Long aLong) {
        personid = aLong;
    }

    public Long getPersonid() {
        return personid;
    }

    public void setPersonid(Long personId) {
        this.personid = personId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public LocalDateTime getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDateTime dateOfBirth) {
        this.dateofbirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phoneNumber) {
        this.phonenumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxidentifier() {
        return taxidentifier;
    }

    public void setTaxidentifier(String taxIdentifier) {
        this.taxidentifier = taxIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!Objects.equals(personid, person.personid)) return false;
        if (!Objects.equals(lastname, person.lastname)) return false;
        if (!Objects.equals(firstname, person.firstname)) return false;
        if (!Objects.equals(dateofbirth, person.dateofbirth)) return false;
        if (!Objects.equals(email, person.email)) return false;
        if (!Objects.equals(phonenumber, person.phonenumber)) return false;
        if (!Objects.equals(address, person.address)) return false;
        return Objects.equals(taxidentifier, person.taxidentifier);
    }

    @Override
    public int hashCode() {
        int result = personid != null ? personid.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (dateofbirth != null ? dateofbirth.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phonenumber != null ? phonenumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (taxidentifier != null ? taxidentifier.hashCode() : 0);
        return result;
    }
}
