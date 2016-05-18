<%-- 
    Document   : recover
    Created on : May 12, 2016, 5:19:56 PM
    Author     : Junwei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recover Your Account</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/>" type="text/css"/>
    </head>
    <body>
        <div class="centered roundedBorder">
        <h1>Find your account?</h1><hr>
        
            <c:if test="${message != null}">
                <p><b><i>${message}</i></b></p>
            </c:if>
                
        <p><i>Use Email to recover:</i></p>
        <form action="../user" method="Get">
            <input type="hidden" name="action" value="findMyAccount">
            <input type="email" name="email" required/>
            <input type="submit" value="Search" />
        </form>
        
<c:import url="/includes/footer.jsp" />
