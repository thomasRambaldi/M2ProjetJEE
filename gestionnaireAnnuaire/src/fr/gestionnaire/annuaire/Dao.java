package fr.gestionnaire.annuaire;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import exceptions.DaoException;

public class Dao extends JdbcTools implements IPersonDao, IGroupDao{

	/**
	 * Constructor of the class Dao 
	 */
	public Dao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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

		String query = "SELECT idPers, idGroup, PrenomPers, NomPers, MailPers, WebPers,"
				+ " NaissancePers, MdpPers FROM personne WHERE idGroup = " + groupId + " ORDER BY NomPers, PrenomPers";

		try(Connection conn = newConnection()) {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Person p =new Person();

				p.setIdPers( rs.getInt(1) );
				p.setIdGroup(  rs.getInt(2) );
				p.setFirstName( rs.getString(3) );
				p.setLastName( rs.getString(4) );
				p.setMail( rs.getString(5) );
				p.setWeb( rs.getString(6) );
				p.setNaissance( rs.getString(7) );
				p.setPassword( rs.getString(8) );

				listPerson.add(p);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		}
		return listPerson;
	}

	/**
	 * Return all people in a group
	 * @param groupId group who contains people
	 * @return return all people in a group
	 * @throws SQLException if a database access error occurs
	 */

	public Collection<Person> findAllPersons() throws SQLException {

		Collection<Person> listPerson= new ArrayList<Person>();

		String query = "SELECT idPers, idGroup, PrenomPers, NomPers, MailPers, WebPers,"
				+ " NaissancePers, MdpPers FROM personne ORDER BY NomPers, PrenomPers";

		try(Connection conn = newConnection()) {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Person p =new Person();

				p.setIdPers( rs.getInt(1) );
				p.setIdGroup(  rs.getInt(2) );
				p.setFirstName( rs.getString(3) );
				p.setLastName( rs.getString(4) );
				p.setMail( rs.getString(5) );
				p.setWeb( rs.getString(6) );
				p.setNaissance( rs.getString(7) );
				p.setPassword( rs.getString(8) );

				listPerson.add(p);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
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

		Person p = new Person();
		String query = "SELECT idPers, idGroup, PrenomPers, NomPers, MailPers, WebPers,"
				+ " NaissancePers, MdpPers FROM personne WHERE idPers = " + id ;

		//Connection conn = null;
		try (Connection conn = newConnection()){
			// create new connection and statement
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			if(! rs.next())
				return null;
			p.setIdPers( Integer.parseInt( rs.getString(1) ) );
			p.setIdGroup( Integer.parseInt( rs.getString(2) ) );
			p.setFirstName( rs.getString(3) );
			p.setLastName( rs.getString(4) );
			p.setMail( rs.getString(5) );
			p.setWeb( rs.getString(6) );
			p.setNaissance( rs.getString(7) );
			p.setPassword( rs.getString(8) );
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		} 
		return p;
	}

	/**
	 * Return one person with him id
	 * @param mail the mail of the person
	 * @return return the person with this id
	 * @throws SQLException if a database access error occurs
	 */
	public Person findPerson(String mail) throws SQLException {

		Person p = new Person();
		String query = "SELECT idPers, idGroup, PrenomPers, NomPers, MailPers, WebPers,"
				+ " NaissancePers, MdpPers FROM personne WHERE MailPers = " +"'" +mail+"'" ;
		try {
			init();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Connection conn = null;
		try (Connection conn = newConnection()){
			// create new connection and statement
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			if(! rs.next())
				return null;
			p.setIdPers( Integer.parseInt( rs.getString(1) ) );
			p.setIdGroup( Integer.parseInt( rs.getString(2) ) );
			p.setFirstName( rs.getString(3) );
			p.setLastName( rs.getString(4) );
			p.setMail( rs.getString(5) );
			p.setWeb( rs.getString(6) );
			p.setNaissance( rs.getString(7) );
			p.setPassword( rs.getString(8) );
			conn.close();

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
	public void savePerson(Person p) throws SQLException{

		//		TODO
		//		if( ! CheckerMail.validate(p.getMail()) ) throw new DaoException("E-mail is not compliant");
		//		if( ! CheckerWeb.validate(p.getWeb()) )  throw new DaoException("Web is not compliant");
		//		if( ! CheckerBirthDay.validate(p.getNaissance()) )  throw new DaoException("BirthDay is not compliant. For exemple DD/MM/YYYY");

		String query = "INSERT INTO personne (idPers, idGroup, PrenomPers, NomPers, "
				+ "MailPers, WebPers, NaissancePers, MdpPers) VALUES( ?, ?, ?, ?, ?, ?, ?, ?);";

		int idPers = p.getIdPers();
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
		String query = "DELETE FROM personne WHERE idPers = ?";
		executeUpdate(query, p.getIdPers());
	}

	/**
	 * Update a person with the new information of a Person in parameter
	 * @param p A new information of Person
	 * @throws SQLException 
	 * @throws DaoException 
	 */
	@Override
	public void updatePerson(Person p, int idPerson) throws SQLException, DaoException {
		//		TODO
		//		if( ! CheckerMail.validate(p.getMail())  ) throw new DaoException("E-mail is not compliant");
		//		if( ! CheckerWeb.validate(p.getWeb()) )  throw new DaoException("Web is not compliant");
		//		if( ! CheckerBirthDay.validate(p.getNaissance()) )  throw new DaoException("BirthDay is not compliant. For exemple DD/MM/YYYY");

		String query = "UPDATE personne SET idPers = ?, idGroup = ?, PrenomPers = ?, NomPers = ? ,"
				+ "MailPers = ?, WebPers = ?, NaissancePers = ?, MdpPers = ? "
				+ "WHERE idPers = ?";

		
		int idPers = p.getIdPers();
		int idGroup = p.getIdGroup();
		String firstName = p.getFirstName();
		String lastName = p.getLastName();
		String mail = p.getMail();
		String web = p.getWeb();
		String naissance = p.getNaissance();
		String password= p.getPassword();
		
		executeUpdate(query, idPers, idGroup, firstName, lastName, mail, web, naissance, password, idPerson);
	}

	/**
	 * Return all group
	 * @return return all group
	 * @throws SQLException 
	 */
	@Override
	public Collection<Group> findAllGroups() throws SQLException {
		Collection<Group> listGroup= new ArrayList<Group>();

		String query = "SELECT idGroup, NomGroup FROM groupe ORDER BY NomGroup";

		try (Connection conn = newConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Group g = new Group();

				g.setIdGroup( rs.getInt(1) );
				g.setNameGroup( rs.getString(2) );
				listGroup.add(g);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		} 
		return listGroup;
	}
	
	public Collection<Group> findAllGroupWithGroupInFirst(Group group) throws SQLException {
		Collection<Group> listGroup= new ArrayList<Group>();
		listGroup.add(group);
		String query = "SELECT idGroup, NomGroup FROM groupe WHERE idGroup!= "+ group.getIdGroup();

		try (Connection conn = newConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Group g = new Group();

				g.setIdGroup( rs.getInt(1) );
				g.setNameGroup( rs.getString(2) );
				listGroup.add(g);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
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

		try (Connection conn = newConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			if (! rs.next())
				return null;

			g.setIdGroup(  rs.getInt(1) );
			g.setNameGroup( rs.getString(2)  );
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		} 
		return g;
	}

	/**
	 * Return one group with him id
	 * @param id The identifiant of the group
	 * @return return the group with this id
	 * @throws SQLException 
	 */
	public Group findGroup(String name) throws SQLException{
		Group g = new Group();
		String query =  "SELECT idGroup, NomGroup FROM groupe WHERE nomGroup = " + "'"+ name + "'" ;

		try (Connection conn = newConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			if (! rs.next())
				return null;

			g.setIdGroup(  rs.getInt(1) );
			g.setNameGroup( rs.getString(2)  );
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
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

		//		if( ! CheckerGroupName.validate(g.getNameGroup()) )  throw new DaoException("The GroupName is not compliant. For exemple M2 ISL 2015/2016");

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

		//		if( ! CheckerGroupName.validate( g.getNameGroup()) )  throw new DaoException("The GroupName is not compliant. For exemple M2 ISL 2015/2016");

		String query = "UPDATE groupe SET idGroup = ?, NomGroup = ? WHERE idGroup = " + idGrp;

		int idGroup = g.getIdGroup();
		String nomGroup = g.getNameGroup();

		executeUpdate(query, idGroup, nomGroup);
	}

	/**
	 * 
	 * @param login
	 * @param password
	 * @return the person logged with all his informations or null if the login don't exist or the password is not correct for the login
	 * @throws SQLException
	 */
	public Person loginPerson(String login, String password) throws SQLException{
		Person p = findPerson(login);
		if(p == null || ! p.getPassword().equals(password))
			return null;
		return p;
	}


	public Group findGroupNameFromPerson(String email) throws SQLException{

		Group g = new Group();
		String query = "SELECT g.nomGroup FROM groupe g WHERE g.idGroup = INNER JOIN  personne p  ON g.idGroup = p.idGroup "
				+ "WHERE mailPers = " +"'" + email +"'" ;

		//Connection conn = null;
		try (Connection conn = newConnection()){
			// create new connection and statement
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			if(! rs.next())
				return null;
			g.setIdGroup( ( Integer.parseInt( rs.getString(1) ) ));
			g.setNameGroup( rs.getString(2) );
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		} 
		return g;
	}

	public Group findGroupNameFromPerson(long id) throws SQLException{

		Group g = new Group();
		String query = "SELECT g.idGroup, g.nomGroup FROM groupe g WHERE g.idGroup = " + id  ;

		//Connection conn = null;
		try (Connection conn = newConnection()){
			// create new connection and statement
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			if(! rs.next())
				return null;
			g.setIdGroup( ( Integer.parseInt( rs.getString(1) ) ));
			g.setNameGroup( rs.getString(2) );
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		} 
		return g;
	}

	public ArrayList<Person> searchPerson(String search){
		ArrayList<Person> persons = new ArrayList<Person>();
		String query =  "SELECT * FROM personne WHERE nomPers    LIKE " + "'%"+ search + "%'" +
												 " OR prenomPers LIKE " + "'%"+ search + "%'" +
												 " OR webPers    LIKE " + "'%"+ search + "%' ORDER BY NomPers, PrenomPers";

		try (Connection conn = newConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(! rs.next()){
				return null;
			}
			else{
				Person p =new Person();

				p.setIdPers( Integer.parseInt( rs.getString(1) ) );
				p.setIdGroup( Integer.parseInt( rs.getString(2) ) );
				p.setLastName( rs.getString(3) );
				p.setFirstName( rs.getString(4) );
				p.setMail( rs.getString(5) );
				p.setWeb( rs.getString(6) );
				p.setNaissance( rs.getString(7) );
				p.setPassword( rs.getString(8) );
				persons.add(p);
			}
			
			while (rs.next()) {
				Person p =new Person();

				p.setIdPers( Integer.parseInt( rs.getString(1) ) );
				p.setIdGroup( Integer.parseInt( rs.getString(2) ) );
				p.setLastName( rs.getString(3) );
				p.setFirstName( rs.getString(4) );
				p.setMail( rs.getString(5) );
				p.setWeb( rs.getString(6) );
				p.setNaissance( rs.getString(7) );
				p.setPassword( rs.getString(8) );
				persons.add(p);
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return persons;
	}
	
	public ArrayList<Group> searchGroup(String search){
		ArrayList<Group> groups = new ArrayList<Group>();
		String query =  "SELECT * FROM groupe WHERE nomGroup  LIKE " + "'%"+ search + "%' ORDER BY nomGroup";

		try (Connection conn = newConnection()){
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(! rs.next())
				return null;
			else{
				Group g =new Group();
				g.setIdGroup( Integer.parseInt( rs.getString(1) ) );
				g.setNameGroup( rs.getString(2) );
				groups.add(g);
			}
			while (rs.next()) {
				Group g =new Group();

				g.setIdGroup( Integer.parseInt( rs.getString(1) ) );
				g.setNameGroup( rs.getString(2) );
				groups.add(g);
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return groups;
	}

	public void addRandomizedPersons(int numberOfPersons, ArrayList<Integer> idsGroups) {
	    String[] firstNames = {"Pierre", "Paul", "Jacques", "Henry", "Gregoire", "Nicolas", "Benjamin", "Florian", "Elimelekh", "Joseph"};
	    String[] lastNames = {"Dupont", "Cohen", "Campanella", "Magron", "Leotier", "Fillon", "Bush", "Bonaparte", "Le Grand", "Porc"};
	    String mail = "@gmail.com";
	    String [] naissances ={"10/11/1894","12/03/1922","02/04/1956","19/12/1982"};
	    String password="test";
	    for(int i=0;i<numberOfPersons;i++){
	    	int randfirstName = (int)(Math.random() * firstNames.length);
	    	int randlastName = (int)(Math.random() * lastNames.length);
		    int randIdGroup = (int)(Math.random() * idsGroups.size());
		    int randNaissance = (int)(Math.random() * naissances.length);
	    	Person p = new Person();
	    	p.setFirstName(firstNames[randfirstName]);
	    	p.setLastName(lastNames[randlastName]);
	    	p.setIdGroup(idsGroups.get(randIdGroup));
	    	p.setIdPers(i+10);
	    	p.setMail(firstNames[randfirstName].toLowerCase()+p.getIdPers()+mail);
	    	p.setWeb("google.fr");
	    	p.setNaissance(naissances[randNaissance]);
	    	p.setPassword(password);
	    	try {
				savePerson(p);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	}
	public void deleteRandomizedPersons(int numberOfPersons) {
	    for(int i=0;i<numberOfPersons;i++){
	    	Person p = new Person();
	    	p.setIdPers(i+10);
	    	try {
				deletePerson(p);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	}

	public void addRandomizedGroup(int numberOfGroups) {
		String [] namesGroups = {"M2 - Imagerie section ", "M2 - Réseaux secteur "};
		for(int i=0;i<numberOfGroups;i++){
			int randGroup = (int)(Math.random() * namesGroups.length);
			Group g = new Group();
	    	g.setIdGroup(i+10);
	    	g.setNameGroup(namesGroups[randGroup]+g.getIdGroup());
			try {
				saveGroup(g);
			} catch (SQLException | DaoException e) {
				e.printStackTrace();
			}
	    }
		
	}
	
	public void deleteRandomizedGroup(int numberOfGroups) {
		for(int i=0;i<numberOfGroups;i++){
			Group g = new Group();
	    	g.setIdGroup(i+10);
			try {
				deleteGroup(g);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
		
	}
}
