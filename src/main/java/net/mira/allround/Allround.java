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
        getCommand("msg").setExecutor(new PrivateMessageCommand());
        getCommand("global").setExecutor(new GlobalMessageCommand());
        getCommand("home").setExecutor((sender, command, label, args) -> {
            if (args.length == 0) {
                return false;
            }

            String subCommand = args[0].toLowerCase();

            switch (subCommand) {
                case "set":
                    return new SetHomeCommand(homeManager).onCommand(sender, command, label, args);
                case "del":
                    return new DeleteHomeCommand(homeManager).onCommand(sender, command, label, args);
                case "tp":
                    return new HomeCommand(homeManager).onCommand(sender, command, label, args);
                default:
                    // Handle unknown sub-command
                    return false;
            }
        });

        // Weitere Initialisierungen...
    }

    @Override
    public void onDisable() {
        log.info("Allround plugin disabled!");

        ConfigFile.saveConfig(file, config);
    }
}
