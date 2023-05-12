package net.mira.allround;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class DeleteHomeCommand implements CommandExecutor {

    private HomeManager homeManager;

    public DeleteHomeCommand(HomeManager homeManager) {
        this.homeManager = homeManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("Dieser Befehl kann nur von einem Spieler verwendet werden.");
            return true;
        }

        if (sender instanceof Player player) {
            homeManager.delHomeLocation(player);
            player.sendMessage(Component.text("§cDein Heimatpunkt wurde entfernt!"));
            return true;
        }

        return true;
    }
}
