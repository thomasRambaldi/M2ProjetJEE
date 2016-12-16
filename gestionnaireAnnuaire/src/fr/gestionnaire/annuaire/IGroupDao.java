package fr.gestionnaire.annuaire;

import java.sql.SQLException;
import java.util.Collection;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import exceptions.DaoException;

public interface IGroupDao {

	/* **************** */ 
	/*		Group		*/
	/* **************** */

	// r�cup�rer les groupes
	/**
	 * Return all group
	 * @return return all group
	 * @throws SQLException 
	 */
	Collection<Group> findAllGroups() throws SQLException;

	//R�cup�rer un groupe
	/**
	 * Return one group with him id
	 * @param id The identifiant of the group
	 * @return return the group with this id
	 * @throws SQLException 
	 */
	Group findGroup(long id) throws SQLException;
	
	/**
	 * Return one group with him id
	 * @param id The identifiant of the group
	 * @return return the group with this id
	 * @throws SQLException 
	 */
	Group findGroup(String name) throws SQLException;

	// modification ou ajout d'une nouvelle personne
	/**
	 * Add a group in the data base
	 * @param p A person
	 * @throws SQLException 
	 * @throws DaoException 
	 */
	void saveGroup(Group g) throws MySQLIntegrityConstraintViolationException, SQLException, DaoException;

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
	 * @throws DaoException 
	 */
	void updateGroup(Group g, int idGrp) throws MySQLIntegrityConstraintViolationException, SQLException, DaoException;

}
