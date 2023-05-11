package net.mira.allround;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private HomeManager homeManager;

    @Override
    public void onEnable() {
        getLogger().info("Allround plugin enabled!");
        homeManager = new HomeManager();
        getCommand("sethome").setExecutor(new SetHomeCommand(homeManager));
        getCommand("home").setExecutor(new HomeCommand(homeManager));
    }

    @Override
    public void onDisable() {
        getLogger().info("Allround plugin disabled!");
    }
}
