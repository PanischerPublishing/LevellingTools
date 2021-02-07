package de.Panischer.managers;

import org.bukkit.configuration.file.FileConfiguration;

import de.Panischer.Main;

public class ConfigManager {
	
	public static void makeConfig() {
		FileConfiguration config = Main.plugin.getConfig();
		if(!config.contains("UseBonuses")) {
			config.set("UseBonuses", true);
		}
		if(!config.contains("UseOwnerBinding")) {
			config.set("UseOwnerBinding", true);
		}
		if(!config.contains("UseAnvilTransmission")) {
			config.set("UseAnvilTransmission", true);
		}
		if(!config.contains("xp.earned-multiplier")) {
			config.set("xp.earned-multiplier", 1.0);
		}
		if(!config.contains("xp.required-multiplier")) {
			config.set("xp.required-multiplier", 1.0);
		}
		if(!config.contains("language.levelup-message")) {
			config.set("language.levelup-message", "§6§lTool§7-§6§lLevelup§7! §7(§f%Item§7)");
		}
		if(!config.contains("language.no-permission")) {
			config.set("language.no-permission", "§7Sorry, but you don't have §cpermission §7to do that.");
		}
		if(!config.contains("language.magic-paper-success")) {
			config.set("language.magic-paper-success", "§7You've got a §6magic §7levelling paper!");
		}
		if(!config.contains("language.config-reloaded")) {
			config.set("language.config-reloaded", "§7You just §creloaded §7the plugin's config!");
		}
		if(!config.contains("language.item-fixed")) {
			config.set("language.item-fixed", "§7Your item has been §cfixed§7!");
		}
		if(!config.contains("language.item-already-fixed")) {
			config.set("language.item-already-fixed", "§7Your item is still §cfixed§7!");
		}
		if(!config.contains("language.item-cannot-be-fixed")) {
			config.set("language.item-cannot-be-fixed", "§7Your item §ccannot §7be fixed!");
		}
		if(!config.contains("language.item-no-info")) {
			config.set("language.item-no-info", "§7This item is §cunlevellable§7!");
		}
		if(!config.contains("milestones")) {
			config.set("milestones.1", "say %Player's LevellingWeapon got its first level!");
		}
		Main.plugin.saveConfig();
	}
	
	public static boolean useBonuses() {
		FileConfiguration config = Main.plugin.getConfig();
		return config.getBoolean("UseBonuses");
	}
	
	public static boolean useOwnerBinding() {
		FileConfiguration config = Main.plugin.getConfig();
		return config.getBoolean("UseOwnerBinding");
	}
	
	public static boolean UseAnvilTransmission() {
		FileConfiguration config = Main.plugin.getConfig();
		return config.getBoolean("UseAnvilTransmission");
	}
	
	public static double getXPEarnedMuliplier() {
		FileConfiguration config = Main.plugin.getConfig();
		return config.getDouble("xp.earned-multiplier");
	}
	
	public static double getXPRequiredMuliplier() {
		FileConfiguration config = Main.plugin.getConfig();
		return config.getDouble("xp.required-multiplier");
	}
	
	public static String getLevelUpMessage() {
		FileConfiguration config = Main.plugin.getConfig();
		return config.getString("language.levelup-message");
	}
	
	public static String getNoPermissionMessage() {
		FileConfiguration config = Main.plugin.getConfig();
		return config.getString("language.no-permission");
	}
	
	public static String getMagicPaperSuccessMessage() {
		FileConfiguration config = Main.plugin.getConfig();
		return config.getString("language.magic-paper-success");
	}
	
	public static String getConfigReloadedMessage() {
		FileConfiguration config = Main.plugin.getConfig();
		return config.getString("language.config-reloaded");
	}
	
	public static String getItemFixedMessage() {
		FileConfiguration config = Main.plugin.getConfig();
		return config.getString("language.item-fixed");
	}
	
	public static String getItemAlreadyFixedMessage() {
		FileConfiguration config = Main.plugin.getConfig();
		return config.getString("language.item-already-fixed");
	}
	
	public static String getItemCannotBeFixedMessage() {
		FileConfiguration config = Main.plugin.getConfig();
		return config.getString("language.item-cannot-be-fixed");
	}
	
	public static String getItemNoInfoMessage() {
		FileConfiguration config = Main.plugin.getConfig();
		return config.getString("language.item-no-info");
	}
	
	public static String getMilestoneCommand(double i) {
		FileConfiguration config = Main.plugin.getConfig();
		try {
			return config.getString("milestones." + String.valueOf(i + 1).replace(".0", ""));
		} catch(NullPointerException | IllegalArgumentException e) {
			return "";
		}
	}
}
