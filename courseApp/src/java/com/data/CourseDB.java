/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import com.business.Course;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Junwei
 */
public class CourseDB {

    public static List<Course> selectCourses() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString = "SELECT c FROM Course c";
        TypedQuery<Course> query = em.createQuery(queryString, Course.class);
        
        List<Course> searchResult = null;
        try{
            searchResult = query.getResultList();
        }finally{
            em.close();
        }
        return searchResult;
    }
    
}
