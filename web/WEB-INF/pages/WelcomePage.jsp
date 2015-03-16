<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 11.03.2015
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div align="center">
<form action="${pageContext.request.contextPath}/menuPage.html" method="get">
    <p>First name :<input type="text" name="firstName"></p>
    <p>Second name :<input type="text" name="secondName"></p>
    <p>Email :<input type="text" name="email"></p>
    <input type="submit" value="Enter">
</form>
</div>
</body>
</html>
