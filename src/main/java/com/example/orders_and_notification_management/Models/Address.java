package com.example.orders_and_notification_management.Models;

public class Address {
    private String district;
    private String street;
    private String building;
    private String apartment;

    public Address() {
    }
    public Address(String district, String street, String building, String apartment) {
        this.district = district;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
