package com.poussu.studymate.userdata;

public class User {
    private String name;
    private String password;
    private String email;
    /**
     * This constructs a User with a specified name, password and email.
     * @param name the name of the user
     * @param password the password of the user
     * @param email the email of the user
     * 
     */
    // User object that contains the users informations.
    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    
    /** 
     * This method will get the email of the user.
     * @return String
     */
    public String getEmail() {
        return email;
    }

    
    /** 
     * This method will get the name of the user.
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /** 
     * This method will get the password of the user.
     * @return String
     */
    public String getPassword() {
        return password;
    }

    
    /** 
     * This method will set the email of the user.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    /** 
     * This method will set the name of the user.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * This method will set the password of the user.
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
