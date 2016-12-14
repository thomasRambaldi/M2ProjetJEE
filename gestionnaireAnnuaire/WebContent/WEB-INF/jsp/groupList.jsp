<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des groupes</title>
</head>

<body>
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