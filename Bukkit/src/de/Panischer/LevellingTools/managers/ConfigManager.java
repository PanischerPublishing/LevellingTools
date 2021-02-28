package de.Panischer.LevellingTools.managers;

import org.bukkit.configuration.file.FileConfiguration;

import de.Panischer.LevellingTools.Main;

public class ConfigManager {

	public static FileConfiguration config;
	
	public static void updateConfig() {
		config = Main.plugin.getConfig();
	}

	public static double getDouble(String string) {
		updateConfig();
		return config.getDouble(string);
	}
	
	public static boolean getBoolean(String string) {
		updateConfig();
		return config.getBoolean(string);
	}
	
	public static String getString(String string) {
		updateConfig();
		return config.getString(string);
	}
	
}
