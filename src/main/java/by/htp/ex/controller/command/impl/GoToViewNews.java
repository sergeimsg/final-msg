package by.htp.ex.controller.command.impl;

import java.io.IOException;

import by.htp.ex.bean.News;
import by.htp.ex.controller.command.Command;
import static by.htp.ex.controller.command.FieldNames.*;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.exception.ServiceException;
import by.htp.ex.service.provider.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToViewNews implements Command {
	
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		News news;
		
		String idNews;

		idNews = request.getParameter(ID.getFieldName());
		
		 System.out.println("idNews  "+idNews);
		
		try {
			news  = newsService.findById(Integer.parseInt(idNews));
			
			request.setAttribute(NEWS.getFieldName(), news);
			request.setAttribute(PRESENTATION.getFieldName(), "viewNews");
			request.getSession(true).setAttribute(LINK.getFieldName(), "go_to_view_news&id=" + idNews);
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			
			request.setAttribute(ERROR.getFieldName(),"Error while gettinhg news");
			request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
		}
		
	}

}
