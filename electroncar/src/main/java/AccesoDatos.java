import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccesoDatos {

	private static AccesoDatos modelo;
	private static Connection conexion = null;
	
	private PreparedStatement stmt_obtenerCliente = null;
	private PreparedStatement stmt_obtenerVehiculo = null;
	private PreparedStatement stmt_existeCod_cli = null;
	private PreparedStatement stmt_existeClave = null;
	private PreparedStatement stmt_comprobarReservado = null;
	

	public static synchronized AccesoDatos initModelo() {
		if (modelo == null) {
			modelo = new AccesoDatos();
		}
		return modelo;
	}
	
	private AccesoDatos() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			conexion = DriverManager.getConnection("jdbc:mysql://localhost/mycardb", "root", "");

			this.stmt_obtenerCliente = conexion.prepareStatement("select * from clientes where cod_cli=?");
			this.stmt_obtenerVehiculo = conexion.prepareStatement("select * from Vehiculos where localidad=?");
			this.stmt_existeCod_cli = conexion.prepareStatement("select cod_cli from clientes where cod_cli=?");
			this.stmt_existeClave = conexion.prepareStatement("select clave from clientes where clave=?");
			this.stmt_comprobarReservado = conexion.prepareStatement("select * from clientes where cod_cli=? and cod_car>0");
			
			

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
	
	public Cliente obtenerCliente(String codigo) {
		Cliente resu = new Cliente();
		
		ResultSet rs;
		try {
			this.stmt_obtenerCliente.setString(1, codigo);
			rs = this.stmt_obtenerCliente.executeQuery();
			if (rs.next()) {
				resu = new Cliente();
				resu.setCod_cli(rs.getString("cod_cli"));
				resu.setNombre(rs.getString("nombre"));
				resu.setClave(rs.getString("clave"));
				resu.setCod_car(rs.getInt("cod_car"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resu;
	}
	
	public Vehiculo obtenerVehiculo(String localidad) {
		Vehiculo resu = new Vehiculo();
		
		ResultSet rs;
		try {
			this.stmt_obtenerVehiculo.setString(1, localidad);
			rs = this.stmt_obtenerVehiculo.executeQuery();
			if (rs.next()) {
				resu = new Vehiculo();
				resu.setCod_car(rs.getInt("cod_car"));
				resu.setLocalidad(rs.getString("localidad"));
				resu.setEstado(rs.getInt("estado"));
				resu.setBateria(rs.getInt("bateria"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resu;
	}
	
	public  boolean existeCod_cli(String codigo) {
		boolean resu = false;
		
		try {
			stmt_existeCod_cli.setString(1, codigo);
			boolean resultado = stmt_existeCod_cli.execute();
			if(resultado) {
				resu= true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resu;
	}
	
	public  boolean existeClave(String clave) {
		boolean resu = false;
		
		try {
			stmt_existeClave.setString(1, clave);
			boolean resultado=stmt_existeClave.execute();
			if(resultado) {
				resu= true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resu;
	}
	
	public boolean comprobarReservado(String codigo) {
		boolean resu = false;
		
		try {
			stmt_comprobarReservado.setString(1, codigo);
			
			resu=stmt_comprobarReservado.execute();
			if(resu) {
				resu=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resu;
	}
	
	
	
	
}
