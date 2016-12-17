<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
<h1>Resultat de la recherche</h1>

<div class="container">
	<ul style="list-style-type: square">
		<c:forEach items="${resultSearchPerson}" var="personFound">
			<li><a
				href="/gestionnaireAnnuaire/actions/person/showPerson?id=${personFound.idPers}">
					${personFound.lastName} ${personFound.firstName} </a></li>
		</c:forEach>
	</ul>
</div>

</body>
</html>