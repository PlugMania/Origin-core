package info.plugmania.origin_core.commandManagment;

import info.plugmania.origin_core.Origin_Core;

import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class CommandListener implements Listener{
	Origin_Core plugin;
	public CommandListener(Origin_Core instance){
		plugin=instance;
	}
	
@EventHandler
public void onPlayerPreprocessEvent(PlayerCommandPreprocessEvent event){
	String commandNoSlash=getCommandStripped(event.getMessage());
	if(plugin.commandManager.has(sit(commandNoSlash,' ',0))){
	plugin.commandManager.onPlayerCommand(event.getPlayer(),sit(commandNoSlash,' ',0), sit(commandNoSlash,' ',1).split(" "));
	event.setCancelled(true);
	}
}

@EventHandler
public void onServerPreprocessEvent(ServerCommandEvent event){
	if(plugin.commandManager.has(sit(event.getCommand(),' ',0))){
	plugin.commandManager.onServerCommand(plugin.getServer(),sit(event.getCommand(),' ',0), sit(event.getCommand(),' ',1).split(" "));
	}
}


/*
 * Utility commands for this class
 * 
 */

public String getCommandStripped(String command) {
	return command.substring(1);
}


//'Split Into Two' along a delimiter, returning either part 0 or 1.
public String sit(String iStr, char delimiter, int part) {
	if (part == 0) {
		if (!iStr.contains(String.valueOf(delimiter)))
			return iStr;
	} else {
		if (!iStr.contains(String.valueOf(delimiter)))
			return "";
	}
	if (part == 0)
		return iStr.substring(0, (iStr.indexOf(delimiter, 0)));
	return iStr.substring(iStr.indexOf(delimiter, 0) + 1, iStr.length());
}

}
