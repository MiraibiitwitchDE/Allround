package net.mira.allround;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Allround extends JavaPlugin {
    Logger log = getLogger();

    @Override
    public void onEnable() {
        log.info("Allround plugin enabled!");
        var homeManager = new HomeManager();
        getCommand("sethome").setExecutor(new SetHomeCommand(homeManager));
        getCommand("home").setExecutor(new HomeCommand(homeManager));
        //do something
    }

    @Override
    public void onDisable() {
        log.info("Allround plugin disabled!");
    }
}
