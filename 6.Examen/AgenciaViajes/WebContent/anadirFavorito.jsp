<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Viajes favoritos</title>
<link rel="stylesheet" type="text/css" href="CSS/Style.css" />
</head>
<body>
	<div>Viaje favorito guardado con éxito</div>
	<h1>Lista de viajes favoritos</h1>
	<div>
		<table>
			<c:forEach items="${sessionScope.favoritos}" var="viaje">
				<tr>
					<td>${viaje.destino}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<a href="Inicio">Inicio.</a>
</body>
</html>