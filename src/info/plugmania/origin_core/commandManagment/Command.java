package info.plugmania.origin_core.commandManagment;

import info.plugmania.origin_core.Origin_Core;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public abstract class Command {
	Origin_Core plugin;
	
	public Command(Origin_Core instance) {
		this.plugin = instance;
	}

	public String getName() {
		return this.getClass().getSimpleName();
	}
	
	public abstract void onPlayerCommand(Player sender,String command,String[] args);
	public abstract void onServerCommand(String command,String[] args);
}
