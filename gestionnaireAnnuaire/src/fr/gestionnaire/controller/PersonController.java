package fr.gestionnaire.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		request.getSession().setAttribute("infoPerson", pers);
		return "infoPerson";
	}

	@RequestMapping(value = "/showPersInGroup", method = RequestMethod.GET)
	public String displayPersInGroup(@ModelAttribute Person p, HttpServletRequest request,
			@RequestParam(value = "id") Integer id){

		Collection<Person> listPers = personManager.findAllPersonInGroup(id);
		request.getSession().setAttribute("persInGroup", listPers);
		return "infoGroup";
	}


	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUpUser(@ModelAttribute Person p, BindingResult result) {
		return "signUp";
	}


	//TODO : Probleme lorsque l'on clique sur le bouton submit (No suitable driver found)
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUpUserConfirme(@ModelAttribute Person p, BindingResult result,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "signUp";
		}
		personManager.savePerson(p);
		return "redirect:/actions/connexion/login";
	}

}
