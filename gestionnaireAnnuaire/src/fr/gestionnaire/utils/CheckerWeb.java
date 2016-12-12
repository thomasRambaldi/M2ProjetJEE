package fr.gestionnaire.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckerWeb {
	private static Pattern pattern;
	private static Matcher matcher;
	
	private static final String WEB_PATTERN  = "^[a-zA-Z0-9.-][a-zA-Z0-9.-]*.[a-zA-Z]{2,3}$";
	

	/**
	 * Validate string with regular expression
	 *
	 * @param string for validation
	 * @return true valid string, false invalid string
	 */
	public static boolean validate(final String string) {
		pattern = Pattern.compile(WEB_PATTERN );
		matcher = pattern.matcher(string);
		return matcher.matches();
	}
}
