package net.mira.allround;

import net.mira.allround.Utils.ConfigFile;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class HomeManager {

    Allround plugin;

    public HomeManager(Allround plugin) {
        this.plugin = plugin;
    }

    public void setHomeLocation(Player player, Location location) {
        plugin.config.set(player.getUniqueId().toString(), location);
        ConfigFile.saveConfig(plugin.file, plugin.config);
    }

    public Location getHomeLocation(Player player) {
        return plugin.config.getLocation(player.getUniqueId().toString());
    }

    public void delHomeLocation(Player player) {
        String playerId = player.getUniqueId().toString();
        ConfigFile.deleteKey(plugin.file, playerId);
        plugin.config.set(playerId, null);
    }

    public boolean hasHomeLocation(Player player) {
        return plugin.config.contains(player.getUniqueId().toString());
    }

    public void reloadHomeLocations() {
        plugin.config = ConfigFile.getConfig(plugin.file);
    }
}
