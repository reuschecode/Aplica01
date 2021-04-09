<%@page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Creación de Noticias</title>
    <spring:url value="/resources" var="urlPublic"/>
    <spring:url value="/" var="urlRoot"/>
    <spring:url value="/noticias/save" var="urlForm"/>
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${urlPublic}/bootstrap/css/theme.css">
    <title>Noticias</title>
</head>
<body>
    <jsp:include page="../includes/menu.jsp"/>
    <div class="container theme-showcase" role="main">
        <h3 class="blog-title"><span class="label label-success">Datos del antecedente:</span></h3>

        <form action="${urlForm}" method="post">
            <div class="row">
                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="titulo">DNI del paciente</label>
                        <input type="text" class="form-control" name="titulo" id="titulo" required="required"/>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="form-group">
                        <label for="estatus">Estatus</label>
                        <select id="estatus" name="estatus" class="form-control">
                            <option value="Activa">Activa</option>
                            <option value="Inactiva">Inactiva</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="form-group">
                        <label for="detalle">Antecedente</label>
                        <textarea class="form-control" name="detalle" id="detalle" rows="10"></textarea>
                    </div>
                </div>
            </div>

            <button type="submit" class="btn btn-danger">Guardar</button>
        </form>

        <hr class="featurette-divider">
        <jsp:include page="../includes/footer.jsp"/>
    </div>

    <!-- Tiny MCE -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous"></script>
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${urlPublic}/tinymce/tinymce.min.js"></script>

    <script type="text/javascript">
        tinymce.init({
            selector: "textarea#detalle",
            plugins: "textcolor, table lists code",
            toolbar: " undo redo | bold italic | alignleft aligncenter alignright alignjustify \n\
                       | bullist numlist outdent indent | forecolor backcolor table code"
        });
    </script>
</body>
</html>
