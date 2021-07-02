package me.zuveno.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class menu implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        if(sender instanceof Player) {
            Player user = (Player) sender;
            me.zuveno.menus.menu menu = new me.zuveno.menus.menu();
            menu.loadGUI(user);
        }
        return false;
    }
}
