<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="alimentosMVC.Alimento"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de alimentos</title>
</head>
<body>
	<% 
	ArrayList <Alimento> lista = (ArrayList) request.getAttribute("listaAlimentos");

if (lista == null){
	out.println( " Me han enviado una lista == NULL");
	
}
else 
{

%>


	<table border="1">
		<tr>
			<th>id</th>
			<th>Nombre</th>
			<th>Energ�a</th>
			<%
for (Alimento p : lista) {
%>
		
		<tr>
			<td><%= p.getid() %></td>
			<td><%= p.getNombre() %></td>
			<td><%= p.getEnergia() %></td>
			
		</tr>
		<%
}
%>
	</table>
<%
}
%>
</body>
</html>