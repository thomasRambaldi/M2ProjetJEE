<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
	<h1>Informations sur les personnes qui sont dans le groupe</h1>

	<div class="container">
		<ul style="list-style-type: square">
			<c:forEach items="${persInGroup}" var="persInGroup">
				<li><a
					href="/gestionnaireAnnuaire/actions/person/showPerson?id=${persInGroup.idPers}">
							${persInGroup.lastName} ${persInGroup.firstName}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>