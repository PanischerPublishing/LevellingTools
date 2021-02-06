package de.Panischer.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Panischer.managers.ConfigManager;
import de.Panischer.managers.LevelManager;
import de.Panischer.utilities.MessageUtils;

public class GetLevelCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if(sender instanceof Player) {
		if(sender.isOp()) {
		Player player = (Player) sender;
			try {
			if(args[0].matches(".*\\d.*")) {
				LevelManager.getLevel(player, Integer.valueOf(args[0]));
				MessageUtils.sendMessage(sender, "§7You've got a §6magic §7levelling paper!");
			} else  {
				MessageUtils.sendMessage(sender, "§7Usage: §c/getlevel §8<§camount§8>");
			}
			}catch(ArrayIndexOutOfBoundsException e) {
				MessageUtils.sendMessage(sender, "§7Usage: §c/getlevel §8<§camount§8>");
			}
		} else {
			sender.sendMessage(ConfigManager.getNoPermissionMessage());
		}
	}
	return false;
	}
}
