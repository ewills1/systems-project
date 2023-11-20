package com.sheffield.model;

public class User {
    private int userID;
    private String email;
    private String password;

    //Constructor
    public User(int userID, String email, String password) {
        this.setUserID(userID);
        this.setEmail(email);
        this.setPassword(password);
    }

    //Getter and setter methods for userID with validation
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID){
        if (isValidUserID(userID)){
            this.userID = userID;
        } else {
            throw new IllegalArgumentException("UserID is not valid");
        }
    }

    //Getter and setter methods for email with validation
    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        if (isValidEmail(email)){
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email is not valid");
        }
    }

    //Getter and setter methods for password with validation
    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        if (isValidPassword (password)){
            this.password = password;
        }else {
            throw new IllegalArgumentException("Password is not valid");
        }
    }

    //private validation methods for each attribute
    private boolean isValidUserID(int userID){
        return userID >= 0 & userID <= 9999;
    }

    private boolean isValidEmail(String email){
        return email != null && email.length() <= 100;
    }

    private boolean isValidPassword(String password){
        return password != null && password.length()<=100;
    }


    @Override
    public String toString() {
        return "{ " + " userID = " + getUserID() + 
            ", email = " + getEmail() + ", password = " +
            getPassword() + " }";
    }
}
