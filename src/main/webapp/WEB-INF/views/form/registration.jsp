<%--
  Created by IntelliJ IDEA.
  User: kattoc
  Date: 05/02/2020
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>registration</title>
</head>
<body>

<%@ include file="../header.jspf" %>

<h1>Sing up</h1>

<form:form method="POST" modelAttribute="patient">

    E-mail: <form:input path="email"/><br>
    <form:errors path="email" cssClass="error"/><br>

    Password: <form:password path="password"/><br>
    <form:errors path="password" cssClass="error"/><br>

    Name: <form:input path="name"/><br>
    <form:errors path="name" cssClass="error"/><br>

    Surname: <form:input path="surname"/><br>
    <form:errors path="surname" cssClass="error"/><br>
    <input type="submit" value="Sing up">
</form:form>
<br>

<%@ include file="../footer.jspf" %>

</body>
</html>