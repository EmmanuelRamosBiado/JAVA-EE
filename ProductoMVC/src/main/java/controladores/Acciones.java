package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Producto;
import Modelo.AccesoDatos;


public class Acciones {
	
	HttpServletRequest request;
	HttpServletResponse response;

	Acciones(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	void accionAlta() throws ServletException, IOException {
		Producto user = new Producto();
		request.setAttribute("orden", "Nuevo");
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/layout/formulario.jsp").forward(request, response);
	}
	
	void accionBorrar(String id) {
		AccesoDatos db = AccesoDatos.initModelo();
		db.borrarProducto(id);
	}
	
	void accionModificar(String id) throws ServletException, IOException {
		AccesoDatos db = AccesoDatos.initModelo();
		Producto user = db.getProducto(id);
		request.setAttribute("orden", "Modificar");
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/layout/formulario.jsp").forward(request, response);

	}
	
	void accionDetalles(String id) throws ServletException, IOException {
		AccesoDatos db = AccesoDatos.initModelo();
		Producto user = db.getProducto(id);
		request.setAttribute("orden", "Detalles");
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/layout/formulario.jsp").forward(request, response);
	}
	
	void accionTerminar() {
		System.out.println("->>> accionTerminar   \n");
	}

	void accionPostAlta() {
		// Habría que controlar los datos de recibido <<<<<<<
		Producto user = new Producto();
		Integer prod_no = Integer.valueOf(request.getParameter("producto_no"));
		user.setProducto_no(prod_no);
		user.setDescripcion(request.getParameter("descripcion"));
		Float precio = Float.valueOf(request.getParameter("precio_actual"));
		user.setPrecio(precio);
		Integer stock = Integer.valueOf(request.getParameter("stock_disponible"));
		user.setStock(stock);
		AccesoDatos db = AccesoDatos.initModelo();
		db.addProducto(user);
	}
	
	void accionPostModificar() {
		// Habría que controlar los datos de recibido <<<<<<<
		Producto user = new Producto();
		Integer prod_no = Integer.valueOf(request.getParameter("producto_no"));
		user.setProducto_no(prod_no);
		user.setDescripcion(request.getParameter("descripcion"));
		Float precio = Float.valueOf(request.getParameter("precio_actual"));
		user.setPrecio(precio);
		Integer stock = Integer.valueOf(request.getParameter("stock_disponible"));
		user.setStock(stock);
		AccesoDatos db = AccesoDatos.initModelo();
		db.modProducto(user);

	}

}
