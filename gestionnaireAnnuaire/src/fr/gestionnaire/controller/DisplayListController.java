package fr.gestionnaire.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.gestionnaire.annuaire.Group;
import fr.gestionnaire.annuaire.Person;
import fr.gestionnaire.web.GroupManager;
import fr.gestionnaire.web.PersonManager;

@Controller()
@RequestMapping("/lists")
public class DisplayListController  {

	@Autowired
	private PersonManager personManager;

	@Autowired
	private GroupManager groupManager;

	
	protected final Log logger = LogFactory.getLog(getClass());
	
    @RequestMapping(value = "/personList", method = RequestMethod.GET)
    public String displayPersons(@ModelAttribute Person p, HttpServletRequest request) {
    	Collection<Person> listPerson = personManager.findAllPerson();
    	System.out.println("---------------------");
    	System.out.println(listPerson);
    	System.out.println("---------------------");
    	HttpSession maSession = request.getSession();
    	maSession.setAttribute("allPersons", listPerson);
    	return "personList";
    }
    
    @RequestMapping(value = "/personList", method = RequestMethod.POST)
    public String displayAllPersons(@ModelAttribute Person p, HttpServletRequest request) {
    	Collection<Person> listPerson = personManager.findAllPerson();
    	System.out.println("---------------------");
    	System.out.println(listPerson);
    	System.out.println("---------------------");
System.out.println(p.getFirstName());
    	HttpSession maSession = request.getSession();
    	maSession.setAttribute("persons", listPerson);
		return "personList";
    }
    
    
    @RequestMapping(value = "/groupList", method = RequestMethod.GET)
    public String displayGroups(@ModelAttribute Group g, HttpServletRequest request) {
    	Collection<Group> listGroup = groupManager.findAllGroup();
    	System.out.println("---------------------");
    	System.out.println(listGroup);
    	System.out.println("---------------------");
    	
    	HttpSession maSession = request.getSession();
    	maSession.setAttribute("groups", listGroup);
    	return "groupList";
    }
    
    @RequestMapping(value = "/groupList", method = RequestMethod.POST)
    public String displayAllGroups(@ModelAttribute Group g, BindingResult result,  HttpServletRequest request) {
//    	Collection<Person> listPerson = personManager.findAllPerson();
//    	System.out.println("COUCOUECOIJOKEJKLCJEZKL");
//    	HttpSession maSession = request.getSession();
//		maSession.setAttribute("listPersons", listPerson);
    	return "redirect:/lists/groupList";
    }
    
    
    
    
    
    
    
    
//    @RequestMapping(value = "/editPerson", method = RequestMethod.GET)
//    public String editPerson(@ModelAttribute Group g, HttpServletRequest request) {
//System.out.println("GET");
//    	return "editPerson";
//    }
//    
//    @RequestMapping(value = "/editPerson", method = RequestMethod.POST)
//    public String editPerson(@ModelAttribute Group g, BindingResult result,  HttpServletRequest request) {
////    	Collection<Person> listPerson = personManager.findAllPerson();
////    	System.out.println("COUCOUECOIJOKEJKLCJEZKL");
////    	HttpSession maSession = request.getSession();
////		maSession.setAttribute("listPersons", listPerson);
//    	System.out.println("POST");
//		return "personList";
//    }

}