package com.evacuationapp.finalevacuationapp;

public class Places {
    String streetAddress,state,country,image,evacuationName,evacuationNumber,evacuationCalamityType,evacuationBarangay,calamityName,calamityDetails;
    double latitude,longitude;
    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCalamityName() {
        return calamityName;
    }

    public void setCalamityName(String calamityName) {
        this.calamityName = calamityName;
    }

    public String getCalamityDetails() {
        return calamityDetails;
    }

    public void setCalamityDetails(String calamityDetails) {
        this.calamityDetails = calamityDetails;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getEvacuationName() {
        return evacuationName;
    }

    public void setEvacuationName(String evacuationName) {
        this.evacuationName = evacuationName;
    }

    public String getEvacuationNumber() {
        return evacuationNumber;
    }

    public void setEvacuationNumber(String evacuationNumber) {
        this.evacuationNumber = evacuationNumber;
    }

    public String getEvacuationCalamityType() {
        return evacuationCalamityType;
    }

    public void setEvacuationCalamityType(String evacuationCalamityType) {
        this.evacuationCalamityType = evacuationCalamityType;
    }


    public String getEvacuationBarangay() {
        return evacuationBarangay;
    }

    public void setEvacuationBarangay(String evacuationBarangay) {
        this.evacuationBarangay = evacuationBarangay;
    }
}
