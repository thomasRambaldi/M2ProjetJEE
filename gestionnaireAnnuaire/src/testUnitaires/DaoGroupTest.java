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

import gestionnaireAnnuaire.Dao;
import gestionnaireAnnuaire.Group;

public class DaoGroupTest {

	private Dao dao;
	private Group g1;
	private Group g2;
	private Group g3;

	@Before
	public void setup() throws SQLException{

		dao = new Dao();

		dao.setUrl("jdbc:mysql://localhost:3306/projetjee?autoReconnect=true&useSSL=false");
		dao.setUser("root");
		dao.setPassword("");
		dao.setDriverName("com.mysql.jdbc.Driver");

		g1 = new Group();
		g1.setIdGroup(1);
		g1.setNameGroup("M2 FSIL 2015/2016");

		g2 = new Group();
		g2.setIdGroup(2);
		g2.setNameGroup("M2 IM 2015/2016");
		
		dao.saveGroup(g1);
		dao.saveGroup(g2);
		
		g3 = new Group();
		g3.setIdGroup(3);
		g3.setNameGroup("M2 ID 2015/2016");
	}

	@After
	public void tearDown() throws SQLException{
		dao.deleteGroup(g1);
		dao.deleteGroup(g2);
		dao.deleteGroup(g3);
		dao = null;
		g1 = null;
		g2 = null;
		g3 = null;
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
		dao.saveGroup(g3);
		assertEquals(3, dao.findGroup(3).getIdGroup());
	}

	@Test(expected = MySQLIntegrityConstraintViolationException.class)
	public void saveGroupViolationTest() throws SQLException{
		Group g = new Group();
		g.setIdGroup(1);
		g.setNameGroup("M2 GL 2015/2016");
		dao.saveGroup(g);
	}

	
	@Test
	public void deleteGroupTest() throws SQLException{
		dao.deleteGroup(g3);
	}

	@Test
	public void updateGroupTest() throws SQLException{
		g3.setNameGroup("M2 ISL 2015/2016");
		
		dao.updateGroup(g3);
	}

}
