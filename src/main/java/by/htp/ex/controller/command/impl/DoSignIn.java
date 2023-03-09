package by.htp.ex.controller.command.impl;


import java.io.IOException;

import by.htp.ex.bean.User;
import by.htp.ex.controller.command.Command;
import static by.htp.ex.controller.command.FieldNames.*;
import by.htp.ex.service.exception.ServiceException;
import by.htp.ex.service.provider.ServiceProvider;
import by.htp.ex.service.IUserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class DoSignIn implements Command {

	private final IUserService userService = ServiceProvider.getInstance().getUserService();

	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login;
		String password;
		
		login = request.getParameter(LOGIN.getFieldName());
		password = request.getParameter(PASSWORD.getFieldName());
		
	
				
		
      try {

			User user = new User(login, password); 
			user = userService.signIn(login, password);
			String role = user.getRole();
		
			Integer idUser = user.getUserId();
		
			
			if ( ! role.equals(GUEST.getFieldName())) {
				
				request.getSession(true).setAttribute(USER.getFieldName(), "active");
				request.getSession(true).setAttribute(ROLE.getFieldName(), role);
				request.getSession(true).setAttribute(ID_USER.getFieldName(), idUser);
				request.getSession(true).setAttribute(LINK.getFieldName(), "do_sign_in");
				response.sendRedirect("controller?command=go_to_news_list");
				
			} else {
				request.getSession(true).setAttribute(USER.getFieldName(), "not active");
				//request.getSession(true).setAttribute(LINK.getFieldName(), "do_sign_in");
				request.getRequestDispatcher("controller?command=go_to_base_page");
			}
			
			
			
		} 
      catch (ServiceException e) {

			request.getSession(true).setAttribute(ERROR.getFieldName(),"An error occurred during authorization. " 
			+ e.getCause().getMessage());
			//request.getSession(true).setAttribute(LINK.getFieldName(), "go_to_error_page");
			request.getRequestDispatcher("controller?command=go_to_error_page").forward(request, response);
		}
				
		


	}

}
