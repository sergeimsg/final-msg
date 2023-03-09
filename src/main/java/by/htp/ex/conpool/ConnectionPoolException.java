package by.htp.ex.conpool;



public class ConnectionPoolException extends Exception{
    
	
   	private static final long serialVersionUID = -261560905800830407L;


	public ConnectionPoolException() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    	

	public ConnectionPoolException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}



	public ConnectionPoolException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}



	public ConnectionPoolException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}



	public ConnectionPoolException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}



	public ConnectionPoolException(String message, Exception e) {
        super(message, e);
    }
}
