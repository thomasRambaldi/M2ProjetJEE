package fr.gestionnaire.web;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.DaoException;
import fr.gestionnaire.annuaire.Dao;
import fr.gestionnaire.annuaire.Group;
import fr.gestionnaire.annuaire.Person;

@Service
public class PersonManager {

	@Autowired
	private Dao dao;

	public PersonManager() { }

	public void updatePerson(Person p)  {
		try {
			dao.updatePerson(p, p.getIdPers());
		} catch (SQLException | DaoException e) {
			e.printStackTrace();
		}
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

	public void savePerson(Person p){
		try {
			dao.savePerson(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Group findGroupNameFromPerson(String email) {
		Group group;
		try {
			group = dao.findGroupNameFromPerson(email) ;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return group;
	}
	
	public Group findGroup(long id) {
		Group group;
		try {
			group = dao.findGroup(id) ;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return group;
	}
	
	public ArrayList<Person> searchPerson(String search){
		return dao.searchPerson(search);
	}

	public void addGroupsTests(int numberOfGroups) {
		dao.addRandomizedGroup(numberOfGroups);
		
	}
	
	public void deleteGroupsTests(int numberOfGroups) {
		dao.deleteRandomizedGroup(numberOfGroups);
		
	}
	
	public void addPersonsTests(int numberOfPersons, ArrayList<Integer> idsGroups) {
		dao.addRandomizedPersons(numberOfPersons,idsGroups);
		
	}

	public void deleteTestPersons(int numberOfPersons) {
		dao.deleteRandomizedPersons(numberOfPersons);
	}

}
