<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Walidacja</title>
</head>
<body>
    <jsp:useBean id="user" class="pl.coderslab.gabinet_fizjoterapii.entity.User"
                 scope="session"></jsp:useBean>
    <jsp:setProperty name="user" property="*" />
    <jsp:useBean id="dataSource" class="pl.coderslab.gabinet_fizjoterapii.entity.DataSource"
    scope="session"></jsp:useBean>
    Nazwa: <%= user.getName() %> <br/>
    <% String result = "Niepoprawne dane";
    if (dataSource.userExists(user)) {
        result = "Poprawny loghin i hasło";
    }
    %>
    <%= result%>
</body>
</html>