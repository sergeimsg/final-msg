package by.htp.ex.util.validation.impl;

import static by.htp.ex.controller.command.FieldNames.*;

import by.htp.ex.bean.News;
import by.htp.ex.util.validation.INewsValidation;
import by.htp.ex.validation.exception.ValidationException;
import jakarta.servlet.http.HttpServletRequest;

public class NewsValidationImpl implements INewsValidation {

	@Override
	public void validNews(HttpServletRequest request) throws ValidationException {

		String role = null;
		
		if(request.getSession() != null) {
			
			role = (String)request.getSession().getAttribute(ROLE.getFieldName());
		}
		
		if(!role.equals(ADMIN.getFieldName())) {
			
			throw new ValidationException("Insufficient access rights.");
		}
		
	}

	@Override
	public void validNews(News news) throws ValidationException {
		
		if(news.getTitle().equals("") || news.getBriefNews().equals("") || news.getContent().equals("")) {
			
			throw new ValidationException("Fields cannot be empty.");
			
		}

}
}
