<%@page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>${nombre}</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <spring:url value="/resources" var="urlPublic"/>
    <spring:url value="/" var="urlRoot"/>
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css">
</head>
<body>
<jsp:include page="includes/menu.jsp"/>
<div class="col-md-12 col-sm-12 col-lg-12 col-xl-12">
    <div class="align-left">
        <img src="${urlPublic}/images/usuario.png" alt="Usuario" style="width: 10em;height: auto; float:left;" class="avatar-img rounded-circle img-responsive">
    </div>
    <div class="table-responsive">
        <div class="col-md-10">
            <table class="table mb-none">
                <tr>
                    <th>Nombres</th>
                    <td>${nombre}</td>
                    <th>DNI</th>
                    <td>${dni}</td>
                    <th>Edad</th>
                    <td>${edad}</td>
                </tr>
                <tr>
                </tr>
                <tr>
                    <th>Sexo</th>
                    <td>${sexo}</td>
                    <th>Dirección</th>
                    <td colspan="4">${direccion}</td>
                </tr>
                <tr>
                    <th>Estado Civil</th>
                    <td>${estadoCivil}</td>
                    <th>Peso</th>
                    <td>${peso}</td>
                    <th>Talla</th>
                    <td>${talla}</td>
                </tr>
                <tr>
                    <th>Fecha Nacimiento</th>
                    <td><fmt:formatDate value="${fechaNacimiento}" pattern="dd/MM/YYYY"/></td>
                </tr>
            </table>
        </div>
    </div>
    <div class="table-responsive">
        <h2>Historial Clínico</h2>
        <div class="form-group">
        <table class="table table-striped table-bordered table-condensed table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Fecha</th>
                <th>Motivo Consulta</th>
                <th>Enfermedad(es)</th>
                <th>Antecedente(s)</th>
                <th>Peso</th>
                <th>Talla</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${historial}" var="c">
            <tr>
                <td>${c.id}</td>
                <td><fmt:formatDate value="${c.fecha}" pattern="dd/MM/YYYY"/></td>
                <td>${c.movitoConsulta}</td>
                <td><strong>${c.enfermedadActual}</strong></td>
                <td><strong>${c.antecedentes}</strong></td>
                <td>${c.peso}</td>
                <td>${c.talla}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
        <div class="table-responsive">
            <h2>Antecedentes Clínico</h2>
            <div class="form-group">
                <table class="table table-striped table-bordered table-condensed table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Fecha</th>
                        <th>Motivo de Atención</th>
                        <th>Operación</th>
                        <th>Estado</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${antecedentes}" var="a">
                        <tr>
                            <td>${a.id}</td>
                            <td><fmt:formatDate value="${a.fecha}" pattern="dd/MM/YYYY"/></td>
                            <td>${a.motivoDeAtencion}</td>
                            <td><strong>${a.operacion}</strong></td>
                            <td><strong>${a.estado}</strong></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        <jsp:include page="includes/footer.jsp"/>
</div>
</div>
</body>
</html>