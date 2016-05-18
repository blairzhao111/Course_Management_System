/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import com.business.CourseRegistration;
import com.business.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Junwei
 */
public class CourseRegistrationDB {
    
    public static void insertCourseRegistration(CourseRegistration cr){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(cr);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    
    public static CourseRegistration selectCourseRegistration(long courseRegistrationNum){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try{
            CourseRegistration cr = em.find(CourseRegistration.class, courseRegistrationNum);
            return cr;
        }finally{
            em.close();
        }
    }
    
    public static List<CourseRegistration> selectEnrolled(Student student){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String studentId = student.getStudentId();
        String queryString = "SELECT r from CourseRegistration r WHERE r.student.studentId = :studentId";
        TypedQuery<CourseRegistration> query = em.createQuery(queryString, CourseRegistration.class);
        query.setParameter("studentId", studentId);
        
        List<CourseRegistration> enrolled = null;
        try{
            enrolled = query.getResultList();
        }finally{
            em.close();
        }
        return enrolled;
    }
    
    public static void removeCourseRegistration(CourseRegistration cr){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(em.merge(cr));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
        } finally {
            em.close();
        }    
    }
}
