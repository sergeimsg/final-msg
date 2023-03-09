package by.htp.ex.controller.command.impl;


import static by.htp.ex.controller.command.FieldNames.*;

import java.io.IOException;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.controller.command.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.exception.ServiceException;
import by.htp.ex.service.provider.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToBasePage implements Command{
	
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<News> latestNews;
		
		String link = request.getParameter(COMMAND.getFieldName());
		
		try {
			latestNews = newsService.latestList(COUNT.getNumber());
			if (!latestNews.isEmpty()) {
				request.setAttribute(NEWS.getFieldName(), latestNews);
				
			}
			request.getSession(true).setAttribute(LINK.getFieldName(), link);
			request.setAttribute(PRESENTATION.getFieldName(), "forGuests");			
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		} catch (ServiceException e) {

			request.getSession(true).setAttribute(ERROR.getFieldName(), "Error while getting list of news.");
			request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
		}
		
		
	}

}
