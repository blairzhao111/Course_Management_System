/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import com.business.Student;
import com.business.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Junwei
 */
public class StudentDB {
    
    public static void insertStudent(Student student){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(student);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    
    public static void updataStudent(Student student){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(student);
            transaction.commit();
        } catch (Exception ex) {
            if(transaction.isActive()){
                transaction.rollback();
            }
            System.out.println(ex);
        } finally {
            em.close();
        }   
    }
    
    public static Student selectStudent(String studentId){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try{
            Student student = em.find(Student.class, studentId);
            return student;
        }finally{
            em.close();
        }
    }
    
    public static Student selectStudent(long userId){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString = "SELECT s FROM Student s WHERE s.userId = :userId";
        TypedQuery<Student> query = em.createQuery(queryString, Student.class);
        query.setParameter("userId", userId);
        
        Student result = null;
        try{
            result = query.getSingleResult();
        }catch(NoResultException e){
            return null;
        }finally{
            em.close();
        }
        return result;   
    }
    
    /**
     * Retrieve a list of Student Object from Database 
     * @param attribute, string representation of attribute of student object that is used in WHERE statement.
     * @param value, actual attribute value used in WHERE statement.
     * @return 
     */
    public static List<Student> selectStudents(String attribute, String value){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString = "SELECT s from Student s WHERE s.:attribute = :value";
        TypedQuery<Student> query = em.createQuery(queryString, Student.class);
        query.setParameter("attribute", attribute);
        query.setParameter("value", value);
        
        List<Student> students = null;
        try{
            students = query.getResultList();
            if(students==null||students.isEmpty()){
                return null;
            }
        }finally{
            em.close();
        }
        return students;
    }
    
}
