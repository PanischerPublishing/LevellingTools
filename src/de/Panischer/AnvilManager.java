package de.Panischer;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
public class AnvilManager implements Listener
{
	@EventHandler
	public void onPrepareAnvil(PrepareAnvilEvent event)
	{
		if(event.getInventory().getItem(0) != null && event.getInventory().getItem(1) != null)
		{
			if(event.getInventory().getItem(1).getType().equals(Material.PAPER) && event.getInventory().getItem(1).hasItemMeta())
			{
				String materialName = event.getInventory().getItem(0).getType().toString();
				if(materialName.contains("AXE") || materialName.contains("SHOVEL") || materialName.contains("SWORD") || materialName.contains("CHESTPLATE") || materialName.contains("BOOTS") || materialName.contains("LEGGINGS") || materialName.contains("HELMET") || materialName.contains("BOW"))
				{
				ItemStack is = event.getInventory().getItem(0).clone();
				ItemMeta im = is.getItemMeta();
				im.setLore(event.getInventory().getItem(1).getItemMeta().getLore());
				is.setItemMeta(im);
				event.setResult(is);
				Main.plugin.getServer().getScheduler().runTask(Main.plugin, () -> event.getInventory().setRepairCost(1));
				}
			}
		}
	}
}
