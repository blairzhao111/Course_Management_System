<%-- 
    Document   : course_center
    Created on : May 12, 2016, 11:38:43 PM
    Author     : Junwei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Center</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/>" type="text/css"/>
    </head>
    <body>
       <div class="centered roundedBorder">
        <h1>Welcome back, ${student.firstName}!</h1>
        <h2>Following are the courses you are currently enrolling:</h2>
<table>
    <tr>
      <th>Number</th>
      <th>Name</th>
      <th>Room</th>
      <th>Instructor</th>
      <th>Days&amp;Times</th>
      <th>Credit</th>
      <th>Registration Date</th>
      <th></th>
    </tr>
    
<c:forEach var="item" items="${enrolled}">
  <tr>
    <td>${item.course.courseNum}</td>
    <td>${item.course.name}</td>
    <td>${item.course.room}</td>
    <td>${item.course.instructor}</td>
    <td>${item.course.dt}</td>
    <td>${item.course.credit}</td>
    <td>${item.courseRegisterationDateDefaultFormat}</td>
    <td>
      <form action="course" method="get">
        <input type="hidden" name="registrationNum" value="${item.courseRegistrationNum}">
        <input type="hidden" name="action" value="drop">
        <input type="submit" value="Drop Course">
      </form>
    </td>
  </tr>
</c:forEach>
</table><br>

<p><i><a href="download?action=course_spreadsheet">Download current enrollments as spreadsheet file.</a></i></p>
<hr>

<h2>Use filter to choose courses you would like to check:</h2>
<form action="course" method="Get">
    <input type="hidden" name="action" value="search">
    <input type="submit" value="Search">
</form><hr>

<h2>Return to User Center</h2>
<form action="course" method="Get">
    <input type="hidden" name="action" value="return">
    <input type="submit" value="Return">
</form>
        
<c:import url="/includes/footer.jsp" />
