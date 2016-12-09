package fr.gestionnaire.web;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.DaoException;
import fr.gestionnaire.annuaire.Dao;
import fr.gestionnaire.annuaire.Person;

@Service
public class LoginManager {
	
	@Autowired
	private Dao dao;
	
	public LoginManager(){	}

	public boolean checkLogin( Person p ){
		Person personDao;
		
		try {
			personDao = dao.findPerson(p.getMail());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return personDao != null;
	}
	
	public boolean checkPassword( Person p ){
		Person personDao;
		
		try {
			personDao = dao.loginPerson(p.getMail(), p.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return personDao != null;
	}
	
	
	public Person infoPersonWithPers(Person p){
		Person personDao;
		try {
			personDao = dao.findPerson(p.getMail());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return personDao;
	}
	
	public Person infoPersonWithId(Integer idPers){
		Person personDao;
		try {
			personDao = dao.findPerson(idPers);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return personDao;
	}
	
	public Collection<Person> getAllPersons(){
		Collection<Person> p = null;
		try {
			p = dao.findAllPersons();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
    
    public void updatePerson(Person p) throws SQLException, DaoException {
    	dao.updatePerson(p, p.getIdPers());
    }
	
}
