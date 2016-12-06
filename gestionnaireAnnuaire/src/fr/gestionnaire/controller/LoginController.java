package fr.gestionnaire.controller;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute Person p, BindingResult result){
    	if( loginManager.checkLogin(p) && loginManager.checkPassword(p) )
    		return new ModelAndView("user");
    	return new ModelAndView("login");
    }
    
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public ModelAndView sayHelloUser() {
//    	System.out.println("SALUT");
//        logger.info("Running " + this);
//        return new ModelAndView("user", "now", null);
//    }
//    
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public ModelAndView loginUser(@ModelAttribute("userLogin") ArrayList<String> p, BindingResult result){
//    	Person personData=null;
//    	Dao dao = new Dao();
//		dao.setUrl("jdbc:mysql://localhost:3306/projetjee?useSSL=false");
//		dao.setUser("root");
//		dao.setPassword("");
//		dao.setDriverName("com.mysql.jdbc.Driver");
//		if(this.dao==null)
//			System.out.println("NULL");
//    	
//    	try { personData = dao.loginPerson(p.get(0), p.get(1)); } catch (Exception e) {e.printStackTrace();}
//
//		if( personData == null ){
//			/*maSession.setAttribute("error", "Email ou mot de passe invalide");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//			return;*/
//			return new ModelAndView("login", "now", null);

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