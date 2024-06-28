<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
    
<%	List<Map<String, String>> autori = (List<Map<String, String>>) request.getAttribute("par"); 
	String parCer = (String) request.getAttribute("parCercata"); 
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<title>CERCA NOME</title>
</head>
<body>
	
	<div class="container">
		<h1>Gli autori con "<b><%=parCer %></b>" sono: <%= autori.size() %></h1>
		<h6><%= autori %></h6>
	
		<div class="card" style="width: 18rem;">
		  <div class="card-header">
		    Elementi trovati con la parola <%= parCer %>
		  </div>
		  <ul class="list-group list-group-flush">
			<%if(autori.size() > 0) { %>
			  <%for(Map<String,String> el : autori) {%>
			  		
				  <li class="list-group-item"><%= el.get("autore") %></li>
			   <%} %>
 			<%}else {%>
 				nessun elemento trovato con "<b><%=parCer %></b>"
 			<%} %>
		  </ul>
		</div>
		
	</div>
	
	
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	
</body>
</html>