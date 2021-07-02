package me.zuveno.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class locale {

    public void loadGUI(Player user) {

        Inventory inv = Bukkit.createInventory(null, 27, "Select Language");

        ItemStack d = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
        ItemMeta de = d.getItemMeta();
        de.setDisplayName("");
        d.setItemMeta(de);
        for (int i = 0; i < inv.getSize(); i++)
            inv.setItem(i, d);

        ItemStack RUS = new ItemStack(Material.getMaterial("DECI_DECALSOVIETSYMBOL"), 1);

        ItemStack ENG = new ItemStack(Material.getMaterial("DECI_DECALUSFLAG"), 1);

        ItemMeta RU = RUS.getItemMeta();
        RU.setDisplayName(ChatColor.RED + "Русский");
        RUS.setItemMeta(RU);
        ItemMeta EN = ENG.getItemMeta();
        EN.setDisplayName(ChatColor.RED + "English");
        ENG.setItemMeta(EN);

        inv.setItem(10, RUS);
        inv.setItem(15, ENG);
        user.openInventory(inv);

    }
}