package testUnitaires;

import static org.junit.Assert.*;

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

import gestionnaireAnnuaire.Dao;
import gestionnaireAnnuaire.Group;
import gestionnaireAnnuaire.Person;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "spring.xml")
public class DaoGroupTest {
// TODO	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private Dao dao;
	
	private Group g1;
	private Group g2;
	private Group g3;

	@Before
	public void setup() throws SQLException{
		g1 = new Group();
		g1.setIdGroup(1);
		g1.setNameGroup("M2 FSIL 2015/2016");

		g2 = new Group();
		g2.setIdGroup(2);
		g2.setNameGroup("M2 IM 2015/2016");
		
		g3 = new Group();
		g3.setIdGroup(3);
		g3.setNameGroup("M2 ID 2015/2016");
	
		dao.saveGroup(g1);
		dao.saveGroup(g2);
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
	public void findGroupDontExistTest() throws SQLException{
		assertEquals(null, dao.findGroup(300));
	}

	@Test
	public void findAllGroupTest() throws SQLException{
		ArrayList<Group> listGroup = new ArrayList<>();
		listGroup.add(g1); listGroup.add(g2);

		Collection<Group> fag = dao.findAllGroups();

		Iterator<Group> iterator = fag.iterator();

		while (iterator.hasNext()){

			Group group = iterator.next();
			assertTrue(contains(listGroup, group));
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
		dao.updateGroup(g3, g3.getIdGroup());
	}
	
	@Test (expected = MySQLIntegrityConstraintViolationException.class)
	public void updateGroupAlreadyExistTest() throws SQLException{
		int oldId = g3.getIdGroup();
		dao.saveGroup(g3);
		g3.setIdGroup(1);
		dao.updateGroup(g3, oldId);
	}
	
	private boolean contains(ArrayList<Group> a, Group g){
		for(Group grp : a)
			if(grp.equals(g))
				return true;
		return false;
	}

}
