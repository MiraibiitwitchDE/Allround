package net.mira.allround;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HomeManager {

    private Map<UUID, Location> homeLocations;

    public HomeManager() {
        homeLocations = new HashMap<>();
    }

    public void setHomeLocation(Player player, Location location) {
        homeLocations.put(player.getUniqueId(), location);
        player.sendMessage("Heimatpunkt gesetzt!");
    }

    public Location getHomeLocation(Player player) {
        return homeLocations.get(player.getUniqueId());
    }

    public boolean hasHomeLocation(Player player) {
        return homeLocations.containsKey(player.getUniqueId());
    }
}
