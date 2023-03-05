
public class Cliente {

	private int id_cliente;
	private String pw_cliente;
	private String nombre;
	private int bloqueado;
	private int cont_error_acceso;

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getPw_cliente() {
		return pw_cliente;
	}

	public void setPw_cliente(String pw_cliente) {
		this.pw_cliente = pw_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(int bloqueado) {
		this.bloqueado = bloqueado;
	}

	public int getCont_error_acceso() {
		return cont_error_acceso;
	}

	public void setCont_error_acceso(int cont_error_acceso) {
		this.cont_error_acceso = cont_error_acceso;
	}
}
