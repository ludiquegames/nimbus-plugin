package ludique.nimbus;

import ludique.nimbus.controllers.ListenerManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Nimbus extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        ListenerManager.RegisterEvents(this);

        getLogger().info("Nimbus Plugin successfully enabled.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
