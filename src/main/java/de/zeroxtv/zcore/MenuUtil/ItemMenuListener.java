package de.zeroxtv.zcore.MenuUtil;

import de.zeroxtv.zcore.ZCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by ZeroxTV
 */
public class ItemMenuListener implements Listener {

    public ItemMenuListener(ZCore zCore) {
        Bukkit.getPluginManager().registerEvents(this, zCore);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getViewers().get(0);
        if (ItemMenu.getCurrentlyOpenMenu(player.getUniqueId()) == null) {
            return;
        }
        if (event.getCurrentItem() == null) return;
        if(event.getClickedInventory().getName().equals(ItemMenu.getCurrentlyOpenMenuName(player.getUniqueId()))) {
            for (MenuItem item : ItemMenu.getCurrentlyOpenMenu(player.getUniqueId()).getMenuItems()) {
                if (item.getItem().getType().equals(event.getCurrentItem().getType())) {
                    event.setCancelled(true);
                    item.click(player);
                    return;
                }
            }
        }
    }
}
