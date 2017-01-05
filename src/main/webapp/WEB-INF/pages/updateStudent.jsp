<%--
  Created by IntelliJ IDEA.
  User: Main Server
  Date: 05.01.2017
  Time: 3:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Miami Dade College</title>
</head>
<body>
<center>
    <form method="post">
        <p><h3>STUDENT UPDATING FORM</h3></p>
        <P>ID of Student for updete</P>
        <p>Please write valid ID number</p>
        <p><input type="text" name="id"/></p>
        <p>Family name of Student:</p>
        <p>Please write letters only. Capintal letter first. For example: Johnson</p>
        <p><input type="text" name="surname"/></p>
        <p>First name of Student: </p>
        <p>Please write letters only. Capintal letter first. For example: John</p>
        <p><input type="text" name="name"/></p>
        <p>Date of Birth of Student: </p>
        <p>Please write date of birth in format: yyyy-MM-dd</p>
        <p><input type="text" name="dateOfBirth"/></p>
        <p>State of Student: </p>
        <p><input type="text" name="state"/></p>
        <p>Campus of Student: </p>
        <p><input type="text" name="campus"/></p>
        <p>Date of Join of Student: </p>
        <p>Please write date of birth in format: yyyy-MM-dd</p>
        <p><input type="text" name="dateOfJoin"/></p>
        <p><input type="submit" value="UPDATE STUDENT"/></p>
    </form>
</center>

</body>
</html>
