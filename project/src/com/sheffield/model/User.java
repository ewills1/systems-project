package com.sheffield.model;

import java.util.List;

public class User {
    private String userID;
    private String email;
    private List<Role> roles;

     /**
     * Constructor for creating a User object.
     *
     * @param userId   The unique identifier for the user.
     * @param email    The email address of the user.
     * @param roles     The role assigned to the user.
     */
    public User(String userID, String email, List<Role>roles) {
        this.setUserID(userID);
        this.setEmail(email);
        this.setRoles(roles);
    }

    //Getter and setter methods for userID 
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID){
        this.userID = userID;
    }

    //Getter and setter methods for email 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Gets the list of roles associated with the user.
     *
     * @return The list of roles.
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * Sets the list of roles associated with the user.
     *
     * @param roles The list of roles to be set.
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "{ " + " userID = " + getUserID() + 
            ", email = " + getEmail() + ", role= "
            + roles.toString()+"}";
    }
}
