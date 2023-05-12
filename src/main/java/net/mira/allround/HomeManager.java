package net.mira.allround;

import net.kyori.adventure.text.Component;
import net.mira.allround.Utils.ConfigFile;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class HomeManager {

    private Allround plugin;

    public HomeManager(Allround plugin) {
        this.plugin = plugin;
    }

    public void setHomeLocation(Player player, Location location) {
        plugin.config.set(player.getUniqueId().toString(), location);
        ConfigFile.saveConfig(plugin.file, plugin.config);
        player.sendMessage(Component.text("§2Heimatpunkt gesetzt!"));
    }

    public Location getHomeLocation(Player player) {
        return plugin.config.getLocation(player.getUniqueId().toString());
    }

    public void delHomeLocation(Player player) {
        ConfigFile.deleteKey(plugin.file, player.getUniqueId().toString());
    }

    public boolean hasHomeLocation(Player player) {
        return plugin.config.contains(player.getUniqueId().toString());
    }
}
