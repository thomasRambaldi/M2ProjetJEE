<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
	<h1>${groupCurrentlyViewed.nameGroup} </h1>
	<h3>Liste des personnes présentes dans ce groupe</h3>

	<div class="container">
		<ul style="list-style-type: square">
			<c:forEach items="${persInGroup}" var="persInGroup">
				<li><a
					href="/gestionnaireAnnuaire/actions/person/showPerson?id=${persInGroup.idPers}">
							${persInGroup.firstName} ${persInGroup.lastName}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>