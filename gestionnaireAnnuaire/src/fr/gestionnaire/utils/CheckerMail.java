package fr.gestionnaire.utils;

import java.util.regex.*;

public class CheckerMail{

	private static Pattern pattern;
	private static Matcher matcher;

	private static final String EMAIL_PATTERN =
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-_]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Validate string with regular expression
	 *
	 * @param string for validation
	 * @return true valid string, false invalid string
	 */
	public static boolean validate(final String string) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(string);
		return matcher.matches();

	}
}
