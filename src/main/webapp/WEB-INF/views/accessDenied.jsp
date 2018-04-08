<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 08.04.2018
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access Denied</title>
</head>
<body>
    <h2>Sorry, ${name}! You do not have permission to view this page.</h2>

    Click <a href="<c:url value="/" /> ">here</a>
    to go back to the Homepage.
</body>
</html>
