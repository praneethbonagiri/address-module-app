package com.learning.microservices.address.service.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {

    private String doorNo;
    private String street;
    private String city;
    private Integer zip;
    @Id
    private Integer empId;

    public Address() {

    }

    public Address(String doorNo, String street, String city, Integer zip, Integer empId) {
        this.doorNo = doorNo;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.empId = empId;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
}
