package de.Panischer.commands;

import de.Panischer.managers.ConfigManager;
import de.Panischer.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FixCommand implements CommandExecutor {
    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("LevellingWeapons.fix")) {
                ItemStack is = player.getInventory().getItemInMainHand();
                if (is.getDurability() != 0) {
                    is.setDurability((short) 0);
                    MessageUtils.sendMessage(player, ConfigManager.getItemFixedMessage());
                } else {
                    MessageUtils.sendMessage(player, ConfigManager.getItemAlreadyFixedMessage());
                }
            } else {
                MessageUtils.sendMessage(player, ConfigManager.getNoPermissionMessage());
            }
        }
        return false;
    }

}
