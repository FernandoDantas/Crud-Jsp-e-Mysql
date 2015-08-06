<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar</title>
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
<form action="SalvoCadastro.jsp" method="post">
	<label>Nome:</label>
	<input type="text" name="nome" title="coloque seu nome" placeholder="informe seu nome" required><br><br>
	<label>Email:</label>
	<input type="text" name="email" title="coloque seu email" placeholder="informe seu email" required><br><br>
	<label>Senha:</label>
	<input type="password" name="senha" title="coloque sua senha" placeholder="informe sua senha" required><br><br>
	<label>Data de Inscrição:</label>
	<input type="text" name="data" onkeypress="mascaraData(this);" maxlength="10" title="Coloque a data" placeholder="Informe a data" required"><br><br>
	
	<input type="submit" value="Cadastrar">
</form>
</body>
</html>