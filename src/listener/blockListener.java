package listener;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import main.Main;

public class blockListener implements Listener {
	
	@SuppressWarnings("unused")
	private Main main;
	
	public blockListener(Main main) {
		this.main = main;
		Bukkit.getPluginManager().registerEvents(this, main);
		
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		ConfigurationSection regen = main.getConfig().getConfigurationSection("WorldRegen");
		
		Boolean regenBool = regen.getBoolean("regen");
		
		if (regenBool) {
			Block block = e.getBlock();
			
			e.getBlock().setType();
		}
		
		
		//p.sendMessage("Grats, you broke a block");
	}
	
	
}
