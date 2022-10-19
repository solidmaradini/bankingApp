package com.example.finalProject.entities.users;


import javax.persistence.Entity;

@Entity
public class Admin extends User{
    private String name;

    public Admin(String name) {
        this.name = name;
    }

    public Admin() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
