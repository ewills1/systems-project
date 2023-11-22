package com.sheffield.model;

public class PersonalRecord {
    

    private String forename;
    private String surname;

    //Constructor 
    public PersonalRecord(String forename, String surname){
        this.forename = forename;
        this.surname = surname;
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

    @Override
    public String toString(){
        return "Name: " + forename + surname;
    }
}
