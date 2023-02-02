<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="alimentosMVC.Alimento"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de Alimento</title>
</head>
<body>
	<%
	Alimento a = (Alimento) request.getAttribute("alimentoItem");
	if (a == null) {
		out.println(" <h1> Alimento no encontrado.</h1>");
	} else {
	%>
	<table border="1">
		<tr>
			<th>id</th>
			<th>Nombre</th>
			<th>Energía</th>
			<th>Proteínas</th>
			<th>Hidratos de carbono</th>
			<th>Fibra</th>
			<th>Grasa total</th>
		</tr>

		<tr>
			<td><%=a.getid() %></td>
			<td><%=a.getNombre() %></td>
			<td><%=a.getEnergia() %></td>
			<td><%=a.getProteninas() %></td>
			<td><%=a.getHidradocarbono() %></td>
			<td><%=a.getFibra()%></td>
			<td><%=a.getGrasatotal() %></td>
		</tr>
	</table>
	<%
	}
	%>
</body>
</html>