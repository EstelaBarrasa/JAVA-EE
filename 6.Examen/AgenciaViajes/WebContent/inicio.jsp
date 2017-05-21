<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido</title>
<link rel="stylesheet" type="text/css" href="CSS/Style.css" />
</head>
<body>
	<h1>Agencia de Viajes</h1>
	<div>Numero de usuarios en el sito web:
		${applicationScope.numeroUsuarios}
	</div>
	
	<div>
	${initParam.Promocion}<br>
	</div>

	
	<div>
		<table>
			<tr>
				<td><a href="Listar">Listado completo de viajes</a></td>
			</tr>
			<tr>
				<td><a href="formulario.jsp">Busqueda de viajes</a></td>
			</tr>
		</table>
	</div>
</body>
</html>