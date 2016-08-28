package com.zombachu.afkwatch;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class AFKWatch extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getScheduler().runTaskTimer(this, new Poller(), 0, 40);
    }

    @Override
    public void onDisable() {
        DataManager dm = DataManager.getInstance();
        for (Player p : Bukkit.getOnlinePlayers()) {
            UUID pID = p.getUniqueId();
            dm.getCachedPlayerData(pID).save();
            dm.uncachePlayerData(pID);
        }
    }

    public static AFKWatch getPlugin() {
        return AFKWatch.getPlugin(AFKWatch.class);
    }
}
