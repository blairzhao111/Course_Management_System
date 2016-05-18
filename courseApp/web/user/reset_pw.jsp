<%-- 
    Document   : reset_pw
    Created on : May 13, 2016, 9:08:03 PM
    Author     : Junwei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/>" type="text/css"/>
    </head>
    <body>
      <div class="centered roundedBorder">
        <h1>Reset Password</h1>
        <h2>Hello, <c:out value="${student.firstName}"/></h2>
        <p>We will send an email to <c:out value="${email}"/>, please follow the instructions and reset your password.</p>
        <p>Click send to send email:</p>
        <form action="user" method="Get">
            <input type="hidden" name="action" value=""/>
            <input type="submit" value="Send" />
        </form><br>
        
<c:import url="/includes/footer.jsp" />
