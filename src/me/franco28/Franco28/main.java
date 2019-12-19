package me.franco28.Franco28;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	private cbox adminboxP = new cbox();
	
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Franco28 CBox Admin Plugins cargado con exito!");
        getCommand(adminboxP.cmd1).setExecutor(adminboxP);
        getCommand(adminboxP.cmd2).setExecutor(adminboxP);
        getCommand(adminboxP.cmd3).setExecutor(adminboxP);
        getCommand(adminboxP.cmd4).setExecutor(adminboxP);
        getCommand(adminboxP.cmd5).setExecutor(adminboxP);
        getCommand(adminboxP.cmd6).setExecutor(adminboxP);
    }

    public void onDisable() {
    	getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Franco28 CBox Admin Plugins desactivado!");
    }
    
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

}
