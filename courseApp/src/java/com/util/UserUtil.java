/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.business.User;

/**
 *
 * @author Junwei
 */
public class UserUtil {
    
    /**
     * Check if given email address is a valid email address.
     * @param email
     * @return 
     */
    public static String emailFormatValidation(String email){
        if(email==null||email.length()==0){return "Email can't be empty! Please re-enter:";}
        
        String message = "";
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(!email.matches(EMAIL_REGEX)){
            message = "Entered email is not valid, Please check and re-enter:";
        }
        return message;
    }
    
    /**
     * Check if given password is equal to or longer than 6 character.
     * @param password
     * @return 
     */
    public static String passwordFormatValidation(String password){
        if(password==null){return "Password can't be empty! Please re-enter:";}
        
        String message = "";
        password = password.trim();
        if(password.length()<6){
            message = "Password must be equal to or longer than 6 characters! Please re-enter:";
        }else{
            for(int i=0;i<password.length();i++){
                if(i==0&&!Character.isLetter(password.charAt(0))){
                    message = "Password must start with a letter! Please re-enter:";
                    break;
                }
                if(password.charAt(i)==' '){
                    message = "Password can't contain space! Please re-enter:";
                    break;
                }
            }
        }
        return message;       
    }
    
    /**
     * Check if two given passwords are the same, used for password verification in registration page.
     * @param p1, first password
     * @param p2  second password
     * @return if two passwords are the same, return empty string, else return error message.
     */
    public static String passwordVerify(String p1, String p2){
        p1 = p1.trim();
        p2 = p2.trim();
        String error = "Two passwords you entered are not same, please try again.";
        if(p1.length()!= p2.length()){return error;}
        for(int i=0;i<p1.length();i++){
            if(p1.charAt(i)!=p2.charAt(i)){return error;}
        }
        return "";
    }
    
}
