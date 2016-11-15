package gestionnaireAnnuaire;

import java.sql.SQLException;
import java.util.Collection;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public interface IPersonDao {

	/* **************** */ 
	/*		Person		*/
	/* **************** */

	// r�cup�rer les personnes
	/**
	 * Return all people in a group
	 * @param groupId group who contains people
	 * @return return all people in a group
	 * @throws SQLException 
	 */
	Collection<Person> findAllPersons(long groupId) throws SQLException;

	// lire une personne
	/**
	 * Return one person with him id
	 * @param id The identifiant of the person
	 * @return return the person with this id
	 * @throws SQLException 
	 */
	Person findPerson(long id) throws SQLException;

	// modification ou ajout d'une nouvelle personne
	/**
	 * Add a person in the data base
	 * @param p A person
	 * @return 
	 * @throws SQLException 
	 */
	void savePerson(Person p) throws MySQLIntegrityConstraintViolationException, SQLException;

	/**
	 * Delete a person in the data base
	 * @param p A person
	 * @throws SQLException 
	 */
	void deletePerson(Person p) throws MySQLIntegrityConstraintViolationException, SQLException;

	/**
	 * Update a person with the new information of a Person in parameter
	 * @param p A new information of Person
	 * @throws SQLException 
	 */
	void updatePerson(Person p, int idPerson) throws MySQLIntegrityConstraintViolationException, SQLException;

	//	   ...

}