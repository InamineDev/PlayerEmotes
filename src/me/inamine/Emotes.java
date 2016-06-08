package me.inamine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Emotes extends JavaPlugin implements Listener {
	
	ArrayList<Player> cooldown = new ArrayList<Player>();
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		FileManager.checkFiles();
		makeList();
		PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
	}
	
	private static Emotes inst;
	
	public Emotes(){
		inst = this;
	}
	
	public static Emotes getInst() {
		return inst;
	}

	public void soundEffect(Player player, Player target) {
		Boolean sounds = this.getConfig().getBoolean("use-sound");
		if (sounds) {
			if (target == null) {
				String sound = this.getConfig().getString("sound-effect");
				Location loc = player.getLocation();
				try {
					Sound so = (Sound) Sound.valueOf(sound);
					player.playSound(loc, so, 10, 2);
					return;
				}
				
				catch (IllegalArgumentException e) {
					Bukkit.getLogger().log(Level.WARNING, "[Player Emotes] Error with sound-effect in config.yml");
					return;
				}
			}

			if (target != null) {
				String sound = this.getConfig().getString("sound-effect");
				Location loc = player.getLocation();
				Location loctar = target.getLocation();
				try {
					Sound so = (Sound) Sound.valueOf(sound);
					player.playSound(loc, so, 10, 2);
					target.playSound(loctar, so, 10, 2);
					return;
				}
				
				catch (IllegalArgumentException e) {
					Bukkit.getLogger().log(Level.WARNING, "[Player Emotes] Error with sound-effect in config.yml");
					return;
				}
			}
			
		}
		if (!sounds) {
			return;
		}
	}
	
	@SuppressWarnings("deprecation")
	public void particleEffect(Player player, Player target) {
		Boolean parts = this.getConfig().getBoolean("use-particles");
		Collection<? extends Player> players = Bukkit.getOnlinePlayers();
		if (parts) {
			if (target == null) {
				try {
					Effect eff = Effect.CRIT;
					for (Player p : players) {
						Location loc = player.getLocation();
						loc.add(0.2, 0.1, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						
						return;
						
					}
					
				}
				
				catch ( NoSuchFieldError e) {
					Effect eff = Effect.SMOKE;
					for (Player p : players) {
						Location loc = player.getLocation();
						loc.add(0.2, 0.1, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						
						return;
					}
				}
			}

			if (target != null) {
				Location loc = player.getLocation();
				Location loctar = target.getLocation();
				try {
					Effect eff = Effect.CRIT;
					for (Player p : players) {
						loc.add(0.2, 0.1, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						
						loctar.add(0.2, 0.1, 0.2);
						p.playEffect(loc, eff, 10);
						loctar.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loctar.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loctar.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loctar.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loctar.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loctar.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loctar.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						
						return;
						
					}
					
				}
				
				catch ( NoSuchFieldError e) {
					Effect eff = Effect.SMOKE;

					for (Player p : players) {
						loc.add(0.2, 0.1, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loc.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						
						loctar.add(0.2, 0.1, 0.2);
						p.playEffect(loc, eff, 10);
						loctar.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loctar.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loctar.add(0.2, 0.125, 0.2);
						p.playEffect(loc, eff, 10);
						loctar.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loctar.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loctar.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						loctar.add(-0.2, 0.125, -0.2);
						p.playEffect(loc, eff, 10);
						
						return;
						
					}
					
					
				}
			}
			
		}
		
		if (!parts) {
			return;
		}
	
	}
	
	public List<String> makeList() {
		List<String> emotesList = new ArrayList<String>();
		emotesList.add("highfive");
		emotesList.add("hug");
		emotesList.add("flirt");
		emotesList.add("dance");
		emotesList.add("smile");
		emotesList.add("raspberry");
		emotesList.add("thumbsup");
		emotesList.add("applaud");
		emotesList.add("bark");
		emotesList.add("beg");
		emotesList.add("bow");
		emotesList.add("cheer");
		emotesList.add("cry");
		emotesList.add("eat");
		emotesList.add("greet");
		emotesList.add("poke");
		emotesList.add("kiss");
		emotesList.add("slap");
		emotesList.add("wink");
		emotesList.add("laugh");
		registerCustom(emotesList);
		return emotesList;
	}
	
	public void registerCustom(List<String> l) {
		if (!FileManager.getCustom().getStringList("custom-emotes").isEmpty()) {
			List<String> custom = FileManager.getCustom().getStringList("custom-emotes");
			for (String ce : custom) {
				l.add(ce);
			}
			return;
		}
		else {
			return;
		}
	}
	
	public void listEmotes(List<String> emotesList, Player player) {
		StringBuilder builder = new StringBuilder();
		for (String e : emotesList) {
			if (player.hasPermission("emotes.use." + e))
			builder.append("&6" + e + "&e, ");
		}
		String emotes = builder.toString();
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', emotes));
	}
	
	public void emote(String cmd, Player player, String[] args) {
		if ( !this.getConfig().getBoolean("only-see-own") ) {
			if ((player.hasPermission("emotes.use." + cmd)) && (args.length == 0) && (!cooldown.contains(player))) {
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (p.hasPermission("emotes.hear")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("self-" + cmd)
						.replace("%player%", player.getDisplayName())));
					}
				}
				addCooldown(player);
				soundEffect(player, null);
				particleEffect(player, null);
				return;
			}
			
			if ((player.hasPermission("emotes.use." + cmd)) && (args.length == 1) && (!cooldown.contains(player))) {
				Player target = player.getServer().getPlayer(args[0]);
				if (target != null) {
					for (Player p : Bukkit.getOnlinePlayers()) {
						if (p.hasPermission("emotes.hear")) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("other-" + cmd)
									.replace("%player%", player.getDisplayName())
									.replace("%target%", target.getDisplayName())));
						}
					}
					addCooldown(player);
					soundEffect(player, target);
					particleEffect(player, target);
					return;
				}
				else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("not-online")
							.replace("%target%", args[0])));
					return;
				}
				
			}
			
			if ((player.hasPermission("emotes.use." + cmd)) && (args.length > 1)) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("bad-usage")));
				return;
			}

			if (cooldown.contains(player)) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("cooldown-message")));
				return;
			}
			
			else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("noPermissions")));
				return;
			}
		}
		if ( this.getConfig().getBoolean("only-see-own") ) {
			if ((player.hasPermission("emotes.use." + cmd)) && (args.length == 0) && (!cooldown.contains(player))) {
				if (player.hasPermission("emotes.hear")) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("self-" + cmd)
							.replace("%player%", player.getDisplayName())));
				}
				addCooldown(player);
				soundEffect(player, null);
				particleEffect(player, null);
				return;
			}
			
			if ((player.hasPermission("emotes.use." + cmd)) && (args.length == 1) && (!cooldown.contains(player))) {
				Player target = player.getServer().getPlayer(args[0]);
				if (target != null) {
					if ((this.getConfig().getBoolean("target-see-emote")) && (!player.getDisplayName().equals(target.getDisplayName()))) {
						if (target.hasPermission("emotes.hear")) {
							target.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("other-" + cmd)
									.replace("%player%", player.getDisplayName())
									.replace("%target%", target.getDisplayName())));
						}
					}
					
					if (player.hasPermission("emotes.hear")) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("other-" + cmd)
								.replace("%player%", player.getDisplayName())
								.replace("%target%", target.getDisplayName())));
					}
					
					addCooldown(player);
					soundEffect(player, target);
					particleEffect(player, target);
					return;
				}
				else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("not-online")
							.replace("%target%", args[0])));
					return;
				}
				
			}
			
			if ((player.hasPermission("emotes.use." + cmd)) && (args.length > 1)) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("bad-usage")));
				return;
			}
			
			if (cooldown.contains(player)) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("cooldown-message")));
				return;
			}
			
			else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("noPermissions")));
				return;
			}
		}
		
	}
	
	public void customGuiEmote(Player player, String emote) {
		List<String> customEmotes = FileManager.getCustom().getStringList("custom-emotes");
		if (customEmotes.contains(emote)) {
			String perm = FileManager.getCustom().getString("custom." + emote + ".permission");
			if ( !this.getConfig().getBoolean("only-see-own") && (player.hasPermission(perm)) && (!cooldown.contains(player)) ) {
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (p.hasPermission("emotes.hear")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getCustom().getString("custom." + emote + ".self-" + emote)
								.replace("%player%", player.getDisplayName())));
					}
				}
				
				addCooldown(player);
				soundEffect(player, null);
				particleEffect(player, null);
				return;
			}
			
			if ( this.getConfig().getBoolean("only-see-own") && (player.hasPermission(perm)) && (!cooldown.contains(player)) ) {
				if (player.hasPermission("emotes.hear")) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getCustom().getString("custom." + emote + ".self-" + emote)
							.replace("%player%", player.getDisplayName())));
				}
						
				addCooldown(player);
				soundEffect(player, null);
				particleEffect(player, null);
				return;
			}
			
			if (cooldown.contains(player)) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("cooldown-message")));
				return;
			}
			
			else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("noPermissions")));
				return;
			}
			
		}
		
		if (!customEmotes.contains(emote)) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getCustom().getString("custom.not-emote")));
			return;
		}
		
	}
	
	public void guiEmote(Player player, String emote) {
		String perm = ("emotes.use." + emote);
		if (!this.getConfig().getBoolean("only-see-own") && (player.hasPermission(perm)) && (!cooldown.contains(player))) {
			for (Player p : Bukkit.getOnlinePlayers()) {
				if (p.hasPermission("emotes.hear")) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("self-" + emote)
							.replace("%player%", player.getDisplayName())));
				}
			}
			addCooldown(player);
			soundEffect(player, null);
			particleEffect(player, null);
			return;
		}
		
		if (this.getConfig().getBoolean("only-see-own") && (player.hasPermission(perm)) && (!cooldown.contains(player))) {
			if (player.hasPermission("emotes.hear")) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("self-" + emote)
						.replace("%player%", player.getDisplayName())));
			}
			addCooldown(player);
			soundEffect(player, null);
			particleEffect(player, null);
			return;
		}
		
		if (cooldown.contains(player)) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("cooldown-message")));
			return;
		}
		else {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("noPermissions")));
			return;
		}
	}
	
	public void customEmote(Player player, String[] args) {
		if (args.length > 0) {
			String emote = args[0];
			List<String> customEmotes = FileManager.getCustom().getStringList("custom-emotes");
			if (customEmotes.contains(emote)) {
				String perm = FileManager.getCustom().getString("custom." + emote + ".permission");
				if ( !this.getConfig().getBoolean("only-see-own") ) {
					if ((player.hasPermission(perm)) && (args.length == 1) && (!cooldown.contains(player))) {
						for (Player p : Bukkit.getOnlinePlayers()) {
							if (p.hasPermission("emotes.hear")) {
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getCustom().getString("custom." + emote + ".self-" + emote)
										.replace("%player%", player.getDisplayName())));
							}
						}
						addCooldown(player);
						soundEffect(player, null);
						particleEffect(player, null);
						return;
					}
				
				
					if ((player.hasPermission(perm)) && (args.length == 2) && (!cooldown.contains(player))) {
						Player target = player.getServer().getPlayer(args[1]);
						if (target != null) {
							for (Player p : Bukkit.getOnlinePlayers()) {
								if (p.hasPermission("emotes.hear")) {
									p.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getCustom().getString("custom." + emote + ".other-" + emote)
											.replace("%player%", player.getDisplayName())
											.replace("%target%", target.getDisplayName())));
								}
							}
							addCooldown(player);
							soundEffect(player, target);
							particleEffect(player, target);
							return;
						}
						else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("not-online")
									.replace("%target%", args[1])));
							return;
						}
					}
				
					if ((player.hasPermission(perm)) && (args.length > 2)) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getCustom().getString("custom.bad-usage")));
						return;
					}
	
					if (cooldown.contains(player)) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("cooldown-message")));
						return;
					}
					
					else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("noPermissions")));
						return;
					}
				}
				
				if ( this.getConfig().getBoolean("only-see-own") ) {
					if ((player.hasPermission(perm)) && (args.length == 1) && (!cooldown.contains(player))) {
						if (player.hasPermission("emotes.hear")) {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getCustom().getString("custom." + emote + ".self-" + emote)
									.replace("%player%", player.getDisplayName())));
						}
						addCooldown(player);
						soundEffect(player, null);
						particleEffect(player, null);
						return;
					}
				
				
					if ((player.hasPermission(perm)) && (args.length == 2) && (!cooldown.contains(player))) {
						Player target = player.getServer().getPlayer(args[1]);
						if (target != null) {
							if (this.getConfig().getBoolean("target-see-emote") && (!player.getDisplayName().equals(target.getDisplayName()))) {
								if (target.hasPermission("emotes.hear")) {
									target.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getCustom().getString("custom." + emote + ".other-" + emote)
											.replace("%player%", player.getDisplayName())
											.replace("%target%", target.getDisplayName())));
								}
							}
							
							if (player.hasPermission("emotes.hear")) {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getCustom().getString("custom." + emote + ".other-" + emote)
										.replace("%player%", player.getDisplayName())
										.replace("%target%", target.getDisplayName())));
							}
							addCooldown(player);
							soundEffect(player, target);
							particleEffect(player, target);
							return;
						}
						else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("not-online")
									.replace("%target%", args[1])));
							return;
						}
					}
				
					if ((player.hasPermission(perm)) && (args.length > 2)) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getCustom().getString("custom.bad-usage")));
						return;
					}
	
					if (cooldown.contains(player)) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("cooldown-message")));
						return;
					}
					
					else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("noPermissions")));
						return;
					}
				}
				
			}
			
			if (!customEmotes.contains(emote)) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getCustom().getString("custom.not-emote")));
				return;
			}
			
				
		}
		
		else {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getCustom().getString("custom.bad-usage")));
			return;
		}
		
	}
	
 	public void customGuiEmoteOther(Player player, String tar, String n) {
			if (!cooldown.contains(player)) {
				Player target = Bukkit.getPlayer(tar);
				
				if ( !this.getConfig().getBoolean("only-see-own") ) {
					for (Player p : Bukkit.getOnlinePlayers()) {
						if (p.hasPermission("emotes.hear")) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getCustom().getString("custom." + n + ".other-" + n)
									.replace("%target%", tar)
									.replace("%player%", player.getDisplayName())));
						}
					}
					addCooldown(player);
					soundEffect(player, target);
					particleEffect(player, target);
					return;
				}
				
				if ( this.getConfig().getBoolean("only-see-own") ) {
					if (player.hasPermission("emotes.hear")) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getCustom().getString("custom." + n + ".other-" + n)
								.replace("%target%", tar)
								.replace("%player%", player.getDisplayName())));
					}
					if (this.getConfig().getBoolean("target-see-emote") && (!player.getDisplayName().equals(target.getDisplayName()))) {
						if (target.hasPermission("emotes.hear")) {
							target.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getCustom().getString("custom." + n + ".other-" + n)
									.replace("%player%", player.getDisplayName())
									.replace("%target%", tar)));
						}
					}
					addCooldown(player);
					soundEffect(player, target);
					particleEffect(player, target);
					return;
				}
				
			}
			if (cooldown.contains(player)) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("cooldown-message")));
				return;
			}
			else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("noPermissions")));
				return;
			}
		
	}

	public void guiEmoteOther(Player player, String tar, String n) {
		if (!cooldown.contains(player)) {
			Player target = Bukkit.getPlayer(tar);
			if ( !this.getConfig().getBoolean("only-see-own") ) {
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (p.hasPermission("emotes.hear")) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("other-" + n)
								.replace("%target%", tar)
								.replace("%player%", player.getDisplayName())));
					}
				}
				soundEffect(player, target);
				particleEffect(player, target);
				addCooldown(player);
				return;
			}
			
			if ( this.getConfig().getBoolean("only-see-own") ) {
				if (player.hasPermission("emotes.hear")) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("other-" + n)
							.replace("%target%", tar)
							.replace("%player%", player.getDisplayName())));
				}
				if (this.getConfig().getBoolean("target-see-emote") && (!player.getDisplayName().equals(target.getDisplayName()))) {
					if (target.hasPermission("emotes.hear")) {
						target.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("other-" + n)
								.replace("%player%", player.getDisplayName())
								.replace("%target%", tar)));
					}
				}
				soundEffect(player, target);
				particleEffect(player, target);
				addCooldown(player);
				return;
			}
			
		}
		if (cooldown.contains(player)) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("cooldown-message")));
			return;
		}
		else {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("noPermissions")));
			return;
		}
		
	}
	
	@EventHandler
	public void onPlayerDrag(InventoryDragEvent event) {
		String invTitle = event.getInventory().getName();
		String title = Utils.transColors(FileManager.getGUI().getString("gui.self-name"));
		String type = Utils.transColors(FileManager.getGUI().getString("gui.select-type-name"));
		String pick = Utils.transColors(FileManager.getGUI().getString("gui.pick-player-name"));
		String other = Utils.transColors(FileManager.getGUI().getString("gui.other-name"));
		if ((!invTitle.equals(title)) 
				&& (!invTitle.equals(type)) 
				&& (!invTitle.equals(pick))
				&& (!invTitle.equals(other))) {
			return;
		}
		else {
			event.setCancelled(true);
			return;
		}
	}
		
	@EventHandler
	public void onPlayerClick(InventoryClickEvent event) {
		try {
			String self = Utils.transColors(FileManager.getGUI().getString("gui.self-name"));
			String type = Utils.transColors(FileManager.getGUI().getString("gui.select-type-name"));
			String pick = Utils.transColors(FileManager.getGUI().getString("gui.pick-player-name"));
			String other = Utils.transColors(FileManager.getGUI().getString("gui.other-name"));
			
			Inventory invC = event.getInventory();
			String invTitle = invC.getTitle();
			
			if ((!invTitle.equals(self)) 
				&& (!invTitle.equals(type))  
				&& (!invTitle.equals(pick))
				&& (!invTitle.equals(other))) {
				return;
			}

			event.setCancelled(true);
			
			Player p = (Player) event.getWhoClicked();
			
	// -- Click events in Type Selector Menu		
			if (invTitle.equals(type) && (invC.getItem(12) != null)) {
				if ((invC.getItem(12).getType() == ( Material.matchMaterial(FileManager.getGUI().getString("gui.indiv-item"))))
						&& (invC.getItem(12).getItemMeta().getDisplayName().equals(Utils.transColors(FileManager.getGUI().getString("gui.indiv-name"))))) {
					
					if ( (event.getCurrentItem().getType() == Material.AIR) || (event.getCurrentItem() == null)) {
						return;
					}
					
					String clicked = (event.getCurrentItem().getItemMeta().getDisplayName());
					String indivdone = Utils.transColors(FileManager.getGUI().getString("gui.indiv-name"));
					String multidone = Utils.transColors(FileManager.getGUI().getString("gui.multi-name"));
					if ( clicked.equals(indivdone) ) {
						Menus.makeMenu(p);
						return;
					}
					if ( clicked.equals(multidone) ) {
						Menus.pickPlayer(p);
						return;
					}
					else {
						return;
					}
				}
				
				
			}
	// -- Click events in Player Selector Menu		
			if (invTitle.equals(pick) && (invC.getItem(0) != null)){
				if  (invC.getItem(0).getType() == (Material.SKULL_ITEM)) {
					event.setCancelled(true);
					if ( event.getCurrentItem().getType() == ( Material.SKULL_ITEM ) ) {
						ItemStack i = event.getCurrentItem();
						SkullMeta sk = (SkullMeta) i.getItemMeta();
						String target = sk.getOwner();
						
						Menus.makeOtherMenu(p, target);
						return;
					}
					else {
						return;
					}
				}
				
			}
				
			
			if (invTitle.equals(Utils.transColors(other)) && (invC.getItem(0) != null)){
				if (invC.getItem(0).getType() == ( Material.NAME_TAG )) {
					
					event.setCancelled(true);
					if ( (event.getCurrentItem().getType() == Material.AIR) || (event.getCurrentItem() == null)) {
						return;
					}
					
					String item = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());
					Set<String> keys = FileManager.getGUI().getConfigurationSection("gui").getKeys(false);
					String target = event.getClickedInventory().getItem(0).getItemMeta().getDisplayName();
					for (String n : keys) {
						if (!(n.equals("name"))) {
							String m = FileManager.getGUI().getString("gui." + n + ".name");
							if (m != null) {
								String mo = Utils.remCodes(m);
								if (item.equals(mo)) {
									Boolean typeSe = FileManager.getGUI().getBoolean("gui." + n + ".custom");
									if (typeSe) {
										customGuiEmoteOther(p, target, n);
										p.closeInventory();
										return;
									}
									if (!typeSe) {
										guiEmoteOther(p, target, n);
										p.closeInventory();
										return;
									}
									
									else {
										return;
									}
								}
							}
						}
					}
				}
			}
				
			// -- Click events in the Emotes Menu
			if (invTitle.equals(self)) {
				event.setCancelled(true);
				if ( (event.getCurrentItem().getType() == Material.AIR) || (event.getCurrentItem() == null)) {
					return;
				}
				String item = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());
				Set<String> keys = FileManager.getGUI().getConfigurationSection("gui").getKeys(false);

				if (keys == null) {
					p.closeInventory();
					return;
				}
				for (String n : keys) {
					String m = FileManager.getGUI().getString("gui." + n + ".name");
					if (m != null) {
						String mo = Utils.remCodes(m);
						if (item.equals(mo)) {
							Boolean typeSe = FileManager.getGUI().getBoolean("gui." + n + ".custom");
							if (typeSe) {
								customGuiEmote(p, n);
								p.closeInventory();
								return;
							}
							if (!typeSe) {
								guiEmote(p, n);
								p.closeInventory();
								return;
							}
							
							else {
								return;
							}
						}
					}
				}
				
			}
			
		}
		
		catch ( NullPointerException e ) {
			Player p = (Player) event.getWhoClicked();
			p.closeInventory();
			return;
		}
	}
		
	public void addCooldown(final Player player) {
		if (!player.hasPermission("emotes.cooldown.bypass")) {
			cooldown.add(player);
			int bdown = this.getConfig().getInt("emote-cooldown");
			int bcooldown = bdown * 20;
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					cooldown.remove(player);
				}
			}, bcooldown);
		}
		else {
			return;
		}
	}
	
	public void remCooldown(Player player) {
		cooldown.remove(player);
		return;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("emote")) {
			Player player = (Player) sender;
			customEmote(player, args);
			return true;
		}

		if ((sender.hasPermission("emotes.menu")) && (cmd.getName().equalsIgnoreCase("em"))) {
			Player player = (Player) sender;
			Menus.pickTypeMenu(player);
			return true;
		}
		
		if ((!sender.hasPermission("emotes.menu")) && (cmd.getName().equalsIgnoreCase("em"))) {
			Player player = (Player) sender;
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("noPermissions")));
			return true;
		}


		if ((cmd.getName().equalsIgnoreCase("wink"))
				|| (cmd.getName().equalsIgnoreCase("highfive"))
				|| (cmd.getName().equalsIgnoreCase("kiss"))
				|| (cmd.getName().equalsIgnoreCase("slap"))
				|| (cmd.getName().equalsIgnoreCase("hug"))
				|| (cmd.getName().equalsIgnoreCase("dance"))
				|| (cmd.getName().equalsIgnoreCase("smile"))
				|| (cmd.getName().equalsIgnoreCase("raspberry"))
				|| (cmd.getName().equalsIgnoreCase("thumbsup"))
				|| (cmd.getName().equalsIgnoreCase("applaud"))
				|| (cmd.getName().equalsIgnoreCase("bark"))
				|| (cmd.getName().equalsIgnoreCase("beg"))
				|| (cmd.getName().equalsIgnoreCase("bow"))
				|| (cmd.getName().equalsIgnoreCase("cheer"))
				|| (cmd.getName().equalsIgnoreCase("cry"))
				|| (cmd.getName().equalsIgnoreCase("eat"))
				|| (cmd.getName().equalsIgnoreCase("greet"))
				|| (cmd.getName().equalsIgnoreCase("poke"))
				|| (cmd.getName().equalsIgnoreCase("laugh"))
				|| (cmd.getName().equalsIgnoreCase("flirt"))) {
			Player player = (Player) sender;
			String c = cmd.getName();
			emote(c, player, args);
			return true;
		}
		
		
