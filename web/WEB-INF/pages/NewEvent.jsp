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
    <title>New Event</title>
    <style>
        #names{
            float:left;
            padding:0px;
            margin-top:-10px;
            margin-right:10px;
        }
        #names p{
            margin: 18px 0px 18px 0px;
        }
        #form{
            float:left;
        }
        #form input{
            margin: 7px;
        }
        #button{
            clear:both;
        }
    </style>
</head>
<body>
<div id="wrapper">
    <div id="names">
        <p>Title</p>
        <p>Description</p>
        <p>Start date</p>
        <p>End date</p>
    </div>
    <div id="form">
        <form action="${pageContext.request.contextPath}/successNewEvent.html" method="get">
            <input type="text" name="title" size="16"></br>
            <input type="text" name="description" size="16"></br>
            <input type="date" name="startDate"></br>
            <input type="date" name="endDate"></br>
            <input type="submit" value="Create Event">
        </form>
    </div>
</div>
<div id="button">
    <form>
        <button formaction="/newEvent.html">Create new Event</button>
        <button formaction="/allEvents.html">Show all Events</button>
        <button formaction="/searchEvent.html">Search Event</button>
        <button formaction="/deleteEvent.html">Delete Event</button>
    </form>
</div>
</body>
</html>
