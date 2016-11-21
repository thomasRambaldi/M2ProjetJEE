package fr.test.unitaires.gestionnaire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.gestionnaire.annuaire.JdbcTools;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fr/test/unitaires/gestionnaire/spring.xml")
public class JdbcToolsTest {

	@Autowired
	JdbcTools jdbc;

	JdbcTools jdbcFalse;

	Connection conn;
	Connection connFalse = null;


	@Before
	public void before(){
		jdbcFalse = new JdbcTools();
		jdbcFalse.setUrl(null);
		jdbcFalse.setUser(null);
		jdbcFalse.setPassword(null);
		jdbcFalse.setDriverName("com.mysql.jdbc.Driver");
	}

	@After
	public void tearDown(){

	}

	@Test
	public void getUrlTest(){
		//		jdbc:mysql://localhost:3306/projetjee?autoReconnect=true&useSSL=false
		assertEquals("jdbc:mysql://localhost:3306/projetjee?useSSL=false", jdbc.getUrl());
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
	public void initTest() throws ClassNotFoundException  {  
		jdbc.init();
	}

	@Test
	public void newConnectionTest() throws SQLException, ClassNotFoundException  {
		jdbc.init();
		conn = jdbc.newConnection();
	}
	
	@Test(expected = SQLException.class)
	public void newConnectionFalseTest() throws SQLException, ClassNotFoundException  {
		//jdbcFalse.init();
		connFalse = jdbcFalse.newConnection();
	}

	@Test
	public void quietCloseTest() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/projetjee?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "";
		Connection conn = (Connection) DriverManager.getConnection(url, user, password);
		jdbc.quietClose(conn);
	}

	@Test
	public void quietCloseSQLExceptionTest() throws SQLException {
		//TODO Modifier la fonction pour tester le cas d'erreur (si necéssaire)
		jdbc.quietClose(null);
	}
	
	@Test
	public void isConnectedTest() throws ClassNotFoundException, SQLException  {  
		assertTrue( jdbc.isConnect() );
	}
	
	@Test(expected = SQLException.class)
	public void isConnectedFalseTest() throws ClassNotFoundException, SQLException  {  
		jdbcFalse.isConnect();
	}

	@Test
	public void executeUpdatePersonneTest() throws SQLException, ClassNotFoundException  {
		jdbc.init();
		Connection c = jdbc.newConnection();
		jdbc.executeUpdate("SELECT idPers, idGroup, NomPers, PrenomPers, MailPers, WebPers,"
				+ " NaissancePers, MdpPers FROM personne;");
		jdbc.quietClose(c);
	}

	@Test
	public void executeUpdateGroupeTest() throws SQLException, ClassNotFoundException  {
		jdbc.init();
		Connection c = jdbc.newConnection();
		jdbc.executeUpdate("SELECT idGroup, nomGroup FROM groupe;");
		jdbc.quietClose(c);
	}

	@Test(expected = SQLException.class)
	public void executeUpdateViolationTest() throws SQLException, ClassNotFoundException  {
		// TODO : Write the code
		jdbc.init();
		Connection c = jdbc.newConnection();
		jdbc.executeUpdate("");
		jdbc.quietClose(c);
	}

	@Test(expected = SQLException.class)
	public void ConnectFalseTest() throws SQLException, ClassNotFoundException  {
		jdbcFalse.init();
		connFalse = jdbcFalse.newConnection();
	}


	@Test(expected = SQLException.class)
	public void IsConnectedFalseTest() throws ClassNotFoundException, SQLException  {  
		jdbcFalse.isConnect();
	}
}
