<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inscription</title>
</head>
<body>

	<h1>Inscription</h1>

	<form:form method="POST" commandName="person">
		<table>
			<tr>
				<td>Numero :</td>
				<td><form:input path="idPers"  /></td>

				<td><small class="errors help-block"><form:errors
							path="idPers" cssClass="error" /></small></td>
			</tr>
			<tr>
				<td>Groupe :</td>
				<td><form:input path="idGroup"  /></td>
				<td><small class="errors help-block"><form:errors
							path="idGroup" cssClass="error" /></small></td>
			</tr>
			<tr>
				<td>Prénom :</td>
				<td><form:input path="firstName" /></td>
				<td><small class="errors help-block"><form:errors
							path="firstName" cssClass="error" /></small></td>
			</tr>

			<tr>
				<td>Nom :</td>
				<td><form:input path="lastName" /></td>
				<td><small class="errors help-block"><form:errors
							path="lastName" cssClass="error" /></small></td>
			</tr>

			<tr>
				<td>Email :</td>
				<td><form:input path="mail" /></td>
				<td><small class="errors help-block"><form:errors
							path="mail" cssClass="error" /></small></td>
			</tr>

			<tr>
				<td>Site web :</td>
				<td><form:input path="web" /></td>
				<td><small class="errors help-block"><form:errors
							path="web" cssClass="error" /></small></td>
			</tr>

			<tr>
				<td>Naissance :</td>
				<td><form:input path="naissance" /></td>
				<td><small class="errors help-block"><form:errors
							path="naissance" cssClass="error" /></small></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><form:input path="password" /></td>
				<td><small class="errors help-block"><form:errors
							path="password" cssClass="error" /></small></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>
