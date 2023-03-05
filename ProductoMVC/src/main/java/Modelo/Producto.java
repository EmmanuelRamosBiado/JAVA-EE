package Modelo;

public class Producto {
	private int producto_no;
	private String descripcion;
	private float precio;
	private int stock;

	public int getProducto_no() {
		return producto_no;
	}

	public void setProducto_no(int producto_no) {
		this.producto_no = producto_no;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
