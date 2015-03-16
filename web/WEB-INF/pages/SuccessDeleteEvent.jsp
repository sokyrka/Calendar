<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 16.03.2015
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success delete Event</title>
</head>
<body>
<h1>${msg}</h1>
<form>
    <button formaction="/newEvent.html">Create new Event</button>
    <button formaction="/allEvents.html">Show all Events</button>
    <button formaction="/searchEvent.html">Search Event</button>
    <button formaction="/deleteEvent.html">Delete Event</button>
</form>
</body>
</html>
