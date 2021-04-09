<%@page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<h1>EDUARDO REUSCHE SÁENZ</h1>

<h1>Listado de Peliculas</h1>
<ul>
    <c:forEach items="${Vpeliculas}" var="dato">
        <li>${dato}</li>
    </c:forEach>
</ul>
</body>
</html>