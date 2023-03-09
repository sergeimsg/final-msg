package by.htp.ex.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.ex.bean.User;
import by.htp.ex.conpool.ConnectionPool;
import by.htp.ex.dao.IUserDAO;
import by.htp.ex.dao.exception.UserDAOException;
import by.htp.ex.conpool.ConnectionPoolException;

public class UserDAOImpl implements IUserDAO {

	private final ConnectionPool connectionPool = ConnectionPool.getInstance();



	private final String LOGINATION_SQL = "SELECT * FROM user where login = ?";

	private final String REGISTRATION_DB_SQL = "INSERT INTO goodnews.user (email, password, role, login) Values (?, ?, ?,?)";

	@Override
	public User logination(String login, String password) throws UserDAOException {

		

		User user = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(LOGINATION_SQL);
			preparedStatement.setString(1, login);
			
			resultSet = preparedStatement.executeQuery();



			if (!resultSet.next()) {

				
				throw new UserDAOException("Wrong login");

			} else {
				
				int id = resultSet.getInt(1);
				String login1 = resultSet.getString(2);
				String passwordUser = resultSet.getString(3);
				String role = resultSet.getString(5);

						
				
				
				if (!passwordUser.equals(password)) {

					throw new UserDAOException("Wrong password");

				}

				user = new User(id, login1, passwordUser, role);
				
			}

		} catch (SQLException | ConnectionPoolException e) {

			throw new UserDAOException("NO connection in pool/DB. Please, try again later.");

		}

		finally {
			connectionPool.closeConnection(connection, preparedStatement, resultSet);
		}

		

		return user;

	}

	@Override
	public boolean registrationDB(String login, String password, String email) throws UserDAOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			

			connection = connectionPool.takeConnection();
			
			preparedStatement = connection.prepareStatement(REGISTRATION_DB_SQL);

			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, "user");
			preparedStatement.setString(4, login);

			int countRow = preparedStatement.executeUpdate();

			if (countRow > 0) {

				return true;

			} else {
				return false;

			}

		} catch (ConnectionPoolException | SQLException e) {
			throw new UserDAOException("Registration is impossible. Try ones more time", e);
		} finally {

			connectionPool.closeConnection(connection, preparedStatement);

		}

	}

}
