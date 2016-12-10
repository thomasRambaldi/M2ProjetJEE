<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des personne dans le groupe</title>
</head>

<body>
	<h1>Informations sur les personnes qui sont dans le groupe</h1>

	<div class="container">
		<ul style="list-style-type: square">
			<c:forEach items="${persInGroup}" var="persInGroup">
				<li><a
					href="/Annuaire/actions/person/showPersInGroup?id=${persInGroup.idGroup}">
							${persInGroup.lastName} ${persInGroup.firstName}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>