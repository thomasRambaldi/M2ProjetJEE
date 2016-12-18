package fr.gestionnaire.controller;



import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gestionnaire.annuaire.Group;
import fr.gestionnaire.annuaire.Person;
import fr.gestionnaire.web.GroupManager;
import fr.gestionnaire.web.LoginManager;
import fr.gestionnaire.web.PersonManager;

@Controller()
@RequestMapping("/connexion")
public class LoginController {

	@Autowired
	private LoginManager loginManager;

	@Autowired
	private PersonManager personManager;

	@Autowired
	private GroupManager groupManager;


	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute Person p, BindingResult result) {
		logger.info("Running as projet " + this);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Person p, Group g,  BindingResult result, HttpServletRequest request){
		if( loginManager.checkLogin(p) && loginManager.checkPassword(p) ){
			Person pers = loginManager.infoPersonWithPers(p);
			HttpSession maSession = request.getSession();
			maSession.setAttribute("personLogged", pers);
			maSession.setAttribute("groupPersonLogged", personManager.findGroup(pers.getIdGroup()));
			return "redirect:user";
		}
		return "login";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String displayUserInformation(@ModelAttribute Person p,  @ModelAttribute Group g, HttpServletRequest request) {
		if(request.getSession().getAttribute("personLogged") == null)
			return "redirect:login";
		return "user";
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public String editUserInformation(@ModelAttribute Person p, HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute("personLogged") == null)
			return "redirect:login";
		
		HttpSession session = request.getSession();
	    Person personSession = (Person) session.getAttribute("personLogged");
	    Group group = personManager.findGroup(personSession.getIdGroup());
		Collection<Group> allGroup = groupManager.findAllGroupWithGroupInFirst(group);
		request.getSession().setAttribute("listGroup", allGroup);
		return "editUser";
	}

	
		
	
	
	//Commentaire -> ajout compar� a la version op�rationnelle
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public String updatePerson(@ModelAttribute @Valid Person p, BindingResult result, HttpServletRequest request) {
		HttpSession session = request.getSession();
	    Person personSession = (Person) session.getAttribute("personLogged");
	    p.setIdPers(personSession.getIdPers());
	    
	    if (result.hasErrors()) {
	        return "editUser";
	    }
	    
		Group group = groupManager.findGroup(request.getParameter("groups")); //------------
		p.setIdGroup(group.getIdGroup());

	    personManager.updatePerson(p);
		
		session.setAttribute("groupPersonLogged", group);
	    session.setAttribute("personLogged", p);
	    return "user";
	}

	@RequestMapping(value = "/testAddPersons", method = RequestMethod.GET)
	public String addPersons(HttpServletRequest request){
		ArrayList<Integer> groupsId = new ArrayList<Integer>();
		Collection<Group> allGroups = groupManager.findAllGroup();
		for(Group g: allGroups)
			groupsId.add(g.getIdGroup());
		personManager.addPersonsTests(10000,groupsId);
		return "redirect:login";
	}
	
	@RequestMapping(value = "/deleteTestPersons", method = RequestMethod.GET)
	public String deleteTestPersons(HttpServletRequest request){
		personManager.deleteTestPersons(10000);
		return "redirect:login";
	}

	@RequestMapping(value = "/log_out", method = RequestMethod.GET)
	public String logOutUser(HttpServletRequest request) {
		request.getSession().setAttribute("personLogged", null);
		return "redirect:login";
	}

	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public String deletePerson(@ModelAttribute Person p, HttpServletRequest request,
			@RequestParam(value = "id") Integer id) {
		p.setIdPers(id);
		personManager.deletePerson(p);
		logOutUser(request);
		return "redirect:login";
	}

	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String signUpPersonGet(Person p, HttpServletRequest request) {
		Collection<Group> allGroup = groupManager.findAllGroup();
		request.getSession().setAttribute("listGroup", allGroup);
		return "inscription";
	}

	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public String signUpPerson(@ModelAttribute @Valid Person p, BindingResult result, 
			HttpServletRequest request) {

		p.setIdGroup(groupManager.findGroup(request.getParameter("groupSignUp")).getIdGroup());

		if (result.hasErrors()) {
			return "inscription";
		}
		personManager.savePerson(p);
		return "redirect:login";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String searchPerson(HttpServletRequest request ,@RequestParam(value = "personSearcher", required = false) String search){
		request.getSession().setAttribute("resultSearchPerson", personManager.searchPerson(search));
		return "resultSearch";
	}

}