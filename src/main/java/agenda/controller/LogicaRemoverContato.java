package agenda.controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.dao.ContatoDao;
import agenda.model.Contato;

public class LogicaRemoverContato implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		
		Connection connection = (Connection) req.getAttribute("conexao");
		
		Contato contato = new Contato();
		contato.setId(id);
		
		ContatoDao dao = new ContatoDao(connection);
		dao.removeContato(contato);
		
		System.out.println("LogicaRemoverContato executada");
		return "mvc?logica=LogicaListarContatos";
	}
}