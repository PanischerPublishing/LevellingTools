package de.Panischer;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
public class LevelManager
{
	public static void addExperience(ItemStack is, Player player, int count)
	{
		try
		{
		for(int i = 0; i < count; i++)
		{
		List<String> lore = new ArrayList<String>();
		ItemMeta im = is.getItemMeta();
		lore.add("");
		if(is.getItemMeta().getLore() != null)
		{
			if(is.getItemMeta().getLore().get(2).contains("§f10 §7/ §f10"))
			{
				int loreLevels = Integer.valueOf(is.getItemMeta().getLore().get(1).substring(10))  + 1;
				lore.add("§7Level §f" + loreLevels);
				lore.add("§7XP §f1 §7/ §f10");
				im.setLore(lore);
				is.setItemMeta(im);
				player.sendMessage("§6§lTool§7-§6§lLevelup§7! §7(§f"+ is.getType().toString() + ")");
			}else
			{
				lore.add(is.getItemMeta().getLore().get(1));
				lore.add("§7XP §f" + (Integer.valueOf(is.getItemMeta().getLore().get(2).substring(7).replace(" §7/ §f10", "")) + 1) + " §7/ §f10");
				im.setLore(lore);
				is.setItemMeta(im);
			}
		}else
		{
			lore.add("§7Level §f1");
			lore.add("§7XP §f1 §7/ §f10");
			im.setLore(lore);
			is.setItemMeta(im);
		}
		}
		}catch(IndexOutOfBoundsException | NullPointerException e)
		{
		}
	}
	public static double getLevels(ItemStack is)
	{
		try
		{
			double levelCount = Integer.valueOf(is.getItemMeta().getLore().get(1).substring(10)) - 1;
			return levelCount;
		}catch(NullPointerException | IndexOutOfBoundsException e)
		{
			return 0;
		}
	}
	public static void getLevel(Player player, int amount)
	{
		List<String> lore = new ArrayList<String>();
		ItemStack is = new ItemStack(Material.PAPER);
		ItemMeta im = is.getItemMeta();
		lore.add("");
		lore.add("§7Level §f" + amount);
		lore.add("§7XP §f1 §7/ §f10");
		im.setLore(lore);
		is.setItemMeta(im);
		player.getInventory().addItem(is);
	}
}
