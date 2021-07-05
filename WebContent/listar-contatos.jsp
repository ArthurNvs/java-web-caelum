<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listar Contatos</title>
	</head>
	<body>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
		
		<c:import url="cabecalho.jsp" />
		
		<!-- cria o DAO -->
		<jsp:useBean id="dao" class="agenda.dao.ContatoDao"/>
		
		<table  border="1">
			<tr bgcolor="#A5FB8 }" >
				<td>NOME</td>
				<td>EMAIL</td>
				<td>ENDEREÇO</td>
				<td>NASCIMENTO</td>
			</tr>
			<!-- percorre contatos montando as linhas da tabela -->
			<c:forEach var="contato" items="${dao.lista}" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? '888888' : 'ffffff' }" >
					<td>${contato.nome}</td>
					<td>
						<c:choose>
							<c:when test="${not empty contato.email}">
							 	<a href="mailto:${contato.email}">${contato.email}</a>
							 </c:when>
							 <c:otherwise>
								 E-mail não informado
							 </c:otherwise>
						 </c:choose>
					</td>
					<td>${contato.endereco}</td>
					<td>
						<fmt:formatDate value="${contato.dataNascimento.time}" 
										pattern="dd/MM/yyyy" />
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>