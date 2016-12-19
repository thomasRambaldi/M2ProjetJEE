package fr.test.unitaires.gestionnaire;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import exceptions.DaoException;
import fr.gestionnaire.annuaire.Dao;
import fr.gestionnaire.annuaire.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fr/test/unitaires/gestionnaire/spring.xml")
public class DaoPersonTest {

	@Autowired
	private Dao dao;

	private Person p1;
	private Person p2;
	private Person p3;

	@Before
	public void setup() throws SQLException, DaoException{
		p1 = new Person();
		p1.setIdPers(1);
		p1.setIdGroup(1);
		p1.setFirstName("Rambaldi");
		p1.setLastName("Thomas");
		p1.setMail("t.rambaldi13@gmail.com");
		p1.setWeb("thomas.rambaldi.etu.perso.luminy.univ-amu.fr");
		p1.setNaissance("28/03/1992");
		p1.setPassword("PassWord");

		p2 = new Person();
		p2.setIdPers(2);
		p2.setIdGroup(1);
		p2.setFirstName("Lebreton");
		p2.setLastName("lebtreton");
		p2.setMail("k.lebtreton@gmail.com");
		p2.setWeb("k.leb.etu.perso.luminy.univ-amu.fr");
		p2.setNaissance("08/11/1994");
		p2.setPassword("azerty");

		p3 = new Person();
		p3.setIdPers(3);
		p3.setIdGroup(2);
		p3.setFirstName("Magron");
		p3.setLastName("Benjamin");
		p3.setMail("b.magron@gmail.com");
		p3.setWeb("benjamin.magron.etu.perso.luminy.univ-amu.fr");
		p3.setNaissance("08/11/1994");
		p3.setPassword("coucou");
		
		dao.savePerson(p1);
		dao.savePerson(p2);
	}

	@After
	public void tearDown() throws SQLException{
		p3.setIdPers(3);
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
		ArrayList<Person> listPers = new ArrayList<>();
		listPers.add(p1); listPers.add(p2);

		Collection<Person> fap = dao.findAllPersons(1);

		Iterator<Person> iterator2 = fap.iterator();

		while (iterator2.hasNext() ){
			Person persFap =  iterator2.next();
			assertTrue(contains(listPers, persFap));
		}
	}
	
	@Test 
	public void findAllPersonsInGroupDontExistTest() throws SQLException{
		Collection<Person> fap = dao.findAllPersons(3);
		assertEquals(0, fap.size());
	}

	@Test
	public void findPersonTest() throws DaoException, SQLException  {
		assertEquals(p1.getIdPers(), dao.findPerson(1).getIdPers());
	}
	
	@Test 
	public void findPersonDontExistTest() throws DaoException, SQLException  {
		assertEquals(null, dao.findPerson(300));
	}

	@Test
	public void savePersonTest() throws SQLException, DaoException{
		dao.savePerson(p3);
		assertEquals(3, dao.findPerson(3).getIdPers());
	}
	
