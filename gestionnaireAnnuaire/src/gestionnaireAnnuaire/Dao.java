package gestionnaireAnnuaire;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;



public class Dao extends JdbcTools implements PersonDao, GroupDao{

	public Dao(){
		super();
	}

	//	@Override
	//	public Person findPerson(long id) {
	//
	//		Person p = new Person();
	//
	//		String strId = Long.toString( id );
	//		String query = "SELECT * FROM personne" ;
	//
	//		// 1. cr�er une connexion
	//		try (Connection conn = newConnection()){
	//
	//			// 2. pr�parer l'instruction
	//			Statement st = conn.createStatement();
	//
	//			// 3. ex�cuter la requ�te
	//			ResultSet rs = st.executeQuery(query);
	//			System.out.println("------->"+rs.getString(0));
	//			
	//			System.out.println(query);
	//			
	//			// 4. lire le r�sultat
	//			while (rs.next()) {
	//
	//				System.out.println("------->"+rs.getString(0));
	//				p.setFirstName(rs.getString(1));
	//				p.setLastName(rs.getString("PrenomPers"));
	//				p.setMail(rs.getString(4));
	//				p.setWeb( rs.getString(5) );
	//				p.setNaissance( rs.getString(6) );
	//				p.setPassword( rs.getString(7) );
	//			}
	//
	//		} catch (SQLException e) {
	//			// 5. construire l'exception DAO
	//			System.out.println("Erreur lors de la requete");
	//			// 6. renvoyer cette exception
	//			//			e.printStackTrace();
	//		}
	//		return p;
	//	}


	/**
	 * Return all people in a group
	 * @param groupId group who contains people
	 * @return return all people in a group
	 */
	@Override
	public Collection<Person> findAllPersons(long groupId) {

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close result, statement and connection
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return listPerson;
	}

	/**
	 * Return one person with him id
	 * @param id The identifiant of the person
	 * @return return the person with this id
	 */
	@Override
	public Person findPerson(long id) {

		Person p = new Person();

		String strId = Long.toString( id );
		String query = "SELECT idPers, idGroup, NomPers, PrenomPers, MailPers, WebPers,"
				+ " NaissancePers, MdpPers FROM personne WHERE idPers = " + strId ;

		Connection conn = null;
		try {

			// create new connection and statement
			conn = newConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				p.setId( Integer.parseInt( rs.getString(1) ) );
				p.setIdGroup( Integer.parseInt( rs.getString(2) ) );
				p.setFirstName( rs.getString(3) );
				p.setLastName( rs.getString(4) );
				p.setMail( rs.getString(5) );
				p.setWeb( rs.getString(6) );
				p.setNaissance( rs.getString(7) );
				p.setPassword( rs.getString(8) );

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close result, statement and connection
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return p;
	}

	/**
	 * Add a person in the data base
	 * @param p A person
	 * @throws MySQLIntegrityConstraintViolationException 
	 */
	@Override
	public void savePerson(Person p) throws SQLException{
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

		executeUpdate(query, idPers, idGroup, firstName, lastName, mail, web, naissance, password);

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

	@Override
	public void updatePerson(Person p) throws SQLException {
		String query = "UPDATE personne SET idPers = ?, idGroup = ?, NomPers = ?, PrenomPers = ? ,"
				+ "MailPers = ?, WebPers = ?, NaissancePers = ?, MdpPers = ?"
				+ "WHERE idPers = " + p.getId();

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
	 */
	@Override
	public Collection<Group> findAllGroups() {
		Collection<Group> listGroup= new ArrayList<>();

		String query = "SELECT idGroup, NomGroup FROM groupe";

		Connection conn = null;
		try {
			// create new connection and statement
			conn = newConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Group g =new Group();

				g.setIdGroup( rs.getInt(1) );
				g.setNameGroup( rs.getString(2) );

				listGroup.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close result, statement and connection
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			while (rs.next()) {

				g.setIdGroup(  rs.getInt(1) );
				g.setNameGroup( rs.getString(2)  );

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException();
		} finally {
			// close result, statement and connection
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return g;
	}

	/**
	 * Add a group in the data base
	 * @param p A person
	 * @throws SQLException 
	 */
	@Override
	public void saveGroup(Group g) throws SQLException {
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

	@Override
	public void updateGroup(Group g) throws SQLException {
		String query = "UPDATE groupe SET idGroup = ?, NomGroup = ? WHERE idGroup = " + g.getIdGroup();

		int idGroup = g.getIdGroup();
		String nomGroup = g.getNameGroup();
		
		executeUpdate(query, idGroup, nomGroup);
	}

}