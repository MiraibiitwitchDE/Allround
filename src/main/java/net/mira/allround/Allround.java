package net.mira.allround;

import net.mira.allround.Utils.ConfigFile;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

public class Allround extends JavaPlugin {
    Logger log = getLogger();
    File file;
    YamlConfiguration config;
    HomeManager homeManager;

    @Override
    public void onEnable() {
        log.info("Allround plugin enabled!");

        file = ConfigFile.getFile(this);
        config = ConfigFile.getConfig(file);

        homeManager = new HomeManager(this);

        getCommand("sethome").setExecutor(new SetHomeCommand(homeManager));
        getCommand("home").setExecutor(new HomeCommand(homeManager));
        getCommand("delhome").setExecutor(new DeleteHomeCommand(homeManager));
    }

    @Override
    public void onDisable() {
        log.info("Allround plugin disabled!");

        ConfigFile.saveConfig(file, config);
    }
}
