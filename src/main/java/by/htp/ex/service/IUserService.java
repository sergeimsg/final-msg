package by.htp.ex.service;
import by.htp.ex.bean.User;
import by.htp.ex.service.exception.ServiceException;


public interface IUserService {
	
	User signIn(String login, String password) throws ServiceException;
	boolean registration(String login, String password, String email) throws ServiceException;
	

}
