package com.fda.inv.web;

import javax.validation.constraints.NotNull;

/**
 * Creada por Rober Molina
 */
public class LoginDto {

    @NotNull
    private String username;
    @NotNull
    private String password;

    private String firstName;

    private String lastName;

    private String document;

    private String phone;

    private String email;

    /**
     * Default constructor
     */
    protected LoginDto() {
    }

    /**
     * Partial constructor
     * @param username
     * @param password
     */
    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
    /**
     * Full constructor
     * @param username
     * @param password
     */
    public LoginDto(String username, String password, String firstName, String lastName
            , String document
            , String phone
            , String email) {
       this(username, password);
       this.firstName = firstName;
       this.lastName = lastName;
        this.document = document;
        this.phone = phone;
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
