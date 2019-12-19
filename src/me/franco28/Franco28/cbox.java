package me.franco28.Franco28;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

public class cbox implements CommandExecutor {

	public String cmd1 = "kill";
	public String cmd2 = "health";
	public String cmd3 = "food";
	public String cmd4 = "fly";
	public String cmd5 = "cchat";
	public String cmd6 = "citems";
	public Player player = null;

	public void errorplayer()
	{
        	player.sendMessage(ChatColor.RED + "Jugador no encontrado");
	}
	
	public void selectplayer()
	{
      	player.sendMessage(ChatColor.RED + "Por favor seleccione algún jugador");
	}
	
	public void returnplayer(String[] args)
	{
    	Player pl = (Player) Bukkit.getServer().getPlayer(args[0]);
        if (pl == null) {
        	errorplayer();
        }  
	}
		
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	     	
		if (sender instanceof Player){

        		player = (Player) sender;

  if (cmd.getName().equalsIgnoreCase(cmd1)) {
	  if (player.hasPermission(cmd1) && sender.hasPermission(cmd1)) {
		   if (args.length == 0) {
	       	   player.sendMessage(ChatColor.RED + "Por favor seleccione algún jugador");
			return true;
			}
		   if (args.length == 1) {
			   Player pl = Bukkit.getServer().getPlayer(args[0]);
			   if (pl == null) {
	       	      player.sendMessage(ChatColor.RED + "Jugador no encontrado");
			return false;
			} else {
	            if (player.equals(pl)) {           	    		          	
		               player.setHealth(0.0D);
	    	           player.sendMessage(ChatColor.RED + "Te mataste vos mismo!");    	               
		            } else {
		            	pl.setHealth(0.0D);    	               
                     	player.sendMessage(ChatColor.RED + "El jugador " + pl.getName() + " ah muerto por tu culpa");
		            }
			       }
			}   
		 	 } else {
		         sender.sendMessage(ChatColor.RED + "No tienes permisos para ejecutar este comando.");
		 	 }   
  }
    	        
  if (cmd.getName().equalsIgnoreCase(cmd2)) {
	  if (player.hasPermission(cmd2) && sender.hasPermission(cmd2)) {

		   Player pl = Bukkit.getServer().getPlayer(args[0]);

		   if (args.length == 0) {
	       	   player.sendMessage(ChatColor.RED + "Por favor seleccione algún jugador");
			return true;
			}
		   if (args.length == 1) {
			   if (pl == null) {
	       	      player.sendMessage(ChatColor.RED + "Jugador no encontrado");
			return false;
			} else {
    			  double health = pl.getHealth(); 
				if (health != 20.0) {
				    pl.sendMessage(ChatColor.GREEN + "El jugador " + player.getName() + " te llenó la barra de vida!");
				    player.sendMessage(ChatColor.GREEN + "El jugador " + pl.getName() + " recibió vida de tu parte!");
				    pl.setHealth(20.0);
                    player.setHealth(20.0);
                    } else {
    				    pl.sendMessage(ChatColor.GREEN + "Tu barra de vida ya esta llena!");
			          	player.sendMessage(ChatColor.GREEN + "Tu barra de vida ya esta llena!");
				    }
			       }
			}   
		 	 } else {
		         sender.sendMessage(ChatColor.RED + "No tienes permisos para ejecutar este comando.");
		 	 }   
  }
    	        
  if (cmd.getName().equalsIgnoreCase(cmd3)) {
	  if (player.hasPermission(cmd3) && sender.hasPermission(cmd3)) {
		   if (args.length == 0) {
	       	   player.sendMessage(ChatColor.RED + "Por favor seleccione algún jugador");
			return true;
			}
		   if (args.length == 1) {
			   Player pl = Bukkit.getServer().getPlayer(args[0]);
			   if (pl == null) {
	       	      player.sendMessage(ChatColor.RED + "Jugador no encontrado");
			return false;
			} else {
  			  double food = pl.getFoodLevel(); 
				if (food != 20.0) {
				    pl.sendMessage(ChatColor.GREEN + "El jugador " + player.getName() + " te llenó la barra de comida!");
                    pl.setFoodLevel(20);
                    player.setFoodLevel(20);
				    } else {
			          	player.sendMessage(ChatColor.GREEN + "Tu barra de comida ya esta llena!");
			          	pl.sendMessage(ChatColor.GREEN + "Tu barra de comida ya esta llena!");
				    }
			       }
			}   
		 	 } else {
		         sender.sendMessage(ChatColor.RED + "No tienes permisos para ejecutar este comando.");
		 	 }
  }      
    	            
  if (cmd.getName().equalsIgnoreCase(cmd4)) { 
	  if (player.hasPermission(cmd4) && sender.hasPermission(cmd4)) {
	   if (args.length == 0) {
       	   player.sendMessage(ChatColor.RED + "Por favor seleccione algún jugador");
		return true;
		}
	   if (args.length == 1) {
		   Player pl = Bukkit.getServer().getPlayer(args[0]);
		   if (pl == null) {
       	      player.sendMessage(ChatColor.RED + "Jugador no encontrado");
		return false;
		} else {
			if (pl.getAllowFlight() == false) {
			    player.sendMessage(ChatColor.BLUE + "El jugador " + pl.getName() + " ahora puede volar!");
			    pl.sendMessage(ChatColor.GREEN + "El jugador " + player.getName() + " te habilitó poder volar!");
			    pl.sendMessage(ChatColor.RED + "Ya puedes volar!");
			    pl.setAllowFlight(true);
			    } else {
			      player.sendMessage(ChatColor.BLUE + "El jugador " + pl.getName() + " ya no puede volar!");
			      pl.sendMessage(ChatColor.RED + "Ya no puedes volar!");
			      pl.setAllowFlight(false);
			    }
		       }
		}   
	 	 } else {
	         sender.sendMessage(ChatColor.RED + "No tienes permisos para ejecutar este comando.");
	 	 }
  }
  
  if (cmd.getName().equalsIgnoreCase(cmd5)) {
      if (sender instanceof Player && !sender.hasPermission("cchat.clear")) {
         sender.sendMessage("No tienes permisos para ejecutar este comando.");
         return true;
      }

      for (int i = 0; i < 100; i++) {
          Bukkit.broadcastMessage("");
      }                

      Bukkit.broadcastMessage(ChatColor.GOLD + "|------------------------+=========+-|");
      Bukkit.broadcastMessage(ChatColor.BOLD + " El Chat fue borrado por " + sender.getName() + " ");
      Bukkit.broadcastMessage(ChatColor.GOLD + "|------------------------+=========+-|");
  }
  
  if (cmd.getName().equalsIgnoreCase(cmd6)) {
      if (sender instanceof Player && !sender.hasPermission(cmd6)) {
         sender.sendMessage("No tienes permisos para ejecutar este comando.");
         return true;
      }
      
      Bukkit.broadcastMessage(ChatColor.GOLD + "|---------------------------+=========+--|");
      Bukkit.broadcastMessage(ChatColor.BOLD + " Los items del suelo fueron borrados      ");
      Bukkit.broadcastMessage(ChatColor.GOLD + "|---------------------------+=========+--|");
                  
      World world = Bukkit.getWorld("Mundo");

      List<Entity> entList = world.getEntities();

      for(Entity current : entList){
          if (current instanceof Item){
        	  current.remove();
          } 
      }
  }
	    }
		return false;
	}
}
