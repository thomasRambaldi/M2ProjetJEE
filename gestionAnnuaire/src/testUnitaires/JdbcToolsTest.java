package testUnitaires;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import gestionAnnuaire.JdbcTools;

public class JdbcToolsTest {

	JdbcTools jdbc;
	
	@Before
	public void before(){
		jdbc = new JdbcTools();
		jdbc.setUrl("jdbc:mysql://dbs-perso.luminy.univmed.fr/r21101993");
		jdbc.setUser("r21101993");
		jdbc.setPassword("BTJq?4");
		//jdbc.setDriverName("com.mysql.jdbc.Driver");
	}
	
	@Test
	public void testInit() throws ClassNotFoundException  {  
		jdbc.init();
	}

	@Test
	public void testClose()  {  
		jdbc.close();
	}
	
	@Test
	public void testNewConnection() throws SQLException, ClassNotFoundException  {
		jdbc.init();
		jdbc.newConnection();
	}
	
	@Test
	public void executeUpdatePersonneTest() throws SQLException, ClassNotFoundException  {
		jdbc.init();
		jdbc.newConnection();
		jdbc.executeUpdate("SELECT * FROM Personne;");
		jdbc.close();
	}
	
	@Test
	public void ExecuteUpdateGroupeTest() throws SQLException, ClassNotFoundException  {
		jdbc.init();
		jdbc.newConnection();
		jdbc.executeUpdate("SELECT * FROM Groupe;");
		jdbc.close();
	}
	
	@Test
	public void testQuietClose() throws SQLException { 

	}

}
