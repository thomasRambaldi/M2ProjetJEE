package testUnitaires;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import exceptions.DaoException;
import gestionAnnuaire.Dao;
import gestionAnnuaire.JdbcTools;
import gestionAnnuaire.Person;


public class DaoTest {

	private Dao dao;
	private JdbcTools jdbc;
	private Person p1;
	private Person p2;
	private Collection<Person> list;
	
	@Before
	public void before() throws SQLException{
		jdbc = new JdbcTools();
		jdbc.setUrl("jdbc:mysql://localhost:3306/projetjee?autoReconnect=true&useSSL=false");
		jdbc.setUser("root");
		jdbc.setPassword("");
		jdbc.setDriverName("com.mysql.jdbc.Driver");
		jdbc.newConnection();
		
		dao = new Dao();
		
		p1 = new Person();
		p1.setFirstName("Rambaldi");
		p1.setLastName("Thomas");
		p1.setMail("t.rambaldi13@gmail.com");
		p1.setWeb("http://thomas.rambaldi.etu.perso.luminy.univ-amu.fr");
		p1.setNaissance("28/03/1992");
		p1.setPassword("PassWord");
		
		p2 = new Person();
		p2.setFirstName("Lebreton");
		p2.setLastName("Kévin");
		p1.setMail("k.lebreton@gmail.com");
		p1.setWeb("http://kevin.lebreton.etu.perso.luminy.univ-amu.fr");
		p1.setPassword("PassWord2");
		
//		list.add(p1);

	}
	
	@Test
	public void findPersonTest() throws DaoException  {
		assertEquals(p1, dao.findPerson(1));
	}
	

}
