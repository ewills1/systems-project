package com.sheffield.model;

public class PersonalRecord {
    

    private String forename;
    private String surname;
    private String userID;

    //Constructor 
    public PersonalRecord(String forename, String surname, String userID){
        this.forename = forename;
        this.surname = surname;
        this.userID = userID;
    }

    //Getter and setter for forename
    public String getForename(){
        return surname;
    }

    public void setForename (String forename){
        this.forename = forename;
    }

    // Getter and setter for surname
    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getUserID(){
        return userID;
    }

    public void setUserID(String userID){
        this.userID = userID;
    }

    @Override
    public String toString(){
        return "Name: " + forename + " " +surname;
    }
}
