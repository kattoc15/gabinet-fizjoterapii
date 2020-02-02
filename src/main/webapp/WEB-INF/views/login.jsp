<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="post" action="waliduj.jsp">
        Podaj swój login: <br/>
        <input type="text" name="name" /><br/>
        Podaj swoje hasło: <br/>
        <input type="text" name="password" /><br/>
        <input type="submit" value="zaloguj">
    </form>
</body>
</html>