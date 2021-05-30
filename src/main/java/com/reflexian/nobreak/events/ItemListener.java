package com.reflexian.nobreak.events;

import com.reflexian.nobreak.NoBreak;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemListener implements Listener {

    private final List<Material> whitelistedMats = Arrays.asList(Material.WOOD_HOE,Material.WOOD_AXE);

    @EventHandler
    public void onItemDamaged(PlayerItemDamageEvent event) {
        if (event.getItem().getType().name().endsWith("CHESTPLATE")||event.getItem().getType().name().endsWith("BOOTS")||event.getItem().getType().name().endsWith("HELMET")||event.getItem().getType().name().endsWith("LEGGINGS")||event.getItem().getType().name().endsWith("PICKAXE")||event.getItem().getType().name().endsWith("SWORD")||event.getItem().getType().name().endsWith("HOE")||event.getItem().getType().name().endsWith("SHOVEL")||event.getItem().getType().name().endsWith("AXE")||whitelistedMats.contains(event.getItem().getType())) {

            if (event.getItem().getItemMeta().spigot().isUnbreakable()) return;
            ItemMeta itemMeta = event.getItem().getItemMeta();
            itemMeta.spigot().setUnbreakable(true);
            event.getItem().setItemMeta(itemMeta);

            if (NoBreak.getInstance().getConfig().getBoolean("send-message")) {
                event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', NoBreak.getInstance().getConfig().getString("message")));
            }

        }

    }

}
