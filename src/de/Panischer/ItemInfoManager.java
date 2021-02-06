package de.Panischer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
public class ItemInfoManager implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			ItemStack is = player.getInventory().getItemInMainHand();
			String material = is.getType().toString();
			if(material.contains("AXE") || material.contains("SHOVEL") || material.contains("SWORD") || material.contains("CHESTPLATE") || material.contains("BOOTS") || material.contains("LEGGINGS") || material.contains("HELMET") || material.contains("BOW"))
			{
			player.sendMessage("§7Material §f" + is.getType().toString());
			if(ConfigManager.useOwnerBinding())
			{
				try
				{
				player.sendMessage("§7Owner §f" + LevelManager.getOwner(is));
				}catch(IndexOutOfBoundsException e)
				{
				}
			}
			player.sendMessage("§7Level §f" + (LevelManager.getLevels(is) + 1));
			player.sendMessage("§7XP §f" + LevelManager.getCurrentXP(is) + "§7 / §f10");
			if(ConfigManager.useBonuses())
			{
				if(material.contains("SWORD"))
				{
					player.sendMessage("§7Bonus §f" + BonusManager.getDamageBonus(is) + " (DAMAGE)");
				}
				if(material.contains("BOW"))
				{
					player.sendMessage("§7Bonus §f" + BonusManager.getDamageBonus(is) + " (DAMAGE)");
				}
				if(material.contains("AXE") &! material.contains("PICKAXE"))
				{
					player.sendMessage("§7Bonus 1 §f" + BonusManager.getDamageBonus(is) + " (DAMAGE)");
					player.sendMessage("§7Bonus 2 §f" + BonusManager.getHasteBonus(is) + " (HASTE)");
				}
				if(material.contains("PICKAXE"))
				{
					player.sendMessage("§7Bonus §f" + BonusManager.getHasteBonus(is) + " (HASTE)");
				}
				if(material.contains("SHOVEL"))
				{
					player.sendMessage("§7Bonus §f" + BonusManager.getHasteBonus(is) + " (HASTE)");
				}
				if(material.contains("CHESTPLATE"))
				{
					player.sendMessage("§7Bonus §f" + BonusManager.getResistanceBonus(is) + " (RESISTANCE)");
				}
				if(material.contains("HELMET"))
				{
					player.sendMessage("§7Bonus §f" + BonusManager.getResistanceBonus(is) + " (RESISTANCE)");
				}
				if(material.contains("BOOTS"))
				{
					player.sendMessage("§7Bonus §f" + BonusManager.getResistanceBonus(is) + " (RESISTANCE)");
				}
				if(material.contains("LEGGINGS"))
				{
					player.sendMessage("§7Bonus §f" + BonusManager.getResistanceBonus(is) + " (RESISTANCE)");
				}
			}
			}else
			{
				player.sendMessage(ConfigManager.getItemNoInfoMessage());
			}
		}
		return false;
	}
}
