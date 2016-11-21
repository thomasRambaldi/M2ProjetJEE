package fr.test.unitaires.utils;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.gestionnaire.utils.CheckerBirthDay;


public class CheckerBirthDayTest {

	CheckerBirthDay cb;
	
	@Before
	public void init(){
		cb = new CheckerBirthDay();
	}
	
	@After
	public void tearDown(){
		cb = null;
	}
	
	@Test
	public void CheckerBirthTrueTest() {
		assertTrue( cb.validate("28/03/1992") );
	}

	@Test
	public void CheckerBirthErrorTest() {
		assertFalse(cb.validate("208/03/1992") );
	}
	
	@Test
	public void CheckerBirthFalseTest() {
		assertFalse (cb.validate("aa/bb/cc") );
	}
}
