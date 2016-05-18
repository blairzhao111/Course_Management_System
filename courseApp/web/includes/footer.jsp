<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<hr>
<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%  
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>
<div><i>&copy; Copyright <%= currentYear %> Junwei Zhao</i></div>
</div> 
<script src="<c:out value='/js/jQuery.js'/>" type="text/javascript"></script>
<script src="<c:out value='/js/program.js'/>" type="text/javascript"></script>
</body>
</html>
