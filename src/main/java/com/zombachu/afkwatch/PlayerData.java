package com.zombachu.afkwatch;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayerData {

    private Location moveLocation;
    private long moveTime;

    /**
     * Poll every 2 seconds
     * Group by 30 seconds
     */

    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerData data = new PlayerData();

            Location currentLocation = player.getLocation();
            // Calculate delta between data.getMoveLocation() and currentLocation then store it
        }
    }

    public Location getMoveLocation() {
        return moveLocation;
    }

    public void setMoveLocation(Location moveLocation) {
        this.moveLocation = moveLocation;
    }

    public long getMoveTime() {
        return moveTime;
    }

    public void setMoveTime(long moveTime) {
        this.moveTime = moveTime;
    }
}
