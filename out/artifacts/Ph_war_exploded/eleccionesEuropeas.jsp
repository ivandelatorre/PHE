<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="clases.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>PHE | Partido Humano Español</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Style CSS -->
    <link rel="stylesheet" href="style.css">
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>

    <link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
</head>

<body>
<%
    BDController controladorBD = new BDController();
    ArrayList<Programa> programas = controladorBD.dame10primerosPuntosPrograma();
    ArrayList<Candidato> candidatos = controladorBD.dameCandidatosPorEuropa();
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
                                    <li><a href="#">Hello World!</a></li>
                                    <li><a href="#">Hello Universe!</a></li>
                                    <li><a href="#">Hello Original!</a></li>
                                    <li><a href="#">Hello Earth!</a></li>
                                    <li><a href="#">Hello Colorlib!</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- Top Social Area -->
                    <div class="col-12 col-sm-4">
                        <div class="top-social-area">
                            <a href="#" data-toggle="tooltip" data-placement="bottom" title="Pinterest"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                            <a href="#" data-toggle="tooltip" data-placement="bottom" title="Facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                            <a href="#" data-toggle="tooltip" data-placement="bottom" title="Twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a>
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

                        <!-- Subscribe btn -->
                        <div class="subscribe-btn">
                            <a href="#" class="btn subscribe-btn" data-toggle="modal" data-target="#subsModal">Subscribirse</a>
                        </div>

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
                                    <li><a href="#">Elecciones</a>
                                        <ul class="dropdown">
                                            <li><a href="eleccionesNacionales.jsp">Nacionales</a></li>
                                            <li><a href="eleccionesAutonomicas.jsp">Autonómicas</a></li>
                                            <li><a href="eleccionesMunicipales.jsp">Municipales</a></li>
                                            <li><a href="eleccionesEuropeas.jsp">Europeas</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="proximos-eventos.jsp">Próximos eventos</a></li>
                                    <li><a href="participa.jsp">Participa</a></li>
                                    <li><a href="contact.html">Contacto</a></li>
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
                <li class="breadcrumb-item">Elecciones europeas</li>
            </ol>
        </nav>
    </div>

    <div class="container w-75">
        <div id="accordion" role="tablist" aria-multiselectable="true">
            <%for (int i = 0; i < programas.size(); i++){%>
            <div class="card">
                <div class="card-header" role="tab" id="headingOne">
                    <div class="mb-0">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse<%=i%>" aria-expanded="false" aria-controls="collapse<%=i%>" class="collapsed">
                            <i class="far fa-file-alt"></i>
                            <h3><%=programas.get(i).getCod_punto()%></h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor</p>
                        </a>
                        <i class="fa fa-angle-right" aria-hidden="true"></i>
                    </div>
                </div>

                <div id="collapse<%=i%>" class="collapse" role="tabpanel" aria-labelledby="heading<%=i%>" aria-expanded="false" style="">
                    <div class="card-block">
                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                    </div>
                </div>
            </div>
            <%}%>
        </div>
    </div>




    <section id="team" class="team-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="site-heading text-center">
                        <h2>Nuestro <span>Equipo</span></h2>
                        <h4>Conoce a todos nuestros miembros</h4>
                    </div>
                </div>
            </div>
            <div class="row team-items d-flex align-content-center justify-content-center">
                <div class="col-md-4 single-item">
                    <div class="item">
                        <div class="thumb">
                            <img class="img-fluid" src="https://i.ibb.co/JC4skS0/team-animate.jpg" alt="Thumb">
                            <div class="overlay">
                                <h4>Iván Jimenez Ortiz</h4>
                                <p>
                                    Lorem Ipsum is simp ly dummy text of the printing and typesetting industry.
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="info">
                        <h4>Iván Jiménez Ortiz</h4>
                        <span>Ingeniero aeronáutico</span>
                    </div>
                </div>
            </div>
            <div class="row team-items d-flex align-content-center justify-content-center">
                <%for (int i = 0; i < candidatos.size();i++){%>
                <div class="col-md-4 single-item subCandidato">
                    <div class="item">
                        <div class="thumb">
                            <img class="img-fluid" src="https://i.ibb.co/JC4skS0/team-animate.jpg" alt="Thumb">
                            <div class="overlay">
                                <h4><%=candidatos.get(i).getNombre()%></h4>
                                <p>
                                    Lorem Ipsum is simp ly dummy text of the printing and typesetting industry.
                                </p>
                                <div class="social">
                                    <ul>
                                        <li class="twitter">
                                            <a href="https://twitter.com/?lang=es"><i class="fab fa-twitter"></i></a>
                                        </li>
                                        <li class="pinterest">
                                            <a href="https://www.pinterest.es/"><i class="fab fa-pinterest"></i></a>
                                        </li>
                                        <li class="instagram">
                                            <a href="https://www.instagram.com/?hl=es"><i class="fab fa-instagram"></i></a>
                                        </li>
                                        <li class="vimeo">
                                            <a href="https://vimeo.com/es"><i class="fab fa-vimeo-v"></i></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="info">
                                    <span class="message">
                                        <a href="#"><i class="fas fa-envelope-open"></i></a>
                                    </span>
                            <h4><%=candidatos.get(i).getNombre()%></h4>
                            <span><%=candidatos.get(i).getProvincia()%></span>
                        </div>
                    </div>
                </div>
                <%}%>

            </div>
        </div>
    </section>

    <br>


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
                        <a href="#" data-toggle="tooltip" data-placement="top" title="Pinterest"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                        <a href="#" data-toggle="tooltip" data-placement="top" title="Facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                        <a href="#" data-toggle="tooltip" data-placement="top" title="Twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                    </div>
                </div>
            </div>
        </div>


Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://www.centronelson.org/" target="_blank">Ivan, Jaime & Alejandro </a>


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