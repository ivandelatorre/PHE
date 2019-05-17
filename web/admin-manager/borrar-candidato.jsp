<!DOCTYPE html>
<%@page import="clases.Candidato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="clases.BDController"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>Admin Site | A�adir Candidatos</title>
	<meta name="description" content="Free Bootstrap 4 Admin Theme | Pike Admin">
	<meta name="author" content="Pike Web Development - https://www.pikephp.com">

	<!-- Favicon -->
	<link rel="shortcut icon" href="assets/images/favicon.ico">

	<!-- Switchery css -->
	<link href="assets/plugins/switchery/switchery.min.css" rel="stylesheet" />

	<!-- Bootstrap CSS -->
	<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

	<!-- Font Awesome CSS -->
	<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

	<!-- Custom CSS -->
	<link href="assets/css/style.css" rel="stylesheet" type="text/css" />

	<!-- BEGIN CSS for this page -->

	<!-- END CSS for this page -->

</head>

<body class="adminbody">

	<div id="main">

		<!-- top bar navigation -->
		<div class="headerbar">

			<!-- LOGO -->
			<div class="headerbar-left">
				<a href="index.jsp" class="logo"> <span>Admin Site</span></a>
			</div>

			<nav class="navbar-custom">

				<ul class="list-inline float-right mb-0">

					<li class="list-inline-item dropdown notif">
						<a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
							<i class="fa fa-fw fa-question-circle"></i>
						</a>
						<div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-arrow-success dropdown-lg">
							<!-- item-->
							<div class="dropdown-item noti-title">
								<h5><small>Help and Support</small></h5>
							</div>

							<!-- item-->
							<a target="_blank" href="" class="dropdown-item notify-item">
								<p class="notify-details ml-0">
									<b>Do you want custom development to integrate this theme?</b>
									<span>Contact Us</span>
								</p>
							</a>

							<!-- item-->
							<a target="_blank" href="" class="dropdown-item notify-item">
								<p class="notify-details ml-0">
									<b>Do you want PHP version of the theme that save dozens of hours of work?</b>
									<span>Try Admin PRO</span>
								</p>
							</a>

							<!-- All-->
							<a title="Clcik to visit Pike Admin Website" target="_blank" href="" class="dropdown-item notify-item notify-all">
								<i class="fa fa-link"></i> Visit Admin Website
							</a>

						</div>
					</li>

					<li class="list-inline-item dropdown notif">
						<a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
							<i class="fa fa-fw fa-envelope-o"></i><span class="notif-bullet"></span>
						</a>
						<div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-arrow-success dropdown-lg">
							<!-- item-->
							<div class="dropdown-item noti-title">
								<h5><small><span class="label label-danger pull-xs-right">12</span>Contact Messages</small></h5>
							</div>

							<!-- item-->
							<a href="#" class="dropdown-item notify-item">
								<p class="notify-details ml-0">
									<b>Jokn Doe</b>
									<span>New message received</span>
									<small class="text-muted">2 minutes ago</small>
								</p>
							</a>

							<!-- item-->
							<a href="#" class="dropdown-item notify-item">
								<p class="notify-details ml-0">
									<b>Michael Jackson</b>
									<span>New message received</span>
									<small class="text-muted">15 minutes ago</small>
								</p>
							</a>

							<!-- item-->
							<a href="#" class="dropdown-item notify-item">
								<p class="notify-details ml-0">
									<b>Foxy Johnes</b>
									<span>New message received</span>
									<small class="text-muted">Yesterday, 13:30</small>
								</p>
							</a>

							<!-- All-->
							<a href="#" class="dropdown-item notify-item notify-all">
								View All
							</a>

						</div>
					</li>

					<li class="list-inline-item dropdown notif">
						<a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
							<i class="fa fa-fw fa-bell-o"></i><span class="notif-bullet"></span>
						</a>
						<div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-lg">
							<!-- item-->
							<div class="dropdown-item noti-title">
								<h5><small><span class="label label-danger pull-xs-right">5</span>Allerts</small></h5>
							</div>

							<!-- item-->
							<a href="#" class="dropdown-item notify-item">
								<div class="notify-icon bg-faded">
									<img src="assets/images/avatars/avatar2.png" alt="img" class="rounded-circle img-fluid">
								</div>
								<p class="notify-details">
									<b>John Doe</b>
									<span>User registration</span>
									<small class="text-muted">3 minutes ago</small>
								</p>
							</a>

							<!-- item-->
							<a href="#" class="dropdown-item notify-item">
								<div class="notify-icon bg-faded">
									<img src="assets/images/avatars/avatar3.png" alt="img" class="rounded-circle img-fluid">
								</div>
								<p class="notify-details">
									<b>Michael Cox</b>
									<span>Task 2 completed</span>
									<small class="text-muted">12 minutes ago</small>
								</p>
							</a>

							<!-- item-->
							<a href="#" class="dropdown-item notify-item">
								<div class="notify-icon bg-faded">
									<img src="assets/images/avatars/avatar4.png" alt="img" class="rounded-circle img-fluid">
								</div>
								<p class="notify-details">
									<b>Michelle Dolores</b>
									<span>New job completed</span>
									<small class="text-muted">35 minutes ago</small>
								</p>
							</a>

							<!-- All-->
							<a href="#" class="dropdown-item notify-item notify-all">
								View All Allerts
							</a>

						</div>
					</li>

					<li class="list-inline-item dropdown notif">
						<a class="nav-link dropdown-toggle nav-user" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
							<img src="assets/images/avatars/admin.png" alt="Profile image" class="avatar-rounded">
						</a>
						<div class="dropdown-menu dropdown-menu-right profile-dropdown">
							<!-- item-->
							<div class="dropdown-item noti-title">
								<h5 class="text-overflow"><small>Hello, admin</small> </h5>
							</div>

							<!-- item-->
							<a href="pro-profile.jsp" class="dropdown-item notify-item">
								<i class="fa fa-user"></i> <span>Profile</span>
							</a>

							<!-- item-->
							<a href="#" class="dropdown-item notify-item">
								<i class="fa fa-power-off"></i> <span>Logout</span>
							</a>

							<!-- item-->
							<a target="_blank" href="" class="dropdown-item notify-item">
								<i class="fa fa-external-link"></i> <span>Admin</span>
							</a>
						</div>
					</li>

				</ul>

				<ul class="list-inline menu-left mb-0">
					<li class="float-left">
						<button class="button-menu-mobile open-left">
							<i class="fa fa-fw fa-bars"></i>
						</button>
					</li>
				</ul>

			</nav>

		</div>
		<!-- End Navigation -->


		<!-- Left Sidebar -->
		<div class="left main-sidebar">

			<div class="sidebar-inner leftscroll">

				<div id="sidebar-menu">

					<ul>

						<li class="submenu">
							<a class="active" href="index.jsp"><i class="fa fa-fw fa-bars"></i><span> Tablero </span> </a>
						</li>

						<li class="submenu">
							<a href="#"><i class="material-icons">search</i> <span> Buscar </span> <span class="menu-arrow"></span></a>
							<ul class="list-unstyled">
								<li><a href="busqueda-candidato.jsp">Candidatos</a></li>
								<li><a href="busqueda-eventos.jsp">Eventos</a></li>
							</ul>
						</li>

						<li class="submenu">
							<a href="#"><i class="material-icons">add</i> <span> A�adir </span> <span class="menu-arrow"></span></a>
							<ul class="list-unstyled">
								<li><a href="add-candidato.jsp">Candidato</a></li>
								<li><a href="add-evento.jsp ">Evento</a></li>
							</ul>
						</li>

						<li class="submenu">
							<a href="#"><i class="material-icons">delete</i> <span> Eliminar </span> <span class="menu-arrow"></span></a>
							<ul class="list-unstyled">
								<li><a>Candidato</a></li>
								<li><a href="borrar-evento.jsp ">Evento</a></li>
							</ul>
						</li>

						

					</ul>

					<div class="clearfix"></div>

				</div>

				<div class="clearfix"></div>

			</div>

		</div>
		<!-- End Sidebar -->

		<div class="content-page">

			<!-- Start content -->
			<div class="content">

				<div class="container-fluid">

					<div class="row">
						<div class="col-xl-12">
							<div class="breadcrumb-holder">
								<h1 class="main-title float-left">Borrar Candidatos</h1>
								<ol class="breadcrumb float-right">
									<li class="breadcrumb-item">Inicio</li>
									<li class="breadcrumb-item active">Borrar Candidato</li>
								</ol>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<!-- end row -->
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6" style="margin: auto;height:400px">
							<h3>Seleccione el candidato a borrar</h3>
							<br/>
							<form action="borrarcandidato.jsp">
								<div class="">
									<div class="mm-dropdown" style="background: white;cursor: pointer;font-size: 20px;font-weight: 200;line-height: 40px;height:53px">
										<div class="textfirst" style="border-color:#5c9cd8;border-radius: 5px;text-align:center">Selecciona Candidato</div>
										<ul class="scrollable-menu"style="text-align:center">
											<%BDController controladorbd=new BDController();
												ArrayList<Candidato> candidatos=controladorbd.dameCandidatos();
												for(Candidato cam: candidatos){
													
												
											%>
												<li class="input-option" data-value="  " style="border-color:#5c9cd8;">
													<img src="images/  .png" alt="" width="20" />
													<input type="hidden" class="option" name="codigo" value="<%=cam.getCod() %>" ><%=cam.getNombre() %></input>
													
												</li>
												
												<% }%>
												
											</ul>
										</div>
										
									</div>
									
							</div><!-- end card-->
							
						</div>
					</div>
					<div class="center" style=" float:right;margin-right: 230px">
									<button type="submit" class="btn btn-primary">Borrar</button>
									</div>
								</form>
				</div>
				<!-- END container-fluid -->

			</div>
			<!-- END content -->

		</div>
		<!-- END content-page -->

		<footer class="footer">
			<span class="text-right">
				Copyright <a target="_blank" href="#">Your Website</a>
			</span>
			<span class="float-right">
				Powered by <a target="_blank" href=""><b>Admin</b></a>
			</span>
		</footer>

	</div>
	<!-- END main -->

	<script src="assets/js/modernizr.min.js"></script>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/moment.min.js"></script>

	<script src="assets/js/popper.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>

	<script src="assets/js/detect.js"></script>
	<script src="assets/js/fastclick.js"></script>
	<script src="assets/js/jquery.blockUI.js"></script>
	<script src="assets/js/jquery.nicescroll.js"></script>
	<script src="assets/js/jquery.scrollTo.min.js"></script>
	<script src="assets/plugins/switchery/switchery.min.js"></script>
	<script src="assets/js/dropdown.js"></script>

	<!-- App js -->
	<script src="assets/js/pikeadmin.js"></script>

	<!-- BEGIN Java Script for this page -->

	<!-- END Java Script for this page -->

</body>
</html>
