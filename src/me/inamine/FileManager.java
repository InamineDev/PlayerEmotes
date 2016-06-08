package me.inamine;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager {

	private static YamlConfiguration msg;
	private static YamlConfiguration custom;
	private static YamlConfiguration gui;
	
	
	public static void checkFiles() {
		if(!Emotes.getInst().getDataFolder().exists()) {
			Emotes.getInst().getDataFolder().mkdir();
		}
		
		File m = new File(Emotes.getInst().getDataFolder(), "messages.yml");
		if(!m.exists()){
			Emotes.getInst().saveResource("messages.yml", true);
		}
		
		File c = new File(Emotes.getInst().getDataFolder(), "custom.yml");
		if(!c.exists()){
			Emotes.getInst().saveResource("custom.yml", true);
		}
		
		File g = new File(Emotes.getInst().getDataFolder(), "GUI.yml");
		
		if(!g.exists()){
			Emotes.getInst().saveResource("GUI.yml", true);
		}
		
		
		msg = YamlConfiguration.loadConfiguration(m);
		custom = YamlConfiguration.loadConfiguration(c);
		gui = YamlConfiguration.loadConfiguration(g);
	}
	
	public static YamlConfiguration getMsg() {
		return msg;
	}
	
	public static YamlConfiguration getGUI() {
		return gui;
	}

	public static YamlConfiguration getCustom() {
		return custom;
	}
	
}
