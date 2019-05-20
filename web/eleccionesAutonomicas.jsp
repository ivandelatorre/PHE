<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ page import="clases.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="es-es">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>PHE | Elecciones Autonomicas</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Style CSS -->
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>

    <link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">

</head>

<body>
<%
    BDController controladorBD = new BDController();

%>
    <!-- Preloader -->
    <div id="preloader">
        <div class="preload-content">
            <div id="original-load"></div>
        </div>
    </div>

    <!-- ##### Header Area Start ##### -->
    <header class="header-area">

        <!-- Top Header Area -->
        <div class="top-header">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <!-- Breaking News Area -->
                    <div class="col-12 col-sm-8">
                        <div class="breaking-news-area">
                            <div id="breakingNewsTicker" class="ticker">
                                <ul>
                                    <li><a href="#">Por españa!</a></li>
                                    <li><a href="#"><script>document.write(new Date().getDate() + " - " + new Date().getMonth() + " - " + new Date().getFullYear());</script> </a></li>
                                    <li><a href="#">Elecciones 2019!</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- Top Social Area -->
                    <div class="col-12 col-sm-4">
                        <div class="top-social-area">
                            <a href="#" data-toggle="tooltip" data-placement="bottom" title="Pinterest"><i class="fab fa-pinterest" aria-hidden="true"></i></a>
                            <a href="#" data-toggle="tooltip" data-placement="bottom" title="Facebook"><i class="fab fa-facebook" aria-hidden="true"></i></a>
                            <a href="#" data-toggle="tooltip" data-placement="bottom" title="Twitter"><i class="fab fa-twitter" aria-hidden="true"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Logo Area -->
        <div class="logo-area text-center">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12">
                        <a href="index.jsp" class="original-logo"><img src="img/logo.png" alt=""></a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Nav Area -->
        <div class="original-nav-area" id="stickyNav">
            <div class="classy-nav-container breakpoint-off">
                <div class="container">
                    <!-- Classy Menu -->
                    <nav class="classy-navbar justify-content-between">



                        <!-- Navbar Toggler -->
                        <div class="classy-navbar-toggler">
                            <span class="navbarToggler"><span></span><span></span><span></span></span>
                        </div>

                        <!-- Menu -->
                        <div class="classy-menu" id="originalNav">
                            <!-- close btn -->
                            <div class="classycloseIcon">
                                <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                            </div>

                            <!-- Nav Start -->
                            <div class="classynav">
                                <ul>
                                    <li><a href="index.jsp">Inicio</a></li>
                                    <li><a>Elecciones</a>
                                        <ul class="dropdown">
                                            <li><a href="eleccionesNacionales.jsp">Nacionales</a></li>
                                            <li><a>Autonomicas</a></li>
                                            <li><a href="eleccionesMunicipales.jsp">Municipales</a></li>
                                            <li><a href="eleccionesEuropeas.jsp">Europeas</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="proximosEventos.jsp">Proximos eventos</a></li>
                                    <li><a href="participa.jsp">Participa</a></li>

                                </ul>

                                <!-- Search Form  -->
                                <div id="search-wrapper">
                                    <form action="#">
                                        <input type="text" id="search" placeholder="Search something...">
                                        <div id="close-icon"></div>
                                        <input class="d-none" type="submit" value="">
                                    </form>
                                </div>
                            </div>
                            <!-- Nav End -->
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <div class="container">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.jsp">Inicio</a></li>
                <li class="breadcrumb-item active" aria-current="page"><a href="#">Elecciones autonomicas</a></li>
            </ol>
        </nav>
    </div>
    <div class="container">
        <h1 class="text-center mt-5 mb-5">Comunidades Autonomas</h1>
        <div class="card-deck justify-content-center">
            <a href="eAutonomicasComunidad.jsp?comunidad=Castilla la mancha"><div class="card cardComunidad">
                <img class="card-img-top imagenComunidad" src="img/mancha.png" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title text-center">Castilla la Mancha</h5>
                </div>
            </div></a>
            <a href="eAutonomicasComunidad.jsp?comunidad=Andalucia"><div class="card cardComunidad">
                <img class="card-img-top imagenComunidad" src="img/andalucia.png" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title text-center">Andalucia</h5>
                </div>
            </div></a>
            <a href="eAutonomicasComunidad.jsp?comunidad=Madrid"><div class="card cardComunidad">
                <img class="card-img-top imagenComunidad" src="img/madrid.png" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title text-center">Madrid</h5>
                </div>
            </div></a>
            <a href="eAutonomicasComunidad.jsp?comunidad=Galicia"><div class="card cardComunidad">
                <img class="card-img-top imagenComunidad" src="img/galicio.png" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title text-center">Galicia</h5>
                </div>
            </div></a>
        </div>
    </div>

    <!-- ##### Footer Area Start ##### -->
    <footer class="footer-area text-center">
        <div class="container">
            <div class="row">
                <div class="col-12">
                   
                    <!-- Footer Nav Area -->
                    <div class="classy-nav-container breakpoint-off">
                        <!-- Classy Menu -->
                        <nav class="classy-navbar justify-content-center">

                            <!-- Navbar Toggler -->
                            <div class="classy-navbar-toggler">
                                <span class="navbarToggler"><span></span><span></span><span></span></span>
                            </div>

                            <!-- Menu -->
                            <div class="classy-menu">

                                <!-- close btn -->
                                <div class="classycloseIcon">
                                    <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                                </div>

                            </div>
                        </nav>
                    </div>
                    
                    <!-- Footer Social Area -->
                    <div class="footer-social-area mt-30">
                        <a href="#" data-toggle="tooltip" data-placement="top" title="Pinterest"><i class="fab fa-pinterest" aria-hidden="true"></i></a>
                        <a href="#" data-toggle="tooltip" data-placement="top" title="Facebook"><i class="fab fa-facebook" aria-hidden="true"></i></a>
                        <a href="#" data-toggle="tooltip" data-placement="top" title="Twitter"><i class="fab fa-twitter" aria-hidden="true"></i></a>
                    </div>
                </div>
            </div>
        </div>


Copyright &copy;<script>document.write(new Date().getFullYear());</script> Todos los derechos reservados | <a href="https://www.centronelson.org/" target="_blank">Ivan, Jaime & Alejandro </a>


    </footer>
    <!-- ##### Footer Area End ##### -->


    <!-- jQuery (Necessary for All JavaScript Plugins) -->
    <script src="js/jquery/jquery-2.2.4.min.js"></script>
    
	<script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>
    <!-- Popper js -->
    <script src="js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="js/plugins.js"></script>
    <!-- Active js -->
    <script src="js/active.js"></script>

    <script type="text/javascript" src="js/main.js"></script>

</body>

</html>