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

public class menu {

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

        Inventory inv = Bukkit.createInventory(null, 9 * 3, "Главное меню");

        ItemStack empty = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);

        ItemMeta empty_m = empty.getItemMeta();

        ItemStack discord = new ItemStack(Material.getMaterial("DECI_BLOCKMAILBOX"), 1);
        ItemStack donate = new ItemStack(Material.getMaterial("DECI_ITEMBOTTLECAPGOLD"), 1);

        ItemMeta d_m = discord.getItemMeta();
        ItemMeta don_m = donate.getItemMeta();

        d_m.setDisplayName(ChatColor.BLUE + "Наш Discord-Сервер | Our Discord-server");
        don_m.setDisplayName(ChatColor.YELLOW + "Покупка доната | Donate purchase");

        ArrayList<String> don_l = new ArrayList<>();

        don_l.add(ChatColor.GRAY + "");
        don_l.add(ChatColor.GREEN + "Нажмите, чтобы узнать,");
        don_l.add(ChatColor.GREEN + "как купить донат!");
        don_l.add(ChatColor.GRAY + "");
        don_l.add(ChatColor.GREEN + "Click to learn ");
        don_l.add(ChatColor.GREEN + "how to buy donate");
        don_l.add(ChatColor.GRAY + "");
        don_m.setLore(don_l);

        ArrayList<String> d_l = new ArrayList<>();

        d_l.add(ChatColor.GRAY + "");
        d_l.add(ChatColor.WHITE + "Там вы можете общаться с нашими");
        d_l.add(ChatColor.BLUE + "игроками, а также быть вкурсе о");
        d_l.add(ChatColor.RED + "Новостях розыгрышах и т.д. ");
        d_l.add(ChatColor.GRAY + "");
        d_l.add(ChatColor.RED + "There you can communicate with our");
        d_l.add(ChatColor.BLUE + "players, and also to be noticed about");
        d_l.add(ChatColor.RED + "News, events, etc.");
        d_l.add(ChatColor.GRAY + "");
        d_m.setLore(d_l);
        discord.setItemMeta(d_m);



        ArrayList<String> p_l = new ArrayList<>();

        p_l.add(nickname);
        p_l.add(level);
        p_l.add(score);
        p_l.add(expbar);
        p_l.add(money);
        p_l.add(kills);
        p_l.add(deaths);
        p_l.add(playertime);

        donate.setItemMeta(don_m);

        empty_m.setDisplayName(ChatColor.RED + "");
        empty.setItemMeta(empty_m);

        ItemStack profile = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        ItemMeta p_m = profile.getItemMeta();
        p_m.setDisplayName(ChatColor.RED + "Ваш профиль: | Your profile:");
        p_m.setLore(p_l);
        profile.setItemMeta(p_m);
        for(int i = 0; i < 27; i++)
            inv.setItem(i, empty);
        if(user.hasPermission("legendz.sponsor")) {
            ItemStack prefixes = new ItemStack(Material.getMaterial("DECI_ITEMMAPDECI"), 1);
            ItemMeta pref_m = prefixes.getItemMeta();
            ArrayList<String> pref_l = new ArrayList<>();
            pref_m.setDisplayName(ChatColor.YELLOW + "Изменить префикс");
            pref_l.add("");
            pref_l.add(ChatColor.GREEN + "Надоел один и тот-же префикс?");
            pref_l.add(ChatColor.GREEN + "Вы можете поменять его на свой вкус!");
            pref_l.add("");
            pref_l.add(ChatColor.GREEN + "Надоел один и тот-же префикс?");
            pref_l.add(ChatColor.GREEN + "Вы можете поменять его на свой вкус!");
            pref_l.add("");
            pref_m.setLore(pref_l);
            prefixes.setItemMeta(pref_m);
            inv.setItem(14, prefixes);
        }
        inv.setItem(16, discord);
        inv.setItem(15, donate);
        inv.setItem(10, profile);



        if(!(levelUpStudy.equalsIgnoreCase("14") || levelUpStudy.equalsIgnoreCase("14.0"))) {
            if(level.equalsIgnoreCase(ChatColor.RED +"Уровень | Level:"+ ChatColor.GRAY +" 50")) {
                ItemStack PowerUp = new ItemStack(Material.NETHER_STAR, 1);
                ItemMeta PowerUP_M = PowerUp.getItemMeta();
                PowerUP_M.setDisplayName(ChatColor.YELLOW + "Получить награду | Get Reward");
                ArrayList<String> POWERUPL = new ArrayList<>();
                POWERUPL.add("");
                POWERUPL.add(ChatColor.GREEN + "За достижение максимального уровня");
                POWERUPL.add(ChatColor.GREEN + "Вы получите награду и уровень сбросится.");
                POWERUPL.add("");
                POWERUPL.add(ChatColor.GREEN + "For reaching the maximum level");
                POWERUPL.add(ChatColor.GREEN + "You will receive a reward and the");
                POWERUPL.add(ChatColor.GREEN + " level will be reset.");
                POWERUPL.add("");
                PowerUP_M.setLore(POWERUPL);
                PowerUp.setItemMeta(PowerUP_M);
                inv.setItem(13, PowerUp);
            }
        }

        if(levelUpStudy.equalsIgnoreCase("1") || levelUpStudy.equalsIgnoreCase("1.0")) {
            ItemStack rank = new ItemStack(Material.getMaterial("DECI_ITEMPOLICEBATON"), 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Ученик | Pupil");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(11, rank);
        } else if(levelUpStudy.equalsIgnoreCase("2") || levelUpStudy.equalsIgnoreCase("2.0")) {
            ItemStack rank = new ItemStack(Material.getMaterial("DECI_ITEMFIREAXE"), 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Выживший | Survivor");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(11, rank);
        } else if(levelUpStudy.equalsIgnoreCase("3") || levelUpStudy.equalsIgnoreCase("3.0")) {
            ItemStack rank = new ItemStack(Material.getMaterial("DECI_REDDOT"), 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Бандит | Bandit");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(11, rank);
        } else if(levelUpStudy.equalsIgnoreCase("4") || levelUpStudy.equalsIgnoreCase("4.0")) {
            ItemStack rank = new ItemStack(Material.getMaterial("DECI_ITEMCOMBATKNIFE"), 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Наёмник | Mercenary");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(11, rank);
        } else if(levelUpStudy.equalsIgnoreCase("5") || levelUpStudy.equalsIgnoreCase("5.0")) {
            ItemStack rank = new ItemStack(Material.getMaterial("DECI_POLICEVEST"), 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Опытный | Experienced");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(11, rank);
        } else if(levelUpStudy.equalsIgnoreCase("6") || levelUpStudy.equalsIgnoreCase("6.0")) {
            ItemStack rank = new ItemStack(Material.EMERALD, 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Герой | Hero");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(11, rank);
        } else if(levelUpStudy.equalsIgnoreCase("7") || levelUpStudy.equalsIgnoreCase("7.0")) {
            ItemStack rank = new ItemStack(Material.getMaterial(""), 1);
            ItemMeta rank_m = rank.getItemMeta();
            rank_m.setDisplayName(ChatColor.YELLOW + "Звание | Rank:");
            ArrayList<String> rank_l = new ArrayList<>();
            rank_l.add(ChatColor.GRAY + "   Герой | Hero");
            rank_m.setLore(rank_l);
            rank.setItemMeta(rank_m);
            inv.setItem(11, rank);
        }

        user.openInventory(inv);
    }

}
