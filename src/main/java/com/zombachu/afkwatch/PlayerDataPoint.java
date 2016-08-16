package com.zombachu.afkwatch;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

public class PlayerDataPoint implements ConfigurationSerializable {

    private int index;
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

    public int getIndex() {
        return index;
    }

    public double getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }

    public double getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(double deltaY) {
        this.deltaY = deltaY;
    }

    public double getDeltaZ() {
        return deltaZ;
    }

    public void setDeltaZ(double deltaZ) {
        this.deltaZ = deltaZ;
    }

    public float getDeltaPitch() {
        return deltaPitch;
    }

    public void setDeltaPitch(float deltaPitch) {
        this.deltaPitch = deltaPitch;
    }

    public float getDeltaYaw() {
        return deltaYaw;
    }

    public void setDeltaYaw(float deltaYaw) {
        this.deltaYaw = deltaYaw;
    }

}
