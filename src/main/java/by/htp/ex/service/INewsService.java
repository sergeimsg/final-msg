package by.htp.ex.service;

import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.service.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;

public interface INewsService {
	
	
    void addNews(News news, HttpServletRequest request) throws ServiceException;
	
	void delete(int idNews, HttpServletRequest request) throws ServiceException;
	
	void update(News news, HttpServletRequest request) throws ServiceException;
  
  List<News> latestList(int count)  throws ServiceException;
  List<News> list()  throws ServiceException;
  News findById(int id) throws ServiceException;
}
