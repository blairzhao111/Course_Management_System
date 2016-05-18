/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Junwei
 */
public class CourseCart implements Serializable {
    
    private List<Course> courses;
    
    public CourseCart(){
        courses = new ArrayList<>();
    }

    /**
     * @return the courses
     */
    public List<Course> getCourses() {
        return courses;
    }
    
    /**
     * @param courses the courses to set
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
    /**
     * 
     * @return 
     */
    public int getCount(){
        return this.courses.size();
    }
    
    /**
     * 
     * @param course 
     */
    public void addCourse(Course course){
        //if course already in the cart, do nothing.
        String courseNum = course.getCourseNum();
        for(int i=0;i<courses.size();i++){
            Course curr = courses.get(i);
            if(curr.getCourseNum().equals(courseNum)){
                return;
            }
        }
        courses.add(course);
    }
    
    /**
     * 
     * @param course 
     */
    public void removeCourse(String courseNum){
        for(int i=0;i<courses.size();i++){
            Course curr = courses.get(i);
            if(curr.getCourseNum().equals(courseNum)){
                courses.remove(i);
                return;
            }
        }
    }


    
}
