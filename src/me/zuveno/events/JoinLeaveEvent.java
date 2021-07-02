package me.zuveno.events;

import litebans.api.Database;
import me.clip.placeholderapi.PlaceholderAPI;
import me.egg82.antivpn.api.VPNAPI;
import me.egg82.antivpn.api.VPNAPIProvider;
import me.robin.battlelevels.api.BattleLevelsAPI;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveEvent implements Listener {

    private String Ac_NewPlayer;

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        e.getPlayer().saveData();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player user = e.getPlayer();
        Ac_NewPlayer = PlaceholderAPI.setPlaceholders(user, "%mycommand_playerdata_ACHIEVnewplayer%");
        if(!Ac_NewPlayer.equalsIgnoreCase("true")) {
            user.playSound(user.getLocation(), Sound.VILLAGER_YES, 1.0f , 1.0f);
            BattleLevelsAPI.addScore(user.getUniqueId(), 5.0d, true);
            user.sendMessage(ChatColor.GREEN + "+5.0EXP" + ChatColor.WHITE + " (Получено достижение | Received achievement)");
            TextComponent NW_Hover = new TextComponent();
            NW_Hover.setText("Вы получили достижение " + "[" + ChatColor.GRAY + "С новобранцем!" + ChatColor.WHITE + "]");
            String NW_Dis = "[" + ChatColor.GRAY + "С новобранцем!" + ChatColor.WHITE + "]" + "\n" + "Зайдите впервые на сервер LegendZ";
            NW_Hover.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(NW_Dis).create()));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getName() + " ACHIEVnewplayer true");
            user.spigot().sendMessage(NW_Hover);
        }
    }

}
