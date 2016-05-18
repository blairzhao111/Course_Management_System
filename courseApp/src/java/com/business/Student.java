/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.business;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author Junwei
 */

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable{
    
    @Id
    @Column(name = "STUDENT_ID", nullable=false)
    private String studentId;
    
    @Column(name ="USER_ID",nullable=false, insertable = false, updatable = false)
    private long userId;
    
    @Column(name = "FIRST_NAME", nullable=false)
    private String firstName;
    
    @Column(name = "LAST_NAME", nullable=false)
    private String lastName;
    
    @Column(name = "MAJOR", nullable=false)
    private String major;
    
    @Column(name = "LEVEL", nullable=false)
    private String level;
    
    @Column(name = "PHONE", nullable=true)
    private String phone;
    
    @OneToOne(optional=false)
    @JoinColumn(name = "USER_ID", unique = true, nullable = false)
    private User user;
    
    public Student(){
       this.studentId = "";
       this.firstName = "";
       this.lastName = "";
       this.major = "";
       this.level = "";
       this.phone = "";
    }
    
    public Student(String studentId,String firstName,String lastName,String major,String level){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.level = level;
        this.phone = "";
    }

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
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
    
}
