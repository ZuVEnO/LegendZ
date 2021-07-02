package me.zuveno.runnables;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class autoSaveWorld extends BukkitRunnable {

    @Override
    public void run() {
        Bukkit.broadcastMessage(ChatColor.YELLOW + "Сохранение... | Saving...");
        World w = Bukkit.getWorld("world");
        w.save();
        Bukkit.broadcastMessage(ChatColor.YELLOW + "Сохранение завершено! | Saved!");
    }

}
