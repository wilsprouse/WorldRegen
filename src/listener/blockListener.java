package listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
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
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) throws InterruptedException {
		Player p = e.getPlayer();
		
		ConfigurationSection regen = main.getConfig().getConfigurationSection("WorldRegen");
		
		Boolean regenBool = regen.getBoolean("regen");
		
		if (regenBool) {
			Location blockLoc = e.getBlock().getLocation();
			Material block = e.getBlock().getType();
			
			ConfigurationSection blackList = regen.getConfigurationSection("blacklist");
			boolean cont = true;
			for (String bl : blackList.getKeys(false)) {
				p.sendMessage(bl);
				if (Integer.parseInt(bl) == block.getId()) {
					cont = false;
				}
				
			}
			
			
			if (cont) { // Not sure why if it will ever matter, but .getId() is deprecated by SpigotMC
				p.sendMessage("Diamond. Ha!");
			
			
			e.getBlock().setType(Material.AIR);
			
			ConfigurationSection regenConfig = regen.getConfigurationSection("regenConfig");
			
			String timeStr = regenConfig.getString("time");
			Thread.sleep(Integer.parseInt(timeStr)*1000);

			e.setCancelled(true);
			blockLoc.getBlock().setType(block);
			//e.getBlock().
			} else {
				p.sendMessage("DENIIIIIED!");
			}
			
		}
		
	}
	
	
}
