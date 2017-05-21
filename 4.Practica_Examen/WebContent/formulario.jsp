<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletTienda" method="POST">
	<input type="hidden" name="opcion" value="2" />
	<label for="idProducto">identificador del producto: </label>
	<input type="number" name="idProducto" placeholder="ID del producto aqui"/>
	<button type="submit">Ver</button>
</form>
</body>
</html>