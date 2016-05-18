/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import com.business.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Junwei
 */
public class UserDB {
    
    public static void insertUser(User user){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(user);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    
    public static void updateUser(User user){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e);
        } finally {
            em.close();
        }    
    }
    
    public static User selectUser(String email){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString = "SELECT u FROM User u WHERE u.email = :email";
        TypedQuery<User> query = em.createQuery(queryString, User.class);
        query.setParameter("email", email);
        
        User result = null;
        try{
            result = query.getSingleResult();
        }catch(NoResultException e){
            return null;
        }finally{
            em.close();
        }
        return result;
    }
    
    //retrieve User object by primary key
    public static User selectUser(long userId){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try{
            User user = em.find(User.class, userId);
            return user;
        }finally{
            em.close();
        }
    }
    
}
