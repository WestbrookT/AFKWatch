package com.zombachu.afkwatch;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AFKWatch extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getScheduler().runTaskTimer(this, new Poller(), 0, 40);
    }

    @Override
    public void onDisable() {

    }

    public static AFKWatch getPlugin() {
        return AFKWatch.getPlugin(AFKWatch.class);
    }
}
