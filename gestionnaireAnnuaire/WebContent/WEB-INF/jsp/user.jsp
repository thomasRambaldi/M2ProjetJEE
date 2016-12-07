<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- <c:url var="editUser" value="/actions/connexion/editUser" /> -->


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vos informations</title>
</head>
<body>

	<form:form method="POST" commandName="person">
		<table>
			<tr>
				<td>Numero :</td>
				<td>${personne.idPers}/></td>
			</tr>
			<tr>
				<td>Groupe :</td>
				<td>${personne.idGroup}</td>
			</tr>
			<tr>
				<td>Nom :</td>
				<td>${personne.firstName}</td>
			</tr>

			<tr>
				<td>Prénom :</td>
				<td>${personne.lastName}</td>
			</tr>

			<tr>
				<td>Email :</td>
				<td>${personne.mail}</td>
			</tr>

			<tr>
				<td>Site web :</td>
				<td>${personne.web}</td>
			</tr>

			<tr>
				<td>Naissance :</td>
				<td>${personne.naissance}</td>
			</tr>

			<tr>
				<td>Password :</td>
				<td>${personne.password}</td>
			</tr>

			<tr>
				<td colspan="3"><p><a href="${editUser}">Editer votre profile</a></p></td>
			</tr>

		</table>
	</form:form>
</body>
</html>
