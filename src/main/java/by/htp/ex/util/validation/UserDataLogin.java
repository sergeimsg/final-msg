package by.htp.ex.util.validation;

import java.util.regex.Pattern;

public interface UserDataLogin {

	public static final String LOGIN_TEMPLATE_REGEX = "([\\w]+)";   //"([.[^@\\s]]+)@([.[^@\\s]]+)\\.([a-z]+)";
	public static final String EMAIL_REGEX =  "([.[^@\\s]]+)@([.[^@\\s]]+)\\.([a-z]+)";
	public static final String PASSWORD_TEMPLATE_REGEX =  "([\\w]+)"; //"([\\d]+)";

	public static final Pattern LOGIN_PATTERN = Pattern.compile(LOGIN_TEMPLATE_REGEX);
	public static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
	public static final Pattern PASS_PATTERN = Pattern.compile(PASSWORD_TEMPLATE_REGEX);

}
