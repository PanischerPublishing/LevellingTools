package de.Panischer.LevellingTools.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.Panischer.LevellingTools.managers.ConfigManager;
import de.Panischer.LevellingTools.utilities.MessageUtil;

public class ReloadConfigCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("permission.reload-config")) {
			ConfigManager.updateConfig();
			sender.sendMessage(MessageUtil.translate(ConfigManager.getString("language.config-reloaded")));
		} else {
			sender.sendMessage(MessageUtil.translate(ConfigManager.getString("language.no-permission")));
		}
		return false;
	}

}
