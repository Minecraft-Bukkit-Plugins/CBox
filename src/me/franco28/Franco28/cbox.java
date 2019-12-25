package me.franco28.Franco28;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import net.md_5.bungee.api.ChatColor;

public class cbox implements CommandExecutor {

	public String cmd1 = "kill";
	public String cmd2 = "health";
	public String cmd3 = "food";
	public String cmd4 = "fly";
	public String cmd5 = "cchat";
	public String cmd6 = "citems";
	public String cmd7 = "thunder";
	public Player player = null;
		
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	     	
		if (sender instanceof Player){

        		Player player = (Player) sender;

  if (cmd.getName().equalsIgnoreCase(cmd1)) {
	  if (player.hasPermission(cmd1) && sender.hasPermission(cmd1)) {
		   if (args.length == 0) {
	       	   player.sendMessage(ChatColor.RED + "Por favor seleccione alg�n jugador");
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
	       	   player.sendMessage(ChatColor.RED + "Por favor seleccione alg�n jugador");
			return true;
			}
		   if (args.length == 1) {
			   if (pl == null) {
	       	      player.sendMessage(ChatColor.RED + "Jugador no encontrado");
			return false;
			} else {
    			  double health = pl.getHealth(); 
				if (health != 20.0) {
                	if(player.equals(pl)) {
    				    player.sendMessage(ChatColor.BLUE + "Te llenaste tu barra de vida!");
                        player.setHealth(20.0);
                	} else {
                   	player.sendMessage(ChatColor.BLUE + "Le llenaste la barra de vida a " + pl.getName());
				    pl.sendMessage(ChatColor.BLUE + "El jugador " + player.getName() + " te llen� la barra de vida!");
				    pl.setHealth(20.0);
                	}
                	} else {
                    	if(player.equals(pl)) {
    				    player.sendMessage(ChatColor.GREEN + "Tu barra de vida ya esta llena!");
				    } else {
    				    pl.sendMessage(ChatColor.GREEN + "Tu barra de vida ya esta llena!");
				    }
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
	       	   player.sendMessage(ChatColor.RED + "Por favor seleccione alg�n jugador");
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
                	if(player.equals(pl)) {
    				    player.sendMessage(ChatColor.BLUE + "Te llenaste la barra de tu comida!");
                        player.setFoodLevel(20);                	
                	} else {
                       	player.sendMessage(ChatColor.BLUE + "Le llenaste la barra de comida a " + pl.getName());
    				    pl.sendMessage(ChatColor.BLUE + "El jugador " + player.getName() + " te llen� la barra de comida!");
                        pl.setFoodLevel(20);
                	}

				    } else {
	                	if(player.equals(pl)) {
		                	player.sendMessage(ChatColor.GREEN + "Tu barra de comida ya esta llena!");
	                	} else {
		                	pl.sendMessage(ChatColor.GREEN + "Tu barra de comida ya esta llena!");
	                		
	                	}			          	
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
       	   player.sendMessage(ChatColor.RED + "Por favor seleccione alg�n jugador");
		return true;
		}
	   if (args.length == 1) {
		   Player pl = Bukkit.getServer().getPlayer(args[0]);
		   if (pl == null) {
       	      player.sendMessage(ChatColor.RED + "Jugador no encontrado");
		return false;
		} else {
			if (pl.getAllowFlight() == false) {
            	if(player.equals(pl)) {
    			    player.sendMessage(ChatColor.RED + "Ya puedes volar!");
    			    player.setAllowFlight(true);                	
            	} else {
                	player.sendMessage(ChatColor.BLUE + "El jugador " + pl.getName() + " ahora puede volar!");
    			    pl.sendMessage(ChatColor.GREEN + "El jugador " + player.getName() + " te habilit� poder volar!");
    			    pl.setAllowFlight(true);            		
            	}
			    
			    } else {
	            	if(player.equals(pl)) {
					      player.sendMessage(ChatColor.RED + "Ya no puedes volar!");
					      player.setAllowFlight(false);
	            	} else {
	  			      player.sendMessage(ChatColor.BLUE + "El jugador " + pl.getName() + " ya no puede volar!");
				      pl.sendMessage(ChatColor.RED + "Ya no puedes volar!");
				      pl.setAllowFlight(false);
	            	}
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

      Bukkit.broadcastMessage(ChatColor.GOLD + "|------------------------+==========+-|");
      Bukkit.broadcastMessage(ChatColor.BOLD + " El Chat fue borrado por " + sender.getName() + " ");
      Bukkit.broadcastMessage(ChatColor.GOLD + "|------------------------+==========+-|");
  }
  
  if (cmd.getName().equalsIgnoreCase(cmd6)) {
      if (sender instanceof Player && !sender.hasPermission(cmd6)) {
         sender.sendMessage("No tienes permisos para ejecutar este comando.");
         return true;
      }
      
      Bukkit.broadcastMessage(ChatColor.GOLD + "|--------------------------+==========+--|");
      Bukkit.broadcastMessage(ChatColor.BOLD + " Los items del suelo fueron borrados      ");
      Bukkit.broadcastMessage(ChatColor.GOLD + "|--------------------------+==========+--|");
                  
      World world = Bukkit.getWorld("Mundo");
      World worldnether = Bukkit.getWorld("Mundo_nether");
      World worldend = Bukkit.getWorld("Mundo_the_end");
      
      List<Entity> entList = world.getEntities();
      List<Entity> entList_nether = worldnether.getEntities();
      List<Entity> entList_end = worldend.getEntities();
      
      for(Entity current : entList){
          if (current instanceof Item){
        	  current.remove();
          } 
      }
      
      for(Entity current : entList_nether){
          if (current instanceof Item){
        	  current.remove();
          } 
      }
      
      for(Entity current : entList_end){
          if (current instanceof Item){
        	  current.remove();
          } 
      }
  }
  
  if (cmd.getName().equalsIgnoreCase(cmd7)) {
	  if (player.hasPermission(cmd7) && sender.hasPermission(cmd7)) {
		   if (args.length == 0) {
	       	   player.sendMessage(ChatColor.RED + "Por favor seleccione alg�n jugador");
			return true;
			}
		   if (args.length == 1) {
			   Player pl = Bukkit.getServer().getPlayer(args[0]);
			   if (pl == null) {
	       	      player.sendMessage(ChatColor.RED + "Jugador no encontrado");
			return false;
			} else {
            	if(player.equals(pl)) {
			          player.getWorld().strikeLightningEffect(player.getLocation());
                      player.setHealth(6);
			          player.sendMessage(ChatColor.DARK_BLUE + "Los dioses se han enojado! Mejor escondete!"); 
            	} else {
			          pl.getWorld().strikeLightningEffect(pl.getLocation());
                      pl.setHealth(6);
			          pl.sendMessage(ChatColor.DARK_BLUE + "Los dioses se han enojado! Mejor escondete!"); 
            	}                    
			       }
			}   
		 	 } else {
		         sender.sendMessage(ChatColor.RED + "No tienes permisos para ejecutar este comando.");
		 	 }
  }
  
	    }
		return false;
	}
	
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerD(EntityDamageByEntityEvent event) {
        if(((EntityDamageByEntityEvent) event).getDamager() instanceof LightningStrike){
        double finalDamage = (20) - event.getDamage();
        event.setDamage(finalDamage);
        }
	}
}
