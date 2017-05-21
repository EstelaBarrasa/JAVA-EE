<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="background-color:red;">${initParam.OfertaMes}</div>
<%-- initParam contiene lox parametros definidos en web.xml como context-param --%>
<a href="ServletTienda?opcion=1">Listar productos</a>
<br/>
<a href="formulario.jsp">Mostrar un producto</a>
</body>
</html>