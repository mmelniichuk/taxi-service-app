<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>All drivers</title>
</head>
<body>
<h1 class="table_dark">All drivers:</h1>
<table border="1" class="table_dark">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>License number</th>
        <th>Login</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="driver" items="${drivers}">
        <tr>
            <td>
                <c:out value="${driver.getId()}"/>
            </td>
            <td>
                <c:out value="${driver.getName()}"/>
            </td>
            <td>
                <c:out value="${driver.getLicenseNumber()}"/>
            </td>
            <td>
                <c:out value="${driver.getLogin()}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/drivers/delete?id=${driver.getId()}">DELETE</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
