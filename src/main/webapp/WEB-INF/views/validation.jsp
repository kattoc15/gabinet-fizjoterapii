<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>validation</title>
</head>
<body>
    <jsp:useBean id="user" class="pl.coderslab.gabinet_fizjoterapii.entity.User"
                 scope="session"></jsp:useBean>
    <jsp:setProperty name="user" property="*" />
    <jsp:useBean id="dataSource" class="pl.coderslab.gabinet_fizjoterapii.entity.DataSource"
    scope="session"></jsp:useBean>
    Name: <%= user.getName() %> <br/>
    <% String result = "Wrong data";
    if (dataSource.userExists(user)) {
        result = "login and password correct";
    }
    %>
    <%= result%>
</body>
</html>--%>
