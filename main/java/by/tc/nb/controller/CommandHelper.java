package by.tc.nb.controller;

import java.util.HashMap;
import java.util.Map;
import by.tc.nb.command.Command;
import by.tc.nb.command.impl.*;

public class CommandHelper {

	private Map<String, Command> commands = new HashMap<String, Command>();

	public CommandHelper() {
		commands.put("ADD_NEW_NOTE", new AddNewNote());
		commands.put("FIND_BY_NOTE", new FindNotes());
		commands.put("SHOW_NOTEBOOK", new ShowNoteBook());
		commands.put("CLEAR_NOTEBOOK", new ClearBook());
		commands.put("FIND_BY_DATE", new FindByDate());
		commands.put("REGISTRATION", new Registration());
		commands.put("AUTHENTICATION", new Authentication());
	}

	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(commandName);
		return command;
	}
}
