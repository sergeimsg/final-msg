package by.htp.ex.validation.exception;

public class UserValidationException extends Exception{

	
	private static final long serialVersionUID = 4740646312688769794L;

	public UserValidationException() {
		super();
	}

	public UserValidationException(String message, Exception e) {
		super(message, e);
		// TODO Auto-generated constructor stub
	}

	public UserValidationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserValidationException(Exception e) {
		super(e);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
