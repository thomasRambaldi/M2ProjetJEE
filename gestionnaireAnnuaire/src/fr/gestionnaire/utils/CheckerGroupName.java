package fr.gestionnaire.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckerGroupName {
	
	private static Pattern pattern;
	private static Matcher matcher;
	
	private static final String NOM_GROUP_PATTERN = "^(L[1-3]|M[1-2]) [a-zA-Z]* [0-9]{4}/[0-9]{4}$";

	/**
	 * Validate string with regular expression
	 *
	 * @param string for validation
	 * @return true valid string, false invalid string
	 */
	public static boolean validate(final String string) {
		pattern = Pattern.compile(NOM_GROUP_PATTERN);
		matcher = pattern.matcher(string);
		return matcher.matches();

	}
}
