package de.Panischer.commands;

import de.Panischer.managers.ConfigManager;
import de.Panischer.managers.LevelManager;
import de.Panischer.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetLevelCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.isOp()) {
                Player player = (Player) sender;
                try {
                    if (args[0].matches(".*\\d.*")) {
                        LevelManager.getLevel(player, Integer.valueOf(args[0]));
                        MessageUtils.sendMessage(player, "&7You've got a &6magic&7 levelling paper!");
                    } else {
                        MessageUtils.sendMessage(player, "&7Usage: &c/getlevel <amount>");
                        player.sendMessage("§7Usage: §c/getlevel §8<§camount§8>");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    MessageUtils.sendMessage(player, "&7Usage: &c/getlevel <amount>");
                }
            } else {
                MessageUtils.sendMessage(sender, ConfigManager.getNoPermissionMessage());
            }
        }
        return false;
    }
}
