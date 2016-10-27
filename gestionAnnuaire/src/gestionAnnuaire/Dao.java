package gestionAnnuaire;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import exceptions.DaoException;


public class Dao extends JdbcTools{
	JdbcTools jdbc;


	public Dao(){
		super();
	}

	public Person findPerson(long id) throws DaoException, SQLException {

		Person p = new Person();

		String strId = Long.toString( id );
		String query = "SELECT nomPers, PrenomPers From personne Where idPers = " + strId;


		// 1. créer une connexion
		try (Connection conn = newConnection()){

			// 2. préparer l'instruction
			Statement st = conn.createStatement();

			// 3. exécuter la requête
			ResultSet rs = st.executeQuery(query);
			System.out.println("------->"+rs.getString(0));
			// 4. lire le résultat
			while (rs.next()) {

				System.out.println("------->"+rs.getString(0));
				p.setFirstName(rs.getString(1));
				p.setLastName(rs.getString("prenom"));
				p.setMail(rs.getString(4));
				p.setWeb( rs.getString(5) );
				p.setNaissance( rs.getString(6) );
				p.setPassword( rs.getString(7) );
			}

		} catch (SQLException e) {
			// 5. construire l'exception DAO
			System.out.println("Erreur lors de la requete");
			// 6. renvoyer cette exception
			//			e.printStackTrace();
		}
		return p;
	}
}
