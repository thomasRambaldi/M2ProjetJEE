<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<h1>Sections de tests</h1>
<p>Ici vous pouvez tester le gestionnaire d'annuaire en lui ajoutant
	3000 personnes aléatoires réparties dans 300 groupes</p>
<p>Votre base de données doit être une base de données MySQL et les
	informations de connection doivent être renseignées dans le fichier
	springapp-servlet.xml</p>
<p>Avant de générer les données de test il faut que votre base de
	données soit préparée de la manière suivante :</p>
<div>
	<ul>
		<li>Une table groupe composée de deux attributs : idGroup
			(entier) et nomGroup(varchar)</li>
		<li>Une table personne composée de plusieurs attributs : idPers
			(entier), idGroup(entier), NomPers,
			 PrenomPers, MailPers, WebPers, NaissancePers et MdpPers (tous varchar)</li>
	</ul>
</div>

<p>Une fois les données générées, vous pourrez vous connecter à l'un des 3000 comptes en vous connectant avec l'adresse mail : [prenom][id]@gmail.com et le mot de passe : test</p>
<p>Attention vous ne devez pas avoir de personnes disposant d'un id entre 10 et 3010 dans votre base de données, cela vaut également pour les groupes il ne faut pas d'id de groupe entre 10 et 310 inclu</p>
<a
	href="/gestionnaireAnnuaire/actions/connexion/testAddPersonsAndGroups"
	class="btn btn-danger">Ajouter les personnes et les groupes de
	tests</a>
<a href="/gestionnaireAnnuaire/actions/connexion/deleteTestPersonsAndGroups"
	class="btn btn-warning">Supprimer les données de test générées</a>
</body>
</html>