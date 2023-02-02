

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio02
 */
@WebServlet("/Ejercicio02")
public class Ejercicio02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String edad = request.getParameter("edad");
		String[] hobbies = request.getParameterValues("hobbies");
		String sexo = request.getParameter("sexo");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet que procesa un formulario basico</title>");
			out.println("<style>img{max-height: 200px}</style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>" + "Hola " + nombre + " " + apellidos + "</h1>");
			out.println("Tu Franja de edad es " + edad + " y tus hobbies son:");

			out.println("<ul>");
			for (String hobby : hobbies) {
				out.println("<li>" + hobby + "</li>");
			}
			out.println("</ul>");
			
			out.println("Tu sexo es : " + sexo + "<br>");
			
			
			if(sexo.equals("hombre")) {
				out.println("<img src='imagenes/hombre.jpg'></img><br>");
			} else if (sexo.equals("mujer")) {
				out.println("<img src='imagenes/mujer.png'></img><br>");
			}
			
			out.println("Este formulario ha sido invocado con Los siguientes parametros:<br/>");
			out.println(request.getQueryString());

			out.println("</body>");
			out.println("</html>");

		} finally {
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
