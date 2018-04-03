<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 14.01.2018
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Users Management</h1>
    <h2>
        <a href="<c:url value="/admin/insert"/>">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="<c:url value="/admin"/>">List All Users</a>

    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Login</th>
            <th>Password</th>
            <th>ROLES</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUsers}">
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.login}" /></td>
                <td><c:out value="${user.password}" /></td>
                <td><c:out value="${user.roles}" /></td>
                <td>
                    <a href="<c:url value="/admin/update?id=${user.id}"/>">Update</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="<c:url value="/admin/delete?id=${user.id}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<a href="<c:url value="/"/>">Logout</a>
</body>
</html>
