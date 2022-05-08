package dev.jensderuiter.subway.event;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemFlag;

public class OnArmorStandPickup implements Listener {

    @EventHandler
    public void OnInteractAtEntity(PlayerInteractAtEntityEvent e) {
        if (e.getRightClicked().getType() == EntityType.ARMOR_STAND) {
            ArmorStand armorStand = (ArmorStand) e.getRightClicked();
            if (armorStand.getHelmet().getItemMeta().getItemFlags().contains(ItemFlag.HIDE_UNBREAKABLE)){
                e.setCancelled(true);
            }
        }
    }

}
