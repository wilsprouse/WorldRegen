package listener;

import java.util.Timer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
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
			Location blockLoc = e.getBlock().getLocation();
			Material block = e.getBlock().getType();
			
			 e.getBlock().setType(Material.AIR);
			
			ConfigurationSection regenConfig = regen.getConfigurationSection("regenConfig");
			
			String timeStr = regenConfig.getString("time");
			
			int loopVal;
			Timer timer;
			timer = new Timer();
			for (loopVal = 0; loopVal < Integer.parseInt(timeStr); loopVal++) {
				
				p.sendMessage(Integer.toString(loopVal));
				
			}
			
			blockLoc.getBlock().setType(block);
			
		}
		
		
		//p.sendMessage("Grats, you broke a block");
	}
	
	
}
