package de.Panischer.managers;

import org.bukkit.inventory.ItemStack;

public class BonusManager {
	
	public static double getDamageBonus(ItemStack is) {
		if(ConfigManager.useBonuses()) {
			double bonus = LevelManager.getLevels(is) / 10;
			return bonus;
		} else {
			return 0;
		}
	}
	
	public static int getHasteBonus(ItemStack is) {
		if(ConfigManager.useBonuses()) {
		if(LevelManager.getLevels(is) < 254) {
			int bonus = (int) LevelManager.getLevels(is);
			return bonus;
		} else {
			return 255;
		}
		} else {
			return 0;
		}
	}
	
	public static double getResistanceBonus(ItemStack is) {
		if(ConfigManager.useBonuses()) {
		double bonus = LevelManager.getLevels(is) / 100;
		return bonus;
		} else {
			return 0;
		}
	}
}
