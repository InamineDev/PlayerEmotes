package me.inamine;

import org.bukkit.ChatColor;

public class Utils {
	
	
	public static String remCodes(String st) {
		String stDone = st.replace("&1", "").replace("&2", "").replace("&3", "")
				.replace("&4", "").replace("&5", "").replace("&6", "")
				.replace("&7", "").replace("&8", "").replace("&9", "")
				.replace("&0", "").replace("&a", "").replace("&b", "")
				.replace("&c", "").replace("&d", "").replace("&e", "")
				.replace("&f", "").replace("&k", "").replace("&m", "")
				.replace("&n", "").replace("&o", "").replace("&l", "");
		return stDone;
	}
	
	public static String transColors(String str) {
		String strD = ChatColor.translateAlternateColorCodes('&', str);
		return strD;
	}

}
