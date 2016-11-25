<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="fr.gestionnaire.annuaire.Person"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Information sur l'utilisateur</title>
</head>

<body>


	<%
		Person user = (Person) session.getAttribute("user");
	%>

	<h1>Information sur l'utilisateur</h1>
	<ul>
		<li>Numéro étudiant : <%=user.getId() %></li>
		<li>Numéro Groupe : <%=user.getIdGroup() %></li>
		<li>Prénom : <%=user.getFirstName() %></li>
		<li>Nom : <%=user.getLastName() %></li>
		<li>Email : <%=user.getMail() %></li>
		<li>Naissance : <%=user.getNaissance() %></li>
		<li>Page web : <%=user.getWeb() %></li>
		<li>Mot de passe: <%=user.getPassword() %></li>
	</ul>




</body>
</html>