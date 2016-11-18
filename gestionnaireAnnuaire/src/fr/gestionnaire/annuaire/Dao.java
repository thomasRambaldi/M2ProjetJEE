package fr.gestionnaire.annuaire;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import exceptions.DaoException;
import fr.gestionnaire.utils.CheckerBirthDay;
import fr.gestionnaire.utils.CheckerGroupName;
import fr.gestionnaire.utils.CheckerMail;
import fr.gestionnaire.utils.CheckerWeb;


public class Dao extends JdbcTools implements IPersonDao, IGroupDao{

	CheckerBirthDay checkBirth ;
	CheckerGroupName checkGroupName;
	CheckerMail checkMail;
	CheckerWeb checkWeb;

	/**
	 * Constructor of the class Dao 
	 */
	public Dao(){
		checkBirth = new CheckerBirthDay();
		checkGroupName = new CheckerGroupName();
		checkMail = new CheckerMail();
		checkWeb = new CheckerWeb();
	}

	/**
	 * Return all people in a group
	 * @param groupId group who contains people
	 * @return return all people in a group
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public Collection<Person> findAllPersons(long groupId) throws SQLException {

		Collection<Person> listPerson= new ArrayList<>();

		String strId = Long.toString( groupId );
		String query = "SELECT idPers, idGroup, NomPers, PrenomPers, MailPers, WebPers,"
				+ " NaissancePers, MdpPers FROM personne WHERE idGroup = " + strId;

		Connection conn = null;
		try {

			// create new connection and statement
			conn = newConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Person p =new Person();

				p.setId( rs.getInt(1) );
				p.setIdGroup(  rs.getInt(2) );
				p.setFirstName( rs.getString(3) );
				p.setLastName( rs.getString(4) );
				p.setMail( rs.getString(5) );
				p.setWeb( rs.getString(6) );
				p.setNaissance( rs.getString(7) );
				p.setPassword( rs.getString(8) );


				listPerson.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			// close result, statement and connection
			if (conn != null)
				conn.close();
		}
		return listPerson;
	}

	/**
	 * Return one person with him id
	 * @param id The identifiant of the person
	 * @return return the person with this id
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public Person findPerson(long id) throws SQLException {

		Person p = new Person();;
		String strId = Long.toString( id );
		String query = "SELECT idPers, idGroup, NomPers, PrenomPers, MailPers, WebPers,"
				+ " NaissancePers, MdpPers FROM personne WHERE idPers = " + strId ;

		//Connection conn = null;
		try (Connection conn = newConnection()){
			// create new connection and statement
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			if(! rs.next())
				return null;
			p.setId( Integer.parseInt( rs.getString(1) ) );
			p.setIdGroup( Integer.parseInt( rs.getString(2) ) );
			p.setFirstName( rs.getString(3) );
			p.setLastName( rs.getString(4) );
			p.setMail( rs.getString(5) );
			p.setWeb( rs.getString(6) );
			p.setNaissance( rs.getString(7) );
			p.setPassword( rs.getString(8) );

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		} 
		return p;
	}


	/**
	 * Add a person in the data base
	 * @param p A person
	 * @throws DaoException 
	 * @throws MySQLIntegrityConstraintViolationException if the primary key already exist in the database
	 */
	@Override
	public void savePerson(Person p) throws SQLException, DaoException{

//		TODO
//		if( ! checkMail.validate(p.getMail()) ) throw new DaoException("E-mail is not compliant");
//		if( ! checkWeb.validate(p.getWeb()) )  throw new DaoException("Web is not compliant");
//		if( ! checkBirth.validate(p.getNaissance()) )  throw new DaoException("BirthDay is not compliant. For exemple DD/MM/YYYY");

		String query = "INSERT INTO personne (idPers, idGroup, NomPers, PrenomPers, "
				+ "MailPers, WebPers, NaissancePers, MdpPers) VALUES( ?, ?, ?, ?, ?, ?, ?, ?);";

		int idPers = p.getId();
		int idGroup = p.getIdGroup();
		String firstName = p.getFirstName();
		String lastName = p.getLastName();
		String mail = p.getMail();
		String web = p.getWeb();
		String naissance = p.getNaissance();
		String password= p.getPassword();

		if(oneOrMoreFieldsIncorrect(idPers, idGroup, firstName, lastName, password))
			throw new SQLException();

		executeUpdate(query, idPers, idGroup, firstName, lastName, mail, web, naissance, password);
	}

	private boolean oneOrMoreFieldsIncorrect(int idPers, int idGroup, String firstName, String lastName, String password) {
		return idPers < 1 || idGroup < 1 || firstName == null || lastName == null || password == null;
	}


