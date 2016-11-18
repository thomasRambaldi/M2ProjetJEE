package fr.test.unitaires.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.gestionnaire.utils.CheckerMail;

public class CheckerMailTest {

	CheckerMail cm;
	
	@Before
	public void init(){
		cm = new CheckerMail();
	}
	
	@After
	public void tearDown(){
		cm = null;
	}
	
	@Test
	public void CheckerMailTrueTest() {
		assertTrue( cm.validate("thomas.rambaldi@etu.univ-amu.fr") );
	}

	@Test
	public void CheckerMailWithNumberTest() {
		assertTrue(cm.validate("alias_13500@hotmail.fr") );
	}
	
	@Test
	public void CheckerMailWithoutArobaseTest() {
		assertFalse (cm.validate("thomas.rambaldi.fr") );
	}
	
	@Test
	public void CheckerMailWithoutEndTest() {
		assertFalse (cm.validate("thomas.rambaldi@testfr") );
	}

}
