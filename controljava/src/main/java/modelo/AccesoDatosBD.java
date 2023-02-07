package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



//Implemento el modelo con  Patrón Singleton
public class AccesoDatosBD {

	private ArrayList <Movimiento> listamov;
	private static AccesoDatosBD modelo;
	private Connection conexion = null;
	private PreparedStatement sentenciapreparada1 = null;
	private PreparedStatement sentenciapreparada2 = null;
	
	public static synchronized  AccesoDatosBD initModelo(){
		if (modelo == null) {
			modelo = new AccesoDatosBD();
		}
		return modelo;
	}
	
	// Creo un lista de Movimientos, podría obtenerse de una base de datos
	private AccesoDatosBD (){
		try {
			// Class.forName("org.apache.derby.jdbc.ClientDriver");
			Class.forName("com.mysql.jdbc.Driver");

			conexion = DriverManager.getConnection("jdbc:mysql://localhost/cuentasdb", "root", "");

			sentenciapreparada1 = conexion.prepareStatement("select * from movimientos where cod_cliente = ? "+
			                                                " and importe >= ? and importe <=? ");
			sentenciapreparada2 = conexion.prepareStatement("select * from movimientos where cod_cliente = ? ");
			
		} catch (Exception ex) {
			System.err.println(" Error - En la base de datos.");
			ex.printStackTrace();
		}
	}
	/*
	 * DEVUELVE UN NUEVO ARRAYLIST CON LOS MOVIMIENTOS QUE CUMPLEN LA CONDICION
	 * DEVUELVE UN ARRAYLIST VACIO SI NO HAY MOVIMIENTOS PARA ESE CLIENTE
	 */
	
	public ArrayList <Movimiento> obtenerListaMovimientos (String cod_cliente, int importmax, int importmin){		
		ArrayList<Movimiento> resultado = new ArrayList <Movimiento>();
		ResultSet rs;
		try {
			// Acceso sincronizado la sentencia y la conexión se comparten
			synchronized (sentenciapreparada1) {
				sentenciapreparada1.setString(1, cod_cliente);
				sentenciapreparada1.setInt(2, importmin);
				sentenciapreparada1.setInt(3, importmax);

				rs = sentenciapreparada1.executeQuery();

				// Vuelco el resultado de ResultSet al ArrayList
				while (rs.next()) {
					Movimiento nueva = new Movimiento(rs.getInt("num_mov"),
							rs.getString("cod_cliente"),
							rs.getString("concepto"),
							rs.getInt("importe"));
					resultado.add(nueva);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
		
		
		}
	
	
	// Devuelve TRUE o FALSE si hay algun Movimiento con ese código de cliente
    public boolean hayMovimientos ( String cod_cliente) {
    	boolean resu = false;
    	
		ResultSet rs;
		try {
			// Acceso sincronizado la sentencia y la conexión se comparten
			synchronized (sentenciapreparada2) {
				sentenciapreparada2.setString(1, cod_cliente);
				rs = sentenciapreparada2.executeQuery();
				// Si es correcto existe
				if (rs.next()) {
					resu = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resu;	
    }
	
	
	
	// Evito que se pueda clonar el objeto.
 @Override
 public AccesoDatos clone(){
         try {
             throw new CloneNotSupportedException();
         } catch (CloneNotSupportedException ex) {
         	ex.printStackTrace();
         }
         return null;
     }    
}