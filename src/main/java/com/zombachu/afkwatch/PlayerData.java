package com.zombachu.afkwatch;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.UUID;

public class PlayerData {

    private UUID pID;
    private Location lastLocation;
    private int index;

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

    public int getIndex() {
        return index;
    }

    public void setIndex(int lastIndex) {
        this.index = lastIndex;
    }

    public static PlayerDataPoint createDataPoint(Location loc1, Location loc2) {
        double deltaX = loc1.getX() - loc2.getX();
        double deltaY = loc1.getY() - loc2.getY();
        double deltaZ = loc1.getZ() - loc2.getZ();
        float deltaPitch = loc1.getPitch() - loc2.getPitch();
        float deltaYaw = loc1.getYaw() - loc2.getYaw();

        return new PlayerDataPoint(deltaX, deltaY, deltaZ, deltaPitch, deltaYaw);
    }

    public void save(Location location) {
        YamlConfiguration config;

        File dataFolder = AFKWatch.getPlugin().getDataFolder();
        File file = new File(dataFolder, pID + ".yml");
        try {
            config = YamlConfiguration.loadConfiguration(file);
        }
        catch (Exception e) {
            config = new YamlConfiguration();
            e.printStackTrace();
        }

        PlayerDataPoint dataPoint = createDataPoint(lastLocation, location);
        config.createSection("" + index, dataPoint.serialize());

        try {
            config.save(file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        lastLocation = location;
        index++;
    }
}
