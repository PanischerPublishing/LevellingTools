package de.Panischer.commands;
import de.Panischer.managers.ConfigManager;
import de.Panischer.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
public class ConfigReloadCommand implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(sender.isOp())
		{
			Main.plugin.reloadConfig();
			sender.sendMessage(ConfigManager.getConfigReloadedMessage());
		}else
		{
			sender.sendMessage(ConfigManager.getNoPermissionMessage());
		}
		return false;
	}
	
}
