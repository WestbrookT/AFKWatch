package com.zombachu.afkwatch;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    DataManager dm = DataManager.getInstance();

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        PlayerData data = new PlayerData(event.getPlayer().getUniqueId());
        dm.cachePlayerData(data);
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) {
        dm.uncachePlayerData(event.getPlayer().getUniqueId());
    }

}
