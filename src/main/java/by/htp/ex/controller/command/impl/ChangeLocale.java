package by.htp.ex.controller.command.impl;

import static by.htp.ex.controller.command.FieldNames.*;

import java.io.IOException;

import by.htp.ex.controller.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ChangeLocale implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String locale = request.getParameter(LINK_LOCALE.getFieldName());
		String link = null;
		System.out.println("locale " + locale);

		if (request.getSession() != null) {

			link = (String) request.getSession().getAttribute(LINK.getFieldName());

	
		}

	
		request.getSession(true).setAttribute(LOCALE.getFieldName(), locale);
		request.getRequestDispatcher("controller?command=" + link).forward(request, response);

	}

}
