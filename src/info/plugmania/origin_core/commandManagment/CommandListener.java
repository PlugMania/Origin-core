package info.plugmania.origin_core.commandManagment;

import info.plugmania.origin_core.Origin_Core;

import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener{
	Origin_Core plugin;
	public CommandListener(Origin_Core instance){
		plugin=instance;
	}
	
@EventHandler
public void onPlayerPreProcessEvent(PlayerCommandPreprocessEvent event){
	plugin.commandManager.onPlayerCommand( command, args)
}

public String getCommandStripped(String command) {
	return command.substring(1);
}
}
