package by.htp.ex.controller.command.impl;

import by.htp.ex.bean.News;
import by.htp.ex.controller.command.Command;


import static by.htp.ex.controller.command.FieldNames.*;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.exception.ServiceException;
import by.htp.ex.service.provider.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;


import javax.servlet.http.HttpServlet;


public class DoEditNews extends HttpServlet implements Command {
	
	
	private static final long serialVersionUID = 1L;
       
	
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	
   
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    
    
    	
    	News news = new News();

    	String idNews = request.getParameter(ID.getFieldName());
    	String title = request.getParameter(TITLE.getFieldName());
		String briefNews = request.getParameter(BRIEF.getFieldName());
		String content = request.getParameter(CONTENT.getFieldName());
		

    	
		
		news.setIdNews(Integer.parseInt(idNews));
		news.setTitle(title);
		news.setBriefNews(briefNews);
		news.setContent(content);
		
	
		
		try {
			
			newsService.update(news, request);
			
			
			request.getSession(true).setAttribute(LINK.getFieldName(), "go_to_view_news");
			response.sendRedirect("controller?command=go_to_view_news&id=" + idNews);
			
		} catch (ServiceException e) {

			request.getSession(true).setAttribute(ERROR.getFieldName(), "An error has occurred. Data not edited. " + e.getCause().getMessage());
			request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
		}

    	
    	
    	
    	
    }

}
