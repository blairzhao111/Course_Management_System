<%-- 
    Document   : index
    Created on : May 9, 2016, 3:29:38 PM
    Author     : Junwei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Log In</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/>" type="text/css"/>
    </head>
    <body>
        <div class="centered roundedBorder">
        <h1>Welcome to the Course Management System!</h1><hr>
        <h2>Log into system:</h2>
        
        <c:if test = "${message != null}">
            <p><i>${message}</i></p>            
        </c:if>
            
        <form action="user" method="POST">
            <input type="hidden" name="action" value="login">        
            <label class="pad_top">Email:</label>
            <input type="email" name="email" value="${user.email}" required><br>
            <label class="pad_top">Password:</label>
            <input type="password" name="password" value="${user.password}" required><br>
            <label>&nbsp;</label>
            <input type="submit" value="Log In" class="margin_left">
        </form><br>
        
        <a href="register.jsp">Have not registered yet? Sign Up Now!</a><br>
        <br>
        <a href="<c:url value='/user/recover.jsp'/>">Forget your account?</a><br>
       
<c:import url="/includes/footer.jsp" />
