package de.Panischer.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.Panischer.Main;
import de.Panischer.managers.ConfigManager;
import de.Panischer.utilities.MessageUtils;

public class ConfigReloadCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.isOp()) {
			Main.plugin.reloadConfig();
			MessageUtils.sendMessage(sender, ConfigManager.getConfigReloadedMessage());
		} else {
			MessageUtils.sendMessage(sender, ConfigManager.getNoPermissionMessage());
		}
		return false;
	}
	
}
