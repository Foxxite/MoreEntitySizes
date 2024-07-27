package com.foxxite.moreEntitySizes;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.Random;

public final class MoreEntitySizes extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onEntitySpawn(EntitySpawnEvent event) {
        Entity entity = event.getEntity();
        EntityType entType = event.getEntityType();

        if (entType == EntityType.PLAYER ||  !(entity instanceof LivingEntity livingEntity)) return;

        Objects.requireNonNull(livingEntity.getAttribute(Attribute.GENERIC_SCALE)).setBaseValue(randomDoubleInRange(0.9, 1.1));
    }

    public double randomDoubleInRange(double min, double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }
}
