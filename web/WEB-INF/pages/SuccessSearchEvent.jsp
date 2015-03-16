<%@ page import="com.home.common.Event" %>
<%@ page import="com.home.service.CalendarServiceImpl" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 16.03.2015
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success search Event</title>
</head>
<body>
<table border="1">
    <%Event event = (Event) request.getAttribute("event");%>
    <tr>
        <td><%=event.getTitle()%></td>
        <td><%=event.getDescription()%></td>
        <td><%=event.getStartDate().getTimeInMillis()%></td>
        <td><%=event.getEndDate().toString()%></td>
    </tr>
</table>
<br>
<form>
    <button formaction="/newEvent.html">Create new Event</button>
    <button formaction="/allEvents.html">Show all Events</button>
    <button formaction="/searchEvent.html">Search Event</button>
    <button formaction="/deleteEvent.html">Delete Event</button>
</form>
</body>
</html>
