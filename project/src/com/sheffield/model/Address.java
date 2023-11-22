package com.sheffield.model;

public class Address {

    private String houseNumber;
    private String streetName;
    private String cityName;
    private String postcode;
    

    public Address (String houseNumber, String streetName, String cityName, String postcode ){
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.cityName = cityName;
        this.postcode = postcode;
    }

    public String getHouseNumber(){
        return houseNumber;
    }
    
    public void setHouseNumber(String houseNumber){
        this.houseNumber = houseNumber;
    }

    public String getStreetName(){
        return streetName;
    }

    public void setStreetName(String streetName){
        this.streetName = streetName;
    }

    public String getCityName(){
        return cityName;
    }

    public void setCityName(String cityName){
        this.cityName = cityName;
    }

    public String getPostcode(){
        return postcode;
    }

    public void setPostCode(String postcode){
        this.postcode = postcode;
    }

    @Override
    public String toString(){
        return houseNumber+", "+streetName+", "+cityName+", "+postcode;
    }
}
