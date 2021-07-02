package me.zuveno.runnables;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class autoMessage extends BukkitRunnable {

    @Override
    public void run() {
        String f1 = "&e[&c✉&e]&eЗалетай к нам в группу в дискорде там много чего интересного » &b&lhttps://discord.com/invite/yncCuFb";
        String f2 = "&e[&c✉&e]&e&lКупить  донат можно  на нашем сайте-&c&llegendz-decimation.easydonate.ru";
        String f3 = "&e[&c✉&e]&eУважаемые Игроки, если вам понравился сервер, не поленитесь пригласить друзей, таким образом вы повысите онлайн, и будет куда интереснее играть!";
        String f4 = "&e[&c✉&e]&eЕсли вы обнаружили подозрительного игрока, пишите &7/report &8NICK Причина";
        String f5 = "&e[&c✉&e]&4&lУважаемые игроки , на сервере запрещено использывать мини-карту, ресурспаки с прозрачными текстурами!! За не соблюдения правил вы получите БАН!!";
        String f6 = "&e[&c✉&e]&eНа сервере есть своё меню. Напиши команду &7&l/menu &e, что бы открыть  меню сервера.";
        String f7 = "&e[&c✉&e]&eЧто бы посмотреть свой баланс напишите &8&l/balance &e. Что бы передать лозы другому игроку напишите &8&l/pay ник количество лозов";
        String f8 = "&e[&c✉&e]&eДобавляй наш сервер в  &6&lOther Servers  &eвот айпи - &f&llz.&b&ljoinserver&4&l.xyz";
        String f9 = "&e[&c✉&e]&eУ нас есть свой уникальный тектстурпак который улучшает мод - &2&lhttps://drive.google.com/file/d/1eQnsGpI3aNrqPfQ9gbj-51WgTXPCbyvB/view?usp=sharing";
        String f10 = "&e[&c✉&e]&eЗалетай к нам в группу в дискорде там много чего интересного » &b&lhttps://discord.com/invite/yncCuFb&7";
        String f11 = "&e[&c✉&e]&e&lYou can buy donate in our discord &c&lhttps://discord.com/invite/yncCuFb";
        String f12 = "&e[&c✉&e]&eDear Players, if you liked the server, do not be lazy to invite friends, this way you will increase online, and it will be much more interesting to play";
        String f13 = "&e[&c✉&e]&eIf you find a suspicious player, write &7/report &8NICK Cause";
        String f14 = "&e[&c✉&e]&4&lDear players, it is forbidden to use a mini-map on the server, resource packs with transparent textures !! For not following the rules, you will receive BAN!!";
        String f15 = "&e[&c✉&e]&eThe server has its own menu. Write the command &7&l/menu &e to open the menu server.";
        String f16 = "&e[&c✉&e]&eTo see your balance write &8&l/balance &e. To convey vines write to another player &8&l /pay nickname number of vines";
        String f17 = "&e[&c✉&e]&eAdd our server to &6Other Servers &ehere`s the ip- &f&llz.&b&ljoinserver&4&l.xyz";
        String f18 = "&e[&c✉&e] &eTo sell an item at auction write &8/ah sell price in vines";
        String f19 = "&e[&c✉&e] &eЧто бы продать предмет на аукционе напишите /ah sell цена в лозах";
        String f20 = "&e[&c✉&e] &eЧто бы продать предмет на аукционе напишите /ah sell цена в лозах";
        String f21 = "&e[&c✉&e] &eIn the city of survivors, you can buy your own house or apartment. There you can store your belongings. You can buy by clicking on the signs in the city.";
        String f22 = "&e[&c✉&e] &eВ городе выживших можно купить себе свой дом или квартиру. Там вы сможете хранить свои вещи. Купить можно нажав на таблички в городе.";

        Random rand = new Random();
        int r = rand.nextInt(22);
        if(r == 0)
            for(Player user : Bukkit.getOnlinePlayers())
            user.sendMessage(ChatColor.translateAlternateColorCodes('&', f1));
        if(r == 1)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f2));
        if(r == 2)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f3));
        if(r == 3)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f4));
        if(r == 4)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f5));
        if(r == 5)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f6));
        if(r == 6)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f7));
        if(r == 7)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f8));
        if(r == 8)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f9));
        if(r == 9)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f10));
        if(r == 10)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f11));
        if(r == 11)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f12));
        if(r == 12)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f13));
        if(r == 13)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f14));
        if(r == 14)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f15));
        if(r == 15)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f15));
        if(r == 16)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f16));
        if(r == 17)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f17));
        if(r == 18)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f18));
        if(r == 19)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f19));
        if(r == 20)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f20));
        if(r == 21)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f21));
        if(r == 22)
            for(Player user : Bukkit.getOnlinePlayers())
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', f22));

    }

}
