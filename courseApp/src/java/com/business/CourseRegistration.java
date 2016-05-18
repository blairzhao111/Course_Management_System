/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.business;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Junwei
 */

@Entity
@Table(name = "COURSEREGISTRATION")
public class CourseRegistration {
    
    @Id
    @Column(name = "REGISTRATION_NUM",unique=true,nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseRegistrationNum;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="Student_ID",referencedColumnName="Student_ID",nullable=false)
    private Student student;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="COURSE_NUM",referencedColumnName="COURSE_NUM",nullable=false)
    private Course course;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REGISTRATION_DATE",nullable=false)
    private Date registrationDate;
    
    public CourseRegistration(){
    }
    
    /**
     * @return the courseRegistrationNum
     */
    public long getCourseRegistrationNum() {
        return courseRegistrationNum;
    }

    /**
     * @param courseRegistrationNum the courseRegistrationNum to set
     */
    public void setCourseRegistrationNum(long courseRegistrationNum) {
        this.courseRegistrationNum = courseRegistrationNum;
    }

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @return the registrationDate
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @param registrationDate the registrationDate to set
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    public String getCourseRegisterationDateDefaultFormat() {
        DateFormat dateFormat = DateFormat.getDateInstance();
        String registrationDateFormatted = dateFormat.format(getRegistrationDate());
        return registrationDateFormatted;
    }
}
