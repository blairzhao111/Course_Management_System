/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.test;

import com.util.UserUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Junwei
 */
public class UserUtilTest {
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of emailFormatValidation method, of class UserUtil.
     */
    @Test
    public void testEmailFormatValidation1() {
        System.out.println("emailFormatValidation");
        String email = null;
        String expected = "Email can't be empty! Please re-enter:";
        String result = UserUtil.emailFormatValidation(email);
        assertTrue("Expected is: "+expected +" Result is: "+result, expected.equals(result));
    }
    
    @Test
    public void testEmailFormatValidation2() {
        System.out.println("emailFormatValidation");
        String email = "";
        String expected = "Email can't be empty! Please re-enter:";
        String result = UserUtil.emailFormatValidation(email);
        assertTrue("Expected is: "+expected +" Result is: "+result, expected.equals(result));
    } 
    
    @Test
    public void testEmailFormatValidation3() {
        System.out.println("emailFormatValidation");
        String email = "email123@gmail.com";
        String expected = "";
        String result = UserUtil.emailFormatValidation(email);
        assertTrue("Expected is: "+expected +" Result is: "+result, expected.equals(result));
    }
    
    @Test
    public void testEmailFormatValidation4() {
        System.out.println("emailFormatValidation");
        String email = "email123gmail@com";
        String expected = "Entered email is not valid, Please check and re-enter:";
        String result = UserUtil.emailFormatValidation(email);
        assertTrue("Expected is: "+expected +" Result is: "+result, expected.equals(result));
    }
    
    @Test
    public void testEmailFormatValidation5() {
        System.out.println("emailFormatValidation");
        String email = "@.";
        String expected = "Entered email is not valid, Please check and re-enter:";
        String result = UserUtil.emailFormatValidation(email);
        assertTrue("Expected is: "+expected +" Result is: "+result, expected.equals(result));
    } 
    
    @Test
    public void testEmailFormatValidation6() {
        System.out.println("emailFormatValidation");
        String email = "123@t.u";
        String expected = "Entered email is not valid, Please check and re-enter:";
        String result = UserUtil.emailFormatValidation(email);
        assertTrue("Expected is: "+expected +" Result is: "+result, expected.equals(result));
    }  
    
    /**
     * Test of passwordFormatValidation method, of class UserUtil.
     */
    @Test
    public void testPasswordFormatValidation1() {
        System.out.println("passwordFormatValidation");
        String password = "password123";
        String expected = "";
        String result = UserUtil.passwordFormatValidation(password);
        assertTrue("Expected is: "+expected +" Result is: "+result, expected.equals(result));
    }
    
    @Test
    public void testPasswordFormatValidation2() {
        System.out.println("passwordFormatValidation");
        String password = "passw";
        String expected = "Password must be equal to or longer than 6 characters! Please re-enter:";
        String result = UserUtil.passwordFormatValidation(password);
        assertTrue("Expected is: "+expected +" Result is: "+result, expected.equals(result));
    }
   
    @Test
    public void testPasswordFormatValidation3() {
        System.out.println("passwordFormatValidation");
        String password = "1password123";
        String expected = "Password must start with a letter! Please re-enter:";
        String result = UserUtil.passwordFormatValidation(password);
        assertTrue("Expected is: "+expected +" Result is: "+result, expected.equals(result));
    }
    
    @Test
    public void testPasswordFormatValidation4() {
        System.out.println("passwordFormatValidation");
        String password = "pass word 123";
        String expected = "Password can't contain space! Please re-enter:";
        String result = UserUtil.passwordFormatValidation(password);
        assertTrue("Expected is: "+expected +" Result is: "+result, expected.equals(result));
    }
    
    @Test
    public void testPasswordFormatValidation5() {
        System.out.println("passwordFormatValidation");
        String password = null;
        String expected = "Password can't be empty! Please re-enter:";
        String result = UserUtil.passwordFormatValidation(password);
        assertTrue("Expected is: "+expected +" Result is: "+result, expected.equals(result));
    }

    /**
     * Test of passwordVerify method, of class UserUtil.
     */
    @Test
    public void testPasswordVerify1() {
        System.out.println("passwordVerify");
        String p1 = "password123";
        String p2 = "password123";
        String expected = "";
        String result = UserUtil.passwordVerify(p1, p2);
        assertTrue("Expected is: "+expected +" Result is: "+result, expected.equals(result));
    }
    
    @Test
    public void testPasswordVerify2() {
        System.out.println("passwordVerify");
        String p1 = "passdorw123";
        String p2 = "password123";
        String expected = "Two passwords you entered are not same, please try again.";
        String result = UserUtil.passwordVerify(p1, p2);
        assertTrue("Expected is: "+expected +" Result is: "+result, expected.equals(result));
    }
    
    @Test
    public void testPasswordVerify3() {
        System.out.println("passwordVerify");
        String p1 = "123";
        String p2 = "password123";
        String expected = "Two passwords you entered are not same, please try again.";
        String result = UserUtil.passwordVerify(p1, p2);
        assertTrue("Expected is: "+expected +" Result is: "+result, expected.equals(result));
    }
    
}
