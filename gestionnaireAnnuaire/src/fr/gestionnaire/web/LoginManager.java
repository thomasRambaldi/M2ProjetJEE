package fr.gestionnaire.web;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		if( personDao == null ) return false;
		
		if( personDao.getMail().equals( p.getMail()) )
			return true;
		return false;
	}
	
	public boolean checkPassword( Person p ){
		Person personDao;
		
		try {
			personDao = dao.findPerson(p.getMail());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
		if( personDao.getPassword().equals( p.getPassword()) )
			return true;
		return false;
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
	
//    public void save(Person p) {
//        if (p.getMail() == null) {
//            p.setNumber(maxId++);
//        }
//        dao.savePerson(p);
//    }
	
}
