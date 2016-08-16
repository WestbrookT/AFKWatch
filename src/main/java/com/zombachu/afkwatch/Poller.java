package com.zombachu.afkwatch;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Poller implements Runnable {

    private DataManager dm = DataManager.getInstance();

    @Override
    public void run() {
        for (Player p: Bukkit.getOnlinePlayers()) {
            PlayerData data = dm.getCachedPlayerData(p.getUniqueId());
            data.save(p.getLocation());
        }
    }
}
