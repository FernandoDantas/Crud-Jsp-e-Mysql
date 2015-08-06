<%@page import="br.com.exemplo.beans.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
</body>
<%
//List<Usuario> lista = usuDao.buscarTodos(usu);
List<Usuario> listaResultado = (List<Usuario>)request.getAttribute("lista");
%>
<table border="1">
<tr bgcolor="#eaeaea">
	<th>ID</th>
	<th>NOME</th>
	<th>EMAIL</th>
	<th>SENHA</th>
	<th>Data de Inscricao</th>
	<th>EXCLUIR</th>
	<th>ALTERAR</th>
</tr>
<%
for(Usuario u:listaResultado){
%>
<tr>
	<th><%=u.getId()%></th>
	<th><%=u.getNome() %></th>
	<th><%=u.getEmail()%></th>
	<th><%=u.getSenha()%></th>
	<th><%=u.getDatainscricao()%></th>	
	<th><a href="UsuarioController?acao=ex&id=<%=u.getId()%>">Excluir</a></th>
	<th><a href="UsuarioController?acao=alt&id=<%=u.getId()%>">Alterar</a></th>
</tr>
<% 
}
%>
</table>
</html>