package me.zuveno.events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.zuveno.menus.locale;
import me.zuveno.menus.menu;
import me.zuveno.menus.rewards;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerMenuEvent implements Listener {

    @EventHandler
    public void onPlayerClick(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();
        rewards rewards = new rewards();
        menu menu = new menu();
        Player user = (Player) e.getWhoClicked();
        ItemMeta im = e.getCurrentItem().getItemMeta();
        user.getInventory().remove(Material.getMaterial("DECI_BAYONET"));
        if(inv.getTitle().equalsIgnoreCase("Главное меню")) {
            e.setCancelled(true);

            if(im.getDisplayName().equalsIgnoreCase(ChatColor.RED + "Ваш профиль: | Your profile:")) {
                user.closeInventory();
                rewards.loadGUI(user);
            }
            if(im.getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Наш Discord-Сервер | Our Discord-server")) {
                user.closeInventory();
                user.sendMessage(ChatColor.YELLOW + "Наш дискорд сервер | Our discord server: " + ChatColor.BLUE + "https://discord.com/invite/yncCuFb");
            } else if(im.getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Покупка доната | Donate purchase")) {
                user.sendMessage("Приобрести донат можно здесь | You can buy donate here -" + ChatColor.YELLOW + " https://legendz-decimation.easydonate.ru");
            } else if (im.getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Получить награду | Get Reward")) {
                user.closeInventory();
                for(Player p : Bukkit.getServer().getOnlinePlayers()) {
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                }
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "battlelevels reset " + user.getName());
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata add " + user.getName() + " levelupstudy 1");
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "givebox " + user.getName() + " 9902 1");
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "eco give " + user.getName() + " 500");
                user.sendMessage(ChatColor.GREEN + "+500❂, 1 Donate Case " + ChatColor.WHITE + "(Награда за достижение максимального уровня! | Reward for reaching the maximum level!)");
                Bukkit.broadcastMessage(ChatColor.GREEN + user.getDisplayName() + ChatColor.WHITE + " повысил своё звание! | " + ChatColor.GREEN + user.getDisplayName() + ChatColor.WHITE + " has upgraded his rank!");
            } else if(im.getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Изменить префикс")) {
                user.closeInventory();
                Bukkit.dispatchCommand(user, "prefix");
            }
        } else if(inv.getTitle().contains("Статистика игрока ")) {
            e.setCancelled(true);
        } else if(inv.getTitle().equalsIgnoreCase("Награды | Rewards")) {
            e.setCancelled(true);
            if(im.getDisplayName().equalsIgnoreCase(ChatColor.RED + "Вернуться в меню | Back to Main Menu")) {
                user.closeInventory();
                menu.loadGUI(user);
            }
        } else if(inv.getTitle().equalsIgnoreCase("Select Language")) {
            e.setCancelled(true);
            if(im.getDisplayName().equalsIgnoreCase(ChatColor.RED + "Русский")) {
                user.sendMessage(ChatColor.GREEN + "Выбран русский язык.");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getDisplayName() + " locale ru");
                user.closeInventory();
            } else if(im.getDisplayName().equalsIgnoreCase(ChatColor.RED + "English")) {
                user.sendMessage(ChatColor.GREEN + "Selected english language.");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getDisplayName() + " locale en");
                user.closeInventory();
            }
            
        }
    }

    @EventHandler
    public void onPlayerClose(InventoryCloseEvent e) {
        Inventory inv = e.getInventory();
        Player user = (Player)e.getPlayer();
        if(inv.getTitle().equalsIgnoreCase("Главное меню")) {
                user.getInventory().remove(Material.STAINED_GLASS_PANE);
                user.getInventory().remove(Material.WRITTEN_BOOK);
                user.getInventory().remove(Material.PAPER);
        }
        locale lc = new locale();
        if(inv.getTitle().equalsIgnoreCase("Select Language")) {
            if(!(PlaceholderAPI.setPlaceholders(user, "%mycommand_playerdata_locale%").equalsIgnoreCase("en") || PlaceholderAPI.setPlaceholders(user, "%mycommand_playerdata_locale%").equalsIgnoreCase("ru")))
                lc.loadGUI(user);
        }
    }

}
