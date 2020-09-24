package com.reflexian.nobreak.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Event implements Listener {

    public com.reflexian.nobreak.NoBreak main;

    public Event(com.reflexian.nobreak.NoBreak main) {
        this.main = main;
    }

    @EventHandler
    public void PlayerItemDamageEvent(PlayerItemDamageEvent e) throws InterruptedException {

        Player player = (Player) e.getPlayer();

        ItemStack itemStack = e.getItem();
        ItemMeta meta = itemStack.getItemMeta();
        if (meta.spigot().isUnbreakable()) {
            return;
        }
        if (itemStack.getType() == (Material.SKULL)) {
            return;
        }
        if (itemStack.getType() == (Material.SKULL_ITEM)) {
            return;
        }
        if (itemStack.getType() == Material.GOLDEN_APPLE || itemStack.getType() == Material.GOLDEN_APPLE && itemStack.getDurability() == 1 ) {
            return;
        }
        if (itemStack.getType() == Material.WOOD_HOE) {
            e.setDamage(0);
            return;
        }
        if (itemStack.getType() == Material.STONE_HOE) {
            e.setDamage(0);
            return;
        }
        if (itemStack.getType() == Material.GOLD_HOE) {
            e.setDamage(0);
            return;
        }
        if (itemStack.getType() == Material.IRON_HOE) {
            e.setDamage(0);
            return;
        }
        if (itemStack.getType() == Material.DIAMOND_HOE) {
            e.setDamage(0);
            return;
        }

        Bukkit.getScheduler().runTaskLater(main, () -> itemStack.setDurability((short) 0), 2); //20 ticks equal 1 second
        Bukkit.getScheduler().runTaskLater(main, () -> meta.spigot().setUnbreakable(true), 4);
        Bukkit.getScheduler().runTaskLater(main, () -> meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE), 6);
        Bukkit.getScheduler().runTaskLater(main, () -> itemStack.setItemMeta(meta), 7);
        //Bukkit.getScheduler().runTaskLater(main, () -> Bukkit.broadcastMessage(meta + " " + e.getPlayer().getInventory().getItemInHand()), 14);
    }
}