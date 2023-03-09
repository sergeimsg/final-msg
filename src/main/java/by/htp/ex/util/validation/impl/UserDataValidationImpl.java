package by.htp.ex.util.validation.impl;

import java.util.regex.Matcher;

import by.htp.ex.util.validation.UserDataValidation;
import by.htp.ex.validation.exception.UserValidationException;

public class UserDataValidationImpl implements UserDataValidation {

	@Override
	public boolean checkLoginUserData(String login, String password) throws UserValidationException {

		if (LOGIN_PATTERN.matcher(login).matches() && PASS_PATTERN.matcher(password).matches()) {

			

			return true;

		} else {

			if (login == null || login == " ") {

				throw new UserValidationException("Login empty");
			}

			return false;
		}

	}

	@Override
	public void checkRegistrationUserData(String login, String password, String email) 
			throws UserValidationException {
		
		

		if (login == null || login == "") {

			throw new UserValidationException("Login is empty, check.");
		} else {
			Matcher mLogin = LOGIN_PATTERN.matcher(login);

			if (!mLogin.matches()) {
				throw new UserValidationException("Incorrect login format, check and try.");

			}
			

		}

		if (password == null || password == "") {

			throw new UserValidationException("Password is empty");
		} else {

			Matcher mPassword = PASS_PATTERN.matcher(password);

			if (!mPassword.matches()) {

				throw new UserValidationException("Password in wrong format, check and try.");

			}
			
		}

		if (email == null || email == "") {

			throw new UserValidationException("Email is empty");
		} else {

			Matcher mEmail = EMAIL_PATTERN.matcher(email);
			if (!mEmail.matches()) {

				throw new UserValidationException("Email in wrong format, check and try.");

			}
			

		}
		
		//System.out.println("Validation passed");

	}

}
