package com.zzeebee.model;

public class UserAuth {

    private String email;
    private String password;
    private String firebase_id;
    private int id;

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getFirebase_id() {
        return firebase_id;
    }

    /**
     * @param firebase_id the password to set
     */
    public void setFirebase_id(String firebase_id) {
        this.firebase_id = firebase_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
