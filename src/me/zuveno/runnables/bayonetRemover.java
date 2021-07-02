package me.zuveno.runnables;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class bayonetRemover extends BukkitRunnable {


    @Override
    public void run() {
        for(Player p : Bukkit.getOnlinePlayers())
            p.getInventory().remove(Material.getMaterial("DECI_BAYONET"));
    }
}
