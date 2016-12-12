package fr.gestionnaire.web;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.DaoException;
import fr.gestionnaire.annuaire.Dao;
import fr.gestionnaire.annuaire.Person;

@Service
public class PersonManager {

	@Autowired
	private Dao dao;

	public PersonManager() { }

	public void updatePerson(Person p) throws SQLException, DaoException {
		dao.updatePerson(p, p.getIdPers());
	}

	public Collection<Person> findAllPerson(){
		Collection<Person> listPerson;
		try {
			listPerson = dao.findAllPersons();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listPerson;
	}

	public Person findPerson(int id){
		Person person;
		try {
			person = dao.findPerson(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return person;
	}

	public Collection<Person> findAllPersonInGroup(int id){
		Collection<Person> listPerson;
		try {
			listPerson = dao.findAllPersons(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listPerson;
	}

	public void deletePerson(Person p){
		try {
			dao.deletePerson(p);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}


	// TODO : a implementer dans la partir controller
	public void savePerson(Person p){
		try {
			dao.savePerson(p);
		} catch (SQLException e) {
			System.out.println("first try");
			e.printStackTrace();
		} catch (DaoException e) {
			System.out.println("second try");
			e.printStackTrace();
		}
	}

}
