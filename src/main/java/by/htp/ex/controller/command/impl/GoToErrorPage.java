package by.htp.ex.controller.command.impl;

import by.htp.ex.controller.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static by.htp.ex.controller.command.FieldNames.*;

import java.io.IOException;
import javax.servlet.http.HttpServlet;


public class GoToErrorPage extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setAttribute(PRESENTATION.getFieldName(), "errorPage");
		request.getSession(true).setAttribute(LINK.getFieldName(), "go_to_error_page");
		request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		
		
		
		
	}

	
	
	
}
