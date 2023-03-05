<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Modelo.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD DE PRODUCTOS</title>
<link href="web/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="container" style="width: 600px;">
		<div id="header">
			<h1>GESTIÓN DE PRODUCTOS JAVAEE</h1>
		</div>
		<div id="content">
			<hr>
			<form method="POST">
				<table>
					<tr>
						<td>DESCRIPCIÓN</td>
						<td>
							<%
							String orden = request.getAttribute("orden").toString();
							%> <input
							type="text" name="descripcion" value="${user.descripcion}"
							<%= orden.equals("Detalles")?"readonly":"" %> size="20" autofocus>
						</td>
					</tr>
					<tr>
						<td>NÚMERO DE PRODUCTO</td>
						<td><input type="text" name="producto_no" value="${user.producto_no}"
							<%= orden.equals("Detalles") || orden.equals("Modificar")?"readonly":"" %>
							size="8"></td>
					</tr>
					<tr>
						<td>PRECIO</td>
						<td><input type="text" name="precio_actual"
							value="${user.precio}"
							<%= orden.equals("Detalles")?"readonly":"" %> size=10></td>
					</tr>
					<tr>
						<td>STOCK</td>
						<td><input type="text" name="stock_disponible"
							value="${user.stock}"
							<%= orden.equals("Detalles")?"readonly":"" %> size=20></td>
					</tr>
				</table>
				<input type="submit" name="orden" value="<%=orden%>"> <input
					type="submit" name="orden" value="Volver" onclick="history.back()">
			</form>
		</div>
	</div>
</body>
</html>