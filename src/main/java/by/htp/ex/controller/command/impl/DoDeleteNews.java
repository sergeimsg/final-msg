package by.htp.ex.controller.command.impl;

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


public class DoDeleteNews extends HttpServlet implements Command {
	
	private static final long serialVersionUID = 1L;
	
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
       
   
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
         
    	
    	String idNews = request.getParameter(ID.getFieldName());

		try {

			newsService.delete(Integer.parseInt(idNews), request);

			request.getSession(true).setAttribute(LINK.getFieldName(), "go_to_news_list");
			response.sendRedirect("controller?command=go_to_news_list");

		} catch (ServiceException e) {

			request.getSession(true).setAttribute(ERROR.getFieldName(),"An error has occurred. Data not deleted. " + e.getCause().getMessage());
			request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);

		}
		
    }
}

	
    	
    
    


