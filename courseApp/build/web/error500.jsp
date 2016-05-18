<%-- 
    Document   : error500
    Created on : May 11, 2016, 10:21:58 PM
    Author     : Junwei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>500 Error</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/>" type="text/css"/>
    </head>
    <body>
        <div class="centered roundedBorder">
        <h1>500 Error</h1>
        <p>Server Internal Error</p>

<c:import url="/includes/footer.jsp"/>
