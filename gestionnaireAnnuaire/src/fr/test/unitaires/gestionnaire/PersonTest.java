package fr.test.unitaires.gestionnaire;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fr.gestionnaire.annuaire.Person;

public class PersonTest {

	Person p = new Person();

	@Before
	public void init(){
		p.setIdPers(1);
		p.setFirstName("Rambaldi");
		p.setLastName("Thomas");
		p.setMail("t.rambaldi13@gmail.com");
		p.setWeb("http://thomas.rambaldi.etu.perso.luminy.univ-amu.fr");
		p.setNaissance("28/03/1992");
		p.setPassword("PassWord");
	}

	@Test
	public void getIdTest() {
		assertEquals(1, p.getIdPers());
	}

	@Test
	public void getFirstNameTest() {
		assertEquals("Rambaldi", p.getFirstName());
	}

	@Test
	public void getLastNameTest() {
		assertEquals("Thomas", p.getLastName());	
	}

	@Test
	public void getMailTest() {
		assertEquals("t.rambaldi13@gmail.com", p.getMail());
	}

	@Test
	public void getWebTest() {
		assertEquals("http://thomas.rambaldi.etu.perso.luminy.univ-amu.fr", p.getWeb());
	}

	@Test
	public void getNaissanceTest() {
		assertEquals("28/03/1992", p.getNaissance());
	}
	
	@Test
	public void getPasswordTest() {
		assertEquals("PassWord", p.getPassword());
	}
}
