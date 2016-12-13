package fr.gestionnaire.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.gestionnaire.annuaire.Group;
import fr.gestionnaire.annuaire.Person;
import fr.gestionnaire.web.GroupManager;

@Controller()
@RequestMapping("/group")
public class GroupController {

	@Autowired
	GroupManager groupManager;
	
	@RequestMapping(value = "/addGroup", method = RequestMethod.GET)
	public String signUpPersonGet(Group g) {
	    return "ajoutGroupe";
	}
	
	@RequestMapping(value = "/addGroup", method = RequestMethod.POST)
	public String signUpPerson(@ModelAttribute @Valid Group g, BindingResult result, HttpServletRequest request) {
	    if (result.hasErrors()) {
	        return "ajoutGroupe";
	    }
	    groupManager.saveGroup(g);
	    return "redirect:actions/lists/groupList";
	}
}
