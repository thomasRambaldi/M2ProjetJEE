package testUnitaires;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.DaoException;
import gestionnaireAnnuaire.Dao;
import gestionnaireAnnuaire.Group;
import gestionnaireAnnuaire.JdbcTools;
import gestionnaireAnnuaire.Person;


public class DaoTest extends JdbcTools{

	private Dao dao;
	private Person p1;
	private Person p2;

	private Group g1;
	private Group g2;

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
		p2.setLastName("Kevin");
		p2.setMail(null);
		p2.setWeb("");
		p1.setNaissance(null);
		p2.setPassword("azerty");

		g1 = new Group();
		g1.setIdGroup(1);
		g1.setNameGroup("M2 FSIL 2015/2016");

		g2 = new Group();
		g2.setIdGroup(2);
		g2.setNameGroup("M2 IM 2015/2016");
	}

	@After
	public void tearDown(){
		//		TODO : write the code
	}
	
	@Test
	public void findPersonTest() throws DaoException, SQLException  {
		assertEquals(p1.getId(), dao.findPerson(1).getId());
	}

	@Test
	public void findAllPersons() throws SQLException{
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
	public void savePersonTest() throws SQLException{
		//		TODO : correction bug
		Person p = new Person();
		p.setId(3);
		p.setIdGroup(2);
		p.setFirstName("Magron");
		p.setLastName("Benjamin");
		p.setMail("b.magron@gmail.com");
		p.setWeb("http://benjamin.magron.etu.perso.luminy.univ-amu.fr");
		p.setNaissance("");
		p.setPassword("coucou");

		dao.savePerson(p);

		//		assertEquals("Magron", dao.findPerson(3).getFirstName());

	}

	@Test
	public void deletePersonTest() throws SQLException{
		// TODO : correction bug (La person est null dans la fonction delete perosn)
		Person p =new Person();

		p.setIdGroup(4);
		p.setFirstName("Test");
		p.setLastName("Test");
		p.setMail("");
		p.setWeb(null);
		p.setNaissance("");
		p.setPassword("mdp");

		dao.deletePerson(p);

	}

	@Test
	public void updatePersonTest() throws SQLException{
		//TODO : correction bug
		p2.setMail("k.kevin@gmail.com");
		p2.setNaissance("");
		
		dao.updatePerson(p2);
	}

	@Test
	public void findGroupTest() throws SQLException{
		assertEquals(g1.getIdGroup(), dao.findGroup(1).getIdGroup());
	}

	@Test
	public void findAllGroupTest() throws SQLException{
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
	public void saveGroupTest() throws SQLException{
		//TODO : correction bug
		Group g =new Group();

		g.setIdGroup(3);
		g.setNameGroup("M2 ID 2015/2016");

		dao.saveGroup(g);

//		assertEquals("Magron", dao.findPerson(3).getFirstName());

	}

	@Test
	public void deleteGroupTest() throws SQLException{
		//TODO correction bug
		Group g =new Group();

		g.setIdGroup(g.getIdGroup());
		g.setNameGroup("M2 ID 2015/2016");

		
		dao.deleteGroup(g);

	}

	@Test
	public void updateGroupTest() throws SQLException{
		//TODO : correction bug
		g1.setNameGroup("M2 ISL 2015/2016");
		
		dao.updateGroup(g1);
	}
}
