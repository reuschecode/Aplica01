<%@page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<!-- begin::Head -->
<head>

    <!--begin::Base Path (base relative path for assets of this page) -->
    <base href="../../../../">

    <!--end::Base Path -->
    <meta charset="utf-8" />
    <title>Login SOWAD</title>
    <meta name="description" content="Login page example">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <spring:url value="/resources/" var="urlPublic"/>
    <spring:url value="/" var="urlRoot"/>
    <!--begin::Fonts -->
    <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.16/webfont.js"></script>

    <script>
        WebFont.load({
            google: {
                "families": ["Poppins:300,400,500,600,700", "Roboto:300,400,500,600,700"]
            },
            active: function() {
                sessionStorage.fonts = true;
            }
        });
    </script>

    <!--end::Fonts -->

    <!--begin::Page Custom Styles(used by this page) -->
    <link href="${urlPublic}css/login-1.css" rel="stylesheet" type="text/css" />
    <link href="${urlPublic}fontawesome/css/all.css" rel="stylesheet">
    <!--end::Page Custom Styles -->

    <!--begin:: Global Mandatory Vendors -->
    <link href="${urlPublic}css/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet" type="text/css" />

    <!--end:: Global Mandatory Vendors -->

    <!--begin::Global Theme Styles(used by all pages) -->
    <link href="${urlPublic}css/style.bundle.css" rel="stylesheet" type="text/css" />

    <!--end::Global Theme Styles -->


    <!--end::Layout Skins
    <link rel="shortcut icon" href="./assets/media/logos/favicon.ico" />
    -->
</head>

<!-- end::Head -->

<!-- begin::Body -->
<body class="kt-quick-panel--right kt-demo-panel--right kt-offcanvas-panel--right kt-header--fixed kt-header-mobile--fixed kt-subheader--enabled kt-subheader--fixed kt-subheader--solid kt-aside--enabled kt-aside--fixed kt-page--loading">

<!-- begin:: Page -->
<div class="kt-grid kt-grid--ver kt-grid--root">
    <div class="kt-grid kt-grid--hor kt-grid--root  kt-login kt-login--v1" id="kt_login">
        <div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--desktop kt-grid--ver-desktop kt-grid--hor-tablet-and-mobile">

            <!--begin::Aside-->
            <div class="kt-grid__item kt-grid__item--order-tablet-and-mobile-2 kt-grid kt-grid--hor kt-login__aside" style="background-image: url(${urlPublic}images/bg-5.jpg);">
                <div class="kt-grid__item">
                    <a href="#" class="kt-login__logo">
                        <img src="${urlPublic}images/logo-4.png" alt="LOGO">
                    </a>
                </div>
                <div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--ver">
                    <div class="kt-grid__item kt-grid__item--middle">
                        <h3 class="kt-login__title">Bienvenido a la Clínica San Pedro</h3>
                        <h4 class="kt-login__subtitle">El mejor servicio médico de Trujillo al alcance de tus manos.</h4>
                    </div>
                </div>
                <div class="kt-grid__item">
                    <div class="kt-login__info">
                        <div class="kt-login__copyright">
                            &copy 2021 Reusche
                        </div>
                        <div class="kt-login__menu">
                            <a href="#" class="kt-link">Facebook</a>
                            <a href="#" class="kt-link">Teléfono</a>
                            <a href="#" class="kt-link">E-Mail</a>
                        </div>
                    </div>
                </div>
            </div>

            <!--begin::Aside-->

            <!--begin::Content-->
            <div class="kt-grid__item kt-grid__item--fluid  kt-grid__item--order-tablet-and-mobile-1  kt-login__wrapper">

                <!--begin::Head-->
                <div class="kt-login__head">
                    <span class="kt-login__signup-label">¿No tienes una cuenta aún?</span>&nbsp;&nbsp;
                    <a href="#" class="kt-link kt-login__signup-link">Regístrate!</a>
                </div>

                <!--end::Head-->

                <!--begin::Body-->
                <div class="kt-login__body">

                    <!--begin::Signin-->
                    <div class="kt-login__form">
                        <div class="kt-login__title">
                            <h3>Inicia Sesión</h3>
                        </div>

                        <!--begin::Form-->
                        <form class="kt-form" action="${urlRoot}loginProcess" novalidate="novalidate" method="post">
                            <div class="form-group">
                                <input class="form-control" type="email" placeholder="Email" name="email" autocomplete="off">
                            </div>
                            <div class="form-group">
                                <input class="form-control" type="password" placeholder="Password" name="password">
                            </div>

                            <!--begin::Action-->
                            <div class="kt-login__actions">
                                <a href="#" class="kt-link kt-login__link-forgot">
                                    ¿Olvidaste la contraseña?
                                </a>
                                <button id="kt_login_signin_submit" class="btn btn-primary btn-elevate kt-login__btn-primary">Iniciar Sesión</button>
                            </div>

                            <!--end::Action-->
                        </form>

                        <!--end::Form-->

                        <!--begin::Divider-->
                        <div class="kt-login__divider">
                            <div class="kt-divider">
                                <span></span>
                                <span>REDES SOCIALES</span>
                                <span></span>
                            </div>
                        </div>

                        <!--end::Divider-->

                        <!--begin::Options-->
                        <div class="kt-login__options">
                            <a href="#" class="btn btn-primary kt-btn">
                                <i class="fab fa-facebook-f"></i>
                                Facebook
                            </a>
                            <a href="#" class="btn btn-danger kt-btn">
                                <i class="fab fa-instagram"></i>
                                Instagram
                            </a>
                            <a href="#" class="btn btn-info kt-btn">
                                <i class="fab fa-twitter"></i>
                                Twitter
                            </a>
                        </div>

                        <!--end::Options-->
                    </div>

                    <!--end::Signin-->
                </div>

                <!--end::Body-->
            </div>

            <!--end::Content-->
        </div>
    </div>
</div>

<!-- end:: Page -->

</body>

<!-- end::Body -->
</html>