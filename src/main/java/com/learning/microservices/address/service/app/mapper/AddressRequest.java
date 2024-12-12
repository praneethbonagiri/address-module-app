package com.learning.microservices.address.service.app.mapper;

public class AddressRequest {
    private String doorNumber;
    private String streetName;
    private String city;
    private Integer zipCode;
    private Integer addId;

    public AddressRequest() {

    }

    public AddressRequest(String doorNumber, String streetName, String city, Integer zipCode, Integer addId) {
        this.doorNumber = doorNumber;
        this.streetName = streetName;
        this.city = city;
        this.zipCode = zipCode;
        this.addId = addId;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }
}
