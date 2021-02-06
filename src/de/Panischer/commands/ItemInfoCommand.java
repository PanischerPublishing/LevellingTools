package de.Panischer.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.Panischer.managers.BonusManager;
import de.Panischer.managers.ConfigManager;
import de.Panischer.managers.LevelManager;
import de.Panischer.utilities.MessageUtils;

public class ItemInfoCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			ItemStack is = player.getInventory().getItemInMainHand();
			String material = is.getType().toString();
			if(material.contains("AXE") || material.contains("SHOVEL") || material.contains("SWORD") || material.contains("CHESTPLATE") || material.contains("BOOTS") || material.contains("LEGGINGS") || material.contains("HELMET") || material.contains("BOW")) {
			MessageUtils.sendMessage(sender, "§7Material §f" + is.getType().toString());
			if(ConfigManager.useOwnerBinding()) {
				try {
				MessageUtils.sendMessage(sender, "§7Owner §f" + LevelManager.getOwner(is));
				}catch(IndexOutOfBoundsException e) {
				}
			}
			MessageUtils.sendMessage(sender, "§7Level §f" + (LevelManager.getLevels(is) + 1));
			MessageUtils.sendMessage(sender, "§7XP §f" + LevelManager.getCurrentXP(is) + "§7 / §f10");
			if(ConfigManager.useBonuses()) {
				if(material.contains("SWORD")) {
					MessageUtils.sendMessage(sender, "§7Bonus §f" + BonusManager.getDamageBonus(is) + " (DAMAGE)");
				}
				if(material.contains("BOW")) {
					MessageUtils.sendMessage(sender, "§7Bonus §f" + BonusManager.getDamageBonus(is) + " (DAMAGE)");
				}
				if(material.contains("AXE") &! material.contains("PICKAXE")){
					MessageUtils.sendMessage(sender, "§7Bonus 1 §f" + BonusManager.getDamageBonus(is) + " (DAMAGE)");
					MessageUtils.sendMessage(sender, "§7Bonus 2 §f" + BonusManager.getHasteBonus(is) + " (HASTE)");
				}
				if(material.contains("PICKAXE")) {
					MessageUtils.sendMessage(sender, "§7Bonus §f" + BonusManager.getHasteBonus(is) + " (HASTE)");
				}
				if(material.contains("SHOVEL")) {
					MessageUtils.sendMessage(sender, "§7Bonus §f" + BonusManager.getHasteBonus(is) + " (HASTE)");
				}
				if(material.contains("CHESTPLATE")) {
					MessageUtils.sendMessage(sender, "§7Bonus §f" + BonusManager.getResistanceBonus(is) + " (RESISTANCE)");
				}
				if(material.contains("HELMET")) {
					MessageUtils.sendMessage(sender, "§7Bonus §f" + BonusManager.getResistanceBonus(is) + " (RESISTANCE)");
				}
				if(material.contains("BOOTS")) {
					MessageUtils.sendMessage(sender, "§7Bonus §f" + BonusManager.getResistanceBonus(is) + " (RESISTANCE)");
				}
				if(material.contains("LEGGINGS")) {
					MessageUtils.sendMessage(sender, "§7Bonus §f" + BonusManager.getResistanceBonus(is) + " (RESISTANCE)");
				}
			}
			} else {
				MessageUtils.sendMessage(sender, ConfigManager.getItemNoInfoMessage());
			}
		}
		return false;
	}
}
