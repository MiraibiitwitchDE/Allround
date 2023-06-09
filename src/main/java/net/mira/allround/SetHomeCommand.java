package net.mira.allround;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {

    private HomeManager homeManager;

    public SetHomeCommand(HomeManager homeManager) {
        this.homeManager = homeManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage(Component.text(ChatColor.RED + "This command can only be used by players!"));
            return true;
        }

        if (sender instanceof Player player) {
            if (args.length == 0 || !args[0].equalsIgnoreCase("set")) {
                return false; // Invalid usage
            }

            homeManager.setHomeLocation(player, player.getLocation());
            player.sendMessage(Component.text(ChatColor.GREEN + "Home point has been set!"));

            return true;
        }

        return true;
    }
}
