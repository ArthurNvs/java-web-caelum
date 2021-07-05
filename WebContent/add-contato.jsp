<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="custom" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="css/jquery.css" rel="stylesheet">
		<script src="js/jquery.js"></script>
		<script src="js/jquery-ui.js"></script>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		<form action="add">
			Nome: <input type="text" name="nome" /> <br/>
			Email: <input type="text" name="email" /> <br/>
			Endereço: <input type="text" name="endereco" /><br/>
			Data de Nascimento: <custom:campoData id="nascimento" /> <br/>
			
			<input type="submit" value="Salvar" />
		</form>
	</body>
</html>
