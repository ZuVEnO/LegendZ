package me.zuveno.events;

import com.sun.xml.internal.ws.api.Component;
import me.clip.placeholderapi.PlaceholderAPI;
import me.robin.battlelevels.api.BattleLevelsAPI;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class InteractEvent implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player user = e.getPlayer();
		Inventory uInv = user.getInventory();
		Block lut = e.getClickedBlock();
		String Ac_NewPlayer = PlaceholderAPI.setPlaceholders(user, "%mycommand_playerdata_ACHIEVfirstloot%");
		if (!Ac_NewPlayer.equalsIgnoreCase("true"))
			if (lut.getType().equals(Material.CHEST)) {
				user.playSound(user.getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
				BattleLevelsAPI.addScore(user.getUniqueId(), 5.0d, true);
				user.sendMessage(ChatColor.GREEN + "+5.0EXP" + ChatColor.WHITE + " (Получено достижение | Received achievement)");
				TextComponent NW_Hover = new TextComponent();
				NW_Hover.setText("Вы получили достижение " + "[" + ChatColor.GRAY + "Вещи кто-то не разобрал" + ChatColor.WHITE + "]");
				String NW_Dis = "[" + ChatColor.GRAY + "Вещи кто-то не разобрал" + ChatColor.WHITE + "]" + "\n" + "Найдите лут в сундуке.";
				NW_Hover.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(NW_Dis).create()));
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getName() + " ACHIEVfirstloot true");
				user.spigot().sendMessage(NW_Hover);
			}
		String AC_BestComplect = PlaceholderAPI.setPlaceholders(user, "%mycommand_playerdata_ACHIEVbestcomplect%");
		TextComponent BC_Hover = new TextComponent();
		BC_Hover.setText("Вы получили достижение " + "[" + ChatColor.DARK_PURPLE + "Вооружен, опасен и прекрасен" + ChatColor.WHITE + "]");
		String BC_Dis = "[" + ChatColor.DARK_PURPLE + "Вооружен, опасен и прекрасен" + ChatColor.WHITE + "]\nНаденьте полный комплект брони\nджаггернаута.";
		BC_Hover.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(BC_Dis).create()));
		if (!AC_BestComplect.equalsIgnoreCase("true") &&
				(user.getInventory().getHelmet().getType().equals(Material.getMaterial("DECI_JUGGERNAUTHELM")) ||
						user.getInventory().getHelmet().getType().equals(Material.getMaterial("DECI_JUGGERNAUTHELMGRAY"))) && (
				user.getInventory().getChestplate().getType().equals(Material.getMaterial("DECI_JUGGERNAUTVEST")) ||
						user.getInventory().getChestplate().getType().equals(Material.getMaterial("DECI_JUGGERNAUTVESTGRAY"))) && (
				user.getInventory().getLeggings().getType().equals(Material.getMaterial("DECI_JUGGERNAUTPANTS")) ||
						user.getInventory().getLeggings().getType().equals(Material.getMaterial("DECI_JUGGERNAUTPANTSGRAY"))) &&
				(user.getInventory().getBoots().getType().equals(Material.getMaterial("DECI_JUGGERNAUTBOOTS")) ||
						user.getInventory().getBoots().getType().equals(Material.getMaterial("DECI_JUGGERNAUTBOOTSGRAY")))) {
			user.playSound(user.getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
			BattleLevelsAPI.addScore(user.getUniqueId(), 5.0d, true);
			user.sendMessage(ChatColor.GREEN + "+5EXP" + ChatColor.WHITE + " (Получено достижение | Received achievement)");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mycmd-playerdata set " + user.getName() + " ACHIEVbestcomplect true");
			user.spigot().sendMessage(BC_Hover);
		}
		uInv.remove(Material.getMaterial("DECI_BAYONET"));
	}


}