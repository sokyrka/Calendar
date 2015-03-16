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
    <title>Welcome page</title>
    <style>
        #form{
            float:left;
        }
        #names{
            float:left;
            padding:0px;
            margin-top:-10px;
            margin-right:10px;
        }
        #wrapper{
            width:270px;
            height:140px;
            border:1px dotted black;
            border-radius:15px;
            padding:15px;
            margin:auto;
            position:relative;
            top:30%;
        }
    </style>
</head>
<body>
    <div id="wrapper">
        <div id="names">
            <p>First name</p>
            <p>Second name</p>
            <p>Email</p>
        </div>
        <div id="form">
            <form action="${pageContext.request.contextPath}/menuPage.html" method="get">
                <input type="text" name="firstName"></br></br>
                <input type="text" name="secondName"></br></br>
                <input type="text" name="email"></br></br>
                <input type="submit" value="Enter">
            </form>
        </div>
    </div>
</body>
</html>
