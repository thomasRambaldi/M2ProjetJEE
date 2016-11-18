package fr.test.unitaires.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.gestionnaire.utils.CheckerGroupName;

public class CheckerGroupNameTest {

	CheckerGroupName cgn;
	
	@Before
	public void init(){
		cgn = new CheckerGroupName();
	}
	
	@After
	public void tearDown(){
		cgn = null;
	}
	
	@Test
	public void CheckerGroupNameL3TrueTest() {
		assertTrue( cgn.validate("L3 Info 2013/2014") );
	}
	
	@Test
	public void CheckerGroupNameM2TrueTest() {
		assertTrue( cgn.validate("M2 ISL 2015/2016") );
	}
	
	@Test
	public void CheckerGroupNameM3FalseTest() {
		assertFalse( cgn.validate("M3 ISL 2015/2016") );
	}
	
	@Test
	public void CheckerGroupNameDateTest() {
		assertFalse( cgn.validate("M2 ISL 2015/24016") );
	}

}

