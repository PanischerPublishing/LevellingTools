package de.Panischer.LevellingTools.managers;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import de.Panischer.LevellingTools.utilities.RandomUtil;

public class EventManager implements Listener {

	@EventHandler
	public void onPlayerEarnXP(PlayerExpChangeEvent event) {
		Player player = event.getPlayer();
		PlayerInventory inventory = player.getInventory();
		if(ItemManager.isHelmet(inventory.getHelmet())) {
			LevelManager.addXPToTool(inventory.getHelmet(), RandomUtil.getRandom(1, 6), player, event);
		}
		if(ItemManager.isChestplate(inventory.getChestplate())) {
			LevelManager.addXPToTool(inventory.getChestplate(), RandomUtil.getRandom(1, 6), player, event);
		}
		if(ItemManager.isLeggings(inventory.getLeggings())) {
			LevelManager.addXPToTool(inventory.getLeggings(), RandomUtil.getRandom(1, 6), player, event);
		}
		if(ItemManager.isBoots(inventory.getBoots())) {
			LevelManager.addXPToTool(inventory.getBoots(), RandomUtil.getRandom(1, 6), player, event);
		}
		if(ItemManager.isPickaxe(inventory.getItemInMainHand())) {
			LevelManager.addXPToTool(inventory.getItemInMainHand(),  RandomUtil.getRandom(1, 6), player, event);
		}
		if(ItemManager.isAxe(inventory.getItemInMainHand())) {
			LevelManager.addXPToTool(inventory.getItemInMainHand(),  RandomUtil.getRandom(1, 6), player, event);
		}
		if(ItemManager.isCrossbow(inventory.getItemInMainHand())) {
			LevelManager.addXPToTool(inventory.getItemInMainHand(),  RandomUtil.getRandom(1, 4), player, event);
		}
		if(ItemManager.isBow(inventory.getItemInMainHand())) {
			LevelManager.addXPToTool(inventory.getItemInMainHand(), RandomUtil.getRandom(1, 6), player, event);
		}
		if(ItemManager.isSword(inventory.getItemInMainHand())) {
			LevelManager.addXPToTool(inventory.getItemInMainHand(), RandomUtil.getRandom(1, 4), player, event);
		}
		if(ItemManager.isShovel(inventory.getItemInMainHand())) {
			LevelManager.addXPToTool(inventory.getItemInMainHand(), RandomUtil.getRandom(1, 8), player, event);
		}
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof Player) {
			Player player = (Player) event.getDamager();
			ItemStack is = player.getInventory().getItemInMainHand();
			if(ItemManager.isSword(is)) {
				LevelManager.addXPToTool(is, RandomUtil.getRandom(1, 3), player, event);
			} else if(ItemManager.isAxe(is)) {
				LevelManager.addXPToTool(is, RandomUtil.getRandom(1, 2), player, event);
			}
		} else if(event.getDamager() instanceof Arrow) {
			Arrow arrow = (Arrow) event.getDamager();
			if(arrow.getShooter() instanceof Player) {
				Player player = (Player) arrow.getShooter();
				ItemStack is = player.getInventory().getItemInMainHand();
				if(ItemManager.isBow(is) || ItemManager.isCrossbow(is)) {
					LevelManager.addXPToTool(is, RandomUtil.getRandom(1, 5), player, event);
				}
			}
		}
		if(event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			PlayerInventory inventory = player.getInventory();
			if(ItemManager.isHelmet(inventory.getHelmet())) {
				LevelManager.addXPToTool(inventory.getHelmet(), RandomUtil.getRandom(1, 6), player, event);
			}
			if(ItemManager.isChestplate(inventory.getChestplate())) {
				LevelManager.addXPToTool(inventory.getChestplate(), RandomUtil.getRandom(1, 6), player, event);
			}
			if(ItemManager.isLeggings(inventory.getLeggings())) {
				LevelManager.addXPToTool(inventory.getLeggings(), RandomUtil.getRandom(1, 6), player, event);
			}
			if(ItemManager.isBoots(inventory.getBoots())) {
				LevelManager.addXPToTool(inventory.getBoots(), RandomUtil.getRandom(1, 6), player, event);
			}
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		ItemStack is = player.getInventory().getItemInMainHand();
		if(ItemManager.isPickaxe(is)) {
			LevelManager.addXPToTool(is, RandomUtil.getRandom(1, 2), player, event);
		}
		if(ItemManager.isShovel(is)) {
			LevelManager.addXPToTool(is, RandomUtil.getRandom(1, 2), player, event);
		}
		if(ItemManager.isAxe(is)) {
			LevelManager.addXPToTool(is, RandomUtil.getRandom(1, 2), player, event);
		}
	}
	
}
