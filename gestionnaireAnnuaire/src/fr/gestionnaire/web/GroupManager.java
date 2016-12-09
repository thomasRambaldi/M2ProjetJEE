package fr.gestionnaire.web;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gestionnaire.annuaire.Dao;
import fr.gestionnaire.annuaire.Group;

@Service
public class GroupManager {

	@Autowired
	private Dao dao;
	
	public GroupManager() { }
	
	public Collection<Group> findAllGroup(){
    	Collection<Group> listGroup;
    	try {
			listGroup= dao.findAllGroups();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    	System.out.println("********************");
    	System.out.println(listGroup);
    	System.out.println("********************");
    	return listGroup;
	}
}
