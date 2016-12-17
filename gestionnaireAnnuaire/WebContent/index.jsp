<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/WEB-INF/jsp/include.jsp"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>

	<h1>Bonjour et bienvenue dans le gestionnaire d'annuaire</h1>

	<%-- rediriger le contrôleur hello --%>
<%-- 	<c:redirect url="/actions/connexion/login" /> --%>

	<p>Bienvenue sur la page d'annuaire</p>
	<a href="/gestionnaireAnnuaire/actions/connexion/login" >Accédez au site</a>
	<!--
	<a href="">Liste des personnes</a>
	
	<a href="">Liste des groupes</a>
	-->

</body>
</html>