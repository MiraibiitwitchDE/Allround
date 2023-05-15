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
            sender.sendMessage(Component.text(ChatColor.RED + "Dieser Befehl kann nur von Spielern verwendet werden!"));
            return true;
        }

        if (sender instanceof Player player) {
            homeManager.setHomeLocation(player, player.getLocation());
            player.sendMessage(Component.text(ChatColor.GREEN + "Home-Punkt wurde gesetzt!"));

            return true;
        }

        return true;
    }
}
