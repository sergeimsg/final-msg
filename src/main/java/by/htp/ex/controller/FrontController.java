package by.htp.ex.controller;

import java.io.IOException;

import by.htp.ex.conpool.ConnectionPool;
import by.htp.ex.conpool.ConnectionPoolException;
import by.htp.ex.controller.command.Command;
import by.htp.ex.controller.command.CommandProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final CommandProvider provider = new CommandProvider();
	
	private final ConnectionPool connectionPool = ConnectionPool.getInstance();  // transfer to User impl
	

	   @Override
	    public void init () throws ServletException {
	    	
					try {
						
						connectionPool.initPoolData();
						
					} catch (ConnectionPoolException | ClassNotFoundException e) {
						throw new ServletException("Connection pool initialization failed.");
					}  	
	    }



    public FrontController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	
	private static final String COMMAND = "command";
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {String commandName = request.getParameter(COMMAND);
		
		
		
		Command command = provider.getCommand(commandName);
		
		
		
		command.execute(request, response);}
		
		catch (Exception e) {
			String eName = e.getClass().getSimpleName();
			request.setAttribute("message", "Sorry. Some technical problems(" + eName + "). Please, try again.");
			request.getRequestDispatcher("WEB-INF/pages/tiles/front-controller-exception.jsp").forward(request,
					response);

		}
		
	}
	
}
		
		

		
		
		
	
	
	
	
