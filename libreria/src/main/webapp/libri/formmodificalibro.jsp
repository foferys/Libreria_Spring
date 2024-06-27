<%@ page language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%	Map<String,String> mappa = (Map<String,String>) request.getAttribute("libroModifica"); %>
<html>
	<head>
		<title>Form modifica libro</title>
	</head>
	<body>
		<h1>FORM MODIFICA LIBRO</h1>
		<form action="modificalibro" method="get">
			ID <input type="text" name="id" value="<%= mappa.get("id") %>" readonly><br>
			AUTORE <input type="text" name="autore" value="<%= mappa.get("autore") %>"><br>
			TITOLO <input type="text" name="titolo" value="<%= mappa.get("titolo") %>"><br>
			<input type="submit" value="AGGIORNA">
		</form>
	</body>
</html>