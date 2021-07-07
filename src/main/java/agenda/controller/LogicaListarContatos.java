package agenda.controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.dao.ContatoDao;
import agenda.model.Contato;

public class LogicaListarContatos implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection connection = (Connection) req.getAttribute("conexao");
		
		List<Contato> contatos = new ContatoDao(connection).getLista();
		
		req.setAttribute("contatos", contatos);
		
		return "/WEB-INF/jsp/listar-contatos.jsp";
	}

}
