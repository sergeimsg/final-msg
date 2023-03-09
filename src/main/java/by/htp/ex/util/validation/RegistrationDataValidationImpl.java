package by.htp.ex.util.validation;

public class RegistrationDataValidationImpl implements RegistrationDataValidation {

	@Override
	public boolean checkRegistrationData(String login, String password,String mail) {
		// TODO Auto-generated method stub
		if (login.matches(LOGIN_TEMPLATE_REGEX) && password.matches(PASSWORD_TEMPLATE_REGEX) && mail.matches(EMAIL_TEMPLATE_REGEX)) {
			
			return true;
			
			
		} else {
							
		return false;

		}
		
	
	}

	
		
		
		
	
	

}
