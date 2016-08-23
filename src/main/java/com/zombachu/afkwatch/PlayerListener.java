package com.zombachu.afkwatch;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class PlayerListener implements Listener {

    private DataManager dm = DataManager.getInstance();

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PlayerData data = new PlayerData(player.getUniqueId());
        data.setLastLocation(player.getLocation());

        dm.cachePlayerData(data);
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) {
        UUID pID = event.getPlayer().getUniqueId();
        dm.getCachedPlayerData(pID).save();
        dm.uncachePlayerData(pID);
    }

}
