package controladores;

import java.util.ArrayList;

import Modelo.Producto;
import Modelo.AccesoDatos;

public class Funciones {
	
	static String mostrarDatos(){
		
		String msg = "";
		String titulos[] = { "Nombre", "Descripción", "Precio", "Stock" };
		msg += "<table>\n";
		// Identificador de la tabla
		msg += "<tr>";
		for (int j = 0; j < titulos.length; j++) {
			msg += "<th>" + titulos[j] + "</th>";
		}
		msg += "</tr>";
		AccesoDatos db = AccesoDatos.initModelo();
		ArrayList<Producto> tuser = db.getProductos();
		for (Producto user : tuser) {
			msg += "<tr>";
			msg += "<td>" + user.getProducto_no() + "</td>";
			msg += "<td>" + user.getDescripcion() + "</td>";
			msg += "<td>" + user.getPrecio() + "</td>";
			msg += "<td>" + user.getStock() + "</td>";
			msg += "<td><a href='#' onclick=\"confirmarBorrar('" + user.getDescripcion() + "','" + user.getProducto_no()
			+ "');\" >Borrar</a></td>\n";
			msg += "<td><a href='?orden=Modificar&id=" + user.getProducto_no() + "'>Modificar</a></td>\n";
			msg += "<td><a href='?orden=Detalles&id=" + user.getProducto_no() + "' >Detalles</a></td>\n";
			msg += "</tr>\n";

		}
		msg += "</table>";

		return msg;
	}

}
