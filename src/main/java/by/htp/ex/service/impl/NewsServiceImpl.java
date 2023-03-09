package by.htp.ex.service.impl;

import java.util.List;

import by.htp.ex.bean.News;
import static by.htp.ex.controller.command.FieldNames.*;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.INewsDAO;
import by.htp.ex.dao.exception.NewsDAOException;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.exception.ServiceException;

import by.htp.ex.util.validation.INewsValidation;
import by.htp.ex.util.validation.ValidationProvider;
import by.htp.ex.validation.exception.ValidationException;
import jakarta.servlet.http.HttpServletRequest;

public class NewsServiceImpl implements INewsService{

	private final INewsDAO newsDAO = DaoProvider.getInstance().getNewsDAO();
	
	private final INewsValidation newsValidation = ValidationProvider.getInstance().getNewsValidation();

	@Override
	public List<News> latestList(int count) throws ServiceException {
		
		try {
			return newsDAO.getLatestsList(COUNT.getNumber());  
		} catch (NewsDAOException e) {
			throw new ServiceException("DB is not available");
		}
	}

	@Override
	public List<News> list() throws ServiceException {
		try {
			return newsDAO.getList();
		} catch (NewsDAOException e) {
			throw new ServiceException("DB is not available");
		}
	}

	@Override
	public News findById(int id) throws ServiceException {
		try {
			
			return newsDAO.fetchById(id);
			
			
		}catch (NewsDAOException e) {
			
			throw new ServiceException(e);
		}
	}

	@Override
	public void addNews(News news, HttpServletRequest request) throws ServiceException {

		try {
			
			newsValidation.validNews(request);
			newsValidation.validNews(news);
			newsDAO.addNews(news);

		} catch (ValidationException e) {
			throw new ServiceException(e);
		} catch (NewsDAOException e) {
			throw new ServiceException("Something went wrong. The news has not been saved.");
		}

	}
	@Override
	public void delete(int idNews, HttpServletRequest request) throws ServiceException {

		try {

			newsValidation.validNews(request);
			newsDAO.deleteNewses(idNews);

		} catch (ValidationException e) {
			throw new ServiceException(e);	
		} catch (NewsDAOException e) {
			throw new ServiceException("Something went wrong. The news hasn't been deleted.");
		}

	}

	@Override
public void update(News news, HttpServletRequest request) throws ServiceException {
		
		try {

			newsValidation.validNews(request);
			newsValidation.validNews(news);
			newsDAO.updateNews(news);

		} catch (ValidationException e) {
			throw new ServiceException(e);
		} catch (NewsDAOException e) {
			throw new ServiceException("Something went wrong. The news has not been updated.");
		}

	}

}
