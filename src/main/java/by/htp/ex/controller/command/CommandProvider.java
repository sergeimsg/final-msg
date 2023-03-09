package by.htp.ex.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.ex.controller.command.impl.ChangeLocale;
import by.htp.ex.controller.command.impl.DoAddNews;
import by.htp.ex.controller.command.impl.DoDeleteNews;
import by.htp.ex.controller.command.impl.DoEditNews;
import by.htp.ex.controller.command.impl.DoRegistration;
import by.htp.ex.controller.command.impl.DoSignIn;
import by.htp.ex.controller.command.impl.DoSignOut;
import by.htp.ex.controller.command.impl.GoToAddNews;
import by.htp.ex.controller.command.impl.GoToBasePage;
import by.htp.ex.controller.command.impl.GoToEditNews;
import by.htp.ex.controller.command.impl.GoToErrorPage;
import by.htp.ex.controller.command.impl.GoToNewsList;
import by.htp.ex.controller.command.impl.GoToRegistrationPageCommand;
import by.htp.ex.controller.command.impl.GoToViewNews;


public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.GO_TO_BASE_PAGE, new GoToBasePage());
		commands.put(CommandName.GO_TO_REGISTRATION_PAGE_COMMAND, new GoToRegistrationPageCommand());
		commands.put(CommandName.GO_TO_ERROR_PAGE, new GoToErrorPage());
		commands.put(CommandName.GO_TO_NEWS_LIST, new GoToNewsList());
		commands.put(CommandName.GO_TO_VIEW_NEWS, new GoToViewNews());
		commands.put(CommandName.GO_TO_ADD_NEWS, new GoToAddNews());		
		commands.put(CommandName.GO_TO_EDIT_NEWS, new GoToEditNews());
		commands.put(CommandName.DO_SIGN_IN, new DoSignIn());
		commands.put(CommandName.DO_SIGN_OUT, new DoSignOut());
		commands.put(CommandName.DO_REGISTRATION,new DoRegistration());
		commands.put(CommandName.DO_ADD_NEWS, new DoAddNews());
		commands.put(CommandName.DO_DELETE_NEWS, new DoDeleteNews());
		commands.put(CommandName.DO_EDIT_NEWS, new DoEditNews());
		commands.put(CommandName.CHANGE_LOCALE, new ChangeLocale());
	}
	
	
	public Command getCommand(String name) {
		CommandName  commandName = CommandName.valueOf(name.toUpperCase());
		Command command = commands.get(commandName);
		return command;
	}

}
