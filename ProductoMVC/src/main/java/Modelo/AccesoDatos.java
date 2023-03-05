package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccesoDatos {
	
	private static AccesoDatos modelo;
	private static Connection conexion = null;
	
	private PreparedStatement stmt_productos = null;
	private PreparedStatement stmt_producto = null;
	private PreparedStatement stmt_borprod = null;
	private PreparedStatement stmt_modprod = null;
	private PreparedStatement stmt_creaprod = null;
	
	public static synchronized AccesoDatos initModelo() {
		if (modelo == null) {
			modelo = new AccesoDatos();
		}
		return modelo;
	}
	
	private AccesoDatos() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");

			this.stmt_productos = conexion.prepareStatement("select * from PRODUCTOS");
			this.stmt_producto = conexion.prepareStatement("select * from PRODUCTOS where PRODUCTO_NO=?");
			this.stmt_borprod = conexion.prepareStatement("delete from PRODUCTOS where PRODUCTO_NO =?");
			this.stmt_modprod = conexion
					.prepareStatement("update PRODUCTOS set DESCRIPCION=?, PRECIO_ACTUAL=?, STOCK_DISPONIBLE=? where PRODUCTO_NO=?");
			this.stmt_creaprod = conexion
					.prepareStatement("insert into productos (PRODUCTO_NO,DESCRIPCION,PRECIO_ACTUAL,STOCK_DISPOIBLE) Values(?,?,?,?)");

		} catch (Exception ex) {
			System.err.println(" Error - En la base de datos.");
			ex.printStackTrace();
		}
	}
	
	public static void closeModelo() {
		if (modelo != null) {
			try {
				conexion.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Producto> getProductos() {
		ArrayList<Producto> tuser = new ArrayList<Producto>();

		ResultSet rs;
		try {
			rs = this.stmt_productos.executeQuery();
			while (rs.next()) {
				Producto usr = new Producto();
				usr.setProducto_no(rs.getInt("PRODUCTO_NO"));
				usr.setDescripcion(rs.getString("DESCRIPCION"));
				usr.setPrecio(rs.getFloat("PRECIO_ACTUAL"));
				usr.setStock(rs.getInt("STOCK_DISPONIBLE"));
				tuser.add(usr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tuser;
	}
	
	public Producto getProducto(String id) {
		Producto usr = null;

		ResultSet rs;
		try {
			this.stmt_producto.setString(1, id);
			rs = this.stmt_producto.executeQuery();
			if (rs.next()) {
				usr = new Producto();
				usr.setProducto_no(rs.getInt("PRODUCTO_NO"));
				usr.setDescripcion(rs.getString("DESCRIPCION"));
				usr.setPrecio(rs.getFloat("PRECIO_ACTUAL"));
				usr.setStock(rs.getInt("STOCK_DISPONIBLE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usr;
	}
	
	public boolean modProducto(Producto user) {

		boolean resu = false;
		try {

			stmt_modprod.setString(1, user.getDescripcion());
			stmt_modprod.setFloat(2, user.getPrecio());
			stmt_modprod.setInt(3, user.getStock());
			stmt_modprod.setInt(4, user.getProducto_no());
			resu = stmt_modprod.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resu;
	}
	
	public boolean addProducto(Producto user) {
		boolean resu = false;
		try {
			stmt_creaprod.setInt(1, user.getProducto_no());
			stmt_creaprod.setString(2, user.getDescripcion());
			stmt_creaprod.setFloat(3, user.getPrecio());
			stmt_creaprod.setInt(4, user.getStock());
			resu = stmt_creaprod.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resu;
	}
	
	public boolean borrarProducto(String login) {
		boolean resu = false;

		try {
			this.stmt_borprod.setString(1, login);
			resu = this.stmt_borprod.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resu;

	}

	// Evito que se pueda clonar el objeto.
	@Override
	public AccesoDatos clone() {
		try {
			throw new CloneNotSupportedException();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
