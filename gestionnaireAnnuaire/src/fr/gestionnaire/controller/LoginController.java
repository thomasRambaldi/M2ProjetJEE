package fr.gestionnaire.controller;



import java.sql.SQLException;
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

import exceptions.DaoException;
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
			Group groupInfo = personManager.findGroupNameFromPerson(pers.getIdGroup());
			HttpSession maSession = request.getSession();
			maSession.setAttribute("personLogged", pers);
			maSession.setAttribute("groupName", groupInfo);
			maSession.setAttribute("connected", true);
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

		Collection<Group> allGroup = groupManager.findAllGroup();
		request.getSession().setAttribute("listGroup", allGroup);
		return "editUser";
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public String updatePerson(@ModelAttribute @Valid Person p, @ModelAttribute Group g, BindingResult result, HttpServletRequest request) {
		Person personSession = (Person) request.getSession().getAttribute("personLogged");
		String groupSession = request.getParameter("groups");
		Group group = groupManager.findGroup(groupSession);

		p.setIdPers(personSession.getIdPers());

		p = (Person) request.getSession().getAttribute("personLogged");
		p.setIdGroup(group.getIdGroup()); // A VOIR SI UTILE
		
		if (result.hasErrors()) {
			return "editUser";
		}
		try {
			personManager.updatePerson(p);
		} catch (SQLException | DaoException e) {
			e.printStackTrace();
			return "editUser";
		}
		Group groupInfo = personManager.findGroupNameFromPerson(group.getIdGroup());
		HttpSession maSession = request.getSession();
		maSession.setAttribute("personLogged", p);
		maSession.setAttribute("groupName", groupInfo);
		return "user";
	}

	@RequestMapping(value = "/log_out", method = RequestMethod.GET)
	public String logOutUser(HttpServletRequest request) {
		request.getSession().setAttribute("personLogged", null);
		request.getSession().setAttribute("connected", null);
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
	public String signUpPerson(@ModelAttribute @Valid Person p, @ModelAttribute Group g, BindingResult result, 
			HttpServletRequest request) {

		String groupSession = request.getParameter("groupsSignUp");
		Group group = groupManager.findGroup(groupSession);
		p.setIdGroup(group.getIdGroup());
		
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