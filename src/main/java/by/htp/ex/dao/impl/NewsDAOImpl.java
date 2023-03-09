package by.htp.ex.dao.impl;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import by.htp.ex.bean.News;
import by.htp.ex.conpool.ConnectionPool;
import by.htp.ex.conpool.ConnectionPoolException;
import by.htp.ex.dao.INewsDAO;

import by.htp.ex.dao.exception.NewsDAOException;


public class NewsDAOImpl implements INewsDAO {
	
	
	
private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
	
	private static final String PATTERN_DATE = "dd.MM.yyyy HH.mm";

	private static final String GET_LATESTS_LIST = "SELECT * FROM news_site ORDER BY news_id DESC LIMIT ?";
	private static final String GET__LIST = "SELECT * FROM goodnews.news_site ORDER BY news_id DESC";
	private static final String FETCH_BY_ID = "SELECT * FROM goodnews.news_site WHERE news_id=?";
	private static final String ADD_NEWS = "INSERT INTO goodnews.news_site (title, brief, content, user_id) Values (?, ?, ?, ?)";
	private static final String UPDATE_NEWS = "UPDATE goodnews.news_site SET title = ?, brief = ?, content = ? WHERE news_id = ?";
	private static final String DELETE_NEWS = "DELETE FROM goodnews.news_site WHERE news_id = ?";
	
	

	@Override
	public List<News> getLatestsList(int count) throws NewsDAOException {
		List<News> resultLatestNews = new ArrayList<News>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		

		try {
			
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(GET_LATESTS_LIST);
			preparedStatement.setInt(1, count);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				int idNews = resultSet.getInt(1);
				String title = resultSet.getString(2);
				String briefNews = resultSet.getString(3);
				String content = resultSet.getString(4);
				
				String newsDate = new SimpleDateFormat(PATTERN_DATE).format(resultSet.getTimestamp(6));
				int userId = resultSet.getInt(5);

				resultLatestNews.add(new News(idNews, title, briefNews, content, newsDate, userId));
			}
			
		} catch (ConnectionPoolException | SQLException e) {
			throw new NewsDAOException(e);
			
		}  finally {  
			
			connectionPool.closeConnection(connection, preparedStatement, resultSet);	
						
		}
		
		return resultLatestNews;
		
	}

	@Override
	public List<News> getList() throws NewsDAOException {
		List<News> listNews = new ArrayList<News>();

		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = connectionPool.takeConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(GET__LIST);
			
			while (resultSet.next()) {
				
				
				int newsID = resultSet.getInt(1);
				String title = resultSet.getString(2);
				String briefNews = resultSet.getString(3);
				String content = resultSet.getString(4);
				String newsDate = new SimpleDateFormat(PATTERN_DATE).format(resultSet.getTimestamp(6));
				 int userID = resultSet.getInt(5);
				
				listNews.add(new News(newsID,title,briefNews, content, newsDate,userID));
				
				
	
				
			}
			
			
		} catch (ConnectionPoolException | SQLException e) {
			
			throw new NewsDAOException(e);
		}
		finally {
			
			connectionPool.closeConnection(connection, statement, resultSet);
		}
		
		
;
		
		return listNews;
	}

	@Override
	public News fetchById(int id) throws NewsDAOException {
		
		News news = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			
			
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(FETCH_BY_ID);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				
				int newsID = resultSet.getInt(1);
				String title = resultSet.getString(2);
				String briefNews = resultSet.getString(3);
				String content = resultSet.getString(4);
				String newsDate = new SimpleDateFormat(PATTERN_DATE).format(resultSet.getTimestamp(6));
				 int userID = resultSet.getInt(5);
				
				news = new News(newsID,title,briefNews, content, newsDate,userID);
				
			}
								
			
		} catch (ConnectionPoolException | SQLException e) {
			
			throw new NewsDAOException();
			
			
		}
		finally  {
		
		
		connectionPool.closeConnection(connection, preparedStatement);
			 
			   
			
		}
		
		
//		return new News(1, "title1", "brief1brief1brief1brief1brief1brief1brief1", "contect1", "11/11/22");
		
		return news;
		
		
	}

	@Override
	public void  addNews(News news) throws NewsDAOException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(ADD_NEWS);
			preparedStatement.setString(1, news.getTitle());
			preparedStatement.setString(2, news.getBriefNews());
			preparedStatement.setString(3, news.getContent());
			preparedStatement.setInt(4, news.getIdUser());
			preparedStatement.executeUpdate();
			
				
			
		} catch (ConnectionPoolException | SQLException e) {

			throw new NewsDAOException(e);
			
		}  finally {
			
			connectionPool.closeConnection(connection, preparedStatement);
			
			
			
		}
		
	
	}

	@Override
	public void updateNews(News news) throws NewsDAOException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		
		try {
			
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(UPDATE_NEWS);
			preparedStatement.setString(1, news.getTitle());
			preparedStatement.setString(2, news.getBriefNews());
			preparedStatement.setString(3, news.getContent());
			preparedStatement.setInt(4, news.getIdNews());
			preparedStatement.executeUpdate();
			
			
				
			
		} catch (ConnectionPoolException | SQLException e) {

			throw new NewsDAOException(e);
			
		}  finally {
			
			connectionPool.closeConnection(connection, preparedStatement);
			
						
		}
		

	}

	

	@Override
	public void deleteNewses(int id) throws NewsDAOException {
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		
		try {
			
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(DELETE_NEWS);
			
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
							
			
		} catch (ConnectionPoolException | SQLException e) {

			throw new NewsDAOException(e);
			
		}  finally {
			
			connectionPool.closeConnection(connection, preparedStatement);
			
						
		}
		
		
		
	}

}
