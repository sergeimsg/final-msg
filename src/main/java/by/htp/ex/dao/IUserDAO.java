package by.htp.ex.dao;

import by.htp.ex.bean.User;
import by.htp.ex.dao.exception.UserDAOException;


public interface IUserDAO {

	User logination(String login, String password) throws UserDAOException;

	boolean registrationDB(String login, String password, String email) throws UserDAOException;

}
