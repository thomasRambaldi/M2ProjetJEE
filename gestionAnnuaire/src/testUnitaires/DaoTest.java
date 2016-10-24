package testUnitaires;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import exceptions.DaoException;
import gestionAnnuaire.Dao;
import gestionAnnuaire.Person;


public class DaoTest {

	private Dao dao;
	private Person p1;
	private Person p2;
	private Collection<Person> list;
	
	@Before
	public void before(){
		dao = new Dao();
		
		p1 = new Person();
		p1.setFirstName("Rambaldi");
		p1.setLastName("Thomas");
		p1.setMail("t.rambaldi13@gmail.com");
		p1.setWeb("http://thomas.rambaldi.etu.perso.luminy.univ-amu.fr");
		p1.setPassword("PassWord");
		
		p2 = new Person();
		p2.setFirstName("Lebreton");
		p2.setLastName("Kévin");
		p1.setMail("k.lebreton@gmail.com");
		p1.setWeb("http://kevin.lebreton.etu.perso.luminy.univ-amu.fr");
		p1.setPassword("PassWord2");
		
		list.add(p1);

	}
	
	@Test
	public void findPersons() throws DaoException {
		String query = "SELECT nom, prénom From Personnes";
		assertEquals(list, dao.findPersons());
	}
	
	

}
