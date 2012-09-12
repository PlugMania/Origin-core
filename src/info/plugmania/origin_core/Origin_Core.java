package info.plugmania.origin_core;

import info.plugmania.origin_core.commandManagment.CommandListener;
import info.plugmania.origin_core.commandManagment.CommandManager;

import org.bukkit.plugin.java.JavaPlugin;

public class Origin_Core extends JavaPlugin {
	public CommandManager commandManager;
	public void onEnable() {
		commandManager=new CommandManager(this);
		this.getServer().getPluginManager().registerEvents(new CommandListener(this), this);
	}
	
	public void onDisable() {
		
	}
}