	@Test(expected = MySQLIntegrityConstraintViolationException.class)
	public void savePersonAlreadyExistTest() throws SQLException, DaoException{
		Person p = new Person();
		p.setIdPers(1);
		p.setIdGroup(2);
		p.setFirstName("Magron");
		p.setLastName("Benjamin");
		p.setMail("b.magron@gmail.com");
		p.setWeb("benjamin.magron.etu.perso.luminy.univ-amu.fr");
		p.setNaissance("22/02/1993");
		p.setPassword("coucou");

		dao.savePerson(p);
	}
	
//	@Test (expected = DaoException.class)
//	public void savePersonWithErrorMailTest() throws SQLException, DaoException{
//		Person p = new Person();
//		p.setIdPers(1);
//		p.setIdGroup(2);
//		p.setFirstName("Campanella");
//		p.setMail("test@Mail");
//		p.setPassword("coucou");
//		dao.savePerson(p);
//	}

//	@Test (expected = DaoException.class)
//	public void savePersonWithErrorWebTest() throws SQLException, DaoException{
//		Person p = new Person();
//		p.setIdPers(1);
//		p.setIdGroup(2);
//		p.setFirstName("Campanella");
//		p.setLastName("Florian");
//		p.setMail("test@hotmail.fr");
//		p.setWeb("googler");
//		p.setNaissance("09/12/1994");
//		p.setPassword("coucou");
//		dao.savePerson(p);
//	}
	
//	@Test (expected = DaoException.class)
//	public void savePersonWithErrorBirthTest() throws SQLException, DaoException{
//		Person p = new Person();
//		p.setIdPers(1);
//		p.setIdGroup(2);
//		p.setFirstName("Campanella");
//		p.setLastName("Florian");
//		p.setMail("test@hotmail.fr");
//		p.setWeb("google.fr");
//		p.setNaissance("18/01/93");
//		p.setPassword("coucou");
//		dao.savePerson(p);
//	}

	@Test
	public void deletePersonTest() throws SQLException{
		dao.deletePerson(p3);
	}
	
	@Test
	public void deletePersonDontExistTest() throws SQLException{
		Person p = new Person();
		p.setIdPers(200);
		p.setIdGroup(2);
		p.setFirstName("Campanella");
		p.setLastName("Florian");
		p.setMail("f.campanella@gmail.com");
		p.setWeb("florian.campanella.etu.perso.luminy.univ-amu.fr");
		p.setNaissance("12/01/1993");
		p.setPassword("test");
		
		dao.deletePerson(p);
	}

	@Test
	public void updatePersonTest() throws SQLException, DaoException{
		p3.setMail("k.kevin@gmail.com");
		dao.updatePerson(p3, p3.getIdPers());
	}
	
	@Test
	public void updatePersonDontExist() throws SQLException, DaoException{
		Person p = new Person();
		p.setIdPers(200);
		p.setIdGroup(2);
		p.setFirstName("Campanella");
		p.setLastName("Florian");
		p.setMail("f.campanella@gmail.com");
		p.setWeb("florian.campanella.etu.perso.luminy.univ-amu.fr");
		p.setNaissance("12/01/1993");
		p.setPassword("test");
		
		dao.updatePerson(p, p.getIdPers());
	}

	@Test (expected = MySQLIntegrityConstraintViolationException.class)
	public void updatePersonAlreadyExistTest() throws SQLException, DaoException{
		int oldId = p3.getIdPers();
		dao.savePerson(p3);
		p3.setIdPers(1);
		dao.updatePerson(p3, oldId);
	}
	
//	@Test (expected = DaoException.class)
//	public void updatePersonWithErrorInMailTest() throws SQLException, DaoException{
//		dao.savePerson(p3);
//		p3.setMail("alias_13500@");
//		dao.updatePerson(p3, p3.getIdPers());
//	}
	
//	@Test (expected = DaoException.class)
//	public void updatePersonWithErrorInWebTest() throws SQLException, DaoException{
//		dao.savePerson(p3);
//		p3.setWeb("google.");
//		dao.updatePerson(p3, p3.getIdPers());
//	}
	
//	@Test (expected = DaoException.class)
//	public void updatePersonWithErrorInBirthTest() throws SQLException, DaoException{
//		dao.savePerson(p3);
//		p3.setNaissance("28 mars");
//		dao.updatePerson(p3, p3.getIdPers());
//	}
	
	/**
	 * The fonction contains will detect if a person is contained in a an arraylist 
	 * by comparison of each attribute and not references
	 * @param a : An arraylist of persons
	 * @param p : a person
	 * @return : true if the person is contained in the arraylist, false otherwise
	 */
	private boolean contains(ArrayList<Person> a, Person p){
		for(Person pers : a)
			if(p.equals(pers))
				return true;
		return false;
	}
}
