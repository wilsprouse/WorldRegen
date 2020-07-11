package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import main.Main;

public class setWorldRegenCommand implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main main;
	
	public setWorldRegenCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String args[]) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("Must be a player!");
			return true;
		}
		
		if (args.length != 0) {
			sender.sendMessage("Try /setworldregen");
			return true;
		}
		
		//sender.sendMessage("JUICY!");
		ConfigurationSection regen = main.getConfig().getConfigurationSection("WorldRegen");
		
		
		regen.set("regen", true);
		//sender.sendMessage("JUICY2!");
		
		sender.sendMessage("Done");
		main.saveConfig();
		

		return true;
	}
}
