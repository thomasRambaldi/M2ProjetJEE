<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
	<h1>Liste des groupes</h1>

	<div class="container">
		<ul style="list-style-type: square">
			<c:forEach items="${groupsList}" var="groupInList">
				<li><a
					href="/gestionnaireAnnuaire/actions/person/showPersInGroup?id=${groupInList.idGroup}">
						${groupInList.nameGroup}</a>
					<c:if test="${connected != null}">
						<a
						href="/gestionnaireAnnuaire/actions/lists/deleteGroup?id=${groupInList.idGroup}">
							Supprimer</a>
					</c:if>
				</li>

			</c:forEach>
		</ul>
	</div>
	
	<c:if test="${connected != null}">
		<p>
			<a href="/gestionnaireAnnuaire/actions/group/addGroup">Ajouter un nouveau groupe</a>
		</p>
	</c:if>

</body>