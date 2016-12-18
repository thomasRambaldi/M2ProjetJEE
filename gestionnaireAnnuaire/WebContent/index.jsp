<%@ include file="/WEB-INF/jsp/header.jsp"%>

<h1>Accueil</h1>

<%-- rediriger le contrôleur hello --%>
<%-- 	<c:redirect url="/actions/connexion/login" /> --%>

<p>Bienvenue sur la page d'accueil du gestionnaire d'annuaire des
	étudiants de master informatique de l'université d'Aix-Marseille</p>
<p>Vous pouvez effectuer les actions suivantes :</p>
<ul class="table table-striped table-hover ">
	<li>S'inscrire au site</li>
	<li>Visualiser les personnes inscrites dans l'annuaire</li>
	<li>Visualiser les groupes disponibles dans l'annuaire</li>
	<li>Acceder à plus d'informations sur les personnes inscrites au
		site en vous connectant</li>
</ul>
<a href="/gestionnaireAnnuaire/actions/connexion/inscription">Vous pouvez vous inscrire ici</a>
<!--
	<a href="">Liste des personnes</a>
	
	<a href="">Liste des groupes</a>
	-->

</body>
</html>