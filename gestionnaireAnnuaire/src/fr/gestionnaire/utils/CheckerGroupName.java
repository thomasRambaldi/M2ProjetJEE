package fr.gestionnaire.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckerGroupName implements IChecker {
	
	private Pattern pattern;
	private Matcher matcher;
	
	private static final String NOM_GROUP_PATTERN = "^(L[1-3]|M[1-2]) [a-zA-Z]* [0-9]{4}/[0-9]{4}$";


	public CheckerGroupName() {
		pattern = Pattern.compile(NOM_GROUP_PATTERN);
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
