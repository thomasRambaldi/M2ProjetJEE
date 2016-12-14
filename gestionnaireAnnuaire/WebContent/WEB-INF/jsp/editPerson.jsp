<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

	<h1>Éditer une personne</h1>
	
	<form:form method="POST" commandName="person">
		<table>
			<tr>
				<td>Numero : </td>
				<td><form:input path="idPers" value="${personLogged.idPers}"/></td>
			</tr>
			<tr>
				<td>Groupe :</td>
				<td><form:input path="idGroup" value="${personLogged.idGroup}"/></td>
			</tr>
			<tr>
				<td>Nom :</td>
				<td><form:input path="firstName" value="${personLogged.firstName}"/></td>
			</tr>

			<tr>
				<td>Prénom :</td>
				<td><form:input path="lastName" value="${personLogged.lastName}"/></td>
			</tr>

			<tr>
				<td>Email :</td>
				<td><form:input path="mail" value="${personLogged.mail}"/></td>
			</tr>

			<tr>
				<td>Site web :</td>
				<td><form:input path="web" value="${personLogged.web}"/></td>
			</tr>

			<tr>
				<td>Naissance :</td>
				<td><form:input path="naissance" value="${personLogged.naissance}"/></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><form:input path="password" value="${personLogged.password}"/></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>