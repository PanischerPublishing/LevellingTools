package de.Panischer.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import de.Panischer.managers.ConfigManager;
import de.Panischer.utilities.MessageUtils;

public class FixCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("LevellingWeapons.fix")) {
				ItemStack is = player.getInventory().getItemInMainHand();
				Damageable im = (Damageable) is.getItemMeta();
				Material material = is.getType();
				if (material.isBlock() || material.getMaxDurability() < 1) {
					MessageUtils.sendMessage(sender, ConfigManager.getItemCannotBeFixedMessage());
					return false;
				}
				if (!im.hasDamage()) {
					MessageUtils.sendMessage(sender, ConfigManager.getItemAlreadyFixedMessage());
					return false;
				}
				im.setDamage(0);
				is.setItemMeta((ItemMeta) im);
				MessageUtils.sendMessage(sender, ConfigManager.getItemFixedMessage());
				return true;
			}
		}
		return false;
	}
}
