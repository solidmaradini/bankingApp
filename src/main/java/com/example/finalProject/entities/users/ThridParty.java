package com.example.finalProject.entities.users;

import javax.persistence.Entity;

@Entity
public class ThridParty extends User{

    private String name;

    private String hashKey;

    public ThridParty(String name, String hashKey) {
        this.name = name;
        this.hashKey = hashKey;
    }

    public ThridParty() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }
}
