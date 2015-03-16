<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 16.03.2015
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Event</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/successSearchEvent.html" method="get">
    <p>Enter event title</p>
    <input type="text" name="title">
    <input type="submit" value="Search">
</form>
<form>
    <button formaction="/newEvent.html">Create new Event</button>
    <button formaction="/allEvents.html">Show all Events</button>
    <button formaction="/searchEvent.html">Search Event</button>
    <button formaction="/deleteEvent.html">Delete Event</button>
</form>
</body>
</html>
