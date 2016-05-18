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
        <title>Change Information</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/>" type="text/css"/>
    </head>
    <body>
      <div class="centered roundedBorder">
        <h1>Here are all your information:</h1><hr>
        
            <c:if test="${message != null}">
                <p><b><i>${message}</i></b></p>
            </c:if>
                
        <form action="user" method="Post">
            <input type="hidden" name="action" value="change"></input>
            <p>If needed, change following information and fields with * sign are required:</p>
            
            <label class="pad_top">Student Id:</label>
            <span>${student.studentId}</span><br>   
            <label class="pad_top">First Name:</label>
            <input type="text" name="firstName" value="${student.firstName}" required/><span>*</span><br>
            <label class="pad_top">Last Name:</label>
            <input type="text" name="lastName" value="${student.lastName}" required/><span>*</span><br> 
            <label class="pad_top">Major:</label>
            <input type="text" name="major" value="${student.major}" required/><span>*</span><br> 
            <label class="pad_top">Education level:</label>
            <p><input type=radio name="education_level" value="Undergraduate"> Undergraduate
                <input type=radio name="education_level" value="Graduate">Graduate<span>*</span></p>
            <label class="pad_top">Phone:</label>
            <input type="text" name="phone" value="${student.phone}"/><br>        
            <hr>
            
            <label>&nbsp;</label>
            <input type="submit" value="Confirm" class="margin_left">
            
        </form><br>
        
<c:import url="/includes/footer.jsp" />
