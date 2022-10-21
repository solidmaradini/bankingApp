package com.example.finalProject.entities.users;

import com.example.finalProject.embedables.Address;
import com.example.finalProject.entities.accounts.Account;
import com.example.finalProject.entities.security.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class AccountHolder extends User{
    private LocalDate dateOfbirth;
    @Embedded
    private Address primaryAddress;
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetName", column = @Column(name = "mailingAddress_streetName")),
            @AttributeOverride(name = "stretNumb", column = @Column(name = "mailingAddress_stretNumb"))})
    private Address mailingAddress;

    @OneToMany (mappedBy = "primaryOwner")
    @JsonIgnore
    private List<Account> primaryAccountList;
    @OneToMany (mappedBy = "secondaryOwner")
    @JsonIgnore
    private List<Account> secondaryAccountList;

    public AccountHolder() {
    }

    public AccountHolder(String username, String password, LocalDate dateOfbirth, Address primaryAddress, String name, Address mailingAddress) {
        super(username, password);
        this.dateOfbirth = dateOfbirth;
        this.primaryAddress = primaryAddress;
        this.name = name;
        this.mailingAddress = mailingAddress;
    }

    public LocalDate getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(LocalDate dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public List<Account> getPrimaryAccountList() {
        return primaryAccountList;
    }

    public void setPrimaryAccountList(List<Account> primaryAccountList) {
        this.primaryAccountList = primaryAccountList;
    }

    public List<Account> getSecondaryAccountList() {
        return secondaryAccountList;
    }

    public void setSecondaryAccountList(List<Account> secondaryAccountList) {
        this.secondaryAccountList = secondaryAccountList;
    }

    @Override
    public String toString() {
        return "AccountHolder{" +
                "dateOfbirth=" + dateOfbirth +
                ", primaryAddress=" + primaryAddress +
                ", name='" + name + '\'' +
                ", mailingAddress=" + mailingAddress +
                '}';
    }
}
