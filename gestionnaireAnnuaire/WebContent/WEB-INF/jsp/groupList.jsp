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
	<h1>Liste des groupes</h1>
	<table border='1'>
		<c:forEach items="${groups}" var="group">
			<tr>
				<td>
					<a href="${group}?id=${group.idPers}"> 
					<c:out value="${group.idGroup}" /></a>
				</td>
				<td>
					<c:out value="${group.firstName}" />
				</td>
				<td>
					<c:out value="${group.lastName}" />
				</td>
								<td>
					<c:out value="${group.mail}" />
				</td>
								<td>
					<c:out value="${group.web}" />
				</td>
								<td>
					<c:out value="${group.naissance}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<p>
		<a href="${group}">Ajouter un nouveau groupe</a>
	</p>
	
</body>
</html>