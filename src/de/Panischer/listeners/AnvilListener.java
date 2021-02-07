package de.Panischer.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.Panischer.Main;
import de.Panischer.managers.ConfigManager;
public class AnvilListener implements Listener {
	
	@EventHandler
	public void onPrepareAnvil(PrepareAnvilEvent event) {
		if(ConfigManager.UseAnvilTransmission()) {
			if(event.getInventory().getItem(0) != null && event.getInventory().getItem(1) != null) {
				if(event.getInventory().getItem(1).getType().equals(Material.PAPER) && event.getInventory().getItem(1).hasItemMeta()) {
					List<String> lore = new ArrayList<String>();
					String materialName = event.getInventory().getItem(0).getType().toString();
					if(materialName.contains("AXE") || materialName.contains("SHOVEL") || materialName.contains("SWORD") || materialName.contains("CHESTPLATE") || materialName.contains("BOOTS") || materialName.contains("LEGGINGS") || materialName.contains("HELMET") || materialName.contains("BOW")) {
					ItemStack is = event.getInventory().getItem(0).clone();
					ItemMeta im = is.getItemMeta();
					if(ConfigManager.useOwnerBinding()) {
						lore.addAll(event.getInventory().getItem(1).getItemMeta().getLore());
						lore.add("§7- §c" + event.getView().getPlayer().getName() + " §7-");
					} else {
						lore.addAll(event.getInventory().getItem(1).getItemMeta().getLore());		
					}
					im.setLore(lore);
					is.setItemMeta(im);
					event.setResult(is);
					Main.plugin.getServer().getScheduler().runTask(Main.plugin, () -> event.getInventory().setRepairCost(1));
					}
				}
			}
		}
	}
}
