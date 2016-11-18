package utils;

import java.util.regex.*;

public class Checker {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN =
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String NOM_GROUP_PATTERN = "M|L ";
	
	public Checker() {
		pattern = Pattern.compile(EMAIL_PATTERN);
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
