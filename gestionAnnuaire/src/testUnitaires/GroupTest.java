package testUnitaires;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import gestionAnnuaire.Group;

public class GroupTest {

	Group g = new Group();

	@Before
	public void init(){
		g.setIdGroup(1);
		g.setNameGroup("ISL");
	}

	@Test
	public void getIdGroupTest() {
		assertEquals(1, g.getIdGroup());
	}

	@Test
	public void getNameGroupTest() {
		assertEquals("ISL", g.getNameGroup());
	}
}
