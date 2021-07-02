package me.zuveno.menus;

import me.clip.placeholderapi.PlaceholderAPI;
import me.zuveno.legendz;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class statistic {

    public void loadGUI(Player sender, Player user) {

        Economy econ = legendz.getEconomy();

        String level = PlaceholderAPI.setPlaceholders(user,ChatColor.RED +"Уровень | Level:"+ ChatColor.GRAY +" %battlelevels_level%");
        String score = PlaceholderAPI.setPlaceholders(user,ChatColor.RED +"Опыт | Exp: "+ ChatColor.GRAY +"%battlelevels_score%/%battlelevels_neededfornext%");
        String expbar = PlaceholderAPI.setPlaceholders(user,"%battlelevels_bar%");
        String money = ChatColor.RED + "Баланс | Balance: " + ChatColor.GRAY + econ.format(econ.getBalance(user));
        String kills = PlaceholderAPI.setPlaceholders(user,ChatColor.RED +"Убийств | Kills: "+ ChatColor.GRAY +user.getStatistic(Statistic.PLAYER_KILLS));
        String deaths = PlaceholderAPI.setPlaceholders(user,ChatColor.RED +"Смертей | Deaths: "+ ChatColor.GRAY +user.getStatistic(Statistic.DEATHS));
        String playertime = PlaceholderAPI.setPlaceholders(user,ChatColor.RED +"Сыграно | Played: "+ ChatColor.GRAY + user.getStatistic(Statistic.PLAY_ONE_TICK) / 72000) + " час(ов) | Hour(s)";

        String levelUpStudy = PlaceholderAPI.setPlaceholders(user, "%mycommand_playerdata_levelupstudy%");
        Inventory inv = Bukkit.createInventory(null, 27, "Статистика игрока " + user.getDisplayName());

        ItemStack empty = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
        ItemMeta empty_m = empty.getItemMeta();
        empty_m.setDisplayName(ChatColor.RED + "");
        empty.setItemMeta(empty_m);

        ArrayList<String> p_l = new ArrayList<>();
        if(user.isOnline())
            p_l.add(ChatColor.RED + "Статус | Status: " + ChatColor.GREEN + "В сети");
        else
            p_l.add(ChatColor.RED + "Статус | Status: " + ChatColor.RED + "Не в сети");
        p_l.add(level);
        p_l.add(score);
        p_l.add(expbar);
        p_l.add(money);
        p_l.add(kills);
        p_l.add(deaths);
        p_l.add(playertime);

        ItemStack profile = new ItemStack(Material.SKULL_ITEM, 1);
        ItemMeta p_m = profile.getItemMeta();
        p_m.setDisplayName(ChatColor.RED + "Статистика игрока " + ChatColor.GRAY + user.getDisplayName());
        p_m.setLore(p_l);
        profile.setItemMeta(p_m);

        for(int i = 0; i < 27; i++)
            inv.setItem(i, empty);
        inv.setItem(12, profile);



        if(levelUpStudy.equalsIgnoreCase("1") || levelUpStudy.equalsIgnoreCase("1.0")) {
            ItemStack rank = new ItemStack(Material.CLAY_BRICK, 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Ученик | Pupil");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(14, rank);
        } else if(levelUpStudy.equalsIgnoreCase("2") || levelUpStudy.equalsIgnoreCase("2.0")) {
            ItemStack rank = new ItemStack(Material.IRON_INGOT, 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Бандит | Bandit");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(14, rank);
        } else if(levelUpStudy.equalsIgnoreCase("3") || levelUpStudy.equalsIgnoreCase("3.0")) {
            ItemStack rank = new ItemStack(Material.GOLD_INGOT, 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Мафия | Mafia");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(14, rank);
        } else if(levelUpStudy.equalsIgnoreCase("4") || levelUpStudy.equalsIgnoreCase("4.0")) {
            ItemStack rank = new ItemStack(Material.DIAMOND, 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Лидер | Leader");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(14, rank);
        } else if(levelUpStudy.equalsIgnoreCase("5") || levelUpStudy.equalsIgnoreCase("5.0")) {
            ItemStack rank = new ItemStack(Material.EMERALD, 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Босс этой качалки | Boss of this gym");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(14, rank);
        }
        sender.openInventory(inv);
    }

}
