package net.mira.allround;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {

    private HomeManager homeManager;

    public HomeCommand(HomeManager homeManager) {
        this.homeManager = homeManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Console || sender instanceof CommandBlock) {
            sender.sendMessage("Dieser Befehl kann nur von einem Spieler verwendet werden.");
            return true;
        }
        
        if (sender instanceof Player player) {
        if (command.getName().equalsIgnoreCase("home")) {

            if (homeManager.hasHomeLocation(player)) {
                player.teleport(homeManager.getHomeLocation(player));
                player.sendMessage("Willkommen zuhause!");
            } else {
                player.sendMessage("Du hast noch keinen Heimatpunkt gesetzt.");
            }
            return true;
        }
        }
        return true;
    }
}
