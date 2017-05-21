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
<div>Contenido del carrito</div>
<table>
<tr>
			<td>ID</td>
			<td>Nombre</td>
			<td>Precio</td>
		</tr>
		<c:forEach items="${carrito}" var="producto">
			<tr>
				<td>${producto.idProducto}</td>
				<td>${producto.nombre}</td>
				<td>${producto.precio}</td>
			</tr>
		</c:forEach>
</table>
<div>Precio total a pagar: ${precioTotal}</div>
<a href="index.jsp">Volver</a>
</body>
</html>