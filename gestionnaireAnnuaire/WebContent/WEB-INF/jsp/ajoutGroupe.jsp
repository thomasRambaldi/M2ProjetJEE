<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajout d'un groupe</title>
</head>
<body>

	<h1>Ajout d'un groupe</h1>

	<form:form method="POST" commandName="group">
		<table>
			<tr>
				<td>Numero groupe :</td>
				<td><form:input path="idGroup" /></td>
				<td><small class="errors help-block"><form:errors
							path="idGroup" cssClass="error" /></small></td>
			</tr>
			<tr>
				<td>Nom du groupe :</td>
				<td><form:input path="nameGroup" /></td>
				<td><small class="errors help-block"><form:errors
							path="nameGroup" cssClass="error" /></small></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>
