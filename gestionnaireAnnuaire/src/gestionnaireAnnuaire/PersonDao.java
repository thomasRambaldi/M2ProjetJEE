package gestionnaireAnnuaire;

import java.util.Collection;

public interface PersonDao {

	/* **************** */ 
	/*		Person		*/
	/* **************** */

	// récupérer les personnes
	/**
	 * Return all people in a group
	 * @param groupId group who contains people
	 * @return return all people in a group
	 */
	Collection<Person> findAllPersons(long groupId);

	// lire une personne
	/**
	 * Return one person with him id
	 * @param id The identifiant of the person
	 * @return return the person with this id
	 */
	Person findPerson(long id);

	// modification ou ajout d'une nouvelle personne
	/**
	 * Add a person in the data base
	 * @param p A person
	 */
	void savePerson(Person p);

	/**
	 * Delete a person in the data base
	 * @param p A person
	 */
	void deletePerson(Person p);

	/**
	 * Update a person with the new information of a Person in parameter
	 * @param p A new information of Person
	 */
	void updatePerson(Person p);

	//	   ...

}