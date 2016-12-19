<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

	<h1>Bienvenue ${personLogged.firstName} ${personLogged.lastName}</h1>

	<h3>Vos informations</h3>
	<form:form method="POST" commandName="person">
		<table>
			<tr>
				<td>Numero : </td>
				<td>${personLogged.idPers}</td>
			</tr>
			
			<tr>
				<td>Groupe :</td>
				<td>${groupPersonLogged.nameGroup}</td>
			</tr>
			
			<tr>
				<td>Nom :</td>
				<td>${personLogged.firstName}</td>
			</tr>

			<tr>
				<td>Prénom :</td>
				<td>${personLogged.lastName}</td>
			</tr>

			<tr>
				<td>Email :</td>
				<td>${personLogged.mail}</td>
			</tr>

			<tr>
				<td>Site web :</td>
				<td><a target="_blank" href="http://www.${personLogged.web}">${personLogged.web}</a></td>
			</tr>


			<tr>
				<td>Naissance :</td>
				<td>${personLogged.naissance}</td>
			</tr>

			<tr>
				<td>Mot de passe :</td>
				<td>${personLogged.password}</td>
			</tr>

			<tr>
			<td><a href="editUser" class="btn btn-default">Editer votre profil</a></td>
			<td><a href="/gestionnaireAnnuaire/actions/lists/personList" class="btn btn-info" >Liste des personnes</a></td>
			<td><a href="/gestionnaireAnnuaire/actions/lists/groupList" class="btn btn-info">Liste des groupes</a></td>
			<td><a href="log_out" class="btn btn-warning">Deconnexion</a></td>
			<td>
					<a href="deleteAccount?id=${personLogged.idPers}" class="btn btn-danger">
						Supprimer votre compte</a>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
