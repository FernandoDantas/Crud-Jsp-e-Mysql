<%@page import="br.com.exemplo.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>P�gina Inicial</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Curso Java Web!</h1>
<%
	Usuario usuAutenticado = (Usuario)session.getAttribute("usuAutenticado");
	out.print("Sej� Bem Vindo(a)! "+usuAutenticado.getNome());	
%>
</body>
</html>