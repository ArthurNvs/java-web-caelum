package agenda.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4924308144743077507L;
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String param = req.getParameter("logica");
		String nomeClasse = "agenda.controller." + param;
		
		try {
			Class<?> classe = Class.forName(nomeClasse);
			
			Logica logica = (Logica) classe.getDeclaredConstructor().newInstance();
			String destino = logica.executa(req, res);
			
			req.getRequestDispatcher(destino).forward(req, res);
		} catch (Exception e) {
			throw new ServletException("A lógica de negócios gerou uma exceção", e);
		}
	}
}