package com.vathanakmao.testproj.sampleapp.gae.model;

import javax.persistence.Embeddable;

@Embeddable
public class Publisher {
    private String name;
    private String address;
    private String city;
    private String stateOrProvince;
    private String postalCode;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getStateOrProvince() {
	return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
	this.stateOrProvince = stateOrProvince;
    }

    public String getPostalCode() {
	return postalCode;
    }

    public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
    }

}
