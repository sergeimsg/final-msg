package by.htp.ex.util.validation;

public interface RegistrationDataValidation extends UserDataLogin {
	
		
	String EMAIL_TEMPLATE_REGEX = "\\w{1,5}";
	
	boolean checkRegistrationData(String login, String password, String mail);

}
