<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authentification</title>
<link type="text/css" rel="stylesheet" href="form.css" />
</head>

<body>
	<div align="center">
		<form method="post" action="Connexion">
			<fieldset>
				<legend>Authentification</legend>
				<p>Vous pouvez vous authentifier via ce formulaire.</p>
	
				<label for="email">Adresse email : </label>
				<input type="text" id="email" name="loginuser" value="" size="30" maxlength="100" /> <br /> 
				
				<label for="password">Mot de passe : </label> 
				<input type="password" id="pwd" name="pwduser" value="" size="30" maxlength="20" /> <br /> 
				
				<input type="submit" value="Submit" class="sansLabel" /> <br />
	
			</fieldset>
		</form>
	</div>
</body>

</html>