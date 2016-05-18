<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Search Result</title>
    <link rel="stylesheet" href="<c:url value='/styles/main.css'/>" type="text/css"/>
</head>
<body>
  <div class="centered roundedBorder">  
<h1>Here is the Course List based on your search conditions:</h1>
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
    
    <c:forEach var="course" items="${searchResult}">
        <tr>
           <td><c:out value="${course.courseNum}"/></td>
           <td><c:out value="${course.name}"/></td>
           <td><c:out value="${course.room}"/></td>
           <td><c:out value="${course.instructor}"/></td>
           <td><c:out value="${course.dt}"/></td>
           <td><c:out value="${course.credit}"/></td>
           <td><form action="course" method="get">
                   <input type="hidden" name="action" value="addToCart">
                   <input type="hidden" name="courseNum" value="<c:out value='${course.courseNum}'/>">
                   <input type="submit" value="Add To Cart">
               </form>
           </td>
       </tr>       
    </c:forEach>
       
</table>  

</body>
</html>