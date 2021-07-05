package agenda.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.dao.ContatoDao;
import agenda.model.Contato;

@WebServlet("/add")
public class AddContatoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7061368898075075139L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("initializing servlet");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		log("destroying servlet");

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();

		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataText = req.getParameter("nascimento");
		Calendar dataNascimento = null;

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataText);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			out.println("Erro conversão da data");
			return;
		}

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);

		
		try {
			ContatoDao dao = new ContatoDao();
			dao.addContato(contato);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			out.println("Erro: {{" + e.getMessage() + "}}");
			return;
		}

		out.println("<html>");
		out.println("<body>");
		out.println("Contato de " + contato.getNome() + " salvo com sucesso");
		out.println("</body>");
		out.println("</html>");

	}

}