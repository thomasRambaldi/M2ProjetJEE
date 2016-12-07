package fr.gestionnaire.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.gestionnaire.annuaire.Person;

@Deprecated
public class Checker {
	private Pattern patternBP;
	private Matcher matcherBP;
	
	private Pattern patternNGP;
	private Matcher matcherNGP;
	
	private Pattern patternEP;
	private Matcher matcherEP;
	
	private Pattern patternWP;
	private Matcher matcherWP;
	
	private static final String BIRTHDAY_PATTERN  = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";

	private static final String NOM_GROUP_PATTERN = "^L[1-3] [a-zA-Z]* [0-9]{4}/[0-9]{4}$";
	
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String WEB_PATTERN  = "^http://[a-zA-Z.-]*.[a-zA-Z]{2,3}$";
	
	public Checker() {
		patternBP = Pattern.compile(BIRTHDAY_PATTERN );
		patternNGP = Pattern.compile(NOM_GROUP_PATTERN);
		patternEP = Pattern.compile(EMAIL_PATTERN);
		patternWP = Pattern.compile(WEB_PATTERN );
	}
	
	public static boolean validatePerson(Person p){
		CheckerBirthDay birthday = new CheckerBirthDay();
		CheckerMail mail = new CheckerMail();
		CheckerWeb web = new CheckerWeb();
		return birthday.validate(p.getNaissance())
				&& mail.validate(p.getMail())
				&& web.validate(p.getWeb());
	}
	
	
	/**
	 * Validate string with regular expression
	 *
	 * @param string for validation
	 * @return true valid string, false invalid string
	 */
	public boolean validateBirthDay(final String string) {
		matcherBP = patternBP.matcher(string);
		return matcherBP.matches();
		
	}
	
	/**
	 * Validate string with regular expression
	 *
	 * @param string for validation
	 * @return true valid string, false invalid string
	 */
	public boolean validateGroupName(final String string) {
		matcherNGP = patternNGP.matcher(string);
		return matcherNGP.matches();
		
	}
	
	/**
	 * Validate string with regular expression
	 *
	 * @param string for validation
	 * @return true valid string, false invalid string
	 */
	public boolean validateEP(final String string) {
		matcherEP = patternEP.matcher(string);
		return matcherEP.matches();
		
	}

	/**
	 * Validate string with regular expression
	 *
	 * @param string for validation
	 * @return true valid string, false invalid string
	 */
	public boolean validateWeb(final String string) {
		matcherWP = patternWP.matcher(string);
		return matcherWP.matches();

	}
}
