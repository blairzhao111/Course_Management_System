/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.business.Student;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.business.User;
import com.data.StudentDB;
import com.data.UserDB;
import com.util.UserUtil;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Junwei
 */
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //get current action
        String action = request.getParameter("action");
        if(action==null){
            action = "login"; //default action is login
        }
        
        //check action type and perform certain action, then forward request and response to appropriate page URL
        String url = "/index.jsp";
        request.removeAttribute("message");
        
        if(action.equals("login")){
            url = logInHelper(request,response);
        }else if(action.equals("register")){
            url = registerHelper(request,response);
        }else if(action.equals("change")){
            url = changeHelper(request, response);
        }else if(action.equals("confirm")){
            url = confirmHelper(request,response);
        }else if(action.equals("modify")){
            url = "/user/change_info.jsp";
        }else if(action.equals("findMyAccount")){
            url = findMyAccountHelper(request,response);
        }else if(action.equals("logout")){
            url = logOutHelper(request,response);
        }
        
        // forward to the view
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "UserController";
    }
    
    private String logInHelper(HttpServletRequest request, HttpServletResponse response){
        String url = "/index.jsp";
        String message = null;
                
        //validate email and password in format aspect.
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        message = validateFormat(email, password);
        if(message!=null){
            request.setAttribute("message", message);
            return url;
        }
         
        //check provided email and password in database.
        User user = UserDB.selectUser(email);
        if(user==null){
            message = "Given email has not been registered yet!";
            request.setAttribute("message", message);
            return url;       
        }else{
            if(!password.equals(user.getPassword())){
                message = "Given password is not correct!";
                request.setAttribute("message", message);
                return url;
            }
        }
        
        Student student = StudentDB.selectStudent(user.getUserId());
        if(student==null){
            message = "You haven't fill out any information, please fill in following fields:";
            request.setAttribute("message", message);
            url = "/user/change_info.jsp";
            return url;
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("student", student);
        //check cookie and set cookie
        
        url = "/user/user_center.jsp";
       
        return url;
    }
    
    private String registerHelper(HttpServletRequest request, HttpServletResponse response){
        
        String url = "/register.jsp";
        String message = null;
        
        //validate email and password in format aspect and check if given email has been used.
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        message = validateFormat(email, password);
        if(message!=null){
            request.setAttribute("message", message);
            return url;
        }
        
        User user = UserDB.selectUser(email);
        if(user!=null){
            message = "This email has been registered.";
            request.setAttribute("message", message);
            return url;       
        }
        
        //check if two given passwords are the same.
        String password_v = request.getParameter("verify_password");
        message = UserUtil.passwordVerify(password, password_v);
        if(message.length()>0){
            request.setAttribute("message", message);
            return url;
        }
        
        //if all registration information is valid, then create an user object by input data.
        String role = request.getParameter("role");
        if(role==null){role = "Student";}
        user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        
        //Get Student registration information and check if all required fields are filled 
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String major = request.getParameter("major");
        String id = request.getParameter("id");
        String level = request.getParameter("education_level");
        String phone = request.getParameter("phone");
        
        if(id==null||firstName==null||lastName==null||major==null||level==null){
            message = "Please fill out all required field!";
            request.setAttribute("message", message);
            return url;
        }
        
        Student student = StudentDB.selectStudent(id);
        if(student!=null){
            message = "This student id has been registered.";
            request.setAttribute("message", message);
            return url;            
        }
        
        student = new Student();
        student.setStudentId(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setMajor(major);
        student.setLevel(level);
        student.setPhone(phone);
        student.setUser(user);
        
        //create session object and add user and student object into session object
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("student", student);
        UserDB.insertUser(user);
        StudentDB.insertStudent(student);
        //cookie
        
        url = "/user/info_confirm.jsp";        
        return url;
    }
    
    private String changeHelper(HttpServletRequest request, HttpServletResponse response){
        String url = "/user/change_info.jsp";
        String message = null;

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String major = request.getParameter("major");
        String level = request.getParameter("education_level");
        String phone = request.getParameter("phone");   
        
        if(firstName==null||lastName==null||major==null||level==null){
            message = "Please fill out all required field!";
            request.setAttribute("message", message);
            return url;
        }
        
        HttpSession session = request.getSession();
        Student student = (Student)session.getAttribute("student");
        User user = (User) session.getAttribute("user");
        if(user==null||student==null){
            return "/index.jsp";
        }
                
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setMajor(major);
        student.setLevel(level);
        student.setPhone(phone);
        student.setUser(user);
        
        session.setAttribute("student", student);
        
        url = "/user/info_confirm.jsp";
        
        return url;
    }
        
    private String confirmHelper(HttpServletRequest request, HttpServletResponse response){
        
        String url = "/user/user_center.jsp";
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Student student = (Student) session.getAttribute("student");
        
        if(user==null||student==null){
            return "/index.jsp";
        }
        
        StudentDB.updataStudent(student);
        
        return url;
    }
    
    //if there is an error message, return it, otherwise return null
    private String validateFormat(String email,String password){
        
        String message = "";
        message = UserUtil.emailFormatValidation(email);
        if(!message.isEmpty()){
            return message;
        }
        message = UserUtil.passwordFormatValidation(password);
        
        return message.isEmpty()?null:message;
    }

    private String logOutHelper(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "/index.jsp";
    }

    private String findMyAccountHelper(HttpServletRequest request, HttpServletResponse response) {
        String url = "/user/reset_pw.jsp";
        
        String email = request.getParameter("email");
        String message = null;
        message = UserUtil.emailFormatValidation(email);
        if(message.length()>0){
            message = "Please enter valid email address!";
            request.setAttribute("message", message);
            url = "/user/recover.jsp";
            return url;
        }
        
        User user = UserDB.selectUser(email);
        if(user==null){
            message = "This email has not been registed yet!";
            request.setAttribute("message", message);
            url = "/user/recover.jsp";
            return url;     
        }
        
        Student student = StudentDB.selectStudent(user.getUserId());
        
        request.setAttribute("student", student);
        request.setAttribute("email", email);
        
        return url;
    }
    
}
