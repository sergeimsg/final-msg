package by.htp.ex.util.validation;

import by.htp.ex.validation.exception.UserValidationException;

public interface UserDataValidation extends UserDataLogin{
	
		
	void checkRegistrationUserData(String login, String password, String email) throws UserValidationException;   
	boolean checkLoginUserData(String login, String password) throws UserValidationException;
       
       
}
