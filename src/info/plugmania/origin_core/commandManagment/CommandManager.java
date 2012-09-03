package info.plugmania.origin_core.commandManagment;

import java.util.ArrayList;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import info.plugmania.origin_core.Origin_Core;

public class CommandManager {
	Origin_Core plugin;
	
	public CommandManager(Origin_Core instance) {
		this.plugin = instance;
	}

	public ArrayList<Command> commandList = new ArrayList<Command>();

	public void add(Command command) {
		commandList.add(command);
	}

	public Command get(String name) {
		for(Command c:commandList){
			if(c.getName().equalsIgnoreCase(name)) return c;
		}
		return new InvalidCommand(plugin);
	}

	public void onCommand(CommandSender sender,String command,String[] args) {

	}
	
	
}
