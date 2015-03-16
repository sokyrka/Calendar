<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 13.03.2015
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <style>
            p{
                float: left;
            }

        </style>
    </title>
</head>
<body>
<div id="form">
<form action="${pageContext.request.contextPath}/successNewEvent.html" method="get">
    <p>Title :<input type="text" name="title"></p>
    <p>Description :<input type="text" name="description"></p>
    <p>Start Date :<input type="date" name="startDate"></p>
    <p>End Date :<input type="date" name="endDate"></p>
    <input type="submit" name="Create new Event">

    <br><br>
    <form><button formaction="/newEvent.html" >Create new Event</button>
        <button formaction="/newEvent.html" >Show all Events</button>
        <button formaction="/newEvent.html" >Search Event</button>
        <button formaction="/newEvent.html" >Delete Event</button></form>
</form>
</div>
</body>
</html>
