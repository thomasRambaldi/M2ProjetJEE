<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" scope="session" class="fr.gestionnaire.annuaire.Person">
		<p>Vos informations :</p>
	</jsp:useBean>



	<table style="border: solid 1px black">
		<tr>
			<td><%= person.getId() %></td>
			<td><%= person.getFirstName() %>
			<td><%= person.getLastName() %></td>
			<td><%= person.getMail() %></td>
			<td><%= person.getWeb() %></td>
			<td><%= person.getNaissance() %></td>
			<td><%= person.getPassword() %></td>
		</tr>
	</table>
	<a href='login.jsp'>Authentification</a>
</body>
</html>