/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.business.Course;
import com.business.CourseCart;
import com.business.CourseRegistration;
import com.business.Student;
import com.data.CourseDB;
import com.data.CourseRegistrationDB;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Junwei
 */
public class CourseController extends HttpServlet {

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
            action = "center"; //default action is login
        }
        
        //check action type and perform certain action, then forward request and response to appropriate page URL
        String url = "/course/course_center.jsp";
        if(action.equals("center")){
            url = showEnrolled(request,response);
        }else if(action.equals("search")){
            url = searchCoursesHelper(request,response);
        }else if(action.equals("drop")){
            url = dropCourseHelper(request,response);
        }else if(action.equals("addToCart")){
            url = addToCart(request,response);
        }else if(action.equals("remove")){
            url = removeFromCart(request,response);
        }else if(action.equals("enroll")){
            url = enrollHelper(request,response);
        }else if(action.equals("return")){
            url = "/user/user_center.jsp";
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
        return "Coursecontroller";
    }

    private String showEnrolled(HttpServletRequest request, HttpServletResponse response) {
        String url = "/course/course_center.jsp";
        
        HttpSession session = request.getSession();
        Student student = (Student)session.getAttribute("student");
        if(student==null){
            url = "/index.jsp";
            return url;
        }
        
        List<CourseRegistration> enrolled = CourseRegistrationDB.selectEnrolled(student);
        session.setAttribute("enrolled", enrolled);
        
        return url;
    }

    private String dropCourseHelper(HttpServletRequest request, HttpServletResponse response) {
           String url = "/course/course_center.jsp";
           
           HttpSession session = request.getSession();
           Student student = (Student)session.getAttribute("student");
           if(student==null){
               url = "/index.jsp";
               return url;
           }    
           
           String CourseRegisterationNum = request.getParameter("registrationNum");
           long registrationNum = Long.parseLong(CourseRegisterationNum);
           CourseRegistration cr = CourseRegistrationDB.selectCourseRegistration(registrationNum);
           CourseRegistrationDB.removeCourseRegistration(cr);
           
           List<CourseRegistration> enrolled = (List<CourseRegistration>)session.getAttribute("enrolled");
           for(int i=0;i<enrolled.size();i++){
               CourseRegistration curr = enrolled.get(i);
               if(curr.getCourseRegistrationNum()==registrationNum){
                   enrolled.remove(i);
                   break;
               }
           }
           
           session.setAttribute("enrolled", enrolled);
           
           return url;
    }

    private String searchCoursesHelper(HttpServletRequest request, HttpServletResponse response) {
        String url = "/course/courses_result.jsp";
        //get search parameters
        List<Course> searchResult = CourseDB.selectCourses();
        HttpSession session = request.getSession();
        session.setAttribute("searchResult", searchResult);
        
        return url;
    }

    private String addToCart(HttpServletRequest request, HttpServletResponse response) {
        String url = "/course/cart.jsp";
        
        HttpSession session = request.getSession();
        List<Course> searchResult = (List<Course>)session.getAttribute("searchResult");
        CourseCart cart = (CourseCart)session.getAttribute("cart");
        if(cart==null){
            cart = new CourseCart();
        }
        
        String courseNum = request.getParameter("courseNum");
        Course target = null;
        for(Course each : searchResult){
            if(each.getCourseNum().equals(courseNum)){
                target = each;
                break;
            }
        }
        cart.addCourse(target);
        session.setAttribute("cart", cart);
        
        return url;
    }
    
    private String removeFromCart(HttpServletRequest request, HttpServletResponse response) {
        String url = "/course/cart.jsp";
        HttpSession session = request.getSession();
        CourseCart cart = (CourseCart)session.getAttribute("cart");
        if(cart==null){
            url = "/index.jsp";
            return url;     
        }
        
        String courseNum = request.getParameter("courseNum");
        cart.removeCourse(courseNum);
        session.setAttribute("cart", cart);
        
        return url;
    }

    private String enrollHelper(HttpServletRequest request, HttpServletResponse response) {
        String url = "/course/course_center.jsp";
        
        HttpSession session = request.getSession();
        CourseCart cart = (CourseCart)session.getAttribute("cart");
        if(cart.getCount()==0){
            return url;
        }
        
        Student student = (Student)session.getAttribute("student");
        List<CourseRegistration> enrolled = (List<CourseRegistration>)session.getAttribute("enrolled");
        List<Course> courses = cart.getCourses();
        for(int i=0;i<courses.size();i++){
            Course course = courses.get(i);
            if(checkIfHasEnrolled(course,enrolled)){
                continue;
            }
            CourseRegistration cr = new CourseRegistration();
            cr.setCourse(course);
            cr.setStudent(student);
            Date now = new Date();
            cr.setRegistrationDate(now);
            
            CourseRegistrationDB.insertCourseRegistration(cr);
            enrolled.add(cr);
        }
        
        session.setAttribute("enrolled", enrolled);
        session.removeAttribute("cart");
        
        return url;
    }
    
    private static boolean checkIfHasEnrolled(Course course,List<CourseRegistration> enrolled){
        String courseNum = course.getCourseNum();
        for(CourseRegistration each : enrolled){
            if(each.getCourse().getCourseNum().equals(courseNum)){
                return true;
            }
        }
        return false;
    }
    
}
