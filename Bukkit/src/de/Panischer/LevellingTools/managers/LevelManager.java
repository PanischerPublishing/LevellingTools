package de.Panischer.LevellingTools.managers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LevelManager {

	public static void addXPToTool(ItemStack is, int amount, Player player, Event event) {
		if(LoreManager.getOwner(is) == null) {
			add(is, amount, player, event);
		}
		if(LoreManager.getOwner(is).equals(player)) {
			add(is, amount, player, event);
		}
		if(ConfigManager.getBoolean("use.owner-binding") == false) {
			add(is, amount, player, event);
		}
	}

	private static void add(ItemStack is, int amount, Player player, Event event) {
		if(is.getItemMeta().hasLore() &! (event instanceof PlayerExpChangeEvent)) {
			if(ItemManager.isPickaxe(is) || ItemManager.isShovel(is)) {
				BonusManager.increaseBlockBreakSpeed((BlockBreakEvent) event);
			}
			if(ItemManager.isSword(is) || ItemManager.isBow(is) || ItemManager.isCrossbow(is)) {
				BonusManager.increaseDamageDealt((EntityDamageByEntityEvent) event);
			}
			if(ItemManager.isHelmet(is) || ItemManager.isChestplate(is) || ItemManager.isLeggings(is) || ItemManager.isBoots(is)) {
				BonusManager.reduceDamageTaken((EntityDamageByEntityEvent) event);
			}
			if(ItemManager.isAxe(is)) {
				if(event instanceof EntityDamageByEntityEvent) {
					BonusManager.increaseDamageDealt((EntityDamageByEntityEvent) event);
				} else if(event instanceof BlockBreakEvent) {
					BonusManager.increaseBlockBreakSpeed((BlockBreakEvent) event);
				}
			}
		}
		for(int i = 0; i < amount; i++) {
			List<String> lore = new ArrayList<String>();
			ItemMeta im = is.getItemMeta();
			if(im.hasLore()) {
				if(LoreManager.getToolXP(is) < LoreManager.getMaxToolXP(is)) {
					lore.add("");
					lore.add("§7XP §f" + (LoreManager.getToolXP(is) + 1) + " §7/ §f" + LoreManager.getMaxToolXP(is));
					lore.add("§7Level §f" + LoreManager.getToolLevel(is));
					if(ConfigManager.getBoolean("use.owner-binding")) {
						lore.add("§c" + player.getName());
					}
					lore.add("");
					lore.add(LoreManager.getLoreMilestone(is));
				} else {
					DecimalFormat format = new DecimalFormat("0.00");
					lore.add("");
					lore.add("§7XP §f" + (double) 0 + " §7/ §f" + format.format(LoreManager.getMaxToolXP(is) * ConfigManager.getDouble("multiplier.xp")).replace(",", "."));
					lore.add("§7Level §f" + (LoreManager.getToolLevel(is) + 1));
					if(ConfigManager.getBoolean("use.owner-binding")) {
						lore.add("§c" + player.getName());
					}
					lore.add("");
					if(MilestoneManager.getLoreMilestone(player, is) == "") {
						lore.add(LoreManager.getLoreMilestone(is));
					} else {
						lore.add(MilestoneManager.getLoreMilestone(player, is));
					}
					MilestoneManager.applyCommandMilestone(player, is);
				}
				im.setLore(lore);
				is.setItemMeta(im);
			} else {
				lore.add("");
				lore.add("§7XP §f" + (double) 0 + " §7/ §f" + (double) 10);
				lore.add("§7Level §f" + (double) 0);
				if(ConfigManager.getBoolean("use.owner-binding")) {
					lore.add("§c" + player.getName());
				}
				lore.add("");
				lore.add(MilestoneManager.getLoreMilestone(player, is));
				im.setLore(lore);
				is.setItemMeta(im);
			}
		}
	}
	
}
