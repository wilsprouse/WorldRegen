package main;

import org.bukkit.Bukkit;
//import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import commands.setWorldRegenCommand;
import listener.blockListener;
import utils.Utils;

public class Main extends JavaPlugin {
	
	public final String PREFIX = Utils.chat("&4[&aWorld Regen&4] ");
	
	public void onEnable() {
		
		Bukkit.getPluginCommand("setworldregen").setExecutor(new setWorldRegenCommand(this));
		
		new blockListener(this);
		
		this.saveDefaultConfig();
		
	}

}