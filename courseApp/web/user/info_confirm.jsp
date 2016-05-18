<%-- 
    Document   : info_confirm
    Created on : May 10, 2016, 10:25:54 PM
    Author     : Junwei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Information Confirm</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/>" type="text/css"/>
    </head>
    <body>
      <div class="centered roundedBorder">
        <h1>Here is the information you just entered:</h1>
        <P><b><i>Please check following information again, if everything is correct, click confirm to continue. Otherwise you can click return to change any information:</i></b></p><hr><br>
 
        <label class="pad_top">Student Id:</label>
        <span>${student.studentId}</span><br>        
        <label class="pad_top">First Name:</label>
        <span>${student.firstName}</span><br>
        <label class="pad_top">Last Name:</label>
        <span>${student.lastName}</span><br>
        <label class="pad_top">Major:</label>
        <span>${student.major}</span><br>
        <label class="pad_top">Education Level:</label>
        <span>${student.level}</span><br>
        <c:if test="${student.phone != ''}">
            <label class="pad_top">Phone:</label>
            <span>${student.phone}</span><br>             
        </c:if>
        <br>
        
        <form action ="user" method="get">
            <input type="hidden" name="action" value="modify">
            <input type="submit" value="Change" class="margin_left">
        </form><br>
        <form action="user" method="get">
            <input type="hidden" name="action" value="confirm">
            <input type="submit" value="Confirm" class="margin_left"/>
        </form>

<c:import url="/includes/footer.jsp" />
