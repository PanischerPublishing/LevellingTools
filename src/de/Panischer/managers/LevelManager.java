package de.Panischer.managers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.Panischer.utilities.MessageUtils;

public class LevelManager {
	
	public static void addExperience(ItemStack is, Player player, int count) {
		try {
			for(int i = 0; i < count; i++) {
			List<String> lore = new ArrayList<String>();
			ItemMeta im = is.getItemMeta();
			lore.add("");
			if(is.getItemMeta().getLore() != null) {
				if(getCurrentXP(is) >= getMaximumXP(is)) {
					int loreLevels = Integer.valueOf(is.getItemMeta().getLore().get(1).substring(10)) + 1;
					lore.add("§7Level §f" + loreLevels);
					lore.add("§7XP §f0 §7/ §f" + (getMaximumXP(is) + ConfigManager.getXPRequiredMuliplier()));
					if(ConfigManager.useOwnerBinding()) {
						lore.add("§7- §c" + player.getName() + " §7-");
					}
					im.setLore(lore);
					im.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
					is.setItemMeta(im);
					MessageUtils.sendMessage(player, ConfigManager.getLevelUpMessage().replace("%Item", is.getType().toString()));
					MileStoneManager.applyMilestone(player, is);
					} else {
					lore.add(is.getItemMeta().getLore().get(1));
					DecimalFormat df = new DecimalFormat("###.###");
					lore.add("§7XP §f" + df.format(getCurrentXP(is) + (1 * ConfigManager.getXPEarnedMuliplier())) + " §7/ §f" + getMaximumXP(is));
					if(ConfigManager.useOwnerBinding()) {
					lore.add("§7- §c" + player.getName() + " §7-");
					}
					im.setLore(lore);
					is.setItemMeta(im);
				}
			} else {
				lore.add("§7Level §f1");
				lore.add("§7XP §f0 §7/ §f10");
				if(ConfigManager.useOwnerBinding())
				{
				lore.add("§7- §c" + player.getName() + " §7-");
				}
				im.setLore(lore);
				is.setItemMeta(im);
			}
			}
		}catch(IndexOutOfBoundsException | NullPointerException e) {
		}
	}
	
	public static double getLevels(ItemStack is) {
		try {
			double levelCount = Integer.valueOf(is.getItemMeta().getLore().get(1).substring(10)) - 1;
			return levelCount;
		}catch(NullPointerException | IndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	public static void getLevel(Player player, int amount) {
		List<String> lore = new ArrayList<String>();
		ItemStack is = new ItemStack(Material.PAPER);
		ItemMeta im = is.getItemMeta();
		lore.add("");
		lore.add("§7Level §f" + amount);
		lore.add("§7XP §f0 §7/ §f10");
		im.setLore(lore);
		is.setItemMeta(im);
		player.getInventory().addItem(is);
	}
	
	public static String getOwner(ItemStack is) {
		if(is.hasItemMeta()) {
			if(is.getItemMeta().hasLore()) {
				return is.getItemMeta().getLore().get(3);
			} else {
				return "none";
			}
		} else {
			return "none";
		}
	}

	public static double getCurrentXP(ItemStack is)
	{
		try {
			String[] lore = is.getItemMeta().getLore().get(2).split("/");
			return Double.valueOf(lore[0].substring(7).replace(" §7", "").replace(",", "."));
		}catch(NullPointerException | IndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	public static double getMaximumXP(ItemStack is) {
		try {
			String[] lore = is.getItemMeta().getLore().get(2).split("/");
			return Double.valueOf(lore[1].substring(3).replace(",", "."));
		}catch(NullPointerException | IndexOutOfBoundsException e) {
			return 0;
		}
	}
}
