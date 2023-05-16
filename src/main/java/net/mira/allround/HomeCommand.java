package net.mira.allround;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {

    private HomeManager homeManager;

    public HomeCommand(HomeManager homeManager) {
        this.homeManager = homeManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by one player!");
            return true;
        }

        if (sender instanceof Player player) {
            if (args.length > 0 && args[0].equalsIgnoreCase("tp")) {
                if (homeManager.hasHomeLocation(player)) {
                    player.teleport(homeManager.getHomeLocation(player));
                    player.sendMessage(Component.text(ChatColor.YELLOW + "Welcome Home! " + player.getName()));
                } else {
                    player.sendMessage(Component.text(ChatColor.RED + "You haven't set a home location yet."));
                }
            }
        }

        return true;
    }
}
