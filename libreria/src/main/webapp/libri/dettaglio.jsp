<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%	Map<String,String> dettaglioLibro = (Map<String,String>) request.getAttribute("libro"); %>
<html>
	<head>
		<title>Dettaglio libro con id = <%= dettaglioLibro.get("id") %></title>
	</head>
	<body>
		<h1>Dettaglio <%= dettaglioLibro.get("titolo") %></h1>
		AUTORE <%= dettaglioLibro.get("autore") %><br>
		TITOLO <%= dettaglioLibro.get("titolo") %><br>
		<a href="formmodifica?id=<%= dettaglioLibro.get("id") %>">FORM MODIFICA</a>
	</body>
</html>