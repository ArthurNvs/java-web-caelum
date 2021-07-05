<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.util.*, 
				  agenda.dao.*,
				  agenda.model.*,
				  java.text.SimpleDateFormat" %>
				  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<%
		String mensagem =  "Bem vindo ao projeto Agenda!";
		String developer = "desenvolvido por: Arthur Neves";
	%>
	<%= mensagem %>
	<br />
	<%= developer %>
	<br />
	<%
		System.out.println("JSP exeutada com sucesso!");
	%>
	
	<%-- Listagem de contatos --%>
	<table>
		<tr>
			<td>Nome </td>
			<td>Email </td>
			<td>Endereço </td>
			<td>Data deNascimento </td>
		</tr>
		<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			
			for (Contato contato : contatos) {
				
			Calendar dataNascimento = contato.getDataNascimento();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String nascimento = sdf.format(dataNascimento.getTime());
		%>
		<tr>
			<td><%=contato.getNome() %></td>
			<td><%=contato.getEmail() %></td>
			<td><%=contato.getEndereco() %></td>
			<td><%=nascimento %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>