package agenda.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.dao.ContatoDao;
import agenda.model.Contato;

public class LogicaRetornaJsp implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Teste Retornar JSP");
		return "listar-contatos.jsp";
	}
}