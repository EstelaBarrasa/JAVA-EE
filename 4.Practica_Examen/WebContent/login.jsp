<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletTienda" method="POST"> 
	<input type="hidden" name="opcion" value="4" />
	<label for="nombre">Nombre:</label>
	<input type="text" name="nombre" placeholder="Su nombre aquí"/>
	<br/>
	<button type="submit">Enviar</button>
</form>
</body>
</html>