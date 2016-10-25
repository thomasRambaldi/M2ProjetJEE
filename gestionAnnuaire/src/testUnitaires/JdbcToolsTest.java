package testUnitaires;

import static org.junit.Assert.assertEquals;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Connection;

import gestionAnnuaire.JdbcTools;

public class JdbcToolsTest {

	JdbcTools jdbc;
	
	@Before
	public void before(){
		jdbc = new JdbcTools();
//		jdbc.setUrl("jdbc:mysql://dbs-perso.luminy.univmed.fr/r21101993");
//		jdbc.setUser("r21101993");
//		jdbc.setPassword("BTJq?4");
		
		jdbc.setUrl("jdbc:mysql://localhost:3306/projetjee?autoReconnect=true&useSSL=false");
		jdbc.setUser("root");
		jdbc.setPassword("");
		jdbc.setDriverName("com.mysql.jdbc.Driver");
//		jdbc.setDriverName("com.mysql.cj.jdbc.Driver");
	}
	
	/* Ajout par rapport au tp*/
	@Test
	public void getUrlTest(){
		assertEquals("jdbc:mysql://localhost:3306/projetjee?autoReconnect=true&useSSL=false",
				jdbc.getUrl());
	}
	
	@Test
	public void getUserTest(){
		assertEquals("root", jdbc.getUser());
	}
	
	@Test
	public void getPassWaodTest(){
		assertEquals("", jdbc.getPassword());
	}
	
	@Test
	public void getDriveNameTest(){
		assertEquals("com.mysql.jdbc.Driver", jdbc.getDriverName());
	}
	
	/* Fin ajout par rapport au tp*/
	
	
	
	
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
		String url = "jdbc:mysql://localhost:3306/projetjee?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "";
		Connection conn = (Connection) DriverManager.getConnection(url, user, password);
		jdbc.quietClose(conn);
	}
	
	/* Ajout par rapport au tp*/
	@Test(expected = SQLException.class)
	public void testQuietCloseWithException() throws SQLException {
		jdbc.quietClose(null);
	}
	/* Fin ajout par rapport au tp*/
}
