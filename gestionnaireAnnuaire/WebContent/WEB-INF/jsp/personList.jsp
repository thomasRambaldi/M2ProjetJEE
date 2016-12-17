<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
	<h1>Liste des personnes</h1>

	<div class="container">
		<ul style="list-style-type: square">
			<c:forEach items="${personsList}" var="personInList">
				<li><a
					href="/gestionnaireAnnuaire/actions/person/showPerson?id=${personInList.idPers}">
						${personInList.lastName} ${personInList.firstName} </a> <c:if
						test="${connected != null}">
						<a
							href="/gestionnaireAnnuaire/actions/lists/deletePerson?id=${personInList.idPers}">
							Supprimer</a>
					</c:if></li>
			</c:forEach>
		</ul>
	</div>

	<c:if test="${connected != null}">
		<p>
			<a href="redirect:/gestionnaire/actions/person/editPerson">Ajouter une nouvelle personne</a>
		</p>
	</c:if>

</body>
</html>