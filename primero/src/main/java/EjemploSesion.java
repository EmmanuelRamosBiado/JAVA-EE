
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EjemploSesion
 */
@WebServlet({ "/EjemploSesion", "/sesion" })
public class EjemploSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int contadorTotal=0;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EjemploSesion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer contador = 0;

		// Session start()
		HttpSession s = request.getSession();

		
		contador = (Integer) s.getAttribute("veces");

		// Ver si hay un atributo session
		if (contador == null) {
			contador = 0;
		} else {
			contador++;
		}
		
		contadorTotal++;
		
		if(contadorTotal==5) {
			// Session destroy
			s.invalidate();
		} else {
			s.setAttribute("veces", contador);
		}

		

		PrintWriter pw = response.getWriter();

		pw.println("<h1>Contador = " + contador + "</h1>");
		pw.println("<h1>Contador Total = " + contadorTotal + "</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
