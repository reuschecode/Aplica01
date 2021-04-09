<%@page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Pacientes</title>
    <spring:url value="/resources" var="urlPublic"/>
    <spring:url value="/" var="urlRoot"/>
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css">
</head>
<body>

        <jsp:include page="includes/menu.jsp"/>
    <div class="container theme-showcase" role="main">
        <div class="card">
            <div class="card- border-0 text-center">
                <h4 class="display-4">Lista de Pacientes</h4>
            </div>
        </div>
        <jsp:include page="includes/footer.jsp"/>
    </div>
        <div class="row page-header">
            <form action="${urlRoot}search" class="form-inline" method="post">
                <div class="form-group">
                    <label for="fecha">Fecha: </label>
                    <select id="fecha" name="fecha" class="form-control">
                        <c:forEach items="${fechas}" var="fecha">
                            <option value="${fecha}">${fecha}</option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Filtrar</button>
            </form>
        </div>
        <div class="card-body">
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th scope="col">DNI</th>
                    <th scope="col">Apellidos</th>
                    <th scope="col">Nombres</th>
                    <th scope="col">Edad</th>
                    <th scope="col">Sexo</th>
                    <th scope="col">Estado Civil</th>
                    <th scope="col">Peso</th>
                    <th scope="col">Talla</th>
                    <th scope="col">Direccion</th>
                    <th scope="col">Fecha Nacimiento</th>
                    <th scope="col">Datos</th>
                    <th scope="col">Imagen</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${Vpacientes}" var="p">
                    <tr>
                        <td>${p.dni}</td>
                        <td>${p.apellidos}</td>
                        <td>${p.nombres}</td>
                        <td>${p.edad}</td>
                        <c:choose>
                            <c:when test="${p.sexo}">
                                <td><span class="btn-sm btn-success">Hombre</span></td>
                            </c:when>
                            <c:otherwise>
                                <td><span class="btn-sm btn-danger">Mujer</span></td>
                            </c:otherwise>
                        </c:choose>
                        <td>${p.estadoCivil}</td>
                        <td>${p.peso}</td>
                        <td>${p.talla}</td>
                        <td><fmt:formatDate value="${p.fechaNacimiento}" pattern="dd/MM/YYYY"/></td>
                        <td>${p.direccion}</td>
                        <td>
                            <!--<a class="btn btn-sm btn-primary" href="detalle/${p.dni}/${fechaBusqueda}" role="button">
                                Ver detalle
                            </a>-->
                            <a href="detalle?dni=${p.dni}&fecha=${fechaBusqueda}" class="btn btn btn-primary" role="button">
                                Ver datos
                            </a>
                       </td>
                        <td><img alt="XD" src="${urlPublic}/images/usuario.png" width="75px"></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    <script type="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.6.0/umd/popper.min.js" integrity="sha512-BmM0/BQlqh02wuK5Gz9yrbe7VyIVwOzD1o40yi1IsTjriX/NGF37NyXHfmFzIlMmoSIBXgqDiG1VNU6kB5dBbA==" crossorigin="anonymous"></script>
    <script type="javascript" src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>