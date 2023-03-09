package by.htp.ex.util.validation;

import by.htp.ex.util.validation.impl.UserDataValidationImpl;
import by.htp.ex.util.validation.impl.*;


public class ValidationProvider {
	
	
	
	private static final ValidationProvider instance = new ValidationProvider();
	
	
	
	private final UserDataValidationImpl userDataValidation = new UserDataValidationImpl();
	private final RegistrationDataValidationImpl registrationDataValidation = new RegistrationDataValidationImpl();
	
	private final INewsValidation newsValidation = new NewsValidationImpl();
	
	public ValidationProvider() { }

	public static ValidationProvider getInstance() {
		
		return instance;
	}
	
	
	public UserDataValidationImpl getUserDataValidation( ) {
		
		return userDataValidation;
	}

	public RegistrationDataValidationImpl getRegistrationDataValidation() {
		return registrationDataValidation;
	}
	
	public INewsValidation getNewsValidation() {
		return newsValidation;
	}
		

}
