package fr.gestionnaire.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckerPwd {
	
	private static Pattern pattern;
	private static Matcher matcher;
	private static String pwd;

	private static final String PWD_PATTERN ="^[a-zA-Z0-9-_!?]+$";

	/**
	 * Validate string with regular expression
	 *
	 * @param string for validation
	 * @return true valid string, false invalid string
	 */
	public static boolean validate(final String string) {
		pattern = Pattern.compile(PWD_PATTERN);
		
		if( pwd.length() < 5 ) return false;
		
		matcher = pattern.matcher(string);
		return matcher.matches();
	}
}
