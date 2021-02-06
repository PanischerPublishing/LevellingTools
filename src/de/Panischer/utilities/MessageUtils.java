package de.Panischer.utilities;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageUtils {
	
	public static void sendMessage(Player player, String message) {
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
	}
	
    public static void sendMessage(CommandSender player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
