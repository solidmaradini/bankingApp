package com.example.finalProject.embedables;


import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetName;
    private String stretNumb;

    public Address() {
    }

    public Address(String streetName, String stretNumb) {
        this.streetName = streetName;
        this.stretNumb = stretNumb;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStretNumb() {
        return stretNumb;
    }

    public void setStretNumb(String stretNumb) {
        this.stretNumb = stretNumb;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", stretNumb='" + stretNumb + '\'' +
                '}';
    }
}
