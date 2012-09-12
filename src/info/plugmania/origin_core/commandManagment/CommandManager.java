package info.plugmania.origin_core.commandManagment;

import java.util.ArrayList;

import org.bukkit.Server;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
	
	public boolean has(String name){
		for(Command c:commandList){
			if(c.getName().equalsIgnoreCase(name)) return true;
		}
		return false;
	}

	public void onPlayerCommand(Player sender,String command,String[] args) {
		get(command).onPlayerCommand(sender, command, args);
	}
	
	public void onServerCommand(Server sender,String command,String[] args){
		get(command).onServerCommand(sender, command, args);
	}
	
	
	
}
