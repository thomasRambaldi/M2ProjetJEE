<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informations de la personne</title>
</head>
<body>
	<h1>Les informations de la personne selectionner</h1>

	<form:form method="POST" commandName="person">
		<table>
			<tr>
				<td>Numero :</td>
				<td>${infoPerson.idPers}</td>
			</tr>
			<tr>
				<td>Groupe :</td>
				<td>${infoPerson.idGroup}</td>
			</tr>
			<tr>
				<td>Nom :</td>
				<td>${infoPerson.firstName}</td>
			</tr>

			<tr>
				<td>Prénom :</td>
				<td>${infoPerson.lastName}</td>
			</tr>

			<c:if test="${connected != null}">
				<tr>
					<td>Email :</td>
					<td>${infoPerson.mail}</td>
				</tr>
			</c:if>

			<tr>
				<td>Site web :</td>
				<td><a href="${infoPerson.web}">${infoPerson.web}</a></td>
			</tr>

			<c:if test="${connected != null}">
				<tr>
					<td>Naissance :</td>
					<td>${infoPerson.naissance}</td>
				</tr>
			</c:if>

		</table>
	</form:form>
</body>
</html>