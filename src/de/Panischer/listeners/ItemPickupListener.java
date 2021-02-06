package de.Panischer.listeners;
import java.util.ArrayList;
import java.util.List;

import de.Panischer.managers.ConfigManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
@SuppressWarnings("deprecation")
public class ItemPickupListener implements Listener
{
	@EventHandler
	public void onItemPickup(PlayerPickupItemEvent event)
	{
		List<String> lore = new ArrayList<String>();
		ItemStack is = event.getItem().getItemStack();
		String materialName = is.getType().toString();
		if(materialName.contains("AXE") || materialName.contains("SHOVEL") || materialName.contains("SWORD") || materialName.contains("CHESTPLATE") || materialName.contains("BOOTS") || materialName.contains("LEGGINGS") || materialName.contains("HELMET") || materialName.contains("BOW"))
		{
		if(!is.hasItemMeta())
		{
		ItemMeta im = is.getItemMeta();
		lore.add("");
		lore.add("§7Level §f1");
		lore.add("§7XP §f0 §7/ §f10");
		if(ConfigManager.useOwnerBinding())
		{
		lore.add("§7- §c" + event.getPlayer().getName() + " §7-");
		}
		im.setLore(lore);
		is.setItemMeta(im);
		}
		}
	}
}
