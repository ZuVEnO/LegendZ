package me.zuveno.events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.robin.battlelevels.api.BattleLevelsAPI;
import me.zuveno.legendz;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerKillEvent implements Listener {

    @EventHandler
    public void onEntityKillEvent(EntityDeathEvent e) {
        Entity trup = e.getEntity();
        Player user = e.getEntity().getKiller();
        TextComponent NW_Hover = new TextComponent();
        NW_Hover.setText("Вы получили достижение " + "[" + ChatColor.GRAY + "Живой, но мёртвый" + ChatColor.WHITE + "]");
        String NW_Dis = "[" + ChatColor.GRAY + "Живой, но мёртвый" + ChatColor.WHITE + "]\nУбейте первого своего зомби.";
        NW_Hover.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(NW_Dis).create()));
        TextComponent SS_Hover = new TextComponent();
        SS_Hover.setText("Вы получили достижение " + "[" + ChatColor.DARK_PURPLE + "Орущая мразь" + ChatColor.WHITE + "]");
        String SS_Dis = "[" + ChatColor.DARK_PURPLE + "Орущая мразь" + ChatColor.WHITE + "]\nВпервые убейте зеваку с\nоглушением своего слуха.";
        SS_Hover.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(SS_Dis).create()));
        TextComponent SSBC_Hover = new TextComponent();
        SSBC_Hover.setText("Игрок " + user.getDisplayName() + " получил достижение " + "[" + ChatColor.DARK_PURPLE + "Орущая мразь" + ChatColor.WHITE + "]");
        String SSBC_Dis = "[" + ChatColor.DARK_PURPLE + "Орущая мразь" + ChatColor.WHITE + "]\nВпервые убейте зеваку с\nоглушением своего слуха.";
        SSBC_Hover.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(SS_Dis).create()));
        String Ac_FirstZombie = PlaceholderAPI.setPlaceholders(user, "%mycommand_playerdata_ACHIEVfirstzombie%");
        String Ac_ShoutShit = PlaceholderAPI.setPlaceholders(user, "%mycommand_playerdata_ACHIEVshoutshit%");
        if (trup.getType().getName().equalsIgnoreCase("deci-Gawker") && !Ac_ShoutShit.equalsIgnoreCase("true")) {
            user.sendMessage(ChatColor.GREEN + "+5.0EXP" + ChatColor.WHITE + " (Получено достижение | Received achievement)");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getName() + " ACHIEVshoutshit true");
            user.spigot().sendMessage(SS_Hover);
            for(Player p : Bukkit.getOnlinePlayers())
                p.spigot().sendMessage(SSBC_Hover);
            BattleLevelsAPI.addScore(user.getUniqueId(), 5.0d, true);
            user.playSound(user.getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
        }
        if (!Ac_FirstZombie.equalsIgnoreCase("true"))
            user.sendMessage(ChatColor.GREEN + "+5EXP" + ChatColor.WHITE + " (Получено достижение | Received achievement)");
            if (user instanceof Player) {
                if (trup.getType().getName().equalsIgnoreCase("deci-InfectedDog")) {
                    user.playSound(user.getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getName() + " ACHIEVfirstzombie true");
                    user.spigot().sendMessage(NW_Hover);
                } else if (trup.getType().getName().equalsIgnoreCase("deci-Infected")) {
                    user.playSound(user.getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getName() + " ACHIEVfirstzombie true");
                    user.spigot().sendMessage(NW_Hover);
                    BattleLevelsAPI.addScore(user.getUniqueId(), 5.0d, true);
                } else if (trup.getType().getName().equalsIgnoreCase("deci-Bloater")) {
                    user.playSound(user.getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
                    BattleLevelsAPI.addScore(user.getUniqueId(), 5.0d, true);
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getName() + " ACHIEVfirstzombie true");
                    user.spigot().sendMessage(NW_Hover);
                } else if (trup.getType().getName().equalsIgnoreCase("deci-Hulk")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getName() + " ACHIEVfirstzombie true");
                    user.spigot().sendMessage(NW_Hover);
                    BattleLevelsAPI.addScore(user.getUniqueId(), 5.0d, true);
                    user.playSound(user.getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
                } else if (trup.getType().getName().equalsIgnoreCase("deci-Crawler")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getName() + " ACHIEVfirstzombie true");
                    user.spigot().sendMessage(NW_Hover);
                    BattleLevelsAPI.addScore(user.getUniqueId(), 5.0d, true);
                    user.playSound(user.getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
                } else if (trup.getType().getName().equalsIgnoreCase("deci-Frail")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getName() + " ACHIEVfirstzombie true");
                    user.spigot().sendMessage(NW_Hover);
                    BattleLevelsAPI.addScore(user.getUniqueId(), 5.0d, true);
                    user.playSound(user.getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
                }
            }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player user = e.getEntity();
        Entity kira = user.getKiller();
        Player killer = user.getKiller();
        TextComponent DFT_Hover = new TextComponent();

        String AC_Killer = PlaceholderAPI.setPlaceholders(killer, "%mycommand_playerdata_ACHIEVkiller%");
        TextComponent ACK_Hover = new TextComponent();
        ACK_Hover.setText("Вы получили достижение " + "[" + ChatColor.YELLOW + "Киллер" + ChatColor.WHITE + "]");
        String ACK_Dis = "[" + ChatColor.YELLOW + "Киллер" + ChatColor.WHITE + "]\nУбейте 32 игрока с помощью ножа";
        ACK_Hover.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ACK_Dis).create()));

        if(!AC_Killer.equalsIgnoreCase("true")) {
            if(legendz.KillsWithKnife.containsKey(killer.getUniqueId())) {
                legendz.KillsWithKnife.put(killer.getUniqueId(), legendz.KillsWithKnife.get(killer.getUniqueId())+1);
                if(legendz.KillsWithKnife.get(killer.getUniqueId()) == 32) {
                    user.sendMessage(ChatColor.GREEN + "+5EXP" + ChatColor.WHITE + " (Получено достижение | Received achievement)");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getName() + " ACHIEVfirstdead true");
                    user.spigot().sendMessage(ACK_Hover);
                    BattleLevelsAPI.addScore(user.getUniqueId(), 5.0d, true);
                    user.playSound(user.getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
                }
            }
        }
        DFT_Hover.setText("Вы получили достижение " + "[" + ChatColor.AQUA + "Я маслину поймал!" + ChatColor.WHITE + "]");
        String FDT_Dis = "Вы получили достижение " + "[" + ChatColor.AQUA + "Я маслину поймал!" + ChatColor.WHITE + "]\nУмрите от игрока";
        DFT_Hover.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(FDT_Dis).create()));
        TextComponent FD_Hover = new TextComponent();
        FD_Hover.setText("Вы получили достижение " + "[" + ChatColor.DARK_PURPLE + "У вас пропущенный" + ChatColor.WHITE + "]");
        String FD_Dis = "[" + ChatColor.DARK_PURPLE + "У вас пропущенный" + ChatColor.WHITE + "]\nУбейте игрока с оружия\nBarret 50cal";
        FD_Hover.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(FD_Dis).create()));
        String AC_FirstDead = PlaceholderAPI.setPlaceholders(killer, "%mycommand_playerdata_ACHIEVfirstdead%");
        String AC_FirstDeathTime = PlaceholderAPI.setPlaceholders(killer, "%mycommand_playerdata_ACHIEVfirstdeathtime%");
        if (!AC_FirstDead.equalsIgnoreCase("true") && killer.getItemInHand().getType().equals(Material.getMaterial("DECI_BARRETT"))) {
            user.sendMessage(ChatColor.GREEN + "+5EXP" + ChatColor.WHITE + " (Получено достижение | Received achievement)");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getName() + " ACHIEVfirstdead true");
            user.spigot().sendMessage(FD_Hover);
            BattleLevelsAPI.addScore(user.getUniqueId(), 5.0d, true);
            user.playSound(user.getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
        }
        if(!AC_FirstDeathTime.equalsIgnoreCase("true")) {
            user.sendMessage(ChatColor.GREEN + "+5EXP" + ChatColor.WHITE + " (Получено достижение | Received achievement)");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getName() + " ACHIEVfirstdeathtime true");
            user.spigot().sendMessage(DFT_Hover);
            BattleLevelsAPI.addScore(user.getUniqueId(), 5.0d, true);
            user.playSound(user.getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
        }
    }

    @EventHandler
    public void onEntityHit(EntityDamageByEntityEvent e) {
        Player user = (Player) e.getDamager();
        Player damagnyt = (Player) e.getEntity();
        String AC_GotDamaged = PlaceholderAPI.setPlaceholders(user, "%mycommand_playerdata_ACHIEVgotdamaged%");
        TextComponent NW_Hover = new TextComponent();
        NW_Hover.setText("Вы получили достижение " + "[" + ChatColor.AQUA + "Есть пробитие" + ChatColor.WHITE + "]");
        String NW_Dis = "[" + ChatColor.AQUA + "Есть пробитие" + ChatColor.WHITE + "]\nДайте урон игроку с частью\nот комплекта брони Джаггернаута.";
        NW_Hover.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(NW_Dis).create()));
        if (!AC_GotDamaged.equalsIgnoreCase("true") &&
                (damagnyt.getInventory().getHelmet().getType().equals(Material.getMaterial("DECI_JUGGERNAUTHELM")) ||
                damagnyt.getInventory().getHelmet().getType().equals(Material.getMaterial("DECI_JUGGERNAUTHELMGRAY"))) && (
                damagnyt.getInventory().getChestplate().getType().equals(Material.getMaterial("DECI_JUGGERNAUTVEST")) ||
                        damagnyt.getInventory().getChestplate().getType().equals(Material.getMaterial("DECI_JUGGERNAUTVESTGRAY"))) && (
                damagnyt.getInventory().getLeggings().getType().equals(Material.getMaterial("DECI_JUGGERNAUTPANTS")) ||
                        damagnyt.getInventory().getLeggings().getType().equals(Material.getMaterial("DECI_JUGGERNAUTPANTSGRAY"))) &&
                (damagnyt.getInventory().getBoots().getType().equals(Material.getMaterial("DECI_JUGGERNAUTBOOTS")) ||
                damagnyt.getInventory().getBoots().getType().equals(Material.getMaterial("DECI_JUGGERNAUTBOOTSGRAY")))) {
            user.playSound(user.getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
            BattleLevelsAPI.addScore(user.getUniqueId(), 5.0d, true);
            user.sendMessage(ChatColor.GREEN + "+5EXP" + ChatColor.WHITE + " (Получено достижение | Received achievement)");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getName() + " ACHIEVgotdamaged true");
            user.spigot().sendMessage(NW_Hover);
        }
    }

}