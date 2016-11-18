package fr.gestionnaire.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckerWeb implements IChecker {
	private Pattern pattern;
	private Matcher matcher;
	
	private static final String WEB_PATTERN  = "^http://[a-zA-Z.-]*.[a-zA-Z]{2,3}$";
	
	public CheckerWeb() {
		pattern = Pattern.compile(WEB_PATTERN );
	}

	/**
	 * Validate string with regular expression
	 *
	 * @param string for validation
	 * @return true valid string, false invalid string
	 */
	public boolean validate(final String string) {
		matcher = pattern.matcher(string);
		return matcher.matches();

	}
}
