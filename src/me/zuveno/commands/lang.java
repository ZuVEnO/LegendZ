package me.zuveno.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import me.zuveno.menus.locale;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class lang implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        if(!(sender instanceof Player)) {
            if(args.length == 1) {
                Player user = Bukkit.getPlayer(args[0]);
                String papi = PlaceholderAPI.setPlaceholders(user, "%mycommand_playerdata_locale%");
                locale lc = new locale();
                if(!(papi.equalsIgnoreCase("en") || !papi.equalsIgnoreCase("ru"))) {
                    lc.loadGUI(user);
                }
            }
        } else {
            sender.sendMessage("Иди нахуй э");
        }
        return false;
    }

}
