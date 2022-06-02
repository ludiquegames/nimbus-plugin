package ludique.nimbus.controllers;

import ludique.nimbus.controllers.listeners.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ListenerManager {

    public static void RegisterEvents(JavaPlugin p_javaPlugin) {
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), p_javaPlugin);
    }

}
