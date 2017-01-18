package de.zeroxtv.zcore;

import de.zeroxtv.zcore.MenuUtil.ItemMenuListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class ZCore extends JavaPlugin {

    private Logger logger;

    @Override
    public void onEnable() {
        logger = Bukkit.getLogger();
        new ItemMenuListener(this);

        logger.info(ChatColor.GREEN + "ZCore enabled");
        logger.info("Ready to load ZPlugins");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
