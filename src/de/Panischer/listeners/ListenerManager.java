package de.Panischer.listeners;

import java.util.Random;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.Panischer.managers.BonusManager;
import de.Panischer.managers.ConfigManager;
import de.Panischer.managers.LevelManager;

public class ListenerManager implements Listener {
	
	@EventHandler
	public void onExperienceChange(PlayerExpChangeEvent event) {
		if(ConfigManager.useOwnerBinding()) {
			if(LevelManager.getOwner(event.getPlayer().getInventory().getItemInMainHand()).equals("§7- §c" + event.getPlayer().getName() + " §7-")) {
				String material = event.getPlayer().getInventory().getItemInMainHand().getType().toString();
				if(material.contains("AXE") || material.contains("SHOVEL") || material.contains("SWORD") || material.contains("BOW")) {
				LevelManager.addExperience(event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer(), new Random().nextInt(2) + 1);
				}
				if(event.getPlayer().getInventory().getHelmet() != null) {
					LevelManager.addExperience(event.getPlayer().getInventory().getHelmet(), event.getPlayer(), new Random().nextInt(2) + 1);
				}
				if(event.getPlayer().getInventory().getChestplate() != null) {
					LevelManager.addExperience(event.getPlayer().getInventory().getChestplate(), event.getPlayer(), new Random().nextInt(2) + 1);
				}
				if(event.getPlayer().getInventory().getLeggings() != null) {
					LevelManager.addExperience(event.getPlayer().getInventory().getLeggings(), event.getPlayer(), new Random().nextInt(2) + 1);
				}
				if(event.getPlayer().getInventory().getBoots() != null) {
					LevelManager.addExperience(event.getPlayer().getInventory().getBoots(), event.getPlayer(), new Random().nextInt(2) + 1);
				}
			}
		} else {
			String material = event.getPlayer().getInventory().getItemInMainHand().getType().toString();
			if(material.contains("AXE") || material.contains("SHOVEL") || material.contains("SWORD") || material.contains("BOW")) {
			LevelManager.addExperience(event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer(), new Random().nextInt(2) + 1);
			}
			if(event.getPlayer().getInventory().getHelmet() != null) {
				LevelManager.addExperience(event.getPlayer().getInventory().getHelmet(), event.getPlayer(), new Random().nextInt(2) + 1);
			}
			if(event.getPlayer().getInventory().getChestplate() != null) {
				LevelManager.addExperience(event.getPlayer().getInventory().getChestplate(), event.getPlayer(), new Random().nextInt(2) + 1);
			}
			if(event.getPlayer().getInventory().getLeggings() != null) {
				LevelManager.addExperience(event.getPlayer().getInventory().getLeggings(), event.getPlayer(), new Random().nextInt(2) + 1);
			}
			if(event.getPlayer().getInventory().getBoots() != null) {
				LevelManager.addExperience(event.getPlayer().getInventory().getBoots(), event.getPlayer(), new Random().nextInt(2) + 1);
			}
		}
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		//Sword / Axe
		if(event.getDamager() instanceof Player) {
			if(ConfigManager.useOwnerBinding()) {
				if(LevelManager.getOwner(((HumanEntity) event.getDamager()).getInventory().getItemInMainHand()).equals("§7- §c" + event.getDamager().getName() + " §7-")) {
					if(((Player) event.getDamager()).getInventory().getItemInMainHand().getType().toString().contains("SWORD")) {
						Player player = (Player) event.getDamager();
						LevelManager.addExperience(player.getInventory().getItemInMainHand(), player, 1);
						event.setDamage(event.getDamage() + BonusManager.getDamageBonus(player.getInventory().getItemInMainHand()));
					}
					if(((Player) event.getDamager()).getInventory().getItemInMainHand().getType().toString().contains("AXE") &!((Player) event.getDamager()).getInventory().getItemInMainHand().getType().toString().contains("PICKAXE")) {
						Player player = (Player) event.getDamager();
						LevelManager.addExperience(player.getInventory().getItemInMainHand(), player, 1);
						event.setDamage(event.getDamage() + BonusManager.getDamageBonus(player.getInventory().getItemInMainHand()));
					}
				}
			} else {
				if(((Player) event.getDamager()).getInventory().getItemInMainHand().getType().toString().contains("SWORD")) {
					Player player = (Player) event.getDamager();
					LevelManager.addExperience(player.getInventory().getItemInMainHand(), player, 1);
					event.setDamage(event.getDamage() + BonusManager.getDamageBonus(player.getInventory().getItemInMainHand()));
				}
				if(((Player) event.getDamager()).getInventory().getItemInMainHand().getType().toString().contains("AXE") &!((Player) event.getDamager()).getInventory().getItemInMainHand().getType().toString().contains("PICKAXE")) {
					Player player = (Player) event.getDamager();
					LevelManager.addExperience(player.getInventory().getItemInMainHand(), player, 1);
					event.setDamage(event.getDamage() + BonusManager.getDamageBonus(player.getInventory().getItemInMainHand()));
				}	
			}
		}
		//Bow / Crossbow
		if(event.getDamager() instanceof Arrow) {
			Arrow arrow = (Arrow) event.getDamager();
			if(arrow.getShooter() instanceof Player) {
					if(ConfigManager.useOwnerBinding()) {
						if(LevelManager.getOwner(((HumanEntity) arrow.getShooter()).getInventory().getItemInMainHand()).equals("§7- §c" + ((CommandSender) arrow.getShooter()).getName() + " §7-")) {
							Player shooter = (Player) arrow.getShooter();
							if(shooter.getInventory().getItemInMainHand().getType().toString().contains("BOW")) {
								LevelManager.addExperience(shooter.getInventory().getItemInMainHand(), shooter, 1);
								event.setDamage(event.getDamage() + BonusManager.getDamageBonus(shooter.getInventory().getItemInMainHand()));
							}
						}
					} else {
						Player shooter = (Player) arrow.getShooter();
						if(shooter.getInventory().getItemInMainHand().getType().toString().contains("BOW")) {
							LevelManager.addExperience(shooter.getInventory().getItemInMainHand(), shooter, 1);
							event.setDamage(event.getDamage() + BonusManager.getDamageBonus(shooter.getInventory().getItemInMainHand()));
						}
					}
			}
		}
		//Armor
		if(event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if(ConfigManager.useOwnerBinding()) {
				if(LevelManager.getOwner(player.getInventory().getItemInMainHand()).equals("§7- §c" + player.getName() + " §7-")) {
					double damageResistance = 0;
					if(player.getInventory().getHelmet() != null) {
						LevelManager.addExperience(player.getInventory().getHelmet(), player, 1);
						damageResistance = BonusManager.getResistanceBonus(player.getInventory().getHelmet());
					}
					if(player.getInventory().getChestplate() != null) {
						LevelManager.addExperience(player.getInventory().getChestplate(), player, 1);
						damageResistance = damageResistance + BonusManager.getResistanceBonus(player.getInventory().getChestplate());
					}
					if(player.getInventory().getLeggings() != null) {
						LevelManager.addExperience(player.getInventory().getLeggings(), player, 1);
						damageResistance = damageResistance + BonusManager.getResistanceBonus(player.getInventory().getLeggings());
					}
					if(player.getInventory().getBoots() != null) {
						LevelManager.addExperience(player.getInventory().getBoots(), player, 1);
						damageResistance = damageResistance + BonusManager.getResistanceBonus(player.getInventory().getBoots());
					}
					event.setDamage(event.getDamage() - damageResistance);
				}
			} else {
				double damageResistance = 0;
				if(player.getInventory().getHelmet() != null) {
					LevelManager.addExperience(player.getInventory().getHelmet(), player, 1);
					damageResistance = BonusManager.getResistanceBonus(player.getInventory().getHelmet());
				}
				if(player.getInventory().getChestplate() != null) {
					LevelManager.addExperience(player.getInventory().getChestplate(), player, 1);
					damageResistance = damageResistance + BonusManager.getResistanceBonus(player.getInventory().getChestplate());
				}
				if(player.getInventory().getLeggings() != null) {
					LevelManager.addExperience(player.getInventory().getLeggings(), player, 1);
					damageResistance = damageResistance + BonusManager.getResistanceBonus(player.getInventory().getLeggings());
				}
				if(player.getInventory().getBoots() != null) {
					LevelManager.addExperience(player.getInventory().getBoots(), player, 1);
					damageResistance = damageResistance + BonusManager.getResistanceBonus(player.getInventory().getBoots());
				}
				event.setDamage(event.getDamage() - damageResistance);	
			}
		}
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event)
	{
		//Armor
		if(event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			if(ConfigManager.useOwnerBinding()) {
				if(LevelManager.getOwner(player.getInventory().getItemInMainHand()).equals("§7- §c" + player.getName() + " §7-")) {
					double damageResistance = 0;
					if(player.getInventory().getHelmet() != null) {
						damageResistance = BonusManager.getResistanceBonus(player.getInventory().getHelmet());
					}
					if(player.getInventory().getChestplate() != null) {
						damageResistance = damageResistance + BonusManager.getResistanceBonus(player.getInventory().getChestplate());
					}
					if(player.getInventory().getLeggings() != null) {
						damageResistance = damageResistance + BonusManager.getResistanceBonus(player.getInventory().getLeggings());
					}
					if(player.getInventory().getBoots() != null) {
						damageResistance = damageResistance + BonusManager.getResistanceBonus(player.getInventory().getBoots());
					}
					event.setDamage(event.getDamage() - damageResistance);
				}
			} else {
				double damageResistance = 0;
				if(player.getInventory().getHelmet() != null) {
					damageResistance = BonusManager.getResistanceBonus(player.getInventory().getHelmet());
				}
				if(player.getInventory().getChestplate() != null) {
					damageResistance = damageResistance + BonusManager.getResistanceBonus(player.getInventory().getChestplate());
				}
				if(player.getInventory().getLeggings() != null) {
					damageResistance = damageResistance + BonusManager.getResistanceBonus(player.getInventory().getLeggings());
				}
				if(player.getInventory().getBoots() != null) {
					damageResistance = damageResistance + BonusManager.getResistanceBonus(player.getInventory().getBoots());
				}
				event.setDamage(event.getDamage() - damageResistance);
			}
		}
	}
	@EventHandler
	public void onBlockDamage(BlockDamageEvent event) {
		if(ConfigManager.useOwnerBinding()) {
			if(LevelManager.getOwner(event.getItemInHand()).equals("§7- §c" + event.getPlayer().getName() + " §7-")) {
				//Pickaxe
				if(event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("PICKAXE")) {
					if(LevelManager.getLevels(event.getItemInHand()) > 0) {
							event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 10, BonusManager.getHasteBonus(event.getItemInHand())));
					}
				}
				//Shovel
				if(event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("SHOVEL")) {
					if(LevelManager.getLevels(event.getItemInHand()) > 0) {
							event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 10, BonusManager.getHasteBonus(event.getItemInHand())));
					}
				}
				//Axe
				if(event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("AXE") &!event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("PICKAXE")) {
					if(LevelManager.getLevels(event.getItemInHand()) > 0) {
							event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 10, BonusManager.getHasteBonus(event.getItemInHand())));
					}
				}
			}
		} else {
			//Pickaxe
			if(event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("PICKAXE")) {
				if(LevelManager.getLevels(event.getItemInHand()) > 0) {
						event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 10, BonusManager.getHasteBonus(event.getItemInHand())));
				}
			}
			//Shovel
			if(event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("SHOVEL")) {
				if(LevelManager.getLevels(event.getItemInHand()) > 0) {
						event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 10, BonusManager.getHasteBonus(event.getItemInHand())));
				}
			}
			//Axe
			if(event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("AXE") &!event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("PICKAXE")) {
				if(LevelManager.getLevels(event.getItemInHand()) > 0) {
						event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 10, BonusManager.getHasteBonus(event.getItemInHand())));
				}
			}
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if(ConfigManager.useOwnerBinding()) {
			if(LevelManager.getOwner(event.getPlayer().getInventory().getItemInMainHand()).equals("§7- §c" + event.getPlayer().getName() + " §7-")) {
			//Pickaxe
			if(event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("PICKAXE")) {
				LevelManager.addExperience(event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer(), 1);
			}
			//Shovel
			if(event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("SHOVEL")) {
				LevelManager.addExperience(event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer(), 1);
			}
			//Axe
			if(event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("AXE") &! event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("PICKAXE")) {
				LevelManager.addExperience(event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer(), 1);
			}
			}
		} else {
			//Pickaxe
			if(event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("PICKAXE")) {
				LevelManager.addExperience(event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer(), 1);
			}
			//Shovel
			if(event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("SHOVEL")) {
				LevelManager.addExperience(event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer(), 1);
			}
			//Axe
			if(event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("AXE") &! event.getPlayer().getInventory().getItemInMainHand().getType().toString().contains("PICKAXE")) {
				LevelManager.addExperience(event.getPlayer().getInventory().getItemInMainHand(), event.getPlayer(), 1);
			}
		}
	}
}
