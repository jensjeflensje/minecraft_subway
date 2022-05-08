package dev.jensderuiter.subway.event;

import dev.jensderuiter.subway.type.Subway;
import dev.jensderuiter.subway.SubwayPlugin;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.UUID;

public class OnSubwaySeat implements Listener {

    @EventHandler
    public void onTryToSeat(PlayerInteractAtEntityEvent event) {
        if (event.getRightClicked().getType() == org.bukkit.entity.EntityType.ARMOR_STAND) {
            UUID uuid = null;
            try {
                uuid = UUID.fromString(event.getRightClicked().getCustomName());
            } catch (Exception ignored) {}
            if (uuid == null) return;

            event.setCancelled(true);

            Subway subway = SubwayPlugin.subwayMap.get(uuid);
            if (subway == null) return;

            if (!subway.takeSeat(event.getPlayer())) {
                event.getPlayer().sendMessage(ChatColor.RED + "There are no seats available.");
            }
        }
    }

}
