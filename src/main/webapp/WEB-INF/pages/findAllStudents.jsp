<%--
  Created by IntelliJ IDEA.
  User: Main Server
  Date: 05.01.2017
  Time: 3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Miami Dade College</title>
</head>
<body>

<p><h3>LIST OF ALL STUDENTS</h3></p>
<c:forEach items="${studentList}" var="student">
<p><c:out value="${student}"/></p>
</c:forEach>
<p><a href="//localhost:9900/MiamiDadeCollege/index">HOME PAGE</a></p>

</body>
</html>
