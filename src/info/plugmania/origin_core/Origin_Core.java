package info.plugmania.origin_core;

import info.plugmania.origin_core.commandManagment.CommandListener;

import org.bukkit.plugin.java.JavaPlugin;

public class Origin_Core extends JavaPlugin {
	
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new CommandListener(this), this);
	}
	
	public void onDisable() {
		
	}
}
