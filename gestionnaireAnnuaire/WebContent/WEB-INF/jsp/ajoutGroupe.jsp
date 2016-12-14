<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

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
				<td colspan="3"><input type="submit" class="btn btn-warning" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>
