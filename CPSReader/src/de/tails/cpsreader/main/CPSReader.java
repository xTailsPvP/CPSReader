package de.tails.cpsreader.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.tails.cpsreader.listeners.PlayerInteractListener;

public class CPSReader extends JavaPlugin {

	private static CPSReader plugin;

	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
	}

	@Override
	public void onDisable() {
		plugin = null;
	}

	public static CPSReader getPlugin() {
		return plugin;
	}
}