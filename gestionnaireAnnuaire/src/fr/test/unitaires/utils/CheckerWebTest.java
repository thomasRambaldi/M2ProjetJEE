package fr.test.unitaires.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.gestionnaire.utils.CheckerWeb;

public class CheckerWebTest {

	CheckerWeb cw;

	@Before
	public void init(){
		cw = new CheckerWeb();
	}

	@After
	public void tearDown(){
		cw = null;
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
}
