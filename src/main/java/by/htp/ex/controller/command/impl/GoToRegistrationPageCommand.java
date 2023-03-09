package by.htp.ex.controller.command.impl;

import static by.htp.ex.controller.command.FieldNames.*;

import java.io.IOException;

import by.htp.ex.controller.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToRegistrationPageCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute(PRESENTATION.getFieldName(), "registration");
	    request.getSession(true).setAttribute(LINK.getFieldName(), "go_to_registration_page_command");
		
		request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		
	}

}
