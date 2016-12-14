<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vos informations</title>

</head>
<body>

	<h1>Vos informations</h1>


	<form:form method="POST" commandName="person">
		<table>
			<tr>
				<td>Numero : </td>
				<td>${personLogged.idPers}</td>
			</tr>
			<tr>
				<td>Groupe :</td>
				<td>${groupName.nameGroup}</td>
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
				<td><a href="${personLogged.web}">${personLogged.web}</a></td>
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
			<td><a href="editUser">Editer votre profile</a></td>
			<td><a href="/gestionnaireAnnuaire/actions/lists/personList">Liste des personnes</a></td>
			<td><a href="/gestionnaireAnnuaire/actions/lists/groupList">Liste des groupes</a></td>
			<td><a href="log_out">Deconnexion</a></td>
			</tr>
			<tr>
				<td>
					<a href="deleteAccount?id=${personLogged.idPers}">
						Supprimer votre compte</a>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
