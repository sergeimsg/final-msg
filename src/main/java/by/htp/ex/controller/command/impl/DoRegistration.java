package by.htp.ex.controller.command.impl;

import static by.htp.ex.controller.command.FieldNames.*;

import java.io.IOException;

import by.htp.ex.service.exception.ServiceException;
import by.htp.ex.service.provider.ServiceProvider;
import by.htp.ex.controller.command.Command;
import by.htp.ex.service.IUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoRegistration implements Command {
	
	private final IUserService service = ServiceProvider.getInstance().getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String login = request.getParameter(LOGIN.getFieldName());
		String password = request.getParameter(PASSWORD.getFieldName());
	    String email = request.getParameter(EMAIL.getFieldName());
	    	    
	    try {
			
	    
	    service.registration(login, password, email);
	    request.getSession(true).setAttribute(LINK.getFieldName(), "do_registration");
	    request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
	   	   	
		
		} catch (ServiceException e) {
			
			request.getSession(true).setAttribute(ERROR.getFieldName(), "Error occuried during registration"+ e.getCause().getMessage());
			request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
			
												
		}
	
		
		
		
		
		
		
				
	}

}
