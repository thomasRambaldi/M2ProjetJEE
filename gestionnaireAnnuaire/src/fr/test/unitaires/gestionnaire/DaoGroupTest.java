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
import fr.gestionnaire.annuaire.Group;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:fr/test/unitaires/gestionnaire/spring.xml")
public class DaoGroupTest {
	// TODO	private JdbcTemplate jdbcTemplate;

	@Autowired
	private Dao dao;

	private Group g1;
	private Group g2;
	private Group g3;

	@Before
	public void setup() throws SQLException, DaoException{
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
		g3.setIdGroup(3);
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
		listGroup.add(g1); 
		listGroup.add(g2);

		Collection<Group> fag = dao.findAllGroups();

		Iterator<Group> iterator = fag.iterator();
		while (iterator.hasNext()){
			Group group = iterator.next();
			assertTrue(contains(listGroup, group));
		}
	}

	@Test
	public void saveGroupTest() throws SQLException, DaoException{
		dao.saveGroup(g3);
		assertEquals(3, dao.findGroup(3).getIdGroup());
	}

	// TODO : Faire le checker de savegroup( comme saveperson) 

	@Test(expected = MySQLIntegrityConstraintViolationException.class)
	public void saveGroupAlreadyExistTest() throws SQLException, DaoException{
		Group g = new Group();
		g.setIdGroup(1);
		g.setNameGroup("M2 GL 2015/2016");
		dao.saveGroup(g);
	}

//	@Test(expected = DaoException.class)
//	public void saveGroupWithErrorInGroupNameTest() throws SQLException, DaoException{
//		Group g = new Group();
//		g.setNameGroup("M3 GL 2015/2016");
//		dao.saveGroup(g);
//	}

	@Test
	public void deleteGroupTest() throws SQLException{
		dao.deleteGroup(g3);
	}

	@Test
	public void deleteGroupDontExistTest() throws SQLException{
		Group g = new Group();
		g.setIdGroup(200);
		g.setNameGroup("M2 FSI 2015/2016");

		dao.deleteGroup(g);
	}

	@Test
	public void updateGroupTest() throws SQLException, DaoException{
		g3.setNameGroup("M2 ISL 2015/2016");
		dao.updateGroup(g3, g3.getIdGroup());
	}

	@Test (expected = MySQLIntegrityConstraintViolationException.class)
	public void updateGroupAlreadyExistTest() throws SQLException, DaoException{
		int oldId = g3.getIdGroup();
		dao.saveGroup(g3);
		g3.setIdGroup(1);
		dao.updateGroup(g3, oldId);
	}

//	@Test (expected = DaoException.class)
//	public void updateGroupWithErrorInGroupNameTest() throws SQLException, DaoException{
//		dao.saveGroup(g3);
//		g3.setNameGroup("M3 ISL 2015/2016");;
//		dao.updateGroup(g3, g3.getIdGroup());
//	}

	private boolean contains(ArrayList<Group> a, Group g){
		for(Group grp : a)
			if(grp.equals(g))
				return true;
		return false;
	}
}
