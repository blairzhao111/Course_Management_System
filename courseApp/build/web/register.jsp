<%-- 
    Document   : register
    Created on : May 9, 2016, 3:31:46 PM
    Author     : Junwei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Sign Up</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/>" type="text/css"/>
    </head>
    <body>
        <div class="centered roundedBorder">
        <h1>Welcome to Sign Up page for the Course Management System!</h1><hr>
        
            <c:if test="${message != null}">
                <p><b><i>${message}</i></b></p>
            </c:if>
                
        <h2>Please fill out:</h2>
        <p><i>Attention: Password must be equal to or longer than 6 character and start with a letter, contains no space: </i></p>
        <form action="user" method="POST">   
            
            <input type="hidden" name="action" value="register">        
            <label class="pad_top">Email:</label>
            <input type="email" name="email" required><br>
            <label class="pad_top">Password:</label>
            <input type="password" name="password" required><br>
            <label class="pad_top">Verify Password:</label>
            <input type="password" name="verify_password" required><br>
            <label class="pad_top">Sign Up As:</label>
            <select name="role">
                <option value="student" selected>Student</option>
                <option value="instructor" disabled>Instructor</option>
                <option value="staff" disabled>Staff</option>
                <option value="administrator" disabled>Administrator</option>
            </select><br>
            <hr>
            
        <h2>Please fill in following information and fields with * sign are required:</h2>
            
            <label class="pad_top">First Name:</label>
            <input type="text" name="firstName" value="${student.firstName}" required/><span>*</span><br>
            <label class="pad_top">Last Name:</label>
            <input type="text" name="lastName" value="${student.lastName}" required/><span>*</span><br> 
            <label class="pad_top">Student Id:</label>
            <input type="text" name="id" value="${student.studentId}" required/><span>*</span><br> 
            <label class="pad_top">Major:</label>
            <input type="text" name="major" value="${student.major}" required/><span>*</span><br> 
            <label class="pad_top">Education level:</label>
            <p><input type=radio name="education_level" value="Undergraduate"> Undergraduate
                <input type=radio name="education_level" value="Graduate">Graduate<span>*</span></p>
            <label class="pad_top">Phone:</label>
            <input type="text" name="phone" value="${student.phone}"/><br>        
            <hr>
            
            <label>&nbsp;</label>
            <input type="submit" value="Register" class="margin_left">
            <input type="reset" value="Reset" class="margin_left"/>
            
        </form><br>
        
<c:import url="/includes/footer.jsp" />