/// Administrative commands!
		if (cmd.getName().equalsIgnoreCase("emotes")) {
			Player player = (Player) sender;
			if (args.length == 0) {
				List<String> usage = FileManager.getMsg().getStringList("emotes-help");
				for (String s : usage) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
				}
				return true;
			}
			
			if ((player.hasPermission("emotes.reload")) && (args[0].equals("reload"))) {
				this.reloadConfig();
				FileManager.checkFiles();
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("reload-message")));
				return true;
			}
			
			if ((!player.hasPermission("emotes.reload")) && (args[0].equals("reload"))) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("noPermissions")));
				return true;
			}
			
			if ((player.hasPermission("emotes.list")) && (args[0].equals("list"))) {
				listEmotes(makeList(), player);
				return true;
			}
			
			if ((player.hasPermission("emotes.menu")) && (args[0].equals("menu"))) {
				Menus.pickTypeMenu(player);
				return true;
			}
			
			
			if ((player.hasPermission("emotes.cooldown.remove")) && (args[0].equals("remove"))) {
				if (args.length == 2) {
					Player target = player.getServer().getPlayer(args[1]);
					if (!(target == null)) {
						remCooldown(target);
						return true;
					}
					else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("not-online")
								.replace("%target%", args[1])));
						return true;
					}
				}
				
				if (args.length == 1) {
					remCooldown(player);
					return true;
				}
				
				else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("bad-usage-remove")
							.replace("%target%", args[1])));
					return true;
				}
			}
			
			if ((!args[0].equals("reload"))
					|| (!args[0].equals("list"))
					|| (!args[0].equals("remove"))
					|| (!args[0].equals("menu"))
					|| (args.length > 2)) {
				List<String> usage = FileManager.getMsg().getStringList("emotes-help");
				for (String s : usage) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
				}
				return true;
			}
			
			else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', FileManager.getMsg().getString("noPermissions")));
				return true;
			}
		}
		
		
		return false;
	}
}