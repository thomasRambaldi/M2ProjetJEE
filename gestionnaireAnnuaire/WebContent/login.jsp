<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page d'authentification</title>
</head>
<body>
	<jsp:useBean id="person" scope="session" class="fr.gestionnaire.annuaire.Person"></jsp:useBean>
	<jsp:useBean id="error" scope="session" class="java.lang.String"></jsp:useBean>

	
	<span class="help-block" style="color:red"><% if(! error.equals(null)) out.print(error);%></span>
	<form action="login" method="post">
		<label><b>Login</b></label> <input type="text"
			placeholder="Entrez votre login" name="login"> <label><b>Password</b></label>
		<input type="password" placeholder="Entrez votre mot de passe" name="psw"
			>

		<button type="submit">Login</button>
	</form>
</body>
</html>