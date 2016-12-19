<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
<h1>Resultats de la recherche</h1>

<c:if test="${resultSearchGroup != null}">
	<a href="#groupes" class="btn btn-default">Descendre vers les groupes
		trouvés</a>
</c:if>

<c:if test="${resultSearchPerson != null}">
	<h3 id="personnes">Personnes trouvées</h3>
</c:if>
<c:if test="${resultSearchPerson == null}">
	<h3>Aucunes personnes trouvées</h3>
</c:if>
<div class="container">
	<ul style="list-style-type: square">
		<c:forEach items="${resultSearchPerson}" var="personFound">
			<li><a
				href="/gestionnaireAnnuaire/actions/person/showPerson?id=${personFound.idPers}">
					${personFound.firstName} ${personFound.lastName} </a></li>
		</c:forEach>
	</ul>
</div>

<c:if test="${resultSearchPerson != null}">
	<a href="#personnes" class="btn btn-default">Remonter aux personnes
		trouvées</a>
</c:if>

<c:if test="${resultSearchGroup != null}">
	<h3 id="groupes">Groupes trouvés</h3>
</c:if>
<c:if test="${resultSearchGroup == null}">
	<h3>Aucuns groupes trouvés</h3>
</c:if>
<div class="container">
	<ul style="list-style-type: square">
		<c:forEach items="${resultSearchGroup}" var="groupFound">
			<li><a
				href="/gestionnaireAnnuaire/actions/person/showPersInGroup?id=${groupFound.idGroup}">
					${groupFound.nameGroup} </a></li>
		</c:forEach>
	</ul>
</div>

</body>
</html>