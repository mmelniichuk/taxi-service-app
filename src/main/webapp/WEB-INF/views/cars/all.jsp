<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>All cars</title>
</head>
<body>
<h1 class="table_dark">All cars:</h1>
<table border="1" class="table_dark">
    <tr>
        <th>ID</th>
        <th>Model</th>
        <th>Manufacturer name</th>
        <th>Manufacturer country</th>
        <th>Drivers</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="car" items="${cars}">
        <tr>
            <td>
                <c:out value="${car.getId()}"/>
            </td>
            <td>
                <c:out value="${car.getModel()}"/>
            </td>
            <td>
                <c:out value="${car.getManufacturer().getName()}"/>
            </td>
            <td>
                <c:out value="${car.getManufacturer().getCountry()}"/>
            </td>
            <td>
                <c:forEach var="driver" items="${car.drivers}">
                    ${driver.getId()} ${driver.getName()} ${driver.getLicenseNumber()} ${driver.getLogin()} <br>
                </c:forEach>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/cars/delete?id=${car.getId()}">DELETE</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
