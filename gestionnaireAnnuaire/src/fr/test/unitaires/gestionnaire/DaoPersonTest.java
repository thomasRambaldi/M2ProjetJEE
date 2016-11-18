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
@ContextConfiguration(locations = "spring.xml")
public class DaoPersonTest {
//TODO	private JdbcTemplate jdbcTemplate;

	@Autowired
	private Dao dao;

	private Person p1;
	private Person p2;
	private Person p3;

	@Before
	public void setup() throws SQLException, DaoException{
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

		p3 =new Person();
		p3.setId(3);
		p3.setIdGroup(2);
		p3.setFirstName("Magron");
		p3.setLastName("Benjamin");
		p3.setMail("b.magron@gmail.com");
		p3.setWeb("http://benjamin.magron.etu.perso.luminy.univ-amu.fr");
		p3.setNaissance("28/28/28");
		p3.setPassword("coucou");
		
		dao.savePerson(p1);
		dao.savePerson(p2);
	}

	@After
	public void tearDown() throws SQLException{
		p3.setId(3);
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
		assertEquals(p1.getId(), dao.findPerson(1).getId());
	}
	
	@Test 
	public void findPersonDontExistTest() throws DaoException, SQLException  {
		assertEquals(null, dao.findPerson(300));
	}

	@Test
	public void savePersonTest() throws SQLException, DaoException{
		dao.savePerson(p3);
		assertEquals(3, dao.findPerson(3).getId());
	}
	
	@Test(expected = MySQLIntegrityConstraintViolationException.class)
	public void savePersonAlreadyExistTest() throws SQLException, DaoException{
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
	
	@Test (expected = SQLException.class)
	public void savePersonCheckerTest() throws SQLException, DaoException{
		Person p = new Person();
		p.setId(1);
		p.setIdGroup(2);
		p.setFirstName("Campanella");
		p.setPassword("coucou");
		dao.savePerson(p);
	}

	@Test
	public void deletePersonTest() throws SQLException{
		dao.deletePerson(p3);
	}
	
	@Test
	public void deletePersonDontExistTest() throws SQLException{
		Person p = new Person();
		p.setId(200);
		p.setIdGroup(2);
		p.setFirstName("Campanella");
		p.setLastName("Florian");
		p.setMail("f.campanella@gmail.com");
		p.setWeb("http://florian.campanella.etu.perso.luminy.univ-amu.fr");
		p.setNaissance("12/01/1993");
		p.setPassword("test");
		
		dao.deletePerson(p);
	}

	@Test
	public void updatePersonTest() throws SQLException, DaoException{
		p3.setMail("k.kevin@gmail.com");
		p3.setNaissance("");
		dao.updatePerson(p3, p3.getId());
	}
	
	@Test
	public void updatePersonDontExist() throws SQLException, DaoException{
		Person p = new Person();
		p.setId(200);
		p.setIdGroup(2);
		p.setFirstName("Campanella");
		p.setLastName("Florian");
		p.setMail("f.campanella@gmail.com");
		p.setWeb("http://florian.campanella.etu.perso.luminy.univ-amu.fr");
		p.setNaissance("12/01/1993");
		p.setPassword("test");
		
		dao.updatePerson(p, p.getId());
	}

	@Test (expected = MySQLIntegrityConstraintViolationException.class)
	public void updatePersonAlreadyExistTest() throws SQLException, DaoException{
		int oldId = p3.getId();
		dao.savePerson(p3);
		p3.setId(1);
		dao.updatePerson(p3, oldId);
	}
	
	@Test
	public void updatePersonDontExistTest() throws SQLException{
	
	}
	
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
