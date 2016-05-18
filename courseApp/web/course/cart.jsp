<%-- 
    Document   : cart
    Created on : May 9, 2016, 5:06:32 PM
    Author     : Junwei
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Course Cart</title>
    <link rel="stylesheet" href="<c:url value='/styles/main.css'/>" type="text/css"/>
</head>
<body>
<div class="centered roundedBorder">
    
<h1>Here are the courses you have selected:</h1><hr>

<table>
    <tr>
      <th>Number</th>
      <th>Name</th>
      <th>Room</th>
      <th>Instructor</th>
      <th>Days&amp;Times</th>
      <th>Credit</th>
      <th></th>
    </tr>


<c:forEach var="course" items="${cart.courses}">
  <tr>
    <td>${course.courseNum}</td>
    <td>${course.name}</td>
    <td>${course.room}</td>
    <td>${course.instructor}</td>
    <td>${course.dt}</td>
    <th>${course.credit}</th>
    <td>
      <form action="course" method="post">
        <input type="hidden" name="action" value="remove">
        <input type="hidden" name="courseNum" value="${course.courseNum}">
        <input type="submit" value="Remove Course">
      </form>
    </td>
  </tr>
</c:forEach>
</table><br>

<p><b>To add a new course to the cart, click continue selecting button below.</b></p>
<p><b>When you finish selecting, click enroll.</b></p>

<form action="course" method="post">
  <input type="hidden" name="action" value="search">
  <input type="submit" value="Continue Selecting">
</form>

<form action="course" method="post">
  <input type="hidden" name="action" value="enroll">
  <input type="submit" value="Enroll">
</form>

<c:import url="/includes/footer.jsp" />