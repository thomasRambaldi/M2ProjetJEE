package gestionAnnuaire;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import exceptions.DaoException;


public class Dao extends JdbcTools{
	JdbcTools jdbc = new JdbcTools();

	public Collection<Person> findPersons() throws DaoException {
		Collection<Person> listPerson = new ArrayList<>();
		String query = "Select nom, prenom From Personnes";

		// 1. créer une connexion
		try (Connection conn = newConnection()){
			// 2. préparer l'instruction
			Statement st = conn.createStatement();

			// 3. exécuter la requête
			ResultSet rs = st.executeQuery(query);


			// 4. lire le résultat
			while (rs.next()) {
				System.out.printf("%-20s | %-20s | %3d\n", //
						rs.getString(1), rs.getString("prenom"), rs.getInt(3));
			}

		} catch (SQLException e) {
			// 5. construire l'exception DAO
			System.out.println("Erreur lors de la requete");
			// 6. renvoyer cette exception
			e.printStackTrace();
		}
		return listPerson;
	}
}
