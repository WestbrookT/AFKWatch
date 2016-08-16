package com.zombachu.afkwatch;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

public class PlayerDataPoint implements ConfigurationSerializable {

    private double deltaX;
    private double deltaY;
    private double deltaZ;
    private float deltaPitch;
    private float deltaYaw;

    public PlayerDataPoint(double deltaX, double deltaY, double deltaZ, float deltaPitch, float deltaYaw) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.deltaZ = deltaZ;
        this.deltaPitch = deltaPitch;
        this.deltaYaw = deltaYaw;
    }

    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("x", deltaX);
        map.put("y", deltaY);
        map.put("z", deltaZ);
        map.put("pi", deltaPitch);
        map.put("ya", deltaYaw);
        return map;
    }

}
