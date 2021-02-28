package de.Panischer.LevellingTools;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.Panischer.LevellingTools.commands.ClearOwnerCommand;
import de.Panischer.LevellingTools.commands.FixItemCommand;
import de.Panischer.LevellingTools.commands.GivePaperCommand;
import de.Panischer.LevellingTools.commands.ItemInfoCommand;
import de.Panischer.LevellingTools.commands.ReloadConfigCommand;
import de.Panischer.LevellingTools.commands.SetOwnerCommand;
import de.Panischer.LevellingTools.managers.AnvilManager;
import de.Panischer.LevellingTools.managers.EventManager;

public class Main extends JavaPlugin {

	public static Main plugin;
	
	public void onEnable() {
		plugin = this;
		PluginManager pluginmanager = getServer().getPluginManager();
		pluginmanager.registerEvents(new EventManager(), plugin);
		pluginmanager.registerEvents(new AnvilManager(), plugin);
		getCommand("givepaper").setExecutor(new GivePaperCommand());
		getCommand("configreload").setExecutor(new ReloadConfigCommand());
		getCommand("fix").setExecutor(new FixItemCommand());
		getCommand("iteminfo").setExecutor(new ItemInfoCommand());
		getCommand("setowner").setExecutor(new SetOwnerCommand());
		getCommand("clearowner").setExecutor(new ClearOwnerCommand());
		plugin.saveDefaultConfig();
	}
	
}
