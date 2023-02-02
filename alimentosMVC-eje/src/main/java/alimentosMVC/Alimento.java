package alimentosMVC;

/* JavaBean Alimentos */

public class Alimento {

	private int id;
	private String nombre;
	private float energia;
	private float proteinas;
	private float hidratoscarbono;
	private float fibra;
	private float grasatotal;

	// Constructor sin parámetros
	public Alimento() {

	}

	public Alimento(int id, String nombre, float energia, float proteinas, float hidratoscarbono, float fibra,
			float grasatotal) {

		this.id = id;
		this.nombre = nombre;
		this.energia = energia;
		this.proteinas = proteinas;
		this.hidratoscarbono = hidratoscarbono;
		this.fibra = fibra;
		this.grasatotal = grasatotal;

	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getEnergia() {
		return energia;
	}

	public void setEnergia(float energia) {
		this.energia = energia;
	}

	public float getProteninas() {
		return proteinas;
	}

	public void setProteninas(float proteninas) {
		this.proteinas = proteninas;
	}

	public float getHidradocarbono() {
		return hidratoscarbono;
	}

	public void setHidradocarbono(float hidradocarbono) {
		this.hidratoscarbono = hidradocarbono;
	}

	public float getFibra() {
		return fibra;
	}

	public void setFibra(float fibra) {
		this.fibra = fibra;
	}

	public float getGrasatotal() {
		return grasatotal;
	}

	public void setGrasatotal(float grasatotal) {
		this.grasatotal = grasatotal;
	}

}
