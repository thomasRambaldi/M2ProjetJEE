<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vos informations</title>
</head>
<body>

	<h1>Vos information</h1>
	<form:form method="POST" commandName="person">
		<table>
			<tr>
				<td>Numero : </td>
				<td>${personLogged.idPers}</td>
			</tr>
			<tr>
				<td>Groupe :</td>
				<td>${personLogged.idGroup}</td>
			</tr>
			<tr>
				<td>Nom :</td>
				<td>${personLogged.firstName}</td>
			</tr>

			<tr>
				<td>Prénom :</td>
				<td>${personLogged.lastName}</td>
			</tr>

			<tr>
				<td>Email :</td>
				<td>${personLogged.mail}</td>
			</tr>

			<tr>
				<td>Site web :</td>
				<td>${personLogged.web}</td>
			</tr>

			<tr>
				<td>Naissance :</td>
				<td>${personLogged.naissance}</td>
			</tr>

			<tr>
				<td>Password :</td>
				<td>${personLogged.password}</td>
			</tr>

			<tr>
			<td><a href="${personLogged}">Editer votre profile</a></td>
			<td><a href="${personLogged}">Liste des personnes</a></td>
			<td><a href="${personLogged}">Liste des groupes</a></td>
			<!-- 
				<td colspan="3"><input type="submit" /></td>
 			-->
			</tr>
		</table>
	</form:form>
</body>
</html>
