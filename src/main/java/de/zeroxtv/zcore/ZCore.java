package de.zeroxtv.zcore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class ZCore extends JavaPlugin {

    public static Logger logger;

    @Override
    public void onEnable() {
        logger = Bukkit.getLogger();

        //SQL Setup
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        logger.info(ChatColor.GREEN + "ZCore enabled");
        logger.info("Ready to load ZPlugins");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
