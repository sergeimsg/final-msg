package by.htp.ex.util.validation;



import by.htp.ex.bean.News;
import by.htp.ex.validation.exception.ValidationException;
import jakarta.servlet.http.HttpServletRequest;

public interface INewsValidation {

	void validNews(HttpServletRequest request) throws ValidationException;

	void validNews(News news) throws ValidationException;
}
