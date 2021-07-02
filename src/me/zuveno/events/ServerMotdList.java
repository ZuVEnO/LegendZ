package me.zuveno.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerMotdList implements Listener {

    @EventHandler
    public void onServer(ServerListPingEvent e) {
        e.setMotd("\u00A7a\u00A7lLegendZ  - \u00A74\u00A7lRU \u00A79EU \u00A7e\u00A7l[CRACKED] \n \u00A7cPyC CEPBEP \u00A7eCUSTOM TRADERS / AUCTION / ANTI-CHEAT TOP 1");
        e.setMaxPlayers(50);
    }

}
