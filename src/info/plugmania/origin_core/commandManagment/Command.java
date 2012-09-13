package info.plugmania.origin_core.commandManagment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

import info.plugmania.origin_core.Origin_Core;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public abstract class Command {
	Origin_Core plugin;
	
	public Command(Origin_Core instance) {
		this.plugin = instance;
	}

	public String getName() {
		return this.getClass().getSimpleName();
	}
	
	public abstract void onPlayerCommand(Player sender,String command,String[] args);
	public abstract void onServerCommand(Server sender,String command,String[] args);
	
	
	
	////////Used for saving any config options attached to this command
	
	public ConfigurationSection save(ConfigurationSection c){
		for(Field f:this.getClass().getFields()){
			if(f.isAnnotationPresent(config.class)){
				try{
					
				if(f.get(this) instanceof Location){
	c.set(f.getName() + ".world", ((Location)f.get(this)).getWorld().getName());				
	c.set(f.getName() + ".x", ((Location)f.get(this)).getX());
	c.set(f.getName() + ".y", ((Location)f.get(this)).getY());
	c.set(f.getName() + ".z", ((Location)f.get(this)).getZ());
				}else{
	c.set(f.getName(), f.get(this));
				}
				
				}catch(Exception e){
					
				}
			}
			}
		return c;
	}

	public void load(ConfigurationSection c){
		for(Field f:this.getClass().getFields()){
			if(f.isAnnotationPresent(config.class)&&c.isSet(f.getName())){
				try{
					
					if(f.get(this) instanceof String){
						f.set(this, c.getString(f.getName()));
					}else if(f.get(this) instanceof Long){
						f.set(this, c.getLong(f.getName()));
					}else if(f.get(this) instanceof Integer){
						f.set(this, c.getInt(f.getName()));
					}else if(f.get(this) instanceof Double){
						f.set(this, c.getDouble(f.getName()));
					}else if(f.get(this) instanceof Boolean){
						f.set(this, c.getBoolean(f.getName()));
					}else if(f.getType()==Location.class){
						f.set(this, new Location(
								plugin.getServer().getWorld(c.getString(f.getName() + ".world")),
								c.getDouble(f.getName() + ".x"),
								c.getDouble(f.getName() + ".y"),
								c.getDouble(f.getName() + ".z")
								));
					}
				}catch(Exception e){
					
				}
			}
			}

	}
	
	@Retention(RetentionPolicy.RUNTIME) public @interface config{
	}

}
