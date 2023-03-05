
public class Movimiento {
	private int id_mov;
	private int id_cliente;
	private String concepto;
	private int importe;

	public int getId_mov() {
		return id_mov;
	}

	public void setId_mov(int id_mov) {
		this.id_mov = id_mov;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}
}
