package de.Panischer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
public class ConfigReloadManager implements CommandExecutor
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
