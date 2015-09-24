package com.webapp.Model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressBook {
    private String name;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String email;

    @JsonCreator
    public AddressBook(@JsonProperty("name") String name, @JsonProperty("addressline1") String addressLine1,@JsonProperty("addressline2") String addressLine2,@JsonProperty("city") String city,@JsonProperty("state") String state,@JsonProperty("country") String country,@JsonProperty("pincode") String pincode,@JsonProperty("emailid") String email) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.email = email;

    }

    public AddressBook() {

    }

    public String getName() {
        return name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPincode() {
        return pincode;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
