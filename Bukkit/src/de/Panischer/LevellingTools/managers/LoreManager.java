package de.Panischer.LevellingTools.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class LoreManager {

	public static double getToolXP(ItemStack is) {
		double xp = Double.valueOf(is.getItemMeta().getLore().get(1).split("/")[0].substring(7).replace(" �7", ""));
		return xp;
	}
	
	public static double getMaxToolXP(ItemStack is) {
		double maxXp = Double.valueOf(is.getItemMeta().getLore().get(1).split("/")[1].substring(3));
		return maxXp;
	}
	
	public static double getToolLevel(ItemStack is) {
		double level = Double.valueOf(is.getItemMeta().getLore().get(2).substring(10));
		return level;
	}
	
	public static Player getOwner(ItemStack is) {
		String playerName = null;
		Player player = null;
		if(is.getItemMeta().getLore() != null) {
			playerName = is.getItemMeta().getLore().get(3).substring(2);
			if(!playerName.equals("") && Bukkit.getPlayer(playerName) != null) {
				player = Bukkit.getPlayer(playerName);
			}
		}
		return player;
	}
	
	public static double getPaperLevel(ItemStack is) {
		if(is.getItemMeta().getLore() != null) {
			double level = Double.valueOf(is.getItemMeta().getLore().get(1).substring(10));
			return level;
		} else {
			return 0;
		}
	}

	public static String getLoreMilestone(ItemStack is) {
		String lore;
		try {
		if(ConfigManager.getBoolean("use.owner-binding")) {
			lore = is.getItemMeta().getLore().get(5);
		} else {
			lore = is.getItemMeta().getLore().get(4);
		}
		} catch(NullPointerException e) {
			lore = "";
		}
		return lore;
	}
	
}
