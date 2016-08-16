package com.zombachu.afkwatch;

import org.bukkit.Location;

import java.util.UUID;

public class PlayerData {

    UUID pID;
    Location lastLocation;

    public PlayerData(UUID pID) {
        this.pID = pID;
    }

    public UUID getID() {
        return pID;
    }

    public Location getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(Location lastLocation) {
        this.lastLocation = lastLocation;
    }
}
