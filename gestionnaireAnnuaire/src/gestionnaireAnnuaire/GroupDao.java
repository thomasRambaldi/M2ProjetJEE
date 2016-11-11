package gestionnaireAnnuaire;

import java.util.Collection;

public interface GroupDao {

	/* **************** */ 
	/*		Group		*/
	/* **************** */

	// récupérer les groupes
	/**
	 * Return all group
	 * @return return all group
	 */
	Collection<Group> findAllGroups();

	//Récupérer un groupe
	/**
	 * Return one group with him id
	 * @param id The identifiant of the group
	 * @return return the group with this id
	 */
	Group findGroup(long id);

	// modification ou ajout d'une nouvelle personne
	/**
	 * Add a group in the data base
	 * @param p A person
	 */
	void saveGroup(Group g);

	/**
	 * Delete a group in the data base
	 * @param p A person
	 */
	void deleteGroup(Group g);

	/**
	 * Update a Group with the new information of a Group in parameter
	 * @param g A new information of Group
	 */
	void updateGroup(Group g);
}
