<%@ page import="com.simplon.cnss.Config.BaseUrl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>New Patient</h1>
<form action="<%=BaseUrl.BASE_URL%>patient/add" method="POST">
    <input name="email" type="email" placeholder="Enter patient email">
    <input name="password" type="password" placeholder="Enter patient password">
    <input name="username" type="text" placeholder="Enter patient username">
    <input name="patient-number" type="number" placeholder="Enter patient number">
    <br><br>
    <button>Submit</button>
</form>
</body>
</html>
