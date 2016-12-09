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
	<h1>Liste des personnes présentent dans l'annuaires</h1>
		Salut
		<c:forEach items="${allPersons}" var="persList">
		coucou
			<ul>
			<li>${persList.firstName}</li>
		</ul>
		</c:forEach>
	
	<p>
		<a href="editPerson">Ajouter une nouvelle personne</a>
	</p>
	
</body>
</html>