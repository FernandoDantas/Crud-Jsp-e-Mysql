<%@page import="br.com.exemplo.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Cadastro</title>
<script language="JavaScript" type="text/javascript">
   function mascaraData(campoData){
              var data = campoData.value;
              if (data.length == 2){
                  data = data + '/';
                  document.forms[0].data.value = data;
      return true;              
              }
              if (data.length == 5){
                  data = data + '/';
                  document.forms[0].data.value = data;
                  return true;
              }
         }
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include><br>
<%
  Usuario usu =(Usuario)request.getAttribute("usuario");
%>
<form action="UsuarioController" method="post">
	<input type="hidden" name="acao" value="salvar">
	
    <label>ID:</label>
	<input size="5" type="text" name="id" title="Seu Código" placeholder="Seu Código" readonly="readonly" value="<%=usu.getId()%>"><br><br>
	<label>Nome:</label>
	<input type="text" name="nome" title="coloque o nome" placeholder="Informe o nome" required value="<%=usu.getNome()%>"><br><br>
	<label>Email:</label>
	<input type="text" name="email" title="coloque o email" placeholder="Informe o email" required value="<%=usu.getEmail()%>"><br><br>
	<label>Senha:</label>
	<input type="password" name="senha" title="Coloque a senha" placeholder="Informe a senha" required value="<%=usu.getSenha()%>"><br><br>
	<label>Data de Inscrição:</label>
	<input type="text" name="data" onkeypress="mascaraData(this);" maxlength="10" title="Coloque a data" placeholder="Informe a data" required value="<%=usu.getDatainscricao()%>"><br><br>
	
	<input type="submit" value="Alterar">
</form>
</body>
</html>