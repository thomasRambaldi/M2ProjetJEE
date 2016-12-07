package fr.gestionnaire.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckerBirthDay {
	private Pattern pattern;
	private static Matcher matcher;
	
	private static final String BIRTHDAY_PATTERN  = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
	
	public CheckerBirthDay() {
		pattern = Pattern.compile(BIRTHDAY_PATTERN );
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
