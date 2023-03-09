package by.htp.ex.service.impl;

import by.htp.ex.bean.User;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.dao.exception.UserDAOException;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.exception.ServiceException;
import by.htp.ex.util.validation.ValidationProvider;
import by.htp.ex.util.validation.impl.UserDataValidationImpl;
import by.htp.ex.validation.exception.UserValidationException;


public class UserServiceImpl implements IUserService {

	private final IUserDAO userDAO = DaoProvider.getInstance().getUserDao();

	private final UserDataValidationImpl userDataValidationImpl = ValidationProvider.getInstance()
			.getUserDataValidation();

	@Override
	public User signIn(String login, String password) throws ServiceException {

		
		
try {
			
			userDataValidationImpl.checkLoginUserData(login, password);
			
			// System.out.println(" Sign in Validation passed in user service");
			
			
			
			return userDAO.logination(login, password);
			
		} catch (UserValidationException e) {
			
			throw new ServiceException(e);
		}
		catch (UserDAOException e) {
			throw new ServiceException(e);
		}



		
	}



	@Override
	public boolean registration(String login, String password, String email) throws ServiceException {
		
		
		
		try {
			
			userDataValidationImpl.checkRegistrationUserData(login, password, email);
			
			userDAO.registrationDB(login, password, email);
			
		} catch (UserValidationException e) {
			
			throw new ServiceException(e);
		}
		catch (UserDAOException e) {
			throw new ServiceException(e);
		}


		
		
		
		return true;
	
		}
		
		
}
