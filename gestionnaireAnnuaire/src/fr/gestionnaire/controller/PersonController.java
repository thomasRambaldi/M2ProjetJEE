package fr.gestionnaire.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gestionnaire.annuaire.Group;
import fr.gestionnaire.annuaire.Person;
import fr.gestionnaire.web.PersonManager;

@Controller()
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonManager personManager;

	@RequestMapping(value = "/showPerson", method = RequestMethod.GET)
	public String displayInfoPers(@ModelAttribute Person p, HttpServletRequest request,
			@RequestParam(value = "id") Integer id){

		Person pers = personManager.findPerson(id);
		Group group = personManager.findGroup(pers.getIdGroup());
		request.getSession().setAttribute("infoPerson", pers);
		request.getSession().setAttribute("groupPersonListed", group);
		return "infoPerson";
	}

	@RequestMapping(value = "/showPersInGroup", method = RequestMethod.GET)
	public String displayPersInGroup(@ModelAttribute Person p, HttpServletRequest request,
			@RequestParam(value = "id") Integer id){
		Group g = personManager.findGroup(id);
		Collection<Person> listPers = personManager.findAllPersonInGroup(id);
		request.getSession().setAttribute("groupCurrentlyViewed", g);
		request.getSession().setAttribute("persInGroup", listPers);
		return "infoGroup";
	}

}
