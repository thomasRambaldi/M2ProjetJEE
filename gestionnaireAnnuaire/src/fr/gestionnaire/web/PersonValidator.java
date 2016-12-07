package fr.gestionnaire.web;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.gestionnaire.annuaire.Person;

@Service
public class PersonValidator implements Validator{


    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	Person person = (Person) target;

    	 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
                 "person.idPers", "Field name is required.");
    	 
    	 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
                 "person.idGroup", "Field name is required.");
    	
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
                "person.firstName", "Field name is required.");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
        		"person.lastName", "Field description is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
                "person.mail", "Field description is required.");
        
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type",
//                "product.web", "Field type is required.");
        
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type",
//                "product.naissance", "Field type is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type",
                "person.password", "Field type is required.");

//        if (!(person .getPrice() > 0.0)) {
//            errors.rejectValue("price", "product.price.too.low",
//                    "Price too low");
//        }
    }

}
