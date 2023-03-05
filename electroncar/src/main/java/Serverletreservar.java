
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Serverletreservar
 */
@WebServlet({ "/Serverletreservar", "/reservar" })
public class Serverletreservar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Serverletreservar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codigo = request.getParameter("cod_cli");
		String clave = request.getParameter("clave");
		String localidad = request.getParameter("localidad");

		AccesoDatos db = AccesoDatos.initModelo();
		
		boolean buenCod = db.existeCod_cli(codigo);
		boolean buenClave=db.existeClave(clave);

		if (buenCod && buenClave) {
			
			Cliente cliente = db.obtenerCliente(codigo);
			String msg = "";
			
			if(db.comprobarReservado(codigo)) {
				
				msg += "Ya tienes un coche";
			} else {
				
				msg += "Se ha reseervado el vehiculo" + "";
			}
			
			
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/WEB-INF/layout/vista.jsp").forward(request, response);
		} else {
			String msg = "ERROR:  Los valores de código de cliente y contraseña no son válidos";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/WEB-INF/layout/error.jsp").forward(request, response);
		}
	}

}
