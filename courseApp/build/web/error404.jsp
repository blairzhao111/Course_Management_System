
<%-- 
    Document   : error404
    Created on : May 9, 2016, 5:06:32 PM
    Author     : Junwei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>404 Error</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/>" type="text/css"/>
    </head>
    <body>
        <div class="centered roundedBorder">
        <h1>404 Error<h1
        <p>The server was not able to find the content you requested.</p>
                
<c:import url="/includes/footer.jsp"/>
