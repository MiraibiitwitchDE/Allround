package net.mira.allround.Utils;

import net.mira.allround.Allround;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigFile {

    //create a function that i not must init the class
    public static File getFile(Allround plugin) {
        return new File(plugin.getDataFolder(), "homes.yml");
    }

    public static YamlConfiguration getConfig(File file) {
        return YamlConfiguration.loadConfiguration(file);
    }

    public static void saveConfig(File file, YamlConfiguration config) {
        try {
            config.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //create a delete function wich deletes a key
    public static void deleteKey(File file, String key) {
        YamlConfiguration config = getConfig(file);
        config.set(key, null);
        saveConfig(file, config);
    }

}
