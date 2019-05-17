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
    <link rel="stylesheet" href="css/main.css">
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>

    <link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">

</head>

<body>
<%
    BDController controladorBD = new BDController();
    ArrayList<Campanna> campannas = controladorBD.dameCampannas();
    ArrayList<Evento> eventos = controladorBD.dameEventos();

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
                <li class="breadcrumb-item active">Participa</li>
            </ol>
        </nav>
    </div>

<!-- #### Container ##### -->
<ul class="nav nav-tabs container" id="myTab" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#voluntario" role="tab" aria-controls="home"
           aria-selected="true">Voluntario</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#asistir" role="tab" aria-controls="profile"
           aria-selected="false">Asistir a un Evento</a>
    </li>
</ul>
<div class="tab-content container" id="myTabContent" style="max-width:750px;">
    <div class="tab-pane fade show active" id="voluntario" role="tabpanel" aria-labelledby="home-tab">

        <!-- #### Form contact Voluntario #### -->
        <form class="text-center border border-light p-5" style="border:0px !important;">

            <p class="h4 mb-4">Ser Voluntario</p>

            <!-- Name -->
            <input type="text" id="nombre" name="nombre" class="form-control mb-4" placeholder="Nombre" required>

            <!-- Surnames -->
            <input type="text" id="apellidos" name="apellidos" class="form-control mb-4" placeholder="Apellidos" required>

            <!-- Date -->
            <label><h6>Fecha de nacimiento</h6></label>
            <input type="date" id="fecha" name="fecha" class="form-control mb-4" required>

            <input type="email" id="email" name="email" class="form-control mb-4" placeholder="E-mail" required/>


            <input type="tel" id="tlf" name="tlf" class="form-control mb-4" placeholder="Teléfono" required/>

            <!-- Subject -->
            <label><h6>Seleccione una Campaña</h6></label>
            <select class="browser-default custom-select mb-4">
                <option selected value="" disabled>Elige una opcion</option>
                <%for (int i = 0; i <  campannas.size(); i++){%>
                <option value=""><%=campannas.get(i).getAmbito()%></option>
                <%}%>
            </select>

            <!-- Copy -->
            <div class="custom-control custom-checkbox mb-4" style="max-width:280px;margin:auto;">
                <input type="checkbox" class="custom-control-input" id="defaultContactFormCopy"/>
                <label class="custom-control-label" for="defaultContactFormCopy" style="font-size:15px;">Subscribirse al Newsletter</label>
            </div>

            <!-- Default checked -->
            <div class="custom-control custom-checkbox" style="max-width:380px;margin:auto;">
                <input type="checkbox" class="custom-control-input" id="defaultChecked2" required/>
                <label class="custom-control-label" for="defaultChecked2" style="font-size:15px;">Acepta nuestra política de Protección de Datos</label>
            </div>
            <br/>

            <!-- Send button -->
            <button class="btn btn-info btn-block" style="max-width:150px;margin:auto;" type="submit">Enviar</button>
        </form>
        <!-- #### End form contact Voluntario #### -->

    </div>
    <div class="tab-pane fade" id="asistir" role="tabpanel" aria-labelledby="profile-tab">

        <!-- #### Form contact Asistir #### -->
        <form class="text-center border border-light p-5" style="border:0px !important;" action="proximosEventos.jsp">

            <p class="h4 mb-4">Asistir a un Evento</p>

            <!-- Name -->
            <input type="text" id="nombreEvento" name="nombreEvento" class="form-control mb-4" placeholder="Nombre" required>

            <!-- Surnames -->
            <input type="text" id="apellidoEvento" name="apellidos" class="form-control mb-4" placeholder="Apellidos" required>

            <!-- Date -->
            <label><h6>Fecha de nacimiento</h6></label>
            <input type="date" id="fechaEvento" name="fechaEvento" class="form-control mb-4" required>

            <input type="email" id="emailEvento" name="emailEvento" class="form-control mb-4" placeholder="E-mail" required/>


            <input type="tel" id="telfEvento" name="telfEvento" class="form-control mb-4" placeholder="Teléfono" required/>

            <!-- Subject -->
            <label><h6>Seleccione un Evento</h6></label>
            <select class="browser-default custom-select mb-4"  name="campaña">
                <option selected value="" disabled>Elige una opcion</option>
                <%for (int i = 0; i <  eventos.size(); i++){%>
                <option value="<%=eventos.get(i).getNombre()%>"><%=eventos.get(i).getNombre()%></option>
                <%}%>
            </select>

            <!-- Copy -->
            <div class="custom-control custom-checkbox mb-4" style="max-width:280px;margin:auto;">
                <input type="checkbox" class="custom-control-input" id="defaultContactFormCop"/>
                <label class="custom-control-label" for="defaultContactFormCop" style="font-size:15px;">Subscribirse al Newsletter</label>
            </div>

            <!-- Default checked -->
            <div class="custom-control custom-checkbox" style="max-width:380px;margin:auto;">
                <input type="checkbox" class="custom-control-input" id="defaultChecked3" required />
                <label class="custom-control-label" for="defaultChecked3" style="font-size:15px;">Acepta nuestra política de Protección de Datos</label>
            </div>
            <br/>

            <!-- Send button -->
            <button class="btn btn-info btn-block" style="max-width:150px;margin:auto;" type="submit">Enviar</button>
        </form>
        <!-- #### End form contact asistir #### -->
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