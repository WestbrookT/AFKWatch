package com.zombachu.afkwatch;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.UUID;

public class PlayerData {

    private UUID pID;
    private Location lastLocation;
    private int lastIndex;

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

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public void save(PlayerDataPoint dataPoint) {
        YamlConfiguration config;

        File file = new File(AFKWatch.getPlugin().getDataFolder().getPath() + File.pathSeparator + pID + ".yml");
        try {
            config = YamlConfiguration.loadConfiguration(file);
        }
        catch (Exception e) {
            config = new YamlConfiguration();
            e.printStackTrace();
        }

        config.createSection("" + dataPoint.getIndex(), dataPoint.serialize());

        try {
            config.save(file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
