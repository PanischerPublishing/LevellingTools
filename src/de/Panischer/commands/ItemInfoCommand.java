package de.Panischer.commands;

import de.Panischer.managers.BonusManager;
import de.Panischer.managers.ConfigManager;
import de.Panischer.managers.LevelManager;
import de.Panischer.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemInfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack is = player.getInventory().getItemInMainHand();
            String material = is.getType().toString();
            if (material.contains("AXE") || material.contains("SHOVEL") || material.contains("SWORD") || material.contains("CHESTPLATE") || material.contains("BOOTS") || material.contains("LEGGINGS") || material.contains("HELMET") || material.contains("BOW")) {
                MessageUtils.sendMessage(player, "&7Material &f" + is.getType().toString());
                if (ConfigManager.useOwnerBinding()) {
                    try {
                        MessageUtils.sendMessage(player, "&7Owner &f" + LevelManager.getOwner(is));
                    } catch (IndexOutOfBoundsException e) {
                    }
                }
                MessageUtils.sendMessage(player, "&7Level &f" + (LevelManager.getLevels(is) + 1));
                MessageUtils.sendMessage(player, "&7XP &f" + LevelManager.getCurrentXP(is) + "&7 / &f10");
                if (ConfigManager.useBonuses()) {
                    if (material.contains("SWORD")) {
                        MessageUtils.sendMessage(player, "&7Bonus &f" + BonusManager.getDamageBonus(is) + " (DAMAGE)");
                    }
                    if (material.contains("BOW")) {
                        MessageUtils.sendMessage(player, "&7Bonus &f" + BonusManager.getDamageBonus(is) + " (DAMAGE)");
                    }
                    if (material.contains("AXE") & !material.contains("PICKAXE")) {
                        MessageUtils.sendMessage(player, "&7Bonus &f" + BonusManager.getDamageBonus(is) + " (DAMAGE)");
                        MessageUtils.sendMessage(player, "&7Bonus &f" + BonusManager.getHasteBonus(is) + " (HASTE)");
                    }
                    if (material.contains("PICKAXE")) {
                        MessageUtils.sendMessage(player, "&7Bonus &f" + BonusManager.getHasteBonus(is) + " (HASTE)");
                    }
                    if (material.contains("SHOVEL")) {
                        MessageUtils.sendMessage(player, "&7Bonus &f" + BonusManager.getHasteBonus(is) + " (HASTE)");
                    }
                    if (material.contains("CHESTPLATE")) {
                        MessageUtils.sendMessage(player, "&7Bonus &f" + BonusManager.getResistanceBonus(is) + " (RESISTANCE)");
                    }
                    if (material.contains("HELMET")) {
                        MessageUtils.sendMessage(player, "&7Bonus &f" + BonusManager.getResistanceBonus(is) + " (RESISTANCE)");
                    }
                    if (material.contains("BOOTS")) {
                        MessageUtils.sendMessage(player, "&7Bonus &f" + BonusManager.getResistanceBonus(is) + " (RESISTANCE)");
                    }
                    if (material.contains("LEGGINGS")) {
                        MessageUtils.sendMessage(player, "&7Bonus &f" + BonusManager.getResistanceBonus(is) + " (RESISTANCE)");
                    }
                }
            } else {
                MessageUtils.sendMessage(player, ConfigManager.getItemNoInfoMessage());
            }
        }
        return false;
    }
}
