package de.zeroxtv.zcore.MenuUtil;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ZeroxTV
 */
public class ItemMenu {
    private ArrayList<MenuItem> items = new ArrayList<>();
    private Inventory inventory;
    private String name;
    public static HashMap<UUID, ItemMenu> curOpen = new HashMap<>();

    public static boolean isMenu(Inventory inv) {
        for (Map.Entry<UUID, ItemMenu> entry : curOpen.entrySet()) {
            if (entry.getValue().getName().equals(inv.getName())) {
                return true;
            }
        }
        return false;
    }

    public ItemMenu(int size,  String name) {
        this.name = name;
        inventory = Bukkit.createInventory(null, size, name);
        for (MenuItem item : items) {
            inventory.addItem(item.getItem());
        }
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
        inventory.setContents(new ItemStack[9]);
        for (MenuItem item : items) {
            inventory.addItem(item.getItem());
        }
    }

    public void open(Player player) {
        player.openInventory(inventory);
        curOpen.put(player.getUniqueId(), this);
    }

    public String getName() {
        return name;
    }

    public static String getCurrentlyOpenMenuName(UUID uuid) {
        if (curOpen.containsKey(uuid)) {
            return curOpen.get(uuid).getName();
        } else {
            return "NULL";
        }
    }

    public static ItemMenu getCurrentlyOpenMenu(UUID uuid) {
        if (curOpen.containsKey(uuid)) {
            return curOpen.get(uuid);
        } else {
            return null;
        }
    }

    public ArrayList<MenuItem> getMenuItems() {
        return items;
    }
}
