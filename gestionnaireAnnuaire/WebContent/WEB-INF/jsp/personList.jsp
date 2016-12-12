<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des personnes</title>
</head>



<body>
	<h1>Liste des personnes</h1>

	<div class="container">
		<ul style="list-style-type: square">
			<c:forEach items="${personsList}" var="personInList">
				<li><a
					href="/gestionnaireAnnuaire/actions/person/showPerson?id=${personInList.idPers}">
						${personInList.lastName} ${personInList.firstName} </a> 
					<a
					href="/gestionnaireAnnuaire/actions/lists/deletePerson?id=${personInList.idPers}">
						Supprimer</a></li>
			</c:forEach>
		</ul>
	</div>
	<p>
		<a href="editPerson">Ajouter une nouvelle personne</a>
	</p>

</body>
</html>