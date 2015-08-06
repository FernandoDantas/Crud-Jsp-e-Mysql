<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>LOGAR NO SISTEMA</title>
</head>
<body>

	<fieldset>
	<legend>Efetuar Login</legend>
	<h1>Página de Login</h1>
	<form action="autenticador" method="post">
		<label>Email:</label>
		<input type="text" name="email" title="Coloque seu e-mail" placeholder="Informe seu e-mail" required><br><br>
		<label>Senha:</label>
		<input type="password" name="senha" title="Coloque sua senha" placeholder="Informe a senha" required><br>
		<input type="submit" value="Logar"><br>
	</form>
	</fieldset>
</body>
</html>