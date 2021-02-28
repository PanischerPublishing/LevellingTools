package de.Panischer.LevellingTools.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.Panischer.LevellingTools.utilities.MessageUtil;

public class MilestoneManager {

	public static void applyCommandMilestone(Player player, ItemStack is) {
		try {
			String command = ConfigManager.getString("console-command-milestones." + String.valueOf(LoreManager.getToolLevel(is) + 1).replace(".0", "")).replace("%player", player.getName());
			if(command != null && command != "") {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), MessageUtil.translate(command));
			}
		} catch(NullPointerException | IllegalArgumentException e) {
			
		}
		player.sendMessage(MessageUtil.translate(ConfigManager.getString("language.levelup-message")).replace("%level", String.valueOf(LoreManager.getToolLevel(is) + (double) 1).replace(".0", "")));
	}
	public static String getLoreMilestone(Player player, ItemStack is) {
		try {
			String milestone = ConfigManager.getString("lore-milestones." + String.valueOf(LoreManager.getToolLevel(is) + 1).replace(".0", ""));
			if(milestone != null && milestone != "") {
				return MessageUtil.translate(milestone);
			} else {
				return "";
			}
		} catch(NullPointerException e) {
			return "";
		}
	}

}
