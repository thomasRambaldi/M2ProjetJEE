<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
	<h1>Les informations de ${infoPerson.firstName} ${infoPerson.lastName}</h1>

	<form:form method="POST" commandName="person">
		<table>
			<tr>
				<td>Numero :</td>
				<td>${infoPerson.idPers}</td>
			</tr>
			
			<tr>
				<td>Groupe :</td>
				<td>${groupPersonListed.nameGroup}</td>
			</tr>
			<tr>
				<td>Prénom :</td>
				<td>${infoPerson.firstName}</td>
			</tr>

			<tr>
				<td>Nom :</td>
				<td>${infoPerson.lastName}</td>
			</tr>

			<c:if test="${personLogged != null}">
				<tr>
					<td>Email :</td>
					<td>${infoPerson.mail}</td>
				</tr>
			</c:if>

			<tr>
				<td>Site web :</td>
				<td><a target="_blank" href="http://www.${infoPerson.web}">${infoPerson.web}</a></td>
			</tr>

			<c:if test="${personLogged != null}">
				<tr>
					<td>Naissance :</td>
					<td>${infoPerson.naissance}</td>
				</tr>
			</c:if>

		</table>
	</form:form>
</body>
</html>