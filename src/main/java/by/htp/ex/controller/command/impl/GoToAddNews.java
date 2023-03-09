package by.htp.ex.controller.command.impl;

import by.htp.ex.controller.command.Command;
import static by.htp.ex.controller.command.FieldNames.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpServlet;




public class GoToAddNews extends HttpServlet implements Command {
	
	
	
	private static final long serialVersionUID = 1L;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getSession(true).setAttribute(LINK.getFieldName(), "go_to_add_news");
		
		request.setAttribute(PRESENTATION.getFieldName(), "addNews");
		request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		
		
		
	}
	
	
	
	

}
