package com.zombachu.afkwatch;

import java.util.HashMap;
import java.util.UUID;

public class DataManager {

    private static DataManager instance;
    private HashMap<UUID, PlayerData> cachedPlayerData;

    private DataManager() {
        cachedPlayerData = new HashMap<>();
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public PlayerData getCachedPlayerData(UUID pID) {
        return cachedPlayerData.get(pID);
    }

    public boolean cachePlayerData(PlayerData data) {
        if (cachedPlayerData.containsKey(data.getID())) {
            return false;
        }
        cachedPlayerData.put(data.getID(), data);
        return true;
    }

    public boolean uncachePlayerData(UUID pID) {
        if (!cachedPlayerData.containsKey(pID)) {
            return false;
        }
        cachedPlayerData.remove(pID);
        return true;
    }

    public HashMap<UUID, PlayerData> getCachedPlayerData() {
        return cachedPlayerData;
    }

}
