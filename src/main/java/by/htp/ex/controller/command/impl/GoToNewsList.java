package by.htp.ex.controller.command.impl;

import java.io.IOException;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.controller.command.Command;
import static by.htp.ex.controller.command.FieldNames.*;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.exception.ServiceException;
import by.htp.ex.service.provider.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToNewsList implements Command {
	
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<News> newsList;
		try {
			newsList = newsService.list();
			
	
			
			if (!newsList.isEmpty()) {
				
	
				
				request.setAttribute(NEWS.getFieldName(), newsList);
				
			}
			
			request.setAttribute(PRESENTATION.getFieldName(), "newsList");
			request.getSession(true).setAttribute(LINK.getFieldName(), "go_to_news_list");
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			
			request.setAttribute(ERROR.getFieldName(),"ERROR WHILE PREPARING NEWS LIST" +e.getMessage());
			request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
			
		}
		
	}

}
