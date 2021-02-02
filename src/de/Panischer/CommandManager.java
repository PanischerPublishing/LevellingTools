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
			if(!args[0].isEmpty())
			{
			if(args[0].matches(".*\\d.*"))
			{
				LevelManager.setLevel(player.getInventory().getItemInMainHand(), Integer.valueOf(args[0]));
				player.sendMessage("§7You set your tools' level!");
			}else
			{
				player.sendMessage("§7Usage: §c/setlevel §8<§camount§8>");
			}
			}else
			{
				player.sendMessage("§7Usage: §c/setlevel §8<§camount§8>");	
			}
			}else
			{
				sender.sendMessage("§7Sorry, but you don't have §cpermission §7to do that.");
			}
		}
		return false;
	}
}
