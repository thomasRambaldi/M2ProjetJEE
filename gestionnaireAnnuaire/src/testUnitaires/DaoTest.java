package testUnitaires;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import exceptions.DaoException;
import gestionnaireAnnuaire.Dao;
import gestionnaireAnnuaire.Group;
import gestionnaireAnnuaire.JdbcTools;
import gestionnaireAnnuaire.Person;


public class DaoTest extends JdbcTools{

	private Dao dao;
	private JdbcTools jdbc;
	private Person p1;
	private Person p2;
	private Collection<Person> list;
	
	private Group g1;
	private Group g2;

	@Before
	public void before() throws SQLException{

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
		p2.setLastName("Kevin");
		//		p2.setMail("k.lebreton@gmail.com");
		//		p2.setWeb("http://kevin.lebreton.etu.perso.luminy.univ-amu.fr");
		//		p1.setNaissance("28/03/1992");
		p2.setPassword("azerty");

		//		list.add(p1);

		
		g1 = new Group();
		g1.setIdGroup(1);
		g1.setNameGroup("M2 FSIL 2015/2016");
		
		g2 = new Group();
		g2.setIdGroup(2);
		g2.setNameGroup("M2 IM 2015/2016");
	}

	@Test
	public void findPersonTest() throws DaoException, SQLException  {
		assertEquals(p1.getId(), dao.findPerson(1).getId());
	}

	@Test
	public void findAllPersons(){
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
	public void savePersonTest(){
		Person p =new Person();

		p.setIdGroup(1);
		p.setFirstName("Magron");
		p.setLastName("Benjamin");
		p.setMail("b.magron@gmail.com");
		p.setWeb("http://benjamin.magron.etu.perso.luminy.univ-amu.fr");
		//		p.setNaissance("");
		p.setPassword("coucou");

		dao.savePerson(p);

		assertEquals("Magron", dao.findPerson(3).getFirstName());

	}

	@Test
	public void deletePersonTest(){
		Person p =new Person();

		p.setIdGroup(1);
		p.setFirstName("Magron");
		p.setLastName("Benjamin");
		p.setMail("b.magron@gmail.com");
		p.setWeb("http://benjamin.magron.etu.perso.luminy.univ-amu.fr");
		//		p.setNaissance("");
		p.setPassword("coucou");
		
		dao.deletePerson(p);
		
	}
	
	@Test
	public void findGroupTest(){
		assertEquals(g1.getIdGroup(), dao.findGroup(1).getIdGroup());
	}

	@Test
	public void findAllGroupTest(){
		Collection<Group> listGroup = new ArrayList<>();
		listGroup.add(g1); listGroup.add(g2);

		Collection<Group> fap = dao.findAllGroups();

		Iterator<Group> iterator = listGroup.iterator();
		Iterator<Group> iterator2 = fap.iterator();

		while (iterator.hasNext() && iterator2.hasNext() ){

			Group group = iterator.next();
			Group  groupFap =  iterator2.next();

			assertEquals(group.getIdGroup(),  groupFap.getIdGroup());
		}

	}
	
	@Test
	public void saveGroupTest(){
		Group g =new Group();

		g.setNameGroup("M2 ID 2015/2016");

		dao.saveGroup(g);

		assertEquals("Magron", dao.findPerson(3).getFirstName());

	}

	@Test
	public void deleteGroupTest(){
		Group g =new Group();

		g.setNameGroup("M2 ID 2015/2016");
		
		dao.deleteGroup(g);
		
	}

}
