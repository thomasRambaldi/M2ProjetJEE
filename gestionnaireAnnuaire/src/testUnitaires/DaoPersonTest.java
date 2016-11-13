package testUnitaires;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import exceptions.DaoException;
import gestionnaireAnnuaire.Dao;
import gestionnaireAnnuaire.Person;

public class DaoPersonTest {

	private Dao dao;
	private Person p1;
	private Person p2;
	private Person p3;

	@Before
	public void setup() throws SQLException{

		dao = new Dao();

		dao.setUrl("jdbc:mysql://localhost:3306/projetjee?autoReconnect=true&useSSL=false");
		dao.setUser("root");
		dao.setPassword("");
		dao.setDriverName("com.mysql.jdbc.Driver");

		p1 = new Person();
		p1.setId(1);
		p1.setIdGroup(1);
		p1.setFirstName("Rambaldi");
		p1.setLastName("Thomas");
		p1.setMail("t.rambaldi13@gmail.com");
		p1.setWeb("http://thomas.rambaldi.etu.perso.luminy.univ-amu.fr");
		p1.setNaissance("28/03/1992");
		p1.setPassword("PassWord");

		p2 = new Person();
		p2.setId(2);
		p2.setIdGroup(1);
		p2.setFirstName("Lebreton");
		p2.setLastName("lebtreton");
		p2.setMail("k.lebtreton@gmail.com");
		p2.setWeb("http://k.leb.etu.perso.luminy.univ-amu.fr");
		p2.setNaissance("08/11/94");
		p2.setPassword("azerty");
		
		
		dao.savePerson(p1);
		dao.savePerson(p2);
		
		p3 =new Person();
		p3.setId(3);
		p3.setIdGroup(2);
		p3.setFirstName("Magron");
		p3.setLastName("Benjamin");
		p3.setMail("b.magron@gmail.com");
		p3.setWeb("http://benjamin.magron.etu.perso.luminy.univ-amu.fr");
		p3.setNaissance("28/28/28");
		p3.setPassword("coucou");

	}

	@After
	public void tearDown() throws SQLException{
		dao.deletePerson(p1);
		dao.deletePerson(p2);
		dao.deletePerson(p3);
		dao = null;
		p1 = null;
		p2 = null;
		p3 = null;
	}


	@Test
	public void findAllPersonsTest() throws SQLException{
		Collection<Person> listPers = new ArrayList<>();
		listPers.add(p1); listPers.add(p2);

		Collection<Person> fap = dao.findAllPersons(1);

		Iterator<Person> iterator = listPers.iterator();
		Iterator<Person> iterator2 = fap.iterator();

		while (iterator.hasNext() && iterator2.hasNext() ){

			Person pers = iterator.next();
			Person persFap =  iterator2.next();

			assertEquals(pers.getId(),  persFap.getId());
		}
	}
		
	@Test
	public void findPersonTest() throws DaoException, SQLException  {
		assertEquals(p1.getId(), dao.findPerson(1).getId());
	}

	@Test
	public void savePersonTest() throws SQLException{
		dao.savePerson(p3);
		assertEquals(3, dao.findPerson(3).getId());
	}

	@Test(expected = MySQLIntegrityConstraintViolationException.class)
	public void savePersonViolationTest() throws SQLException{
		Person p = new Person();
		p.setId(1);
		p.setIdGroup(2);
		p.setFirstName("Magron");
		p.setLastName("Benjamin");
		p.setMail("b.magron@gmail.com");
		p.setWeb("http://benjamin.magron.etu.perso.luminy.univ-amu.fr");
		p.setNaissance("");
		p.setPassword("coucou");

		dao.savePerson(p);
	}

	@Test
	public void deletePersonTest() throws SQLException{
		dao.deletePerson(p3);
	}

	@Test
	public void updatePersonTest() throws SQLException{
		p3.setMail("k.kevin@gmail.com");
		p3.setNaissance("");

		dao.updatePerson(p3);
	}

}