	/**
	 * Delete a person in the data base
	 * @param p A person
	 * @throws SQLException 
	 */
	@Override
	public void deletePerson(Person p) throws SQLException {

		String query = "DELETE FROM personne WHERE idPers = " + p.getId();

		executeUpdate(query);
	}

	/**
	 * Update a person with the new information of a Person in parameter
	 * @param p A new information of Person
	 * @throws SQLException 
	 * @throws DaoException 
	 */
	@Override
	public void updatePerson(Person p, int idPerson) throws SQLException, DaoException {

//		if( ! checkMail.validate(p.getMail()) ) throw new DaoException("E-mail is not compliant");
//		if( ! checkWeb.validate(p.getWeb()) )  throw new DaoException("Web is not compliant");
//		if( ! checkBirth.validate(p.getNaissance()) )  throw new DaoException("BirthDay is not compliant. For exemple DD/MM/YYYY");

		String query = "UPDATE personne SET idPers = ?, idGroup = ?, NomPers = ?, PrenomPers = ? ,"
				+ "MailPers = ?, WebPers = ?, NaissancePers = ?, MdpPers = ? "
				+ "WHERE idPers = " + idPerson;

		int idPers = p.getId();
		int idGroup = p.getIdGroup();
		String firstName = p.getFirstName();
		String lastName = p.getLastName();
		String mail = p.getMail();
		String web = p.getWeb();
		String naissance = p.getNaissance();
		String password= p.getPassword();

		executeUpdate(query, idPers, idGroup, firstName, lastName, mail, web, naissance, password);
	}

	/**
	 * Return all group
	 * @return return all group
	 * @throws SQLException 
	 */
	@Override
	public Collection<Group> findAllGroups() throws SQLException {
		Collection<Group> listGroup= new ArrayList<>();

		String query = "SELECT idGroup, NomGroup FROM groupe";

		Connection conn = null;
		try {
			// create new connection and statement
			conn = newConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Group g = new Group();

				g.setIdGroup( rs.getInt(1) );
				g.setNameGroup( rs.getString(2) );

				listGroup.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			// close result, statement and connection
			if (conn != null)
				conn.close();
		}
		return listGroup;
	}

	/**
	 * Return one group with him id
	 * @param id The identifiant of the group
	 * @return return the group with this id
	 * @throws SQLException 
	 */
	@Override
	public Group findGroup(long id) throws SQLException {

		Group g = new Group();
		String strId = Long.toString( id );
		String query =  "SELECT idGroup, NomGroup FROM groupe WHERE idGroup = " + strId ;

		Connection conn = null;
		try {
			// create new connection and statement
			conn = newConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			if (! rs.next())
				return null;

			g.setIdGroup(  rs.getInt(1) );
			g.setNameGroup( rs.getString(2)  );
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			// close result, statement and connection
			if (conn != null)
				conn.close();
		}
		return g;
	}

	/**
	 * Add a group in the data base
	 * @param p A person
	 * @throws SQLException 
	 * @throws DaoException 
	 */
	@Override
	public void saveGroup(Group g) throws SQLException, DaoException {
		
//		TODO
//		if( ! checkGroupName.validate(g.getNameGroup()) )  throw new DaoException("The GroupName is not compliant. For exemple M2 ISL 2015/2016");
		
		String query = "INSERT INTO groupe (idGroup, nomGroup) VALUES(?, ?)";

		int idGroup = g.getIdGroup();
		String nomGroupe = g.getNameGroup();

		executeUpdate(query, idGroup, nomGroupe);
	}

	/**
	 * Delete a group in the data base
	 * @param p A person
	 * @throws SQLException 
	 */
	@Override
	public void deleteGroup(Group g) throws SQLException {
		String query = "DELETE FROM groupe WHERE idGroup = " + g.getIdGroup();

		executeUpdate(query);
	}

	/**
	 * Update a Group with the new information of a Group in parameter
	 * @param g A new information of Group
	 * @throws SQLException 
	 * @throws DaoException 
	 */
	@Override
	public void updateGroup(Group g, int idGrp) throws SQLException, DaoException {
		
//		if( ! check.validateGroupName(g.getNameGroup()) )  throw new DaoException("The GroupName is not compliant. For exemple M2 ISL 2015/2016");
		
		String query = "UPDATE groupe SET idGroup = ?, NomGroup = ? WHERE idGroup = " + idGrp;

		int idGroup = g.getIdGroup();
		String nomGroup = g.getNameGroup();

		executeUpdate(query, idGroup, nomGroup);
	}

}
