package net.mira.allround;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {

    private HomeManager homeManager;

    public SetHomeCommand(HomeManager homeManager) {
        this.homeManager = homeManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("sethome")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Dieser Befehl kann nur von einem Spieler verwendet werden.");
                return true;
            }

            Player player = (Player) sender;
            homeManager.setHomeLocation(player, player.getLocation());
            return true;
        }

        return false;
    }
}
