package com.zombachu.afkwatch;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class PlayerData {

    private UUID pID;
    private Location lastLocation;
    private int index;

    private int baseIndex;
    private List<PlayerDataPoint> dataPoints;

    public PlayerData(UUID pID) {
        this.pID = pID;
        this.dataPoints = new ArrayList<>();
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

    public int getBaseIndex() {
        return baseIndex;
    }

    public void setBaseIndex(int baseIndex) {
        this.baseIndex = baseIndex;
    }

    public List<PlayerDataPoint> getDataPoints() {
        return dataPoints;
    }

    public void setDataPoints(List<PlayerDataPoint> dataPoints) {
        this.dataPoints = dataPoints;
    }

    public void createDataPoint(Location newLocation) {
        double deltaX = lastLocation.getX() - newLocation.getX();
        double deltaY = lastLocation.getY() - newLocation.getY();
        double deltaZ = lastLocation.getZ() - newLocation.getZ();
        float deltaPitch = lastLocation.getPitch() - newLocation.getPitch();
        float deltaYaw = lastLocation.getYaw() - newLocation.getYaw();

        dataPoints.add(new PlayerDataPoint(deltaX, deltaY, deltaZ, deltaPitch, deltaYaw));

        lastLocation = newLocation;
    }

    public YamlConfiguration load() {
        File dataFolder = AFKWatch.getPlugin().getDataFolder();
        File file = new File(dataFolder, pID + ".yml");

        YamlConfiguration config;

        try {
            config = YamlConfiguration.loadConfiguration(file);
        }
        catch (Exception e) {
            config = new YamlConfiguration();
            e.printStackTrace();
        }

        Set<String> keys = config.getKeys(false);

        if (!keys.isEmpty()) {
            String[] keysArray = keys.toArray(new String[keys.size()]);
            baseIndex = 1 + Integer.parseInt(keysArray[keysArray.length - 1]);
        } else {
            baseIndex = 0;
        }

        return config;
    }

    public void save() {
        File dataFolder = AFKWatch.getPlugin().getDataFolder();
        File file = new File(dataFolder, pID + ".yml");

        YamlConfiguration config = load();

        for (int i = 0; i < dataPoints.size(); i++) {
            PlayerDataPoint dataPoint = dataPoints.get(i);
            config.createSection("" + (baseIndex + i), dataPoint.serialize());
        }

        try {
            config.save(file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
