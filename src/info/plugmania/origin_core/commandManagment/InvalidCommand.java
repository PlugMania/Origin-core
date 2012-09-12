package info.plugmania.origin_core.commandManagment;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import info.plugmania.origin_core.Origin_Core;

public class InvalidCommand extends Command {
	public InvalidCommand(Origin_Core instance) {
		super(instance);
	}

	public void onPlayerCommand(Player sender,String command, String[] args) {
		sender.sendMessage(ChatColor.RED + command + " is not a valid command!");
	}
	
	public void onServerCommand(Server s,String c, String[] args) {
		//TODO: add code to tell the server off for doing an invalid command.
	}
}
