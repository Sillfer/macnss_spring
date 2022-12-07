<%@ page import="com.simplon.cnss.Config.BaseUrl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="<%=BaseUrl.BASE_URL%>users/login" method="POST">
    <input name="email" type="email" placeholder="email">
    <input name="password" type="password" placeholder="password">
    <div>
        <label>Agent</label>
        <input name="role" type="radio" value="agent" checked>
        <br>
        <label>Patient</label>
        <input name="role" type="radio" value="patient">
    </div>
    <br><br>
    <button>Login</button>
</form></body>
</html>
