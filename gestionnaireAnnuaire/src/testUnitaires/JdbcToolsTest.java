package testUnitaires;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;


import gestionnaireAnnuaire.JdbcTools;
import junit.framework.TestCase;

public class JdbcToolsTest {

	JdbcTools jdbc;
	JdbcTools jdbcFalse;

	Connection conn;
	Connection connFalse;

	@Before
	public void before(){

		jdbc = new JdbcTools();
		jdbc.setUrl("jdbc:mysql://localhost:3306/projetjee?autoReconnect=true&useSSL=false");
		jdbc.setUser("root");
		jdbc.setPassword("");
		jdbc.setDriverName("com.mysql.jdbc.Driver");

		jdbcFalse = new JdbcTools();
		jdbcFalse.setUrl("jdbc:mysql://dbs-perso.luminy.univmed.fr/r21101993");
		jdbcFalse.setUser("root");
		jdbcFalse.setPassword("");
		jdbcFalse.setDriverName("com.mysql.jdbc.Driver");
	}

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

	@Test
	public void testInit() throws ClassNotFoundException  {  
		jdbc.init();
	}

	@Test
	public void testNewConnection() throws SQLException, ClassNotFoundException  {
		jdbc.init();
		conn = jdbc.newConnection();
	}

	@Test
	public void testClose()  {  
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

	@Test
	public void testIsConnected() throws ClassNotFoundException, SQLException  {  
		assertTrue( jdbc.isConnect() );
	}

	@Test
	public void executeUpdatePersonneTest() throws SQLException, ClassNotFoundException  {
		jdbc.init();
		jdbc.newConnection();
		jdbc.executeUpdate("SELECT idPers, idGroup, NomPers, PrenomPers, MailPers, WebPers,"
				+ " NaissancePers, MdpPers FROM personne;");
		jdbc.close();
	}

	@Test
	public void ExecuteUpdateGroupeTest() throws SQLException, ClassNotFoundException  {
		jdbc.init();
		jdbc.newConnection();
		jdbc.executeUpdate("SELECT idGroup, nomGroup FROM groupe;");
		jdbc.close();
	}
	
	@Test
	public void ExecuteUpdateViolation() throws SQLException, ClassNotFoundException  {
		// TODO : Write the code
		jdbc.init();
		jdbc.newConnection();
		jdbc.executeUpdate("SELECT idGroup, nomGroup FROM groupe;");
		jdbc.close();
	}
	

	@Test(expected = SQLException.class)
	public void testConnectFalse() throws SQLException, ClassNotFoundException  {
		jdbcFalse.init();
		connFalse = jdbcFalse.newConnection();
	}


	@Test(expected = SQLException.class)
	public void testIsConnectedFalse() throws ClassNotFoundException, SQLException  {  
		jdbcFalse.isConnect();
	}


}
