

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio01
 */
@WebServlet("/Ejercicio01")
public class Ejercicio01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = response.getWriter();
		
		try {
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<title>FIREFOX?</title>");
            pw.println("</head>");
            pw.println("<body>");
            

            
            Enumeration<String> nombresDeCabeceras = request.getHeaderNames();
            while (nombresDeCabeceras.hasMoreElements()) {
                String cabecera = nombresDeCabeceras.nextElement();
                String info = request.getHeader(cabecera);
                
                if(cabecera.equals("user-agent")) {
                	if(info.contains("Firefox")) {
                		pw.println("<p>Estás usando el navegador de Firefox</p>");
                	} else {
                		pw.println("<p>No estás usando el navegador de Firefox");
                	}
                }
                
                
            }
            
            
            pw.println("</body>");
            pw.println("</html>");

        } finally {
            pw.close();
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
