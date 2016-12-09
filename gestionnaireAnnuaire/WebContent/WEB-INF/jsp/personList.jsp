<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/WEB-INF/jsp/include.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des personnes présentent dans l'annuaire</title>
</head>

<body>
	<h1>Liste des personnes</h1>
	<table border='1'>
		<c:forEach items="${persons}" var="pers">
			<tr>
				<td>
					<a href="${pers}?id=${pers.idPers}"> 
					<c:out value="${pers.idGroup}" /></a>
				</td>
				<td>
					<c:out value="${pers.firstName}" />
				</td>
				<td>
					<c:out value="${pers.lastName}" />
				</td>
								<td>
					<c:out value="${pers.mail}" />
				</td>
								<td>
					<c:out value="${pers.web}" />
				</td>
								<td>
					<c:out value="${pers.naissance}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<p>
		<a href="${pers}">Ajouter une nouvelle personne</a>
	</p>
	
</body>
</html>