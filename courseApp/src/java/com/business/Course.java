/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.business;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Course class 
 * @author Junwei
 */
@Entity
@Table(name="COURSE")
public class Course implements Serializable{
    
    @Id
    @Column(name="COURSE_NUM", unique=true, nullable=false)
    private String courseNum;
    
    @Column(name="NAME", nullable=false)
    private String name;
    
    @Column(name="ROOM", nullable=false)
    private String room;
    
    @Column(name="INSTRUCTOR", nullable=false)
    private String instructor;
    
    @Column(name="DAYS_TIMES", nullable=false)
    private String dt;
    
    @Column(name="CREDIT", nullable=false)
    private char credit;
    
    public Course(){
        this.courseNum = "";
        this.name = "";
        this.room = "";
        this.instructor = "";
        this.dt = "";
    }
    
    public Course(String num,String name,String room,String instructor,String days_times,char credit,String term){
        this.courseNum = num;
        this.name = name;
        this.room = room;
        this.instructor = instructor;
        this.dt = days_times; 
        this.credit = credit;
    }

    /**
     * @return the courseNum
     */
    public String getCourseNum() {
        return courseNum;
    }

    /**
     * @param courseNum the courseNum to set
     */
    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * @return the instructor
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * @param instructor the instructor to set
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    /**
     * @return the dt
     */
    public String getDt() {
        return dt;
    }

    /**
     * @param dt the dt to set
     */
    public void setDt(String dt) {
        this.dt = dt;
    }

    /**
     * @return the credit
     */
    public char getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(char credit) {
        this.credit = credit;
    }

}
