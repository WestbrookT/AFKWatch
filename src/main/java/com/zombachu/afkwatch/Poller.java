package com.zombachu.afkwatch;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Poller implements Runnable {

    private DataManager dm = DataManager.getInstance();

    @Override
    public void run() {
        for (Player p: Bukkit.getOnlinePlayers()) {
            dm.getCachedPlayerData(p.getUniqueId()).save(p.getLocation());
        }
    }
}
