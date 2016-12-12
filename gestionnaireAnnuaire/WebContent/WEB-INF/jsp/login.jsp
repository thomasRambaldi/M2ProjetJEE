<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authentification</title>
</head>
<body>

	<form:form method="POST" commandName="person">
		<table>
			<tr>
				<td>Email :</td>
				<td><form:input path="mail" /></td>
			</tr>
			<tr>
				<td>Mot de passe :</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Sign in"/></td>
				<td colspan="3"> 
					<a href="/gestionnaireAnnuaire/actions/person/signUp" >Sign up</a>
				</td>
			</tr>
		</table>
	</form:form>


</body>
</html>