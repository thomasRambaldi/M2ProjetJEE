package fr.gestionnaire.controller;



import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/connexion")
public class LoginController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView sayHello() {
        String now = (new Date()).toString();
        logger.info("Running " + this);
        return new ModelAndView("login", "now", now);
    }

}