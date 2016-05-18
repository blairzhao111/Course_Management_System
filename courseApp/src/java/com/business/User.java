/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.business;

import java.io.Serializable;
import javax.persistence.*;


/**
 * User class
 * @author Junwei
 */

@Entity
@Table(name = "USER")
public class User implements Serializable {
    
    @Id
    @Column(name = "USER_ID", nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    
    @Column(name = "EMAIL", nullable=false)
    private String email;
    
    @Column(name = "PASSWORD", nullable=false)
    private String password;
    
    @Column(name = "ROLE", nullable=false)
    private String role;
    
    public User(){
        email = "";
        password = "";
        role = "";
    }

    /**
     * @return the userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

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
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
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
