package gestionAnnuaire;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import exceptions.DaoException;


public class Dao extends JdbcTools{
//	JdbcTools jdbc = new JdbcTools();

	
	public Dao(){
//		jdbc.setUrl("jdbc:mysql://localhost:3306/projetjee?autoReconnect=true&useSSL=false");
//		jdbc.setUser("root");
//		jdbc.setPassword("");
//		jdbc.setDriverName("com.mysql.jdbc.Driver");
	}
	
	public Person findPerson(long id) throws DaoException {
		
		Person p = null;
		
		String strId = Long.toString( id );
		String query = "SELECT nomPers, PrenomPers From personne "
				+ "Where idPers = " + strId;

		// 1. cr�er une connexion
		try (Connection conn = newConnection()){

			// 2. pr�parer l'instruction
			Statement st = conn.createStatement();

			// 3. ex�cuter la requ�te
			ResultSet rs = st.executeQuery(query);


			// 4. lire le r�sultat
//			while (rs.next()) {
				System.out.printf("%-20s | %-20s \n", //
						rs.getString(2), rs.getString("prenom") );
				
				p.setFirstName( rs.getString(2) );
				p.setLastName(rs.getString("prenom"));
				p.setMail(rs.getString(4));
				p.setWeb( rs.getString(5) );
				p.setNaissance( rs.getString(6) );
				p.setPassword( rs.getString(7) );
//			}

		} catch (SQLException e) {
			// 5. construire l'exception DAO
			System.out.println("Erreur lors de la requete");
			// 6. renvoyer cette exception
			e.printStackTrace();
		}
		return p;
	}
}
