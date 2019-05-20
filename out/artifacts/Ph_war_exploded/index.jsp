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

  <link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">

</head>

<body>
  <%
  BDController controladorBD = new BDController();
  ArrayList<Noticia> noticias = controladorBD.dame4NoticiasCampanna();
    ArrayList<Evento> eventos = controladorBD.dame5proximosEventos();
      %>
      <!-- Preloader -->
      <div id="preloader">
        <div class="preload-content">
          <div id="original-load"></div>
        </div>
      </div>

      <!-- Subscribe Modal -->
      <div class="subscribe-newsletter-area">
        <div class="modal fade" id="subsModal" tabindex="-1" role="dialog" aria-labelledby="subsModal" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
              <div class="modal-body">
                <h5 class="title">Subscribete a nuestro newsletter</h5>
                <form action="#" class="newsletterForm" method="post">
                  <input type="email" name="email" id="subscribesForm2" placeholder="Ingresa tu e-mail">
                  <button type="submit" class="btn original-btn">Subscribirse</button>
                </form>
              </div>
            </div>
          </div>
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
                          <li><a href="eleccionesAutonomicas.jsp">Autonomicas</a></li>
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
                        <input type="text" id="search" placeholder="Buscar">
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
      <!-- ##### Header Area End ##### -->

      <div class="main-carousel">
        <%for (int i = 0; i < noticias.size(); i++){%>
          <div class="carousel-cell"><img class="imgs-banner" src="img/bg-img/b1.jpg"><div class="container-button-banner"><div class="title-new-banner"><%=noticias.get(i).getTitulo()%></div></div></div>
          <%}%>
        </div>
        <div class="container">
          <div class="jumbotron mt-5">
            <h1 class="display-4">Por españa!</h1>
            <p class="lead">El Partido Humano Español (PHE) es un partido politico liberal conservador español situado
              entre el centroderecha y la derecha politica. Fue fundado en enero de 1995. Desde 2011 y hasta 2018, fue el
              partido que ocupo el Gobierno de España, bajo el mandato de Arturo Ratilla hasta que fue desplazado tras la
              aprobacion de una mocion de censura en su contra.<br><br> Definido en sus estatutos como de «centro reformista» e
              inspirado en los valores del humanismo cristiano cuenta, segun sus propias estimaciones, con mas de 865 000
              afiliados​ divididos entre militantes (que pagan cuotas) y simpatizantes (que no las pagan), aunque esta afirmacion
              ha sido motivo de controversia: un analisis independiente situa el numero de afiliados en unos 100 000.
              <br><br>Es uno de los partidos mayoritarios de España, ganando sucesivamente las elecciones generales celebradas
              en el periodo 2011-2016. Actualmente, tras las elecciones generales de 2019, el Partido Humano Español (PHE)
              tiene 52 escaños en el Congreso de los Diputados y 35 en el Senado. Ademas, gobierna en seis comunidades autonomas,
              asi como en Ceuta y Melilla. Es, con las presidencias de Jose Alguilla y Maria Izanqui, la segunda formacion
              que mas años ha gobernado el pais desde el restablecimiento de la democracia, por detras del PSOE.</p>
          </div>
        </div>
        <!-- ##### Blog Wrapper Start ##### -->
        <div class="blog-wrapper section-padding-100 clearfix">
          <div class="container">
            <div class="row align-items-end">
              <!-- Single Blog Area -->
              <div class="col-12 col-md-6 col-lg-3">
                <div class="single-catagory-area clearfix mb-100">
                  <img src="img/blog-img/1.jpg" alt="">
                  <!-- Catagory Title -->
                  <div class="catagory-title">
                    <a href="eleccionesEuropeas.jsp">Elecciones Europeas</a>
                  </div>
                </div>
              </div>
              <!-- Single Blog Area -->
              <div class="col-12 col-md-6 col-lg-3">
                <div class="single-catagory-area clearfix mb-100">
                  <img src="img/blog-img/1.jpg" alt="">
                  <!-- Catagory Title -->
                  <div class="catagory-title">
                    <a href="eleccionesNacionales.jsp">Elecciones Nacionales</a>
                  </div>
                </div>
              </div>
              <!-- Single Blog Area -->
              <div class="col-12 col-md-6 col-lg-3">
                <div class="single-catagory-area clearfix mb-100">
                  <img src="img/blog-img/2.jpg" alt="">
                  <!-- Catagory Title -->
                  <div class="catagory-title">
                    <a href="eleccionesAutonomicas.jsp">Elecciones Autonomicas</a>
                  </div>
                </div>
              </div>
              <div class="col-12 col-md-6 col-lg-3">
                <div class="single-catagory-area clearfix mb-100">
                  <img src="img/blog-img/2.jpg" alt="">
                  <!-- Catagory Title -->
                  <div class="catagory-title">
                    <a href="eleccionesMunicipales.jsp">Elecciones Municipales</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="container">
          <div class="row">
            <div class="col-12 col-lg-9">
              <!-- Single Blog Area  -->
              <%for (int i = 0; i < eventos.size(); i++){%>
                <div class="single-blog-area blog-style-2 mb-50 wow fadeInUp" data-wow-delay="0.5s" data-wow-duration="1000ms">
                  <div class="row align-items-center">
                    <div class="col-12 col-md-6">
                      <div class="single-blog-thumbnail">
                        <img src="img/blog-img/5.jpg" alt="">
                        <div class="post-date">
                          <a href="#"><%=eventos.get(i).getDia()%> <span>march</span></a>
                        </div>
                      </div>
                    </div>
                    <div class="col-12 col-md-6">
                      <!-- Blog Content -->
                      <div class="single-blog-content">
                        <div class="line"></div>
                        <h4><a href="#" class="post-headline"><%=eventos.get(i).getNombre()%></a></h4>
                        <p><%=eventos.get(i).getDescripcion()%></p>
                        <div class="post-meta">
                          <p>En <a href="#"><%=eventos.get(i).getMunicipio()%></a></p>
                          <p><%=eventos.get(i).getHora()%></p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <%}%>
                <!-- Load More -->
              </div>
            </div>
          </div>

          <!-- ##### Modals ##### -->
          <!-- Modal -->
          <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
            aria-hidden="true">

            <!-- Add .modal-dialog-centered to .modal-dialog to vertically center the modal -->
            <div class="modal-dialog modal-dialog-centered" role="document">


            </div>
          </div>

          <!-- ##### Modals End ##### -->

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

            Copyright &copy;<script>document.write(new Date().getFullYear());</script> Todos los derechos reservados | <a href="https://www.centronelson.org/" target="_blank">Ivan, Jaime & Alejandro </a>

          </footer>

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
