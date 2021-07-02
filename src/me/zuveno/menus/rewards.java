package me.zuveno.menus;

import me.clip.placeholderapi.PlaceholderAPI;
import me.zuveno.legendz;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class rewards {

    public void loadGUI(Player user) {

        Economy econ = legendz.getEconomy();

        String nickname = PlaceholderAPI.setPlaceholders(user,ChatColor.RED +"Никнейм | Nickname: " + ChatColor.GRAY + user.getDisplayName());
        String level = PlaceholderAPI.setPlaceholders(user,ChatColor.RED +"Уровень | Level:"+ ChatColor.GRAY +" %battlelevels_level%");
        String score = PlaceholderAPI.setPlaceholders(user,ChatColor.RED +"Опыт | Exp: "+ ChatColor.GRAY +"%battlelevels_score%/%battlelevels_neededfornext%");
        String expbar = PlaceholderAPI.setPlaceholders(user,"%battlelevels_bar%");
        String money = ChatColor.RED + "Баланс | Balance: " + ChatColor.GRAY + econ.format(econ.getBalance(user));
        String kills = PlaceholderAPI.setPlaceholders(user,ChatColor.RED +"Убийств | Kills: "+ ChatColor.GRAY +user.getStatistic(Statistic.PLAYER_KILLS));
        String deaths = PlaceholderAPI.setPlaceholders(user,ChatColor.RED +"Смертей | Deaths: "+ ChatColor.GRAY +user.getStatistic(Statistic.DEATHS));
        String playertime = PlaceholderAPI.setPlaceholders(user,ChatColor.RED +"Сыграно | Played: "+ ChatColor.GRAY + user.getStatistic(Statistic.PLAY_ONE_TICK) / 72000) + " час(ов) | Hour(s)";

        String levelUpStudy = PlaceholderAPI.setPlaceholders(user, "%mycommand_playerdata_levelupstudy%");

        Inventory inv = Bukkit.createInventory(null, 45, "Награды | Rewards");

        ItemStack empty = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
        ItemMeta empty_m = empty.getItemMeta();
        empty_m.setDisplayName(ChatColor.GRAY + "");
        empty.setItemMeta(empty_m);
        for(int i = 0; i < 45; i++) {
            inv.setItem(i, empty);
        }

        String levels1 = PlaceholderAPI.setPlaceholders(user, "%battlelevels_level%");
        double lvl = Integer.parseInt(levels1);


        ItemStack level1 = new ItemStack(Material.getMaterial("DECI_NVGOGGLES_FURY"), 1);
        inv.setItem(0, level1);
        ItemStack level2 = new ItemStack(Material.getMaterial("DECI_MILITARYVESTBLACK"), 1);
        inv.setItem(1, level2);
        ItemStack level4 = new ItemStack(Material.getMaterial("DECI_ITEMDRAINCLEANER"), 1);
        inv.setItem(3, level4);
        ItemStack level5 = new ItemStack(Material.getMaterial("DECI_ITEMBOTTLECAP"), 1);
        ItemMeta level5_m = level5.getItemMeta();
        level5_m.setDisplayName(ChatColor.RED + "40❂");
        level5.setItemMeta(level5_m);
        inv.setItem(4, level5);
        ItemStack level7 = new ItemStack(Material.getMaterial("DECI_ITEMKITMETALWALL"), 1);
        inv.setItem(6, level7);
        ItemStack level8 = new ItemStack(Material.getMaterial("DECI_ITEMDRAINCLEANER"), 1);
        inv.setItem(7, level8);
        ItemStack level10 = new ItemStack(Material.getMaterial("DECI_ITEMBOTTLECAP"), 1);
        ItemMeta level10_m = level10.getItemMeta();
        level10_m.setDisplayName(ChatColor.RED + "80❂");
        level10.setItemMeta(level10_m);
        inv.setItem(9, level10);
        ItemStack level12 = new ItemStack(Material.getMaterial("DECI_ITEMPAINKILLERS"), 4);
        inv.setItem(11, level12);
        ItemStack level14 = new ItemStack(Material.getMaterial("DECI_ITEMKITMETALWALL"), 7);
        inv.setItem(13, level14);
        ItemStack level15 = new ItemStack(Material.getMaterial("DECI_ITEMBOTTLECAP"), 1);
        ItemMeta level15_m = level15.getItemMeta();
        level15_m.setDisplayName(ChatColor.RED + "110❂");
        level15.setItemMeta(level15_m);
        inv.setItem(14, level15);
        ItemStack level16 = new ItemStack(Material.getMaterial("DECI_ITEMGLIDER"), 11);
        inv.setItem(15, level16);
        ItemStack level18 = new ItemStack(Material.getMaterial("DECI_ITEMSCRAPLYEPACKET"), 1);
        inv.setItem(17, level18);
        ItemStack level20 = new ItemStack(Material.getMaterial("DECI_ITEMBOTTLECAP"), 1);
        ItemMeta level20_m = level20.getItemMeta();
        level20_m.setDisplayName(ChatColor.RED + "140❂");
        level20.setItemMeta(level20_m);
        inv.setItem(19, level20);
        ItemStack level21 = new ItemStack(Material.getMaterial("DECI_HONEYBADGER"), 1);
        inv.setItem(20, level21);
        ItemStack level23 = new ItemStack(Material.getMaterial("DECI_HONEYBADGER"), 1);
        inv.setItem(22, level23);
        ItemStack level25 = new ItemStack(Material.getMaterial("DECI_JUGGERNAUTHELMGRAY"), 1);
        inv.setItem(24, level25);
        ItemStack level26 = new ItemStack(Material.getMaterial("DECI_ITEMACIDCANISTER"), 1);
        inv.setItem(25, level26);
        ItemStack level29 = new ItemStack(Material.getMaterial("DECI_ITEMMORTARGUN"), 1);
        inv.setItem(28, level29);
        ItemStack level30 = new ItemStack(Material.getMaterial("DECI_ITEMBOTTLECAP"), 1);
        ItemMeta level30_m = level30.getItemMeta();
        level30_m.setDisplayName(ChatColor.RED + "180❂");
        level30.setItemMeta(level30_m);
        inv.setItem(29, level30);

        ItemStack green = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5);
        ItemMeta green_m = green.getItemMeta();
        green_m.setDisplayName(ChatColor.GREEN + "Получено");
        green.setItemMeta(green_m);
        for(int i = 0; i < lvl; i++)
            inv.setItem(i, green);


        ItemStack profile = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        ItemMeta p_m = profile.getItemMeta();
        p_m.setDisplayName(ChatColor.RED + "Ваш профиль: | Your profile:");

        ArrayList<String> p_l = new ArrayList<>();

        p_l.add(nickname);
        p_l.add(level);
        p_l.add(score);
        p_l.add(expbar);
        p_l.add(money);
        p_l.add(kills);
        p_l.add(deaths);
        p_l.add(playertime);

        p_m.setLore(p_l);
        profile.setItemMeta(p_m);

        if(levelUpStudy.equalsIgnoreCase("1")) {
            ItemStack rank = new ItemStack(Material.CLAY_BRICK, 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Ученик | Pupil");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(43, rank);
        } else if(levelUpStudy.equalsIgnoreCase("2")) {
            ItemStack rank = new ItemStack(Material.IRON_INGOT, 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Бандит | Bandit");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(43, rank);
        } else if(levelUpStudy.equalsIgnoreCase("3")) {
            ItemStack rank = new ItemStack(Material.GOLD_INGOT, 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Мафия | Mafia");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(43, rank);
        } else if(levelUpStudy.equalsIgnoreCase("4")) {
            ItemStack rank = new ItemStack(Material.DIAMOND, 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Лидер | Leader");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(43, rank);
        } else if(levelUpStudy.equalsIgnoreCase("5")) {
            ItemStack rank = new ItemStack(Material.EMERALD, 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Босс этой качалки | Boss of this gym");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(43, rank);
        }

        ItemStack mainMenu = new ItemStack(Material.getMaterial("DECI_BLOCKRADIO1"), 1);
        ItemMeta mainMenu_m = mainMenu.getItemMeta();
        mainMenu_m.setDisplayName(ChatColor.RED + "Вернуться в меню | Back to Main Menu");
        mainMenu.setItemMeta(mainMenu_m);
        inv.setItem(44, mainMenu);
        inv.setItem(42, profile);

        user.openInventory(inv);
    }

}
