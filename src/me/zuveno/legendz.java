package me.zuveno;

import me.zuveno.commands.lang;
import me.zuveno.commands.statistic;
import me.zuveno.events.*;
import me.zuveno.runnables.bayonetRemover;
import net.milkbowl.vault.economy.Economy;
import me.zuveno.commands.menu;
import me.zuveno.runnables.autoMessage;
import me.zuveno.runnables.autoSaveWorld;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class legendz extends JavaPlugin {

    public static HashMap<UUID, Integer> KillsWithKnife = new HashMap<UUID, Integer>();

    private static Economy econ;
    PluginManager plMgr = Bukkit.getServer().getPluginManager();

    @Override
    public void onEnable() {
        System.out.println("====================");
        System.out.println("= LegendZ  Manager =");
        System.out.println("=      Plugin      =");
        System.out.println("=====By==ZuVEnO=====");
        if(!setupEconomy()) {
            System.out.println("Я ебу тому ебало блять! [SUKAxVAUTLT]");
            plMgr.disablePlugin(this);
        }
        try {
            plMgr.registerEvents(new JoinLeaveEvent(), this);
            System.out.println("[LZM] Ивент JoinLeaveEvent зарегестрировался!");
        } catch (Exception e) {
            System.out.println("Я ебу тому ебало блять! [0754x34]");
            e.printStackTrace();
            plMgr.disablePlugin(this);
        }
        try {
            plMgr.registerEvents(new ServerMotdList(), this);
            System.out.println("[LZM] Ивент ServerMotdList зарегестрировался!");
        } catch (Exception e) {
            System.out.println("Я ебу тому ебало блять! [7843x77]");
            e.printStackTrace();
            plMgr.disablePlugin(this);
        }
        try {
            plMgr.registerEvents(new InteractEvent(), this);
            System.out.println("[LZM] Ивент InteractEvent зарегестрировался!");
        } catch (Exception e) {
            System.out.println("Я ебу тому ебало блять! [8155x12]");
            e.printStackTrace();
            plMgr.disablePlugin(this);
        }
        try {
            plMgr.registerEvents(new PlayerKillEvent(), this);
            System.out.println("[LZM] Ивент PlayerKillEvent зарегестрировался!");
        } catch (Exception e) {
            System.out.println("Я ебу тому ебало блять! [0321x13]");
            e.printStackTrace();
            plMgr.disablePlugin(this);
        }
        try {
            plMgr.registerEvents(new PlayerMenuEvent(), this);
            System.out.println("[LZM] Ивент PlayerMenuEvent зарегестрировался!");
        } catch (Exception e) {
            System.out.println("Я ебу тому ебало блять! [6753x00]");
            e.printStackTrace();
            getServer().shutdown();
        }
        try {
            this.getCommand("menu").setExecutor(new menu());
            System.out.println("[LZM] Команда menu зарегестрировался!");
        } catch (Exception e) {
            System.out.println("Я ебу тому ебало блять! [7854x34]");
            e.printStackTrace();
            plMgr.disablePlugin(this);
        }
        try {
            this.getCommand("statistic").setExecutor(new statistic());
            System.out.println("[LZM] Команда statistic зарегестрировался!");
        } catch (Exception e) {
            System.out.println("Я ебу тому ебало блять! [3906x11]");
            e.printStackTrace();
            plMgr.disablePlugin(this);
        }
        this.getCommand("lang").setExecutor(new lang());
        System.out.println("[LZM] Команда lang зарегестрировался!");
        System.out.println("[LZM] Запускаем авто-сохранение...");
        new autoSaveWorld().runTaskTimer(this, 0, 5 * 60 * 20);
        System.out.println("[LZM] Запускаем авто-рекламировщик...");
        new autoMessage().runTaskTimer(this, 0, 30 * 20);
        System.out.println("[LZM] Запуск фильтрации байянэта...");
        new bayonetRemover().runTaskTimer(this, 0, 20 * 20);
    }

    @Override
    public void onDisable() {
        Bukkit.broadcastMessage(ChatColor.YELLOW + "Сохранение... | Saving...");
        World w = Bukkit.getWorld("world");
        w.save();
        Bukkit.broadcastMessage(ChatColor.YELLOW + "Сохранение завершено! | Saved!");
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }
    
}
