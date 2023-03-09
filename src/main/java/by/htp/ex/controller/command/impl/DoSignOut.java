package by.htp.ex.controller.command.impl;

import java.io.IOException;

import by.htp.ex.controller.command.Command;
import static by.htp.ex.controller.command.FieldNames.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoSignOut implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.getSession(true).setAttribute(USER.getFieldName(), "not active");
			response.sendRedirect("controller?command=go_to_base_page");
		
	}

}
