package fr.gestionnaire.web;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.DaoException;
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
		return listGroup;
	}
	
	public Collection<Group> findAllGroupWithGroupInFirst(Group g){
		Collection<Group> listGroup;
		try {
			listGroup= dao.findAllGroupWithGroupInFirst(g);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listGroup;
	}
	
	public Group findGroup(String name){
		Group group;
		try {
			group= dao.findGroup(name);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return group;
	}
	
	public ArrayList<Group> searchGroup(String search){
		ArrayList<Group> groups;
		groups= dao.searchGroup(search);
		return groups;
	}


	public void deleteGroup(Group g){
		try {
			dao.deleteGroup(g);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// TODO : A implementer dans la partie controller
	public void saveGroup(Group g){
		try {
			dao.saveGroup(g);
		} catch (SQLException | DaoException e) {
			e.printStackTrace();
		}
	}
}













