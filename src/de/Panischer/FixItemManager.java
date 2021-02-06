package de.Panischer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
public class FixItemManager implements CommandExecutor
{
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			if(player.hasPermission("LevellingWeapons.fix"))
			{
				ItemStack is = player.getInventory().getItemInMainHand();
				if(is.getDurability() != 0)
				{
					is.setDurability((short) 0);
					player.sendMessage(ConfigManager.getItemFixedMessage());
				}else
				{
					player.sendMessage(ConfigManager.getItemAlreadyFixedMessage());
				}
			}else
			{
				player.sendMessage(ConfigManager.getNoPermissionMessage());
			}
		}
		return false;
	}

}
