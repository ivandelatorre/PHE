<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="clases.*"%>
<%@ page import="clases.GeneratePDFFileIText"%>
<%@ page import="com.itextpdf.*"%>
<%@ page import="java.awt.Desktop"%>
<%@ page import="java.net.*"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guru File</title>
</head>
<body>
	<%
		BDController controladorBD = new BDController();

		//Llamo al constructor de la clase que genera los pdf

		GeneratePDFFileIText generatePDFFileIText = new GeneratePDFFileIText();

		//Obtengo la ruta de la aplicacion
		String filePath = application.getRealPath("/");
		filePath = filePath.replace("\\", "/");

		//Identifico que tipo de listado tengo que generar
		if (request.getParameter("tipo").equalsIgnoreCase("candidatos")) {
			ArrayList<Candidato> candidatos = controladorBD.dameCandidatos();
			
			//Llamo al constructor y le envio la ruta del documento que voy a generar y el arrayList de la entidad
			//Aqui es donde se va a guardar el documento pdf
			generatePDFFileIText.createPDFCandidatos(new File(filePath + "pdf/candidatos.pdf"), candidatos);

			//Ejecuto el documento pdf creado para que se abra.
			Desktop d = Desktop.getDesktop();
			URI uriBase = new URI(filePath + "pdf/candidatos.pdf");
			d.browse(uriBase);

			//mando el navegador a la pagina de jugadores.jsp
			response.sendRedirect("busqueda-candidato.jsp");
		}
	%>

</body>
</html>