package de.Panischer.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageUtils {

    /**
     * Sends the player a message (color coding enabled)
     * @param player player to send the message to
     * @param message the message you want to send
     */
    public static void sendMessage(Player player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    /**
     * Sends the player a message (color coding enabled)
     * @param player player to send the message to
     * @param message the message you want to send
     */
    public static void sendMessage(CommandSender player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

}
