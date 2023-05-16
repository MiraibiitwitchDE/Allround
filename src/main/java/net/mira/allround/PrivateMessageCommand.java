package net.mira.allround;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrivateMessageCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            var player = (Player) sender;

            if (args.length >= 2) {
                String targetName = args[0];
                Player targetPlayer = Bukkit.getPlayer(targetName);

                if (targetPlayer != null) {
                    String message = String.join(" ", args).substring(targetName.length() + 1);

                    sendPrivateMessage(player, targetPlayer, message);
                } else {
                    player.sendMessage(ChatColor.RED + "[" + ChatColor.WHITE + "Player not found" + ChatColor.RED + "]");
                }
            } else {
                player.sendMessage(Component.text("Usage: /msg <player> <message>"));
            }
        }

        return true;
    }

    private void sendPrivateMessage(Player sender, Player target, String message) {
        Component senderName = Component.text(sender.getName()).color(NamedTextColor.DARK_PURPLE);
        Component targetName = Component.text(target.getName()).color(NamedTextColor.YELLOW);

        Component whisperMessage = Component.text("[Whisper] ").color(NamedTextColor.RED)
                .append(senderName)
                .append(Component.text(" ").color(NamedTextColor.WHITE).append(Component.text("to")))
                .append(Component.text(" ").color(NamedTextColor.WHITE).append(targetName))
                .append(Component.text(": ").color(NamedTextColor.WHITE))
                .append(Component.text(message).color(NamedTextColor.WHITE));


        sender.sendMessage(whisperMessage);
        target.sendMessage(whisperMessage);
    }
}
