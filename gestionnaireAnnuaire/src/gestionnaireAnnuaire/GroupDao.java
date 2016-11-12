package gestionnaireAnnuaire;

import java.sql.SQLException;
import java.util.Collection;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

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
	 * @throws SQLException 
	 */
	Group findGroup(long id) throws SQLException;

	// modification ou ajout d'une nouvelle personne
	/**
	 * Add a group in the data base
	 * @param p A person
	 * @throws SQLException 
	 */
	void saveGroup(Group g) throws MySQLIntegrityConstraintViolationException, SQLException;

	/**
	 * Delete a group in the data base
	 * @param p A person
	 * @throws SQLException 
	 */
	void deleteGroup(Group g) throws MySQLIntegrityConstraintViolationException, SQLException;

	/**
	 * Update a Group with the new information of a Group in parameter
	 * @param g A new information of Group
	 * @throws SQLException 
	 */
	void updateGroup(Group g) throws MySQLIntegrityConstraintViolationException, SQLException;
}
