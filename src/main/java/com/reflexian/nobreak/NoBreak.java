package com.reflexian.nobreak;

import com.reflexian.nobreak.events.ItemListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoBreak extends JavaPlugin implements Listener {

    private static NoBreak instance;

    @Override
    public void onEnable() {
        instance=this;
        int pluginId = 8333;
        new MetricsLite(this, pluginId);
        getServer().getPluginManager().registerEvents(new ItemListener(), this);

    }

    @Override
    public void onDisable() {

    }

    public static NoBreak getInstance() {
        return instance;
    }
}
