package net.mira.allround;

import net.kyori.adventure.text.Component;
import net.mira.allround.Utils.ConfigFile;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class DeleteHomeCommand implements CommandExecutor {

    private HomeManager homeManager;
    private String usage;

    public DeleteHomeCommand(HomeManager homeManager) {
        this.homeManager = homeManager;
        this.usage = usage;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage(Component.text(ChatColor.RED + "Dieser Befehl kann nur von Spielern verwendet werden!"));
            return true;
        }

        if (sender instanceof Player player) {
            if (args.length == 0 || !args[0].equalsIgnoreCase("del")) {
                return false;
            }

            homeManager.delHomeLocation(player);
            player.sendMessage(Component.text(ChatColor.RED + "Dein Home-Punkt wurde entfernt!"));
            removeHomeFromConfig(player);
            homeManager.reloadHomeLocations();
            return true;
        }

        return true;
    }

    private void removeHomeFromConfig(Player player) {
        String playerId = player.getUniqueId().toString();
        File configFile = ConfigFile.getFile(homeManager.plugin);
        YamlConfiguration config = ConfigFile.getConfig(configFile);

        if (config.contains(playerId)) {
            config.set(playerId, null);
            ConfigFile.saveConfig(configFile, config);
        }
    }
}
