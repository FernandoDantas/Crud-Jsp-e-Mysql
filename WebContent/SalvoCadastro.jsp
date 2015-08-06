<%@page import="jdk.nashorn.internal.runtime.ParserException"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.exemplo.jdbc.UsuarioDAO"%>
<%@page import="br.com.exemplo.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página - Salvar Cadastro</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<%
	String snome = request.getParameter("nome");
	String semail = request.getParameter("email");
	String ssenha = request.getParameter("senha");	
	String sdata = request.getParameter("data");	
	try{
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	Date data = new Date(format.parse(sdata).getTime());
	
	Usuario usu = new Usuario();
	usu.setNome(snome);
	usu.setEmail(semail);
	usu.setSenha(ssenha);
	usu.setDatainscricao(data);
	
	UsuarioDAO usuDao = new UsuarioDAO();
	usuDao.cadastro(usu);
	}catch(ParserException e){
		out.print("Erro de Data - "+e.getMessage());
	}
	
	%>
	
	<h1>Salvo com Sucesso!</h1>	
</body>
</html>