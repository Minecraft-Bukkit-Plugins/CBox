package me.franco28.Franco28;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	private cbox adminboxP = new cbox();

	List<String> config = getConfig().getStringList("Users");

    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Franco28 CBox Admin Plugins cargado con exito!");
        getCommand(adminboxP.cmd1).setExecutor(adminboxP);
        getCommand(adminboxP.cmd2).setExecutor(adminboxP);
        getCommand(adminboxP.cmd3).setExecutor(adminboxP);
        getCommand(adminboxP.cmd4).setExecutor(adminboxP);
        getCommand(adminboxP.cmd5).setExecutor(adminboxP);
        getCommand(adminboxP.cmd6).setExecutor(adminboxP);
        getCommand(adminboxP.cmd7).setExecutor(adminboxP);
        getConfig().set("Users", config);
        saveConfig();
    }

    public void onDisable() {
    	getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Franco28 CBox Admin Plugins desactivado!");
    	List<String> config = getConfig().getStringList("Users");
    	config.addAll(config);
        getConfig().set("Users", config);
        saveConfig();
    }
    
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

}
