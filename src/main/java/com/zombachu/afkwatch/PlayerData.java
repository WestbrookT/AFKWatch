package com.zombachu.afkwatch;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.junit.experimental.theories.DataPoint;

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

    public static PlayerDataPoint createDataPoint(Location old, Location recent) {
        double deltaX = old.getX() - recent.getX();
        double deltaY = old.getY() - recent.getY();
        double deltaZ = old.getZ() - recent.getZ();

        float deltaPi = old.getPitch() - recent.getPitch();
        float deltaYa = old.getYaw() - recent.getYaw();

        PlayerDataPoint dataPoint = new PlayerDataPoint(deltaX, deltaY, deltaZ, deltaPi, deltaYa);

        return dataPoint;
    }

    public void save(Location location) {
        YamlConfiguration config;

        File file = new File(AFKWatch.getPlugin().getDataFolder().getPath() + File.pathSeparator + pID + ".yml");
        try {
            config = YamlConfiguration.loadConfiguration(file);
        }
        catch (Exception e) {
            config = new YamlConfiguration();
            e.printStackTrace();
        }

        index++;

        PlayerDataPoint dataPoint = createDataPoint(lastLocation, location);

        config.createSection("" + index, dataPoint.serialize());

        try {
            config.save(file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
