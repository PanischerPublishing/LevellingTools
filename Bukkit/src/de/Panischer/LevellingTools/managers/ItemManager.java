package de.Panischer.LevellingTools.managers;

import org.bukkit.inventory.ItemStack;

public class ItemManager {

	public static boolean isSword(ItemStack is) {
		if(is != null) {
			return is.getType().toString().contains("SWORD");
		} else {
			return false;
		}
	}

	public static boolean isShovel(ItemStack is) {
		if(is != null) {
			return is.getType().toString().contains("SHOVEL");
		} else {
			return false;
		}
	}

	public static boolean isPickaxe(ItemStack is) {
		if(is != null) {
		return is.getType().toString().contains("PICKAXE");
		} else {
			return false;
		}
	}

	public static boolean isAxe(ItemStack is) {
		if(is != null) {
		return is.getType().toString().contains("AXE") &! is.getType().toString().contains("PICKAXE");
	} else {
		return false;
	}
	}

	public static boolean isBow(ItemStack is) {
		if(is != null) {
		return is.getType().toString().contains("BOW") &! is.getType().toString().contains("CROSSBOW");
		} else {
			return false;
		}
	}

	public static boolean isCrossbow(ItemStack is) {
		if(is != null) {
		return is.getType().toString().contains("CROSSBOW");
		} else {
			return false;
		}
	}

	public static boolean isHelmet(ItemStack is) {
		if(is != null) {
		return is.getType().toString().contains("HELMET");
		} else {
			return false;
		}
	}

	public static boolean isChestplate(ItemStack is) {
		if(is != null) {
		return is.getType().toString().contains("CHESTPLATE");
		} else {
			return false;
		}
	}

	public static boolean isLeggings(ItemStack is) {
		if(is != null) {
		return is.getType().toString().contains("LEGGINGS");
		} else {
			return false;
		}
	}

	public static boolean isBoots(ItemStack is) {
		if(is != null) {
		return is.getType().toString().contains("BOOTS");
		} else {
			return false;
		}
	}
	
}
