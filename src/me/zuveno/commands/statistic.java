package me.zuveno.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import me.zuveno.legendz;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class statistic implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

        Economy econ = legendz.getEconomy();
        if (args.length == 0) {
            sender.sendMessage("[" + ChatColor.RED + "LZ" + ChatColor.BLUE + "M" + ChatColor.WHITE + "] Error! Player not specified!");
        } else {
            Player user = Bukkit.getPlayer(args[0]);
            if (sender instanceof Player) {
                Player sendr = (Player) sender;
                if (user.hasPlayedBefore()) {
                    me.zuveno.menus.statistic s = new me.zuveno.menus.statistic();
                    s.loadGUI(sendr, user);
                } else {
                    sendr.sendMessage("[" + ChatColor.RED + "LZ" + ChatColor.BLUE + "M" + ChatColor.WHITE + "] Error! Player doesn`t exist!");
                }
            } else {
                if (user.hasPlayedBefore()) {
                    String levelUpStudy = PlaceholderAPI.setPlaceholders(user, "%mycommand_playerdata_levelupstudy%");
                    String level = PlaceholderAPI.setPlaceholders(user, "Уровень | Level: %battlelevels_level%");
                    String score = PlaceholderAPI.setPlaceholders(user, "Опыт | Exp: %battlelevels_score%/%battlelevels_neededfornext%");
                    if (levelUpStudy.equalsIgnoreCase("1")) {
                        System.out.println(ChatColor.YELLOW + "Звание | Rank: Ученик | Pupil");
                    } else if (levelUpStudy.equalsIgnoreCase("2")) {
                        System.out.println(ChatColor.YELLOW + "Звание | Rank: Бандит | Bandit");
                    } else if (levelUpStudy.equalsIgnoreCase("3")) {
                        System.out.println(ChatColor.YELLOW + "Звание | Rank: Мафия | Mafia");
                    } else if (levelUpStudy.equalsIgnoreCase("4")) {
                        System.out.println(ChatColor.YELLOW + "Звание | Rank: Лидер | Leader");
                    } else if (levelUpStudy.equalsIgnoreCase("5")) {
                        System.out.println(ChatColor.YELLOW + "Звание | Rank: Босс этой качалки | Boss of this gym");
                    }
                    String money = "Баланс | Balance: " + econ.format(econ.getBalance(user));

                    String kills = PlaceholderAPI.setPlaceholders(user, "Убийств | Kills: " + user.getStatistic(Statistic.PLAYER_KILLS));
                    String deaths = PlaceholderAPI.setPlaceholders(user, "Смертей | Deaths: " + user.getStatistic(Statistic.DEATHS));
                    String playertime = PlaceholderAPI.setPlaceholders(user, "Сыграно | Played: " + user.getStatistic(Statistic.PLAY_ONE_TICK) / 72000) + " час(ов) | Hour(s)";
                    System.out.println("Статистика игрока " + user.getDisplayName());
                    if (user.isOnline())
                        System.out.println("Статус | Status: В сети");
                    else
                        System.out.println("Статус | Status: Не в сети");
                    System.out.println(level);
                    System.out.println(score);
                    System.out.println(money);
                    System.out.println(kills);
                    System.out.println(deaths);
                    System.out.println(playertime);
                } else {
                    System.out.println("[LZM] Error! Player doesn`t exist!");
                }
            }
        }
        return false;
    }
}
