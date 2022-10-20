package com.example.finalProject.entities.users;

import javax.persistence.Entity;

@Entity
public class ThirdParty extends User{
    private String name;
    private String hashKey;

    public ThirdParty(String name, String hashKey) {
        this.name = name;
        this.hashKey = hashKey;
    }

    public ThirdParty() {
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
