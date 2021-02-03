package de.Panischer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class CommandManager implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
	if(sender instanceof Player)
	{
		if(sender.isOp())
		{
		Player player = (Player) sender;
			try
			{
			if(args[0].matches(".*\\d.*"))
			{
				LevelManager.getLevel(player, Integer.valueOf(args[0]));
				player.sendMessage("§7You've got a §6magic §7levelling paper!");
			}else
			{
				player.sendMessage("§7Usage: §c/getlevel §8<§camount§8>");
			}
			}catch(ArrayIndexOutOfBoundsException e)
			{
				player.sendMessage("§7Usage: §c/getlevel §8<§camount§8>");
			}
		}else
		{
			sender.sendMessage("§7Sorry, but you don't have §cpermission §7to do that.");
		}
	}
	return false;
	}
}
