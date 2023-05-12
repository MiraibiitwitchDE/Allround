package net.mira.allround;

import net.kyori.adventure.text.Component;
import net.mira.allround.Utils.ConfigFile;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class DeleteHomeCommand implements CommandExecutor {

    private HomeManager homeManager;
    private Allround plugin;

    public DeleteHomeCommand(HomeManager homeManager) {
        this.homeManager = homeManager;
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players!");
            return true;
        }

        if (sender instanceof Player player) {
            homeManager.delHomeLocation(player);
            player.sendMessage(Component.text(ChatColor.RED + "Your home point has been removed!"));

            // Delete key from homes.yml
            File configFile = ConfigFile.getFile(plugin);
            ConfigFile.deleteKey(configFile, player.getUniqueId().toString());
            homeManager.reloadHomeLocations();
            return true;
        }

        return true;
    }
}
