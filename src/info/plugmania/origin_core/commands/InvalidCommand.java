package info.plugmania.origin_core.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import info.plugmania.origin_core.Origin_Core;

public class InvalidCommand extends Command {

	public InvalidCommand(Origin_Core instance) {
		super(instance);
	}

	public boolean onCommand(CommandSender sender,
			org.bukkit.command.Command command, String something, String[] args) {
	sender.sendMessage(ChatColor.RED + "You've somehow ended up with an invalid command!");
		return true;
	}

}
