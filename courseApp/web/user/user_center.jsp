<%-- 
    Document   : student_center
    Created on : May 10, 2016, 10:23:58 PM
    Author     : Junwei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Center</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/>" type="text/css"/>
    </head>
    <body>
        <div class="centered roundedBorder">
        <h1>Welcome to the User Center, <c:out value="${student.firstName}"/></h1>
        <p><b>Log In As: <c:out value="${user.email}"/>, <c:out value="${user.role}"/></b></p>
        <hr>
        <h2>What action would you like to perform?</h2>
        <label class="pad_top">Change my information:</label>
        <form action="user" method="Get">
            <input type="hidden" name="action" value="modify"/>
            <input type="submit" value="Choose" />
        </form><br>
        <label class="pad_top">Go to the course center:</label>
        <form action="course" method="Get">
            <input type="hidden" name="action" value="center"/>
            <input type="submit" value="Choose" />
        </form><br><hr>
        <form action="user" method="Get">
            <input type="hidden" name="action" value="logout"/>
            <input type="submit" value="Log Out" />
        </form><br>
        
<c:import url="/includes/footer.jsp" />
