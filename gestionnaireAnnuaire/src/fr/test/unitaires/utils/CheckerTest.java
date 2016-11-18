package fr.test.unitaires.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.gestionnaire.utils.CheckerBirthDay;
import fr.gestionnaire.utils.CheckerGroupName;
import fr.gestionnaire.utils.CheckerMail;
import fr.gestionnaire.utils.CheckerWeb;

public class CheckerTest {

	CheckerBirthDay cb;
	CheckerMail cm;
	CheckerWeb cw;
	CheckerGroupName cgn;

	
	@Before
	public void init(){
		cb = new CheckerBirthDay();
		cm = new CheckerMail();
		cw = new CheckerWeb();
		cgn = new CheckerGroupName();
	}
	
	@After
	public void tearDown(){
		cb = null;
		cm = null;
		cw = null;
		cgn = null;
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
	
	@Test
	public void CheckerWebTrueTest() {
		assertTrue( cw.validate("http://thomas.rambaldi.etu.perso.luminy.univ-amu.fr") );
	}

	@Test
	public void CheckerWebWithNumberTest() {
		assertTrue(cw.validate("http://google.fr") );
	}

	@Test
	public void CheckerWebWithoutArobaseTest() {
		assertFalse (cw.validate("thomas.rambaldi.fr") );
	}

	@Test
	public void CheckerWebWithoutEndTest() {
		assertFalse (cw.validate("thomas.rambaldi@testfr") );
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
