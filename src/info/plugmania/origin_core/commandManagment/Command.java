package info.plugmania.origin_core.commandManagment;

import info.plugmania.origin_core.Origin_Core;

import org.bukkit.command.CommandExecutor;

public abstract class Command implements CommandExecutor {
	Origin_Core plugin;
	
	public Command(Origin_Core instance) {
		this.plugin = instance;
	}

	public String getName() {
		return this.getClass().getSimpleName();
	}
}