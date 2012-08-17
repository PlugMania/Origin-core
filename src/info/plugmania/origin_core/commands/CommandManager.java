package info.plugmania.origin_core.commands;

import java.util.ArrayList;

import info.plugmania.origin_core.Origin_Core;

public class CommandManager {
	Origin_Core plugin;
public CommandManager(Origin_Core instance){
	plugin=instance;
}

public ArrayList<Command> commandList=new ArrayList<Command>();

public void addCommand(Command command){
	commandList.add(command);
}

public Command getCommand(String name){
	for(Command c:commandList){
		if(c.getName().equalsIgnoreCase(name)) return c;
	}
	return new InvalidCommand(plugin);
}
}
