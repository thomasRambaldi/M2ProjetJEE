package gestionnaireAnnuaire;

import java.util.Collection;

public interface PersonDao {

	/* **************** */ 
	/*		Person		*/
	/* **************** */

	// récupérer les personnes
	Collection<Person> findAllPersons(long groupId);

	// lire une personne
	Person findPerson(long id);

	// modification ou ajout d'une nouvelle personne
	void savePerson(Person p);

	void deletePerson(Person p);


	/* **************** */ 
	/*		Group		*/
	/* **************** */
	
	// récupérer les groupes
	Collection<Group> findAllGroups();

	//Récupérer un groupe
	Group findGroup(long id);

	// modification ou ajout d'une nouvelle personne
	void saveGroup(Group g);

	void deleteGroup(Group g);

	//	   ...

}