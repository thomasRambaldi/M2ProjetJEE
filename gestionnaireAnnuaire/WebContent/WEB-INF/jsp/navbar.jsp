<nav class="navbar navbar-light bg-faded">
<a class="navbar-brand">Gestionnaire d'annuaire</a>
  <ul class="nav navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="/gestionnaireAnnuaire">Accueil <span class="sr-only">(current)</span></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/gestionnaireAnnuaire/actions/connexion/login">Se connecter</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/gestionnaireAnnuaire/actions/lists/personList">Liste des personnes</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/gestionnaireAnnuaire/actions/lists/groupList">Liste des groupes</a>
    </li>
    <c:if test="${personLogged != null}">
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="supportedContentDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Mon compte</a>
      <div class="dropdown-menu" aria-labelledby="supportedContentDropdown">
      <a class="dropdown-item " href="/gestionnaireAnnuaire/actions/connexion/user">Votre profil</a> </br>
 	  <a class="dropdown-item " href="/gestionnaireAnnuaire/actions/connexion/log_out">Se deconnecter</a>
      </div>
    </li>
    </c:if>
  </ul>
  <form class="form-inline float-xs-right" action="/gestionnaireAnnuaire/actions/connexion/search" method="get">
    <input class="form-control" name="personSearcher" type="text" placeholder="Rechercher une personne">
    <button class="btn btn-outline-success" type="submit">Rechercher</button>
  </form>
</nav>