package gestionnaireAnnuaire;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;



public class Dao extends JdbcTools implements PersonDao{
	JdbcTools jdbc;

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
	//		// 1. créer une connexion
	//		try (Connection conn = newConnection()){
	//
	//			// 2. préparer l'instruction
	//			Statement st = conn.createStatement();
	//
	//			// 3. exécuter la requête
	//			ResultSet rs = st.executeQuery(query);
	//			System.out.println("------->"+rs.getString(0));
	//			
	//			System.out.println(query);
	//			
	//			// 4. lire le résultat
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
				//				System.out.printf("%-20s | %-20s | %-20s\n", //
				//						rs.getString(1), rs.getString(2), rs.getString(3));

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
				//				System.out.printf("%-20s | %-20s | %-20s\n", //
				//						rs.getString(1), rs.getString(2), rs.getString(3));

				p.setId( Integer.parseInt( rs.getString(1) ) );
				p.setIdGroup( Integer.parseInt( rs.getString(2) ) );
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

	@Override
	public void savePerson(Person p) {

		String query = "INSERT INTO personne (idGroupe, NomPers, PrenomPers, MailPers, "
				+ "WebPers, NaissancePers, MdpPers) VALUES( ?, ?, ?, ?, ?, ?, ?)";

		int idGroup = p.getIdGroup();
		String firstName = p.getFirstName();
		String lastName = p.getLastName();
		String mail = p.getMail();
		String web = p.getWeb();
		String naissance = p.getNaissance();
		String password= p.getPassword();

		jdbc.executeUpdate(query, idGroup, firstName, lastName, mail, web, naissance, password);
	}

	@Override
	public void deletePerson(Person p) {
		String query = "DELETE FROM personne WHERE idPers = " + p.getId();

		jdbc.executeUpdate(query);
	}

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
				//				System.out.printf("%-20s | %-20s | %-20s\n", //
				//						rs.getString(1), rs.getString(2), rs.getString(3));

				g.setIdGroup( Integer.parseInt( rs.getString(1) ) );
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

	@Override
	public Group findGroup(long id) {
		Group g = new Group();
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
				//				System.out.printf("%-20s | %-20s | %-20s\n", //
				//						rs.getString(1), rs.getString(2), rs.getString(3));

				g.setIdGroup( Integer.parseInt( rs.getString(1) ) );
				g.setNameGroup( rs.getString(2)  );

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
		return g;
	}

	@Override
	public void saveGroup(Group g) {
		String query = "INSERT INTO groupe (nomGroup) VALUES(?)";

		String nomGroupe = g.getNameGroup();

		jdbc.executeUpdate(query, nomGroupe);
	}

	@Override
	public void deleteGroup(Group g) {
		String query = "DELETE FROM groupe WHERE idGroup = " + g.getIdGroup();

		jdbc.executeUpdate(query);
	}
}
