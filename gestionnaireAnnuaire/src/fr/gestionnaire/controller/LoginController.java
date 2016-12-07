package fr.gestionnaire.controller;



import java.sql.SQLException;

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
import org.springframework.web.servlet.ModelAndView;

import exceptions.DaoException;
import fr.gestionnaire.annuaire.Person;
import fr.gestionnaire.web.LoginManager;

@Controller()
@RequestMapping("/connexion")
public class LoginController {
	
	@Autowired
	private LoginManager loginManager;
	
	protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String sayHello(@ModelAttribute Person p, BindingResult result) {
        logger.info("Running " + this);
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute Person p, BindingResult result, HttpServletRequest request){
    	if( loginManager.checkLogin(p) && loginManager.checkPassword(p) ){
    		System.out.println("YES");
    		Person pers = loginManager.infoPersonWithPers(p);
    		HttpSession maSession = request.getSession();
    		maSession.setAttribute("personLogged", pers);
    		return "redirect:user";
    	}
    	return "login";
    }
    
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String editProduct(@ModelAttribute Person p) {
		logger.info("Running " + this);
	    return "user";
	}
	
//	@ModelAttribute
//	public Person editPerson(
//	        @RequestParam(value = "id", required = false) Integer idPers) {
//	    if (idPers != null) {
//	        logger.info("find product " + idPers);
//	        return loginManager.infoPersonWithId(idPers);
//	    }
//	    Person p = new Person();
//	    p.setIdPers(0);
//	    p.setIdGroup(0);
//	    p.setFirstName("");
//	    p.setLastName("");
//	    p.setMail("");
//	    p.setWeb("");
//	    p.setNaissance("");
//	    p.setPassword("");
//	    
//	    logger.info("edit person = " + p);
//	    return p;
//	}
	
	//TODO: Faire que si il ya une exception (Dao ou Sql) empecher de faire l'update 
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String updatePerson(@ModelAttribute Person p, BindingResult result, HttpServletRequest request) {
	    System.out.println("UPDATE");
		if (result.hasErrors()) {
	        return "user";
	    }
	    try {
			loginManager.updatePerson(p);
		} catch (SQLException | DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:user";
		}
	    HttpSession maSession = request.getSession();
		maSession.setAttribute("personLogged", p);
	    return "redirect:user";
	}
	
    
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public ModelAndView sayHelloUser() {
//    	System.out.println("SALUT");
//        logger.info("Running " + this);
//        return new ModelAndView("user", "now", null);
//    }
    
//    @ModelAttribute(name="userLogin")
//    public ArrayList<String> newLogin(
//            @RequestParam(value = "login", required = false) String login,
//            @RequestParam(value = "pwd", required = false) String pwd) {
//        if (login != null) {
//            logger.info("find product " + login +" - "+pwd);
//            ArrayList<String> p = new ArrayList<>();
//            p.add(login);
//            p.add(pwd);
//            return p;
//        }
//        return null;
//    }
    
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public ModelAndView loginUser(@ModelAttribute Person p, BindingResult result){
//        logger.info(p + "POST POST " + this);
//        return new ModelAndView("user");
//    }

//    @ModelAttribute("person")
//    Person person() throws SQLException {
//        logger.info("information profile");
//        Person p = new Person();
//        System.out.println("LoginController ---> " + p );
//        p = personDao.findPerson(500);
//        return p;
//    }
//
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public String listProducts2()	 {
//        logger.info("Liste info");
//        return "personLogged";
//    }
    
//    http://localhost:8080/gestionnaireAnnuaire/actions/connexion/list?id=5
    
    
}