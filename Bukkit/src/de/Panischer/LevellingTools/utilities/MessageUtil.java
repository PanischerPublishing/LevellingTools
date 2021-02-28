package de.Panischer.LevellingTools.utilities;

import org.bukkit.ChatColor;

public class MessageUtil {

	public static String translate(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}
	
}
