package fr.gestionnaire.controller;



import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.gestionnaire.annuaire.IPersonDao;
import fr.gestionnaire.annuaire.Person;

@Controller()
@RequestMapping("/connexion")
public class LoginController {

	@Autowired
	IPersonDao personDao;
	
    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView sayHello() {
        String now = (new Date()).toString();
        logger.info("Running " + this);
        return new ModelAndView("login", "now", now);
    }

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