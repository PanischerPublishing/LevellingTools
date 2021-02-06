package de.Panischer;
import org.bukkit.plugin.java.JavaPlugin;
public class Main extends JavaPlugin
{
	public static Main plugin;
	public void onEnable()
	{
		plugin = this;
		ConfigManager.makeConfig();
		getServer().getPluginManager().registerEvents(new ListenerManager(), this);
		getServer().getPluginManager().registerEvents(new AnvilManager(), this);
		getServer().getPluginManager().registerEvents(new ItemPickupManager(), this);
		getCommand("getlevel").setExecutor(new MagicPaperManager());
		getCommand("fix").setExecutor(new FixItemManager());
		getCommand("lwreload").setExecutor(new ConfigReloadManager());
		getCommand("iteminfo").setExecutor(new ItemInfoManager());
	}
}
