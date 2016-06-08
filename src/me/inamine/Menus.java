package me.inamine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Menus {
	public static void pickPlayer(Player player) {
		try {
			Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', (FileManager.getGUI().getString("gui.pick-player-name"))));
			Collection<? extends Player> list = Bukkit.getOnlinePlayers();
			for (Player p : list) {
	            ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
	            SkullMeta meta = (SkullMeta) head.getItemMeta();
	            meta.setDisplayName(p.getDisplayName());
	            meta.setOwner(p.getName());
	            head.setItemMeta(meta);
	            inv.addItem(head);
			}
			
			player.openInventory(inv);
		}
		
		catch ( IllegalArgumentException e) {
			Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&cInvalid name for pick-player"));
			Collection<? extends Player> list = Bukkit.getOnlinePlayers();
			for (Player p : list) {
	            ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
	            SkullMeta meta = (SkullMeta) head.getItemMeta();
	            meta.setDisplayName(p.getDisplayName());
	            meta.setOwner(p.getName());
	            head.setItemMeta(meta);
	            inv.addItem(head);
			}
			
			player.openInventory(inv);
		}
	}

	public static void pickTypeMenu(Player player) {
		try {
			Inventory inv = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', (FileManager.getGUI().getString("gui.select-type-name"))));

			Material defmat = Material.WOOL;
			ItemStack defitem = new ItemStack(defmat);
			ItemMeta meta = defitem.getItemMeta();
			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cBroken Item in GUI.yml!"));
			defitem.setItemMeta(meta);
			inv.setItem(12, defitem);
			inv.setItem(14, defitem);
			
			String indiv = FileManager.getGUI().getString("gui.indiv-item");
			if  (indiv != null) {
				Material d = Material.matchMaterial(indiv);
				if (!(d == null)) {
					ItemStack item = new ItemStack(d);
					if  (!(item == null)) {
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileManager.getGUI().getString("gui.indiv-name")));
						List<String> loreList = FileManager.getGUI().getStringList("gui.indiv-lore");
						List<String> newLore = new ArrayList<String>();
						for (String lolHI : loreList) {
							newLore.add(ChatColor.translateAlternateColorCodes('&', lolHI));
						}
						itemMeta.setLore(newLore);
						item.setItemMeta(itemMeta);
						inv.setItem(12, item);
					}
				}
			}
			
			String multi = FileManager.getGUI().getString("gui.multi-item");
			if  (multi != null) {
				Material rip = Material.matchMaterial(multi);
				if (rip != null) {
					ItemStack item = new ItemStack(rip);
					if  (item != null) {
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileManager.getGUI().getString("gui.multi-name")));
						List<String> loreList = FileManager.getGUI().getStringList("gui.multi-lore");
						List<String> newLore = new ArrayList<String>();
						for (String lolHI : loreList) {
							newLore.add(ChatColor.translateAlternateColorCodes('&', lolHI));
						}
						itemMeta.setLore(newLore);
						item.setItemMeta(itemMeta);
						inv.setItem(14, item);
					}
				}
			}
			
			player.openInventory(inv);
		}
		
		catch ( IllegalArgumentException e) {
			Inventory inv = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', "&cInvalid name for select-type"));
			Material defmat = Material.WOOL;
			ItemStack defitem = new ItemStack(defmat);
			ItemMeta meta = defitem.getItemMeta();
			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cBroken Item in GUI.yml!"));
			defitem.setItemMeta(meta);
			inv.setItem(12, defitem);
			inv.setItem(14, defitem);
			
			String indiv = FileManager.getGUI().getString("gui.indiv-item");
			if  (indiv != null) {
				Material d = Material.matchMaterial(indiv);
				if (!(d == null)) {
					ItemStack item = new ItemStack(d);
					if  (!(item == null)) {
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileManager.getGUI().getString("gui.indiv-name")));
						List<String> loreList = FileManager.getGUI().getStringList("gui.indiv-lore");
						List<String> newLore = new ArrayList<String>();
						for (String lolHI : loreList) {
							newLore.add(ChatColor.translateAlternateColorCodes('&', lolHI));
						}
						itemMeta.setLore(newLore);
						item.setItemMeta(itemMeta);
						inv.setItem(12, item);
					}
				}
			}
			
			String multi = FileManager.getGUI().getString("gui.multi-item");
			if  (multi != null) {
				Material rip = Material.matchMaterial(multi);
				if (rip != null) {
					ItemStack item = new ItemStack(rip);
					if  (item != null) {
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileManager.getGUI().getString("gui.multi-name")));
						List<String> loreList = FileManager.getGUI().getStringList("gui.multi-lore");
						List<String> newLore = new ArrayList<String>();
						for (String lolHI : loreList) {
							newLore.add(ChatColor.translateAlternateColorCodes('&', lolHI));
						}
						itemMeta.setLore(newLore);
						item.setItemMeta(itemMeta);
						inv.setItem(14, item);
					}
				}
			}
			
			player.openInventory(inv);
		}
		
	}
	public static void makeMenu(Player player) {
		List<String> emotesList = new ArrayList<String>();
		// Manually adds each emote, gross, I know..
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
		List<String> allowedList = new ArrayList<String>();
		List<String> custom = FileManager.getCustom().getStringList("custom-emotes");
		// Checks if any custom emotes exist
		if (!custom.isEmpty()) {
			for (String e : emotesList) {
				if (player.hasPermission("emotes.use." + e)) {
					allowedList.add(e);
				}
			}
			for (String f : custom) {
				if (player.hasPermission(FileManager.getCustom().getString("custom." + f + ".permission"))) {
					allowedList.add(f);
				}
			}
		}
		// Checks if any custom emotes exist
		if (custom.isEmpty()) {
			for (String e : emotesList) {
				if (player.hasPermission("emotes.use." + e)) {
					allowedList.add(e);
				}
			}
		}
		// Creation of the GUI! :D
		try {
			Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', (FileManager.getGUI().getString("gui.self-name"))));
			for (String e : allowedList) {
				String k = FileManager.getGUI().getString("gui." + e + ".item-id");
				// Checks if the string exists
				if  (!(k == null)) {
					Material d = Material.matchMaterial(k);
					// Checks if the item matches a material
					if (!(d == null)) {
						ItemStack item = new ItemStack(d);
						// Checks if the item is a proper item stack (shouldn't be an issue, mostly just in case)
						if  (!(item == null)) {
							// Getting the meta data from the item
							ItemMeta itemMeta = item.getItemMeta();
							// Setting the name to what the name should be (isn't on the item, just in a seperate "copied" itemmeta)
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileManager.getGUI().getString("gui." + e + ".name")));
							// Gets what the lore should be
							List<String> loreList = FileManager.getGUI().getStringList("gui." + e + ".lore");
							// Makes a new list for the lore to go into
							List<String> newLore = new ArrayList<String>();
							// Adds each line from the Lore: section to the lore of the item with colors
							for (String lolHI : loreList) {
								newLore.add(ChatColor.translateAlternateColorCodes('&', lolHI));
							}
							// Sets the lore of the itemmeta to the above
							itemMeta.setLore(newLore);
							// Attaches the item meta to the item
							item.setItemMeta(itemMeta);
							// Finds the first empty spot in the inventory
							int spot = inv.firstEmpty();
							// Puts the item in the inventory in the spot given above
							inv.setItem(spot, item);
						}
					}
					
					
				}
			}
			// And finally, opens the inventory!
			player.openInventory(inv);
			
		}
		
		catch (IllegalArgumentException note) {
			Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&cInvalid name for self-name"));
			for (String e : allowedList) {
				String k = FileManager.getGUI().getString("gui." + e + ".item-id");
				// Checks if the string exists
				if  (!(k == null)) {
					Material d = Material.matchMaterial(k);
					// Checks if the item matches a material
					if (!(d == null)) {
						ItemStack item = new ItemStack(d);
						// Checks if the item is a proper item stack (shouldn't be an issue, mostly just in case)
						if  (!(item == null)) {
							// Getting the meta data from the item
							ItemMeta itemMeta = item.getItemMeta();
							// Setting the name to what the name should be (isn't on the item, just in a seperate "copied" itemmeta)
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileManager.getGUI().getString("gui." + e + ".name")));
							// Gets what the lore should be
							List<String> loreList = FileManager.getGUI().getStringList("gui." + e + ".lore");
							// Makes a new list for the lore to go into
							List<String> newLore = new ArrayList<String>();
							// Adds each line from the Lore: section to the lore of the item with colors
							for (String lolHI : loreList) {
								newLore.add(ChatColor.translateAlternateColorCodes('&', lolHI));
							}
							// Sets the lore of the itemmeta to the above
							itemMeta.setLore(newLore);
							// Attaches the item meta to the item
							item.setItemMeta(itemMeta);
							// Finds the first empty spot in the inventory
							int spot = inv.firstEmpty();
							// Puts the item in the inventory in the spot given above
							inv.setItem(spot, item);
						}
					}
					
					
				}
			}
			// And finally, opens the inventory!
			player.openInventory(inv);
		}
		
	}
	
	public static void makeOtherMenu(Player player, String target) {
		List<String> emotesList = new ArrayList<String>();
		// Manually adds each emote, gross, I know..
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
		List<String> allowedList = new ArrayList<String>();
		List<String> custom = FileManager.getCustom().getStringList("custom-emotes");
		// Checks if any custom emotes exist
		if (!custom.isEmpty()) {
			for (String e : emotesList) {
				if (player.hasPermission("emotes.use." + e)) {
					allowedList.add(e);
				}
			}
			for (String f : custom) {
				if (player.hasPermission(FileManager.getCustom().getString("custom." + f + ".permission"))) {
					allowedList.add(f);
				}
			}
		}
		// Checks if any custom emotes exist
		if (custom.isEmpty()) {
			for (String e : emotesList) {
				if (player.hasPermission("emotes.use." + e)) {
					allowedList.add(e);
				}
			}
		}
		try {
			Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', (FileManager.getGUI().getString("gui.other-name"))));
			// Creation of the GUI! :D
			ItemStack targ = new ItemStack(Material.NAME_TAG, 1);
			ItemMeta targdata = targ.getItemMeta();
			targdata.setDisplayName(target);
			targ.setItemMeta(targdata);
			inv.setItem(0, targ);
			for (String e : allowedList) {
				String k = FileManager.getGUI().getString("gui." + e + ".item-id");
				// Checks if the string exists
				if  (!(k == null)) {
					Material d = Material.matchMaterial(k);
					// Checks if the item matches a material
					if (!(d == null)) {
						ItemStack item = new ItemStack(d);
						// Checks if the item is a proper item stack (shouldn't be an issue, mostly just in case)
						if  (!(item == null)) {
							// Getting the meta data from the item
							ItemMeta itemMeta = item.getItemMeta();
							// Setting the name to what the name should be (isn't on the item, just in a seperate "copied" itemmeta)
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileManager.getGUI().getString("gui." + e + ".name")));
							// Gets what the lore should be
							List<String> loreList = FileManager.getGUI().getStringList("gui." + e + ".lore");
							// Makes a new list for the lore to go into
							List<String> newLore = new ArrayList<String>();
							// Adds each line from the Lore: section to the lore of the item with colors
							for (String lolHI : loreList) {
								newLore.add(ChatColor.translateAlternateColorCodes('&', lolHI));
							}
							// Sets the lore of the itemmeta to the above
							itemMeta.setLore(newLore);
							// Attaches the item meta to the item
							item.setItemMeta(itemMeta);
							// Finds the first empty spot in the inventory
							int spot = inv.firstEmpty();
							// Puts the item in the inventory in the spot given above
							inv.setItem(spot, item);
						}
					}
					
					
				}
			}
			// And finally, opens the inventory!
			player.openInventory(inv);
		}
		catch (IllegalArgumentException dsf) {
			Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&cInvalid name for other-name"));
			// Creation of the GUI! :D
			ItemStack targ = new ItemStack(Material.NAME_TAG, 1);
			ItemMeta targdata = targ.getItemMeta();
			targdata.setDisplayName(target);
			targ.setItemMeta(targdata);
			inv.setItem(0, targ);
			for (String e : allowedList) {
				String k = FileManager.getGUI().getString("gui." + e + ".item-id");
				// Checks if the string exists
				if  (!(k == null)) {
					Material d = Material.matchMaterial(k);
					// Checks if the item matches a material
					if (!(d == null)) {
						ItemStack item = new ItemStack(d);
						// Checks if the item is a proper item stack (shouldn't be an issue, mostly just in case)
						if  (!(item == null)) {
							// Getting the meta data from the item
							ItemMeta itemMeta = item.getItemMeta();
							// Setting the name to what the name should be (isn't on the item, just in a seperate "copied" itemmeta)
							itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', FileManager.getGUI().getString("gui." + e + ".name")));
							// Gets what the lore should be
							List<String> loreList = FileManager.getGUI().getStringList("gui." + e + ".lore");
							// Makes a new list for the lore to go into
							List<String> newLore = new ArrayList<String>();
							// Adds each line from the Lore: section to the lore of the item with colors
							for (String lolHI : loreList) {
								newLore.add(ChatColor.translateAlternateColorCodes('&', lolHI));
							}
							// Sets the lore of the itemmeta to the above
							itemMeta.setLore(newLore);
							// Attaches the item meta to the item
							item.setItemMeta(itemMeta);
							// Finds the first empty spot in the inventory
							int spot = inv.firstEmpty();
							// Puts the item in the inventory in the spot given above
							inv.setItem(spot, item);
						}
					}
					
					
				}
			}
			// And finally, opens the inventory!
			player.openInventory(inv);
		}
	}
}
