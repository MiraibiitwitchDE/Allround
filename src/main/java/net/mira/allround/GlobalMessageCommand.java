package net.mira.allround;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GlobalMessageCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length > 0) {
                String message = String.join(" ", args);

                sendGlobalMessage(player, message);
            } else {
                player.sendMessage(Component.text("Usage: /global <message>"));
            }
        }

        return true;
    }

    private void sendGlobalMessage(Player sender, String message) {
        Component playerName = Component.text(sender.getName()).color(NamedTextColor.YELLOW);

        Component globalMessage = Component.text(ChatColor.LIGHT_PURPLE + "[Global] ")
                .append(playerName)
                .append(Component.text(": "))
                .append(Component.text(message));

        // Broadcast the message to all players
        for (Player player : sender.getServer().getOnlinePlayers()) {
            player.sendMessage(globalMessage);
        }
    }
}
