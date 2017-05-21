<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE htm>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busqueda</title>
<link rel="stylesheet" type="text/css" href="CSS/Style.css" />
</head>
<body>
	<h1>Busqueda de viajes</h1>
	<div>
		<form action="Buscar" method="POST">
			<label for="palabra">Destino a buscar: </label> <input type="text"
				name="palabra" placeholder="destino aquí" />
			<button type="submit">Buscar</button>
		</form>
	</div>
</body>
</html>