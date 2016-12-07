package fr.gestionnaire.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckerBirthDay {
	private static Pattern pattern;
	private static Matcher matcher;
	
	private static final String BIRTHDAY_PATTERN  = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";

	/**
	 * Validate string with regular expression
	 *
	 * @param string for validation
	 * @return true valid string, false invalid string
	 */
	public static boolean validate(final String string) {
		pattern = Pattern.compile(BIRTHDAY_PATTERN );
		matcher = pattern.matcher(string);
		return matcher.matches();

	}
}
