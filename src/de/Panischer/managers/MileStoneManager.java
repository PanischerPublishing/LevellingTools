package de.Panischer.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MileStoneManager {

	public static void applyMilestone(Player player, ItemStack is) {
		String milestoneCommand = ConfigManager.getMilestoneCommand(LevelManager.getLevels(is));
		if(milestoneCommand != "" && milestoneCommand != null) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), milestoneCommand.replace("%Player", player.getName()));
		}
	}
}
