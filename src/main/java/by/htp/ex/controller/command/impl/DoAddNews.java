package by.htp.ex.controller.command.impl;

import by.htp.ex.bean.News;
import by.htp.ex.controller.command.Command;
import static by.htp.ex.controller.command.FieldNames.*;

import by.htp.ex.service.INewsService;
import by.htp.ex.service.provider.ServiceProvider;
import by.htp.ex.service.exception.ServiceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



import java.io.IOException;



public class DoAddNews extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;
	
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();



    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

    	News news = new News();

		String title = request.getParameter(TITLE.getFieldName());
		String briefNews = request.getParameter(BRIEF.getFieldName());
		String content = request.getParameter(CONTENT.getFieldName());
		Integer idUser = 0;
		
		if(request.getSession() != null) {
			idUser = (Integer)request.getSession().getAttribute(ID_USER.getFieldName());
		}
		
		news.setTitle(title);
		news.setBriefNews(briefNews);
		news.setContent(content);
		news.setIdUser(idUser);
		
	//	System.out.println(news.getTitle()+news.getBriefNews()+news.getContent()+" id User  "+news.getIdUser());

		try {

			newsService.addNews(news, request);

			request.getSession(true).setAttribute(LINK.getFieldName(), "go_to_news_list");
			response.sendRedirect("controller?command=go_to_news_list");

		} catch (ServiceException e) {

			request.getSession(true).setAttribute(ERROR.getFieldName(),"An error has occurred. Data not added. "); // + e.getCause().getMessage());
			request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
		}

	}
    	
    	
    }

	

