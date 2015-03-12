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
<form action="${pageContext.request.contextPath}/successEvent.html" method="get">
    <p>Title</p><input type="text" name="title"></br>
    <p>Description</p><input type="text" name="description"></br>
    <p>Attender</p><input type="text" name="attender"></br></br>
    <input type="submit">
</form>

</body>
</html>
