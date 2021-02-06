package de.Panischer;

import de.Panischer.commands.ConfigReloadCommand;
import de.Panischer.commands.FixCommand;
import de.Panischer.commands.GetLevelCommand;
import de.Panischer.commands.ItemInfoCommand;
import de.Panischer.listeners.AnvilListener;
import de.Panischer.listeners.ItemPickupListener;
import de.Panischer.listeners.ListenerManager;
import de.Panischer.managers.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        ConfigManager.makeConfig();
        getServer().getPluginManager().registerEvents(new ListenerManager(), this);
        getServer().getPluginManager().registerEvents(new AnvilListener(), this);
        getServer().getPluginManager().registerEvents(new ItemPickupListener(), this);
        getCommand("getlevel").setExecutor(new GetLevelCommand());
        getCommand("fix").setExecutor(new FixCommand());
        getCommand("lwreload").setExecutor(new ConfigReloadCommand());
        getCommand("iteminfo").setExecutor(new ItemInfoCommand());
    }
}
