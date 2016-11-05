package gestionAnnuaire;

import java.util.Collection;

public interface PersonDao {

	   // r�cup�rer les groupes
	   Collection<Group> findAllGroups();

	   // r�cup�rer les personnes
	   Collection<Person> findAllPersons(long groupId);

	   // lire une personne
	   Person findPerson(long id);

	   // modification ou ajout d'une nouvelle personne
	   void savePerson(Person p);

	   // modification ou ajout d'une nouvelle personne
	   void saveGroup(Group g);

	   void deletePerson(Person p);
	   
	   void deleteGroup(Group g);
	   
//	   ...
	   
}