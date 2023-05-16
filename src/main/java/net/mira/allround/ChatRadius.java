package net.mira.allround;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatRadius extends JavaPlugin implements Listener {

    private static final int CHAT_RADIUS = 1000;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player sender = event.getPlayer();

        String message = event.getMessage();
        event.setCancelled(true);

        sendLocalChat(sender, message);
    }

    private void sendLocalChat(Player sender, String message) {
        Component localChatMessage = Component.text(ChatColor.YELLOW + "[Local] ")
                .append(Component.text(message));

        for (Player player : sender.getServer().getOnlinePlayers()) {
            if (player != sender && player.getLocation().distanceSquared(sender.getLocation()) <= CHAT_RADIUS * CHAT_RADIUS) {
                player.sendMessage(localChatMessage);
            }
        }
    }
}
