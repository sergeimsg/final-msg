package by.htp.ex.service.exception;

public class ServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1291668902432628598L;

	public ServiceException(String e) {
		super(e);
	}
	
	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public ServiceException(String message, Exception exception) {
		super(message, exception);
	}
	
	
	
	
}
