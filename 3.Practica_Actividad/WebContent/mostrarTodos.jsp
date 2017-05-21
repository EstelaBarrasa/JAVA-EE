<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div>Hola: ${nombreusuario}</div>
		<div>${oferta}</div>
		<div>Listado de productos</div>
		<table>
			<tr>
				<td>ID</td>
				<td>NOMBRE</td>
				<td>PRECIO</td>
				<td></td>
			</tr>
			<c:forEach items="${lista}" var="producto">
				<tr>
					<td>"${producto.id}" </td>
					<td>"${producto.nombre}" </td>
					<td>"${producto.precio}"</td>
					<td>
						<form action="ServletTienda" method="POST">
							<input type="hidden" name="opcion" value="3"/>
							<input type="hidden" name="id" value="${producto.id}" />
							<button type="submit">Añadir al carrito</button>
						</form>
					</td>	
				</tr>
			</c:forEach>
		</table>
		<a href="index.jsp">Volver</a>
</body>
</html>