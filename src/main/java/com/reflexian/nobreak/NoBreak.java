package com.reflexian.nobreak;

import com.reflexian.nobreak.Events.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoBreak extends JavaPlugin implements Listener {

    private Object MetricsLite;

    @Override
    public void onEnable() {
        int pluginId = 8333;
        MetricsLite = new MetricsLite(this, pluginId);
        getServer().getPluginManager().registerEvents(new Event(this), this);
        this.saveDefaultConfig();

    }

    @Override
    public void onDisable() {

    }
}
